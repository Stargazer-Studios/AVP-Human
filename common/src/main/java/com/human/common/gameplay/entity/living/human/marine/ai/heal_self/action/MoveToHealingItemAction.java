package com.human.common.gameplay.entity.living.human.marine.ai.heal_self.action;

import com.human.common.gameplay.entity.ai.goap.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.HealingSensors;
import com.just.core.functional.option.Option;
import com.just.goap.action.Action;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.PathfinderMob;

public class MoveToHealingItemAction {

    public static Action.Signal perform(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        var worldState = context.getWorldState();
        var blackboard = context.getBlackboard(Blackboard.Scope.ACTION);
        var worldItemTargetOption = worldState.getOrDefault(HealingSensors.BEST_HEALING_ITEM_IN_WORLD.key(), Option.none());

        if (worldItemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var itemEntity = worldItemTargetOption.unwrap().itemTarget().itemEntity();

        return switch (MoveToPosAction.perform(pathfinderMob, blackboard, itemEntity::position, 1)) {
            case FINISHED, MOVING -> Action.Signal.CONTINUE;
            case NO_PATH, POSITION_NOT_FOUND -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(Action.Context<? extends PathfinderMob> context) {
        var pathfinderMob = context.getActor();
        pathfinderMob.getNavigation().stop();
    }

    private MoveToHealingItemAction() {
        throw new UnsupportedOperationException();
    }
}
