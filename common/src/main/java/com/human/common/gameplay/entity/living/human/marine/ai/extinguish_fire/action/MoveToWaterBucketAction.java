package com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.action;

import com.blib.api.common.goap.v1.action.impl.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.ExtinguishFireSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.PathfinderMob;

public class MoveToWaterBucketAction {

    public static Action.Signal perform(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        var worldState = context.getWorldState();
        var blackboard = context.getBlackboard(Blackboard.Scope.ACTION);
        var waterBucketEntityOption = worldState.getOrDefault(ExtinguishFireSensors.NEAREST_WATER_BUCKET_IN_WORLD.key(), Option.none());

        if (waterBucketEntityOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var itemEntity = waterBucketEntityOption.unwrap();

        return switch (MoveToPosAction.perform(pathfinderMob, blackboard, itemEntity.position(), 1)) {
            case FINISHED, MOVING -> Action.Signal.CONTINUE;
            case NO_PATH -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        pathfinderMob.getNavigation().stop();
    }

    private MoveToWaterBucketAction() {
        throw new UnsupportedOperationException();
    }
}
