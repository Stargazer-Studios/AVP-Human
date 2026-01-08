package com.human.common.gameplay.entity.living.human.marine.ai.combat.action;

import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.StateKey;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.pathfinder.Path;

public class MoveUntilAttackTargetInRangeForEquippedBestWeaponAction {

    private static final StateKey<Path> PATH_TO_ATTACK_TARGET = StateKey.sensed("path_to_attack_target");

    public static Action.Signal perform(PathfinderMob pathfinderMob, ReadableWorldState worldState, Blackboard blackboard) {
        var weaponStrategyResultOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON_IN_HANDS.key(), Option.none());

        var attackTargetOption = worldState.getOrDefault(CombatSensors.NEAREST_ATTACKABLE_TARGET.key(), Option.none());

        if (weaponStrategyResultOption.isNone() || attackTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        var attackTarget = attackTargetOption.unwrap();
        var pathToAttackTargetOrNull = blackboard.getOrNull(PATH_TO_ATTACK_TARGET);

        if (pathToAttackTargetOrNull == null || pathToAttackTargetOrNull.isDone()) {
            pathToAttackTargetOrNull = pathfinderMob.getNavigation().createPath(attackTarget, 1);
            blackboard.set(PATH_TO_ATTACK_TARGET, pathToAttackTargetOrNull);
        }

        if (pathToAttackTargetOrNull != null) {
            pathfinderMob.getNavigation().moveTo(pathToAttackTargetOrNull, 1.0);
        }

        return Action.Signal.CONTINUE;
    }

    public static void onFinish(PathfinderMob pathfinderMob, ReadableWorldState worldState, Blackboard blackboard) {
        pathfinderMob.getNavigation().stop();
    }

    private MoveUntilAttackTargetInRangeForEquippedBestWeaponAction() {
        throw new UnsupportedOperationException();
    }
}
