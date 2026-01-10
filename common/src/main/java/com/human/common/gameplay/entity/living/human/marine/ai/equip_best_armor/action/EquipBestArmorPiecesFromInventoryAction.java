package com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.action;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.action.EquipItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.EquipBestArmorSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ArmorSetTarget;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.EquipmentSlot;

public class EquipBestArmorPiecesFromInventoryAction {

    public static Action.Signal perform(Marine marine, ReadableWorldState worldState, Blackboard $3) {
        var bestArmorTarget = worldState.getOrDefault(EquipBestArmorSensors.BEST_ARMOR_SET_TARGET.key(), ArmorSetTarget.EMPTY);

        if (bestArmorTarget.isEmpty()) {
            return Action.Signal.ABORT;
        }

        if (bestArmorTarget.helmet() instanceof ItemTarget.Inventory(BLibInventory.Entry entry)) {
            EquipItemAction.perform(marine, entry, EquipmentSlot.HEAD);
        }

        if (bestArmorTarget.chestplate() instanceof ItemTarget.Inventory(BLibInventory.Entry entry)) {
            EquipItemAction.perform(marine, entry, EquipmentSlot.CHEST);
        }

        if (bestArmorTarget.leggings() instanceof ItemTarget.Inventory(BLibInventory.Entry entry)) {
            EquipItemAction.perform(marine, entry, EquipmentSlot.LEGS);
        }

        if (bestArmorTarget.boots() instanceof ItemTarget.Inventory(BLibInventory.Entry entry)) {
            EquipItemAction.perform(marine, entry, EquipmentSlot.FEET);
        }

        return Action.Signal.CONTINUE;
    }

    private EquipBestArmorPiecesFromInventoryAction() {
        throw new UnsupportedOperationException();
    }
}
