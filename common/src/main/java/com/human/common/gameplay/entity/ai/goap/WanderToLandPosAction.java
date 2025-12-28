package com.human.common.gameplay.entity.ai.goap;

import com.just.goap.StateKey;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.util.LandRandomPos;
import net.minecraft.world.level.pathfinder.Path;

public class WanderToLandPosAction {

    private static final StateKey<Path> PATH = StateKey.sensed("path");

    public static WanderResult perform(PathfinderMob pathfinderMob, Blackboard blackboard, double speedMultiplier) {
        var pathOrNull = blackboard.getOrNull(PATH);
        var navigation = pathfinderMob.getNavigation();

        if (pathOrNull == null) {
            var randomPosition = LandRandomPos.getPos(pathfinderMob, 10, 7);

            if (randomPosition == null) {
                return WanderResult.POSITION_NOT_FOUND;
            }

            pathOrNull = navigation.createPath(randomPosition.x, randomPosition.y, randomPosition.z, 1);

            if (pathOrNull != null) {
                blackboard.set(PATH, pathOrNull);
                navigation.moveTo(pathOrNull, speedMultiplier);

                return WanderResult.MOVING;
            } else {
                return WanderResult.NO_PATH;
            }
        }

        return pathOrNull.isDone()
            ? WanderResult.FINISHED
            : WanderResult.MOVING;
    }

    public enum WanderResult {
        FINISHED,
        MOVING,
        NO_PATH,
        POSITION_NOT_FOUND,
    }
}
