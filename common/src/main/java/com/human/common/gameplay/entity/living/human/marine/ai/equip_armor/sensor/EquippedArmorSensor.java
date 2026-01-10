package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.sensor;

import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.ArmorStrategies;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.ArmorStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.ArmorStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import org.jetbrains.annotations.NotNull;

public class EquippedArmorSensor {

    public static @NotNull Option<ArmorStrategyResult<ItemTarget.Equipped>> sense(
        ArmorItem.Type type,
        LivingEntity livingEntity,
        ReadableWorldState worldState
    ) {
        var bestScore = -Double.MIN_VALUE;
        EquipmentSlot bestEquipmentSlot = null;
        ArmorStrategy bestStrategy = null;

        // TODO: Avoid the array allocation here. Use a builder pattern to force singleton allocation, probably.
        for (var equipmentSlot : new EquipmentSlot[] { type.getSlot(), EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND }) {
            var itemStack = livingEntity.getItemBySlot(equipmentSlot);

            for (var strategy : ArmorStrategies.getForType(type)) {
                if (!strategy.isValidItemStack(itemStack) || !strategy.isValidWorldState(livingEntity, worldState)) {
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
            : Option.some(new ArmorStrategyResult<>(new ItemTarget.Equipped(bestEquipmentSlot), bestStrategy, bestScore));
    }
}
