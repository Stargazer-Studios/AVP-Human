package com.human.common.gameplay.entity.living.human.marine.ai.equip_totem.action;

import com.blib.api.common.inventory.v1.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.ai.generic.action.PickUpItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_totem.TotemSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import net.minecraft.world.entity.LivingEntity;

public class PickUpTotemAction {

    public static <T extends LivingEntity & BLibInventoryHolder> Action.Signal perform(Action.Context<T> context) {
        var livingEntityWithInventory = context.getActor();
        var worldState = context.getWorldState();
        var totemEntityOption = worldState.getOrDefault(TotemSensors.NEAREST_TOTEM_IN_WORLD.key(), Option.none());

        if (totemEntityOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return PickUpItemAction.perform(livingEntityWithInventory, totemEntityOption.unwrap());
    }

    private PickUpTotemAction() {
        throw new UnsupportedOperationException();
    }
}
