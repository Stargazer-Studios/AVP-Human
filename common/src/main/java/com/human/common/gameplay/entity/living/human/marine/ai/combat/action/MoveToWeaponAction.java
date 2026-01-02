package com.human.common.gameplay.entity.living.human.marine.ai.combat.action;

import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.StateKey;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.pathfinder.Path;

public class MoveToWeaponAction {

    private static final StateKey<Path> PATH_TO_WEAPON = StateKey.sensed("path_to_weapon");

    public static Action.Signal perform(PathfinderMob pathfinderMob, ReadableWorldState worldState, Blackboard blackboard) {
        var worldItemTargetOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON_IN_WORLD.key(), Option.none());

        if (worldItemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var itemEntity = worldItemTargetOption.unwrap().itemTarget().itemEntity();

        var path = blackboard.getOrNull(PATH_TO_WEAPON);

        if (path == null) {
            path = pathfinderMob.getNavigation().createPath(itemEntity, 0);
        }

        if (path != null) {
            pathfinderMob.getNavigation().moveTo(path, 1);
        }

        return Action.Signal.CONTINUE;
    }

    public static void onFinish(PathfinderMob pathfinderMob, ReadableWorldState worldState, Blackboard blackboard) {
        pathfinderMob.getNavigation().stop();
    }

    private MoveToWeaponAction() {
        throw new UnsupportedOperationException();
    }
}
