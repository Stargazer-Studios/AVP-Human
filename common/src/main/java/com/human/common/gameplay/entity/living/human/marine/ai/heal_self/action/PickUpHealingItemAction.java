package com.human.common.gameplay.entity.living.human.marine.ai.heal_self.action;

import com.blib.api.common.inventory.v1.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.ai.generic.action.PickUpItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.HealingSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import net.minecraft.world.entity.LivingEntity;

public class PickUpHealingItemAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(Action.Context<T> context) {
        var livingEntityWithInventory = context.getActor();
        var worldState = context.getWorldState();
        var worldItemTargetOption = worldState.getOrDefault(HealingSensors.BEST_HEALING_ITEM_IN_WORLD.key(), Option.none());

        if (worldItemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return PickUpItemAction.perform(livingEntityWithInventory, worldItemTargetOption.unwrap().itemTarget().itemEntity());
    }

    private PickUpHealingItemAction() {
        throw new UnsupportedOperationException();
    }
}
