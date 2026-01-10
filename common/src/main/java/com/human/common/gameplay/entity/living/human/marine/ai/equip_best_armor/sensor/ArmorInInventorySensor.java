package com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.strategy.ArmorStrategies;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.strategy.ArmorStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.strategy.ArmorStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.core.functional.option.Option;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import org.jetbrains.annotations.NotNull;

public class ArmorInInventorySensor {

    public static <T extends LivingEntity & BLibInventoryHolder> @NotNull Option<ArmorStrategyResult<ItemTarget.Inventory>> sense(
        ArmorItem.Type type,
        T livingEntityWithInventory,
        ReadableWorldState worldState
    ) {
        var bestScore = -Double.MIN_VALUE;
        BLibInventory.Entry bestEntry = null;
        ArmorStrategy bestStrategy = null;

        for (var strategy : ArmorStrategies.getForType(type)) {
            if (!strategy.isValidWorldState(livingEntityWithInventory, worldState)) {
                continue;
            }

            var entries = strategy.selectEntriesFromInventory(livingEntityWithInventory.getInventory());

            for (var entry : entries) {
                var itemStack = entry.copyItemStack();

                if (!strategy.isValidItemStack(itemStack)) {
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
            : Option.some(new ArmorStrategyResult<>(new ItemTarget.Inventory(bestEntry), bestStrategy, bestScore));
    }
}
