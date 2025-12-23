package com.human.common.gameplay.worldgen.structure.util;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import org.jetbrains.annotations.NotNull;

public class StructureUtil {

    public static boolean hasAtLeast1NonWaterCorner(@NotNull Structure.GenerationContext generationContext) {
        // Grabs the chunk position we are at
        var chunkPos = generationContext.chunkPos();

        // Get first non-air block.
        var occupiedYPos = generationContext.chunkGenerator()
            .getFirstOccupiedHeight(
                chunkPos.getMinBlockX(),
                chunkPos.getMinBlockZ(),
                Heightmap.Types.WORLD_SURFACE_WG,
                generationContext.heightAccessor(),
                generationContext.randomState()
            );

        // Get column of blocks at corner of the chunk. BEWARE, getBaseColumn is an expensive call. Call this as few
        // times as possible for your checks. Note, this column of blocks only has the raw terrain of the world which
        // for the Overworld is Stone, Water, and Air.
        var columnOfBlocks = generationContext.chunkGenerator()
            .getBaseColumn(
                chunkPos.getBlockX(0),
                chunkPos.getBlockZ(0),
                generationContext.heightAccessor(),
                generationContext.randomState()
            );

        // Grab the block at the specified Y value.
        var blockState = columnOfBlocks.getBlock(occupiedYPos);

        // Checks to make sure our structure only spawns if the spot does NOT have water.
        return !blockState.getFluidState().is(FluidTags.WATER);
    }

    private StructureUtil() {
        throw new UnsupportedOperationException();
    }
}
