package com.human.common.gameplay.entity.living.human.marine.ai.combat.sensor;

import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;

public class BestWeaponSensor {

    public static final StateKey.Sensed<Option<WeaponStrategyResult<? extends ItemTarget>>> KEY = StateKey.sensed("best_weapon");

    public static Option<WeaponStrategyResult<? extends ItemTarget>> sense(LivingEntity ignored, ReadableWorldState worldState) {
        var handsOption = worldState.getOrDefault(BestWeaponInHandsSensor.KEY, Option.none());
        var inventoryOption = worldState.getOrDefault(BestWeaponInInventorySensor.KEY, Option.none());
        var worldOption = worldState.getOrDefault(BestWeaponInWorldSensor.KEY, Option.none());

        Option<WeaponStrategyResult<? extends ItemTarget>> bestOption = Option.none();

        // Find the best scoring target among hands, inventory, and world
        for (var itemTargetOption : new Option[] { handsOption, inventoryOption, worldOption }) {
            if (itemTargetOption.isSome()) {
                var candidate = (WeaponStrategyResult<? extends ItemTarget>) itemTargetOption.unwrap();

                if (bestOption.isNone() || candidate.score() > bestOption.unwrap().score()) {
                    bestOption = Option.some(candidate);
                }
            }
        }

        return bestOption;
    }
}
