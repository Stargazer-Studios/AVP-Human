package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.sensor;

import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.EquipArmorSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.ArmorStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;

public class BestChestplateSensor {

    public static Option<ArmorStrategyResult<? extends ItemTarget>> sense(LivingEntity ignored, ReadableWorldState worldState) {
        var equippedOption = worldState.getOrDefault(EquipArmorSensors.BEST_CHESTPLATE_EQUIPPED.key(), Option.none());
        var inventoryOption = worldState.getOrDefault(EquipArmorSensors.BEST_CHESTPLATE_IN_INVENTORY.key(), Option.none());
        var worldOption = worldState.getOrDefault(EquipArmorSensors.BEST_CHESTPLATE_IN_WORLD.key(), Option.none());

        Option<ArmorStrategyResult<? extends ItemTarget>> bestOption = Option.none();

        // Find the best scoring target among hands, inventory, and world
        for (var itemTargetOption : new Option[] { equippedOption, inventoryOption, worldOption }) {
            if (itemTargetOption.isSome()) {
                var candidate = (ArmorStrategyResult<? extends ItemTarget>) itemTargetOption.unwrap();

                if (bestOption.isNone() || candidate.score() > bestOption.unwrap().score()) {
                    bestOption = Option.some(candidate);
                }
            }
        }

        return bestOption;
    }

}
