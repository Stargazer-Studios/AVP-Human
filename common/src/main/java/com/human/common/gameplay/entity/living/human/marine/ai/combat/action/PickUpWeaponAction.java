package com.human.common.gameplay.entity.living.human.marine.ai.combat.action;

import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.action.PickUpItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;

public class PickUpWeaponAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(
        T livingEntityWithInventory,
        ReadableWorldState worldState,
        Blackboard blackboard
    ) {
        var worldItemTargetOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON_IN_WORLD.key(), Option.none());

        if (worldItemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return PickUpItemAction.perform(livingEntityWithInventory, worldItemTargetOption.unwrap().itemTarget().itemEntity());
    }

    private PickUpWeaponAction() {
        throw new UnsupportedOperationException();
    }
}
