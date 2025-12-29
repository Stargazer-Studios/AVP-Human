package com.human.common.gameplay.entity.living.human.marine.ai.idle.action;

import com.human.common.gameplay.entity.ai.goap.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.ai.util.LandRandomPos;

public class WanderAction {

    public static Action.Signal perform(Marine marine, ReadableWorldState $2, Blackboard blackboard) {
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

    public static void onFinish(Marine marine, ReadableWorldState $2, Blackboard $3) {
        marine.getNavigation().stop();
    }

    private WanderAction() {
        throw new UnsupportedOperationException();
    }
}
