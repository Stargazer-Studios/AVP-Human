package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.impl;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategy;
import com.human.common.gameplay.item.GunItem;
import com.human.common.gameplay.item.gun.FireModeConfig;
import com.human.common.registry.init.HumanDataComponents;
import com.human.common.registry.tag.HumanItemTags;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.StateKey;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public class GunStrategy implements WeaponStrategy {

    private static final StateKey<Integer> TICK_COUNTDOWN = StateKey.sensed("tick_countdown");

    @Override
    public boolean canUseItemStack(ItemStack itemStack) {
        if (!itemStack.is(HumanItemTags.GUNS)) {
            return false;
        }

        return itemStack.getOrDefault(HumanDataComponents.AMMUNITION.get(), 0) > 0;
    }

    @Override
    public boolean isValid(LivingEntity livingEntity, ReadableWorldState worldState) {
        return true;
    }

    @Override
    public Collection<BLibInventory.Entry> selectEntriesFromInventory(BLibInventory inventory) {
        return inventory.filterEntriesByStack(this::canUseItemStack);
    }

    @Override
    public double score(LivingEntity livingEntity, ReadableWorldState worldState, ItemStack itemStack) {
        if (itemStack.getItem() instanceof GunItem gunItem) {
            var fireMode = gunItem.getGunConfig().getDefaultFireMode();
            var targetOption = worldState.getOrDefault(CombatSensors.NEAREST_ATTACKABLE_TARGET.key(), Option.none());

            if (targetOption.isNone()) {
                return -Double.MIN_VALUE;
            }

            var target = targetOption.unwrap();
            var distance = livingEntity.distanceTo(target);
            var rangeFit = rangeFit(distance, fireMode.range());

            var timeToContact = computeTimeToContact(target, distance);
            var timeToKill = computeTimeToKill(target, fireMode);
            var pressureRatio = timeToKill / timeToContact;
            var frequencyFit = Math.exp(-pressureRatio);

            return rangeFit * frequencyFit;
        }

        return -Double.MIN_VALUE;
    }

    @Override
    public double getRangeForWeapon(LivingEntity livingEntity, ItemStack itemStack) {
        if (itemStack.getItem() instanceof GunItem gunItem) {
            return gunItem.getGunConfig().getDefaultFireMode().range();
        }

        var attributes = livingEntity.getAttributes();
        var attribute = Attributes.ENTITY_INTERACTION_RANGE;

        return attributes.hasAttribute(attribute)
            ? attributes.getBaseValue(attribute)
            : attribute.value().getDefaultValue();
    }

    @Override
    public Action.Signal execute(LivingEntity livingEntity, ReadableWorldState worldState, Blackboard blackboard) {
        if (!(livingEntity instanceof Mob mob)) {
            return Action.Signal.ABORT;
        }

        var target = mob.getTarget();

        if (target == null) {
            return Action.Signal.ABORT;
        }

        var currentTickCountdown = blackboard.getOrNull(TICK_COUNTDOWN);

        if (currentTickCountdown == null) {
            currentTickCountdown = Integer.MAX_VALUE;
            blackboard.set(TICK_COUNTDOWN, currentTickCountdown);
        } else {
            currentTickCountdown -= 1;
            blackboard.set(TICK_COUNTDOWN, currentTickCountdown);
        }

        var tickCountdown = currentTickCountdown;
        var equippedWeaponOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON_IN_HANDS.key(), Option.none());

        equippedWeaponOption.ifSome(equippedWeapon -> {
            var equipmentSlot = equippedWeapon.itemTarget().equipmentSlot();
            var itemStack = mob.getItemBySlot(equipmentSlot);

            if (itemStack.getItem() instanceof GunItem gunItem) {
                // Always look at the target while shooting.
                mob.lookAt(EntityAnchorArgument.Anchor.EYES, target.getEyePosition());
                mob.getLookControl().setLookAt(target);

                gunItem.onUseTick(mob.level(), mob, itemStack, tickCountdown);
            }
        });

        return Action.Signal.CONTINUE;
    }

    private double computeTimeToContact(LivingEntity target, float distance) {
        var targetSpeed = target.getDeltaMovement().horizontalDistance();
        // Prevent divide-by-zero / stationary targets.
        return targetSpeed > 0.001
            ? distance / targetSpeed
            : Double.POSITIVE_INFINITY;
    }

    private double computeTimeToKill(LivingEntity target, FireModeConfig fireMode) {
        var shotsNeeded = Math.ceil(target.getHealth() / fireMode.damage());
        var timePerShot = fireMode.cooldownInTicks() / 20.0;
        return shotsNeeded * timePerShot;
    }

    // TODO: Rewrite this once gun damage falloff is added.
    private double rangeFit(double distance, double weaponRange) {
        var preferredDistance = weaponRange * 0.6;
        var sigma = weaponRange * 0.4;
        var difference = distance - preferredDistance;
        return Math.exp(-(difference * difference) / (2 * sigma * sigma));
    }
}
