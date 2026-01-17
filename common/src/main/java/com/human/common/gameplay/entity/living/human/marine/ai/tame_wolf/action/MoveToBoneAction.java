package com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action;

import com.human.common.gameplay.entity.ai.goap.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.TameWolfSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.PathfinderMob;

public class MoveToBoneAction {

    public static Action.Signal perform(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        var worldState = context.getWorldState();
        var blackboard = context.getBlackboard(Blackboard.Scope.ACTION);
        var boneEntityOption = worldState.getOrDefault(TameWolfSensors.NEAREST_BONE_IN_WORLD.key(), Option.none());

        if (boneEntityOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var boneEntity = boneEntityOption.unwrap();

        return switch (MoveToPosAction.perform(pathfinderMob, blackboard, boneEntity::position, 1)) {
            case FINISHED, MOVING -> Action.Signal.CONTINUE;
            case NO_PATH, POSITION_NOT_FOUND -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        pathfinderMob.getNavigation().stop();
    }

    private MoveToBoneAction() {
        throw new UnsupportedOperationException();
    }
}
