package com.human.common.gameplay.entity.living.human.marine.ai.follow_leader.action;

import com.human.common.gameplay.entity.ai.goap.MoveToPosAction;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.just.goap.Action;
import com.just.goap.StateKey;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;

public class MoveCloserToLeaderAction {

    private static final StateKey<Float> OLD_WATER_MALUS_COST = StateKey.sensed("old_water_malus_cost");

    public static void onStart(PathfinderMob mob, ReadableWorldState $2, Blackboard blackboard) {
        blackboard.set(OLD_WATER_MALUS_COST, mob.getPathfindingMalus(PathType.WATER));
        mob.setPathfindingMalus(PathType.WATER, 0.0F);
    }

    public static Action.Signal perform(Marine marine, ReadableWorldState $2, Blackboard blackboard) {
        var leaderOrNull = marine.getLeader().unwrapOr(null);

        if (leaderOrNull == null) {
            return Action.Signal.ABORT;
        }

        if (marine.distanceToSqr(leaderOrNull) >= 144.0) {
            teleportToAroundBlockPos(marine, leaderOrNull.blockPosition());
            return Action.Signal.CONTINUE;
        }

        var moveResult = MoveToPosAction.perform(
            marine,
            blackboard,
            leaderOrNull::position,
            1.0D
        );

        return switch (moveResult) {
            case FINISHED, MOVING -> Action.Signal.CONTINUE;
            case NO_PATH, POSITION_NOT_FOUND -> Action.Signal.ABORT;
        };
    }

    public static void onFinish(PathfinderMob mob, ReadableWorldState $2, Blackboard blackboard) {
        mob.getNavigation().stop();
        mob.setPathfindingMalus(PathType.WATER, blackboard.getOrThrow(OLD_WATER_MALUS_COST));
    }

    private static void teleportToAroundBlockPos(Marine marine, BlockPos pos) {
        for (var i = 0; i < 10; ++i) {
            var j = marine.getRandom().nextIntBetweenInclusive(-3, 3);
            var k = marine.getRandom().nextIntBetweenInclusive(-3, 3);

            if (Math.abs(j) >= 2 || Math.abs(k) >= 2) {
                var l = marine.getRandom().nextIntBetweenInclusive(-1, 1);

                if (maybeTeleportTo(marine, pos.getX() + j, pos.getY() + l, pos.getZ() + k)) {
                    return;
                }
            }
        }
    }

    private static boolean maybeTeleportTo(Marine marine, int x, int y, int z) {
        if (!canTeleportTo(marine, new BlockPos(x, y, z))) {
            return false;
        } else {
            marine.moveTo((double) x + 0.5, y, (double) z + 0.5, marine.getYRot(), marine.getXRot());
            marine.getNavigation().stop();
            return true;
        }
    }

    private static boolean canTeleportTo(Marine marine, BlockPos pos) {
        var pathType = WalkNodeEvaluator.getPathTypeStatic(marine, pos);

        if (pathType != PathType.WALKABLE) {
            return false;
        } else {
            var blockPos = pos.subtract(marine.blockPosition());
            return marine.level().noCollision(marine, marine.getBoundingBox().move(blockPos));
        }
    }

    private MoveCloserToLeaderAction() {
        throw new UnsupportedOperationException();
    }
}
