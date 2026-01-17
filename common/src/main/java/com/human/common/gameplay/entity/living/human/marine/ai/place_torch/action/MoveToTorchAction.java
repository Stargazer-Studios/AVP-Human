package com.human.common.gameplay.entity.living.human.marine.ai.place_torch.action;

import com.human.common.gameplay.entity.ai.goap.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.ai.place_torch.TorchSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.PathfinderMob;

public class MoveToTorchAction {

    public static Action.Signal perform(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        var worldState = context.getWorldState();
        var blackboard = context.getBlackboard(Blackboard.Scope.ACTION);
        var torchEntityOption = worldState.getOrDefault(TorchSensors.NEAREST_TORCH_IN_WORLD.key(), Option.none());

        if (torchEntityOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var torchEntity = torchEntityOption.unwrap();

        return switch (MoveToPosAction.perform(pathfinderMob, blackboard, torchEntity::position, 1)) {
            case FINISHED, MOVING -> Action.Signal.CONTINUE;
            case NO_PATH, POSITION_NOT_FOUND -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        pathfinderMob.getNavigation().stop();
    }

    private MoveToTorchAction() {
        throw new UnsupportedOperationException();
    }
}
