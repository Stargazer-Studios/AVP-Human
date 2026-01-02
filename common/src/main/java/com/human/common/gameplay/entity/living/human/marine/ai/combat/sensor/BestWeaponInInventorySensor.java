package com.human.common.gameplay.entity.living.human.marine.ai.combat.sensor;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategies;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BestWeaponInInventorySensor {

    public static final StateKey.Sensed<Option<WeaponStrategyResult<ItemTarget.Inventory>>> KEY = StateKey.sensed(
        "best_weapon_in_inventory"
    );

    public static <T extends LivingEntity & BLibInventoryHolder> @NotNull Option<WeaponStrategyResult<ItemTarget.Inventory>> sense(
        T livingEntityWithInventory,
        ReadableWorldState worldState
    ) {
        var bestScore = -Double.MIN_VALUE;
        BLibInventory.Entry bestEntry = null;
        WeaponStrategy bestStrategy = null;

        for (var strategy : WeaponStrategies.STRATEGIES) {
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
            : Option.some(new WeaponStrategyResult<>(new ItemTarget.Inventory(bestEntry), bestStrategy, bestScore));
    }
}
