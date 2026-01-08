package com.human.common.gameplay.entity.living.human.marine.ai.combat.action;

import com.human.common.gameplay.entity.ai.goap.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.PathfinderMob;

public class MoveToWeaponAction {

    public static Action.Signal perform(PathfinderMob pathfinderMob, ReadableWorldState worldState, Blackboard blackboard) {
        var worldItemTargetOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON_IN_WORLD.key(), Option.none());

        if (worldItemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var itemEntity = worldItemTargetOption.unwrap().itemTarget().itemEntity();

        return switch (MoveToPosAction.perform(pathfinderMob, blackboard, itemEntity::position, 1)) {
            case FINISHED, MOVING -> Action.Signal.CONTINUE;
            case NO_PATH, POSITION_NOT_FOUND -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(PathfinderMob pathfinderMob, ReadableWorldState worldState, Blackboard blackboard) {
        pathfinderMob.getNavigation().stop();
    }

    private MoveToWeaponAction() {
        throw new UnsupportedOperationException();
    }
}
