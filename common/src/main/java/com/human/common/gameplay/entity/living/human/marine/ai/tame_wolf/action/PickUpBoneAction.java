package com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action;

import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.ai.generic.action.PickUpItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.TameWolfSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import net.minecraft.world.entity.LivingEntity;

public class PickUpBoneAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(Action.Context<T> context) {
        var livingEntityWithInventory = context.getActor();
        var worldState = context.getWorldState();
        var boneEntityOption = worldState.getOrDefault(TameWolfSensors.NEAREST_BONE_IN_WORLD.key(), Option.none());

        if (boneEntityOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return PickUpItemAction.perform(livingEntityWithInventory, boneEntityOption.unwrap());
    }

    private PickUpBoneAction() {
        throw new UnsupportedOperationException();
    }
}
