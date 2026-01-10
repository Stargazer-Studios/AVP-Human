package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.sensor;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.ArmorStrategies;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.ArmorStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.ArmorStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ArmorItem;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ArmorInWorldSensor {

    public static @NotNull Option<ArmorStrategyResult<ItemTarget.World>> sense(
        ArmorItem.Type type,
        LivingEntity livingEntity,
        ReadableWorldState worldState
    ) {
        var bestScore = -Double.MIN_VALUE;
        ItemEntity bestItemEntity = null;
        ArmorStrategy bestStrategy = null;

        for (var strategy : ArmorStrategies.getForType(type)) {
            if (!strategy.isValidWorldState(livingEntity, worldState)) {
                continue;
            }

            var itemEntities = worldState.getOrDefault(GOAPSensors.NEARBY_ITEM_ENTITIES.key(), List.of());

            // TODO: Access by item -> item entities map first, then filter item entities as current impl does.
            for (var entry : itemEntities) {
                var itemStack = entry.getItem();

                if (!strategy.isValidItemStack(itemStack)) {
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
            : Option.some(new ArmorStrategyResult<>(new ItemTarget.World(bestItemEntity), bestStrategy, bestScore));
    }
}
