package com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.TameWolfSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import net.minecraft.world.item.Items;

public class UseBoneOnWolfAction {

    public static Action.Signal perform(Action.Context<? extends Marine> context) {
        var marine = context.getActor();
        var worldState = context.getWorldState();
        var wolfOption = worldState.getOrDefault(TameWolfSensors.NEAREST_UNTAMED_WOLF.key(), Option.none());

        if (wolfOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var wolf = wolfOption.unwrap();

        // Ensure marine has a bone in main hand.
        var mainHandItem = marine.getMainHandItem();

        if (!mainHandItem.is(Items.BONE)) {
            return Action.Signal.ABORT;
        }

        // Make the marine look at the wolf.
        marine.getLookControl().setLookAt(wolf, 30.0F, 30.0F);

        // Consume the bone.
        mainHandItem.shrink(1);

        // Attempt to tame the wolf (1/3 chance, same as vanilla).
        if (marine.getRandom().nextInt(3) == 0) {
            // Taming successful! Tame the wolf to the marine's leader if they have one,
            // otherwise tame to the marine itself.
            var ownerUUID = marine.getLeaderUUID().unwrapOr(marine.getUUID());

            wolf.setTame(true, true);
            wolf.setOwnerUUID(ownerUUID);
            wolf.getNavigation().stop();
            wolf.setOrderedToSit(false);
            wolf.setInSittingPose(false);
            // Hearts particle effect.
            wolf.level().broadcastEntityEvent(wolf, (byte) 7);

            return Action.Signal.CONTINUE;
        } else {
            // Taming failed, show smoke particles.
            wolf.level().broadcastEntityEvent(wolf, (byte) 6);
        }

        // If we still have bones equipped, continue trying.
        if (marine.getMainHandItem().is(Items.BONE) && marine.getMainHandItem().getCount() > 0) {
            return Action.Signal.CONTINUE;
        }

        // Check if we have more bones in inventory.
        var hasBoneInInventory = worldState.getOrDefault(TameWolfSensors.HAS_BONE_IN_INVENTORY.key(), false);

        if (hasBoneInInventory) {
            // Need to equip another bone, so abort this action to re-plan.
            return Action.Signal.ABORT;
        }

        // No more bones, abort.
        return Action.Signal.ABORT;
    }

    private UseBoneOnWolfAction() {
        throw new UnsupportedOperationException();
    }
}
