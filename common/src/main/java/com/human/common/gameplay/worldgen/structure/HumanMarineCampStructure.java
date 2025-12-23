package com.human.common.gameplay.worldgen.structure;

import com.blib.common.gameplay.structure.JigsawBackedStructure;
import com.human.common.registry.init.HumanStructureTypes;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.heightproviders.ConstantHeight;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.DimensionPadding;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.LiquidSettings;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Optional;

public class HumanMarineCampStructure extends JigsawBackedStructure {

    public static final MapCodec<HumanMarineCampStructure> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            settingsCodec(instance),
            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter((structure) -> structure.startPool)
        )
            .apply(instance, HumanMarineCampStructure::new)
    );

    public static final String NAME = "marine_camp_grass";

    public HumanMarineCampStructure(
        Structure.StructureSettings structureSettings,
        Holder<StructureTemplatePool> startPool
    ) {
        super(
            structureSettings,
            startPool,
            Optional.empty(),
            1,
            ConstantHeight.of(VerticalAnchor.absolute(-1)),
            false,
            Optional.of(Heightmap.Types.WORLD_SURFACE_WG),
            116,
            List.of(),
            DimensionPadding.ZERO,
            LiquidSettings.APPLY_WATERLOGGING
        );
    }

    @Override
    protected @NotNull Optional<GenerationStub> findGenerationPoint(@NotNull GenerationContext generationContext) {
        if (!extraSpawningChecks(generationContext)) {
            return Optional.empty();
        }

        return super.findGenerationPoint(generationContext);
    }

    private boolean extraSpawningChecks(@NotNull Structure.GenerationContext generationContext) {
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

    @Override
    public @NotNull StructureType<?> type() {
        return HumanStructureTypes.MARINE_CAMP.get();
    }
}
