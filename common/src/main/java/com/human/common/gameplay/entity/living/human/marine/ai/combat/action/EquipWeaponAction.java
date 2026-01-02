package com.human.common.gameplay.entity.living.human.marine.ai.combat.action;

import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.action.EquipItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;

public class EquipWeaponAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(
        T livingEntityWithInventory,
        ReadableWorldState worldState,
        Blackboard blackboard
    ) {
        var inventoryItemTargetOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON_IN_INVENTORY.key(), Option.none());

        if (inventoryItemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return EquipItemAction.perform(
            livingEntityWithInventory,
            inventoryItemTargetOption.unwrap().itemTarget().entry(),
            EquipmentSlot.MAINHAND
        );
    }

    private EquipWeaponAction() {
        throw new UnsupportedOperationException();
    }
}
