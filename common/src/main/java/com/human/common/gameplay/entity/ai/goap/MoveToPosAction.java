package com.human.common.gameplay.entity.ai.goap;

import com.just.goap.StateKey;
import com.just.goap.state.Blackboard;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.level.pathfinder.Path;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import java.util.function.Supplier;

// TODO: Move to BLib.
public class MoveToPosAction {

    private static final StateKey<Path> PATH = StateKey.sensed("path");

    public static MoveResult perform(
        PathfinderMob pathfinderMob,
        Blackboard blackboard,
        Supplier<@Nullable Vec3> positionSupplier,
        double speedMultiplier
    ) {
        var pathOrNull = blackboard.getOrNull(PATH);
        var navigation = pathfinderMob.getNavigation();

        if (pathOrNull == null || !pathOrNull.canReach()) {
            var position = positionSupplier.get();

            if (position == null) {
                return MoveResult.POSITION_NOT_FOUND;
            }

            pathOrNull = navigation.createPath(position.x, position.y, position.z, 1);

            if (pathOrNull != null && pathOrNull.canReach()) {
                blackboard.set(PATH, pathOrNull);
                navigation.moveTo(pathOrNull, speedMultiplier);

                return MoveResult.MOVING;
            } else {
                return MoveResult.NO_PATH;
            }
        }

        if (pathOrNull.isDone()) {
            blackboard.set(PATH, null);
            return MoveResult.FINISHED;
        }

        return MoveResult.MOVING;
    }

    public enum MoveResult {
        FINISHED,
        MOVING,
        NO_PATH,
        POSITION_NOT_FOUND,
    }
}
