package com.human.common.gameplay.entity.living.human.marine.ai.break_fall.sensor;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.break_fall.BreakFallSensors;
import com.just.core.functional.option.Option;
import net.minecraft.core.BlockPos;
import org.jetbrains.annotations.NotNull;

public class LandingBlockPosSensor {

    public static @NotNull Option<BlockPos> sense(Marine marine) {
        var level = marine.level();
        var startPos = marine.blockPosition();

        // Search downward for a solid block.
        for (int y = 0; y < BreakFallSensors.MAX_LANDING_SEARCH_DEPTH; y++) {
            var checkPos = startPos.below(y);
            var blockState = level.getBlockState(checkPos);
            var belowPos = checkPos.below();
            var belowState = level.getBlockState(belowPos);

            // If we hit a solid block below and the current position is replaceable, this is our landing spot.
            if (blockState.canBeReplaced() && !belowState.canBeReplaced() && !belowState.isAir()) {
                return Option.some(checkPos);
            }

            // If we hit a solid block directly, the landing spot is above it.
            if (!blockState.canBeReplaced() && !blockState.isAir()) {
                // The landing position is above this solid block.
                var abovePos = checkPos.above();
                var aboveState = level.getBlockState(abovePos);

                if (aboveState.canBeReplaced()) {
                    return Option.some(abovePos);
                }

                // Can't place water here.
                return Option.none();
            }
        }

        return Option.none();
    }
}
