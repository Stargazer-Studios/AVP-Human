package com.human.common.gameplay.entity.living.human.ai.generic.action;

import com.blib.api.common.inventory.v1.BLibInventoryHolder;
import com.just.goap.action.Action;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;

public class PickUpItemAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(
        T livingEntityWithInventory,
        ItemEntity itemEntity
    ) {
        if (itemEntity.isRemoved()) {
            return Action.Signal.ABORT;
        }

        // Put target item entity in inventory.
        livingEntityWithInventory.getInventory().addItemStack(itemEntity.getItem());
        // Pick up the item entity.
        livingEntityWithInventory.take(itemEntity, itemEntity.getItem().getCount());
        itemEntity.discard();

        return Action.Signal.CONTINUE;
    }

    private PickUpItemAction() {
        throw new UnsupportedOperationException();
    }
}
