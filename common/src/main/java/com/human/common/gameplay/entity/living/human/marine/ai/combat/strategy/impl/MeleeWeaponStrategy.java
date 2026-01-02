package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.impl;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.StateKey;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemAttributeModifiers;

import java.util.Collection;

public class MeleeWeaponStrategy implements WeaponStrategy {

    private static final StateKey<Integer> ATTACK_DELAY_IN_TICKS = StateKey.sensed("attack_delay_in_ticks");

    @Override
    public boolean canUseItemStack(ItemStack itemStack) {
        // TODO: Replace with "melee weapons" tag.
        return itemStack.is(ItemTags.AXES)
            || itemStack.is(ItemTags.SWORDS)
            || itemStack.is(Items.MACE);
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
        // TODO:
        return 0;
    }

    @Override
    public double getRangeForWeapon(LivingEntity livingEntity, ItemStack itemStack) {
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

        var currentAttackDelayInTicks = blackboard.getOrDefault(ATTACK_DELAY_IN_TICKS, 0);

        if (currentAttackDelayInTicks > 0) {
            blackboard.set(ATTACK_DELAY_IN_TICKS, currentAttackDelayInTicks - 1);
            return Action.Signal.CONTINUE;
        }

        var equippedWeaponOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON_IN_HANDS.key(), Option.none());

        equippedWeaponOption.ifSome(equippedWeapon -> {
            var equipmentSlot = equippedWeapon.itemTarget().equipmentSlot();
            var itemStack = livingEntity.getItemBySlot(equipmentSlot);

            var modifiedAttackDamage = computeModifiedAttribute(mob, Attributes.ATTACK_DAMAGE, itemStack, equippedWeapon);

            target.hurt(mob.level().damageSources().mobAttack(mob), (float) modifiedAttackDamage);

            var modifiedAttackSpeed = computeModifiedAttribute(mob, Attributes.ATTACK_SPEED, itemStack, equippedWeapon);

            blackboard.set(ATTACK_DELAY_IN_TICKS, Math.abs((int) (modifiedAttackSpeed * 20)));
        });

        return Action.Signal.CONTINUE;
    }

    private static double computeModifiedAttribute(
        Mob mob,
        Holder<Attribute> attribute,
        ItemStack itemStack,
        WeaponStrategyResult<ItemTarget.Equipped> equippedWeapon
    ) {
        var baseValue = mob.getAttributes().hasAttribute(attribute)
            ? mob.getAttributes().getBaseValue(attribute)
            : attribute.value().getDefaultValue();

        return computeAttribute(itemStack, attribute, equippedWeapon.itemTarget().equipmentSlot(), baseValue);
    }

    private static double computeAttribute(
        ItemStack itemStack,
        Holder<Attribute> attribute,
        EquipmentSlot slot,
        double baseValue
    ) {
        var modifiers = itemStack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);

        var value = baseValue;

        for (var entry : modifiers.modifiers()) {
            if (!entry.slot().test(slot) || !entry.attribute().equals(attribute)) {
                continue;
            }

            var mod = entry.modifier();

            switch (mod.operation()) {
                case ADD_VALUE -> value += mod.amount();
                case ADD_MULTIPLIED_BASE -> value += baseValue * mod.amount();
            }
        }

        for (var entry : modifiers.modifiers()) {
            if (!entry.slot().test(slot) || !entry.attribute().equals(attribute)) {
                continue;
            }

            var mod = entry.modifier();

            if (mod.operation() == AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL) {
                value += value * mod.amount();
            }
        }

        return value;
    }
}
