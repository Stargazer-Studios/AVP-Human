package com.human.common.gameplay.entity.living.human.marine.ai.equip_totem.action;

import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.ai.generic.action.EquipItemAction;
import com.just.goap.action.Action;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;

public class EquipTotemAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(Action.Context<T> context) {
        var livingEntityWithInventory = context.getActor();
        var inventory = livingEntityWithInventory.getInventory();

        var totemEntryOption = inventory.selectEntries(Items.TOTEM_OF_UNDYING)
            .stream()
            .findFirst();

        if (totemEntryOption.isEmpty()) {
            return Action.Signal.ABORT;
        }

        return EquipItemAction.perform(livingEntityWithInventory, totemEntryOption.get(), EquipmentSlot.OFFHAND);
    }

    private EquipTotemAction() {
        throw new UnsupportedOperationException();
    }
}
