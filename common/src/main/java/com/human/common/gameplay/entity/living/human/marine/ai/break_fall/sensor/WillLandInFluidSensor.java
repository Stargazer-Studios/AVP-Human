package com.human.common.gameplay.entity.living.human.marine.ai.break_fall.sensor;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.break_fall.BreakFallSensors;
import org.jetbrains.annotations.NotNull;

public class WillLandInFluidSensor {

    public static @NotNull Boolean sense(Marine marine) {
        var level = marine.level();
        var startPos = marine.blockPosition();

        // Search downward for fluid or solid ground.
        for (int y = 0; y < BreakFallSensors.MAX_LANDING_SEARCH_DEPTH; y++) {
            var checkPos = startPos.below(y);
            var blockState = level.getBlockState(checkPos);
            var fluidState = blockState.getFluidState();

            // Check if this is a fluid.
            if (!fluidState.isEmpty() && fluidState.isSource()) {
                return true;
            }

            // If we hit solid ground without finding fluid, we won't land in fluid.
            if (!blockState.canBeReplaced() && !blockState.isAir()) {
                return false;
            }
        }

        return false;
    }
}
