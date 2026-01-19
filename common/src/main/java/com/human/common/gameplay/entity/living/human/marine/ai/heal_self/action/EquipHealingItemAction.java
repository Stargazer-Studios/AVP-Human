package com.human.common.gameplay.entity.living.human.marine.ai.heal_self.action;

import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.ai.generic.action.EquipItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.HealingSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class EquipHealingItemAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(Action.Context<T> context) {
        var livingEntityWithInventory = context.getActor();
        var worldState = context.getWorldState();
        var inventoryItemTargetOption = worldState.getOrDefault(HealingSensors.BEST_HEALING_ITEM_IN_INVENTORY.key(), Option.none());

        if (inventoryItemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return EquipItemAction.perform(
            livingEntityWithInventory,
            inventoryItemTargetOption.unwrap().itemTarget().entry(),
            EquipmentSlot.MAINHAND
        );
    }

    private EquipHealingItemAction() {
        throw new UnsupportedOperationException();
    }
}
