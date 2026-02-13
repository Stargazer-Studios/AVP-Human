package com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.action;

import com.blib.api.common.goap.v1.action.impl.PickUpItemAction;
import com.blib.api.common.inventory.v1.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.ExtinguishFireSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import net.minecraft.world.entity.LivingEntity;

public class PickUpWaterBucketAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(Action.Context<T> context) {
        var livingEntityWithInventory = context.getActor();
        var worldState = context.getWorldState();
        var waterBucketEntityOption = worldState.getOrDefault(ExtinguishFireSensors.NEAREST_WATER_BUCKET_IN_WORLD.key(), Option.none());

        if (waterBucketEntityOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return PickUpItemAction.perform(livingEntityWithInventory, waterBucketEntityOption.unwrap());
    }

    private PickUpWaterBucketAction() {
        throw new UnsupportedOperationException();
    }
}
