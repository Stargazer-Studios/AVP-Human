package com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.sensor;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy.FRIStrategies;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy.FRIStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy.FRIStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BestFRIInInventorySensor {

    public static final StateKey.Sensed<Option<FRIStrategyResult<ItemTarget.Inventory>>> KEY = StateKey.sensed("best_fri_in_inventory");

    public static <T extends LivingEntity & BLibInventoryHolder> @NotNull Option<FRIStrategyResult<ItemTarget.Inventory>> sense(
        T livingEntityWithInventory,
        ReadableWorldState worldState
    ) {
        var bestScore = -Double.MIN_VALUE;
        BLibInventory.Entry bestEntry = null;
        FRIStrategy bestStrategy = null;

        for (var strategy : FRIStrategies.STRATEGIES) {
            if (!strategy.isValid(livingEntityWithInventory, worldState)) {
                continue;
            }

            var entries = strategy.selectEntriesFromInventory(livingEntityWithInventory.getInventory());

            for (var entry : entries) {
                var itemStack = entry.copyItemStack();

                if (!strategy.canUseItemStack(itemStack)) {
                    continue;
                }

                var newScore = strategy.score(livingEntityWithInventory, worldState, itemStack);

                if (newScore > bestScore) {
                    bestScore = newScore;
                    bestEntry = entry;
                    bestStrategy = strategy;
                }
            }
        }

        return bestEntry == null
            ? Option.none()
            : Option.some(new FRIStrategyResult<>(new ItemTarget.Inventory(bestEntry), bestStrategy, bestScore));
    }
}
