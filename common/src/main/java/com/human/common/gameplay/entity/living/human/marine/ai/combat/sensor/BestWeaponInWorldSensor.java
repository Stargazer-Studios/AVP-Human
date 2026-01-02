package com.human.common.gameplay.entity.living.human.marine.ai.combat.sensor;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategies;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class BestWeaponInWorldSensor {

    public static final StateKey.Sensed<Option<WeaponStrategyResult<ItemTarget.World>>> KEY = StateKey.sensed("best_weapon_in_world");

    public static @NotNull Option<WeaponStrategyResult<ItemTarget.World>> sense(
        LivingEntity livingEntity,
        ReadableWorldState worldState
    ) {
        var bestScore = -Double.MIN_VALUE;
        ItemEntity bestItemEntity = null;
        WeaponStrategy bestStrategy = null;

        for (var strategy : WeaponStrategies.STRATEGIES) {
            if (!strategy.isValid(livingEntity, worldState)) {
                continue;
            }

            var itemEntities = worldState.getOrDefault(GOAPSensors.NEARBY_ITEM_ENTITIES.key(), List.of());

            // TODO: Access by item -> item entities map first, then filter item entities as current impl does.
            for (var entry : itemEntities) {
                var itemStack = entry.getItem();

                if (!strategy.canUseItemStack(itemStack)) {
                    continue;
                }

                var newScore = strategy.score(livingEntity, worldState, itemStack);

                if (newScore > bestScore) {
                    bestScore = newScore;
                    bestItemEntity = entry;
                    bestStrategy = strategy;
                }
            }
        }

        return bestItemEntity == null
            ? Option.none()
            : Option.some(new WeaponStrategyResult<>(new ItemTarget.World(bestItemEntity), bestStrategy, bestScore));
    }
}
