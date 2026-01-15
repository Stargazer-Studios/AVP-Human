package com.human.common.gameplay.entity.living.human.marine.ai.idle.action;

import com.human.common.gameplay.entity.ai.goap.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.just.goap.action.Action;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.ai.util.LandRandomPos;

public class WanderAction {

    public static Action.Signal perform(Action.Context<Marine> context) {
        var marine = context.getActor();
        var blackboard = context.getBlackboard(Blackboard.Scope.ACTION);
        var moveResult = MoveToPosAction.perform(
            marine,
            blackboard,
            () -> LandRandomPos.getPos(marine, 10, 7),
            0.8D
        );

        return switch (moveResult) {
            case FINISHED -> {
                marine.resetTicksUntilBored();
                yield Action.Signal.CONTINUE;
            }
            case MOVING -> Action.Signal.CONTINUE;
            case NO_PATH, POSITION_NOT_FOUND -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(Action.Context<Marine> context) {
        var marine = context.getActor();
        marine.getNavigation().stop();
    }

    private WanderAction() {
        throw new UnsupportedOperationException();
    }
}
