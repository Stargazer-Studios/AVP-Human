package com.human.fabric.data.worldgen;

import com.human.common.gameplay.worldgen.structure.HumanCommunicationsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.gameplay.worldgen.structure.HumanMobileLabStructure;
import com.human.common.registry.key.HumanStructureKeys;
import com.human.common.registry.key.HumanStructureTemplatePoolKeys;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.TerrainAdjustment;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class HumanStructures {

    public static void bootstrap(BootstrapContext<Structure> registry) {
        registry.register(HumanStructureKeys.COMMUNICATIONS_OUTPOST, createHumanCommunicationsOutpostStructure(registry));
        registry.register(HumanStructureKeys.MARINE_CAMP_GRASS, createHumanMarineCampStructure(registry));
        registry.register(HumanStructureKeys.MOBILE_LAB, createHumanMobileLabStructure(registry));
    }

    private static @NotNull HumanCommunicationsOutpostStructure createHumanCommunicationsOutpostStructure(
        BootstrapContext<Structure> registry
    ) {
        var biomeLookup = registry.lookup(Registries.BIOME);
        var templatePoolLookup = registry.lookup(Registries.TEMPLATE_POOL);

        var biomes = HolderSet.direct(
            List.of(
                biomeLookup.getOrThrow(Biomes.MEADOW),
                biomeLookup.getOrThrow(Biomes.SAVANNA_PLATEAU)
            )
        );

        var structureSettings = new Structure.StructureSettings.Builder(biomes)
            .generationStep(GenerationStep.Decoration.TOP_LAYER_MODIFICATION)
            .spawnOverrides(Map.of())
            .terrainAdapation(TerrainAdjustment.BEARD_BOX)
            .build();

        var startPool = templatePoolLookup.getOrThrow(HumanStructureTemplatePoolKeys.COMMUNICATIONS_OUTPOST_BOTTOM);

        return new HumanCommunicationsOutpostStructure(structureSettings, startPool);
    }

    private static @NotNull HumanMarineCampStructure createHumanMarineCampStructure(BootstrapContext<Structure> registry) {
        var biomeLookup = registry.lookup(Registries.BIOME);
        var templatePoolLookup = registry.lookup(Registries.TEMPLATE_POOL);

        var biomes = HolderSet.direct(
            List.of(
                biomeLookup.getOrThrow(Biomes.BIRCH_FOREST),
                biomeLookup.getOrThrow(Biomes.FLOWER_FOREST),
                biomeLookup.getOrThrow(Biomes.FOREST),
                biomeLookup.getOrThrow(Biomes.OLD_GROWTH_BIRCH_FOREST),
                biomeLookup.getOrThrow(Biomes.PLAINS),
                biomeLookup.getOrThrow(Biomes.SUNFLOWER_PLAINS),
                biomeLookup.getOrThrow(Biomes.TAIGA)
            )
        );

        var structureSettings = new Structure.StructureSettings.Builder(biomes)
            .generationStep(GenerationStep.Decoration.TOP_LAYER_MODIFICATION)
            .spawnOverrides(Map.of())
            .terrainAdapation(TerrainAdjustment.BEARD_BOX)
            .build();

        var startPool = templatePoolLookup.getOrThrow(HumanStructureTemplatePoolKeys.MARINE_CAMP_GRASS);

        return new HumanMarineCampStructure(structureSettings, startPool);
    }

    private static @NotNull HumanMobileLabStructure createHumanMobileLabStructure(BootstrapContext<Structure> registry) {
        var biomeLookup = registry.lookup(Registries.BIOME);
        var templatePoolLookup = registry.lookup(Registries.TEMPLATE_POOL);

        var biomes = HolderSet.direct(
            List.of(
                biomeLookup.getOrThrow(Biomes.BADLANDS),
                biomeLookup.getOrThrow(Biomes.DESERT),
                biomeLookup.getOrThrow(Biomes.CHERRY_GROVE),
                biomeLookup.getOrThrow(Biomes.ERODED_BADLANDS),
                biomeLookup.getOrThrow(Biomes.PLAINS),
                biomeLookup.getOrThrow(Biomes.SAVANNA),
                biomeLookup.getOrThrow(Biomes.SNOWY_PLAINS),
                biomeLookup.getOrThrow(Biomes.WINDSWEPT_SAVANNA)
            )
        );

        var structureSettings = new Structure.StructureSettings.Builder(biomes)
            .generationStep(GenerationStep.Decoration.SURFACE_STRUCTURES)
            .spawnOverrides(Map.of())
            .terrainAdapation(TerrainAdjustment.BEARD_BOX)
            .build();

        var startPool = templatePoolLookup.getOrThrow(HumanStructureTemplatePoolKeys.MOBILE_LAB);

        return new HumanMobileLabStructure(structureSettings, startPool);
    }
}
