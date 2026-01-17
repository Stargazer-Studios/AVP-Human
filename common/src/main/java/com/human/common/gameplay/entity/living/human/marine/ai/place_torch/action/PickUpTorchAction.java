package com.human.common.gameplay.entity.living.human.marine.ai.place_torch.action;

import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.action.PickUpItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.place_torch.TorchSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import net.minecraft.world.entity.LivingEntity;

public class PickUpTorchAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(Action.Context<T> context) {
        var livingEntityWithInventory = context.getActor();
        var worldState = context.getWorldState();
        var torchEntityOption = worldState.getOrDefault(TorchSensors.NEAREST_TORCH_IN_WORLD.key(), Option.none());

        if (torchEntityOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return PickUpItemAction.perform(livingEntityWithInventory, torchEntityOption.unwrap());
    }

    private PickUpTorchAction() {
        throw new UnsupportedOperationException();
    }
}
