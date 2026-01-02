package com.human.common.gameplay.entity.living.human.marine.ai.combat.sensor;

import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategies;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BestWeaponInHandsSensor {

    private static final EquipmentSlot[] HAND_SLOTS = new EquipmentSlot[] { EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND };

    public static final StateKey.Sensed<Option<WeaponStrategyResult<ItemTarget.Equipped>>> KEY = StateKey.sensed("best_weapon_in_hands");

    public static @NotNull Option<WeaponStrategyResult<ItemTarget.Equipped>> sense(
        LivingEntity livingEntity,
        ReadableWorldState worldState
    ) {
        var bestScore = -Double.MIN_VALUE;
        EquipmentSlot bestEquipmentSlot = null;
        WeaponStrategy bestStrategy = null;

        for (var equipmentSlot : HAND_SLOTS) {
            var itemStack = livingEntity.getItemBySlot(equipmentSlot);

            for (var strategy : WeaponStrategies.STRATEGIES) {
                if (!strategy.canUseItemStack(itemStack) || !strategy.isValid(livingEntity, worldState)) {
                    continue;
                }

                var newScore = strategy.score(livingEntity, worldState, itemStack);

                if (newScore > bestScore) {
                    bestScore = newScore;
                    bestEquipmentSlot = equipmentSlot;
                    bestStrategy = strategy;
                }
            }
        }

        return bestEquipmentSlot == null
            ? Option.none()
            : Option.some(new WeaponStrategyResult<>(new ItemTarget.Equipped(bestEquipmentSlot), bestStrategy, bestScore));
    }
}
