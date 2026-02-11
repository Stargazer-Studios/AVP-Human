package com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action;

import com.blib.api.common.goap.v1.action.impl.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.TameWolfSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.PathfinderMob;

public class MoveToWolfAction {

    public static Action.Signal perform(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        var worldState = context.getWorldState();
        var blackboard = context.getBlackboard(Blackboard.Scope.ACTION);
        var wolfOption = worldState.getOrDefault(TameWolfSensors.NEAREST_UNTAMED_WOLF.key(), Option.none());

        if (wolfOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var wolf = wolfOption.unwrap();

        return switch (MoveToPosAction.perform(pathfinderMob, blackboard, wolf.position(), 1)) {
            case FINISHED, MOVING -> Action.Signal.CONTINUE;
            case NO_PATH -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        pathfinderMob.getNavigation().stop();
    }

    private MoveToWolfAction() {
        throw new UnsupportedOperationException();
    }
}
