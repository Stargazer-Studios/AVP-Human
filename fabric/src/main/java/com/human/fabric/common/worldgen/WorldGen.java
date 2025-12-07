package com.human.fabric.common.worldgen;

import com.human.HumanResources;
import com.human.common.data.worldgen.HumanOres;
import com.human.common.registry.key.HumanPlacedFeatureKeys;
import net.fabricmc.fabric.api.biome.v1.BiomeModificationContext;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectionContext;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.biome.v1.ModificationPhase;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.levelgen.GenerationStep;

import java.util.function.BiConsumer;

public class WorldGen {

    private static final ResourceLocation RESOURCE_LOCATION = HumanResources.location("features");

    public static void initialize() {
        // modify the biomes
        BiomeModifications.create(RESOURCE_LOCATION)
            // Bauxite Ore
            .add(ModificationPhase.ADDITIONS, BiomeSelectors.foundInOverworld(), overworldOreModifiers())
            // Lead Ore
            .add(ModificationPhase.ADDITIONS, context -> {
                var key = context.getBiomeKey();
                return key.equals(Biomes.SWAMP) || key.equals(Biomes.MANGROVE_SWAMP);
            }, leadOreSwampModifiers())
            // Lithium Ore
            .add(
                ModificationPhase.ADDITIONS,
                context -> context.getBiomeKey().equals(Biomes.DESERT) || context.hasTag(BiomeTags.IS_BADLANDS),
                lithiumOreDesertModifiers()
            )
            // Monazite Ore
            .add(ModificationPhase.ADDITIONS, context -> context.hasTag(BiomeTags.IS_JUNGLE), monaziteOreJungleModifiers())
            // Zinc Ore
            .add(ModificationPhase.ADDITIONS, context -> !context.getBiomeKey().equals(Biomes.DRIPSTONE_CAVES), zincOreModifiers())
            .add(
                ModificationPhase.ADDITIONS,
                context -> context.getBiomeKey().equals(Biomes.DRIPSTONE_CAVES),
                zincOreDripstoneCaveModifiers()
            );
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> overworldOreModifiers() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            var settings = biomeModificationContext.getGenerationSettings();

            settings.addFeature(GenerationStep.Decoration.LOCAL_MODIFICATIONS, HumanPlacedFeatureKeys.AUTUNITE_GEODE);

            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.BAUXITE_MIDDLE.placedFeatureKey());
            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.BAUXITE_UPPER.placedFeatureKey());
            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.GALENA.placedFeatureKey());
            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.LITHIUM.placedFeatureKey());
            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.MONAZITE.placedFeatureKey());
            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.SILICON_GRAVEL.placedFeatureKey());
            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.TITANIUM_LOWER.placedFeatureKey());
        };
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> leadOreSwampModifiers() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            var settings = biomeModificationContext.getGenerationSettings();

            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.LEAD_SWAMP.placedFeatureKey());
        };
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> lithiumOreDesertModifiers() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            var settings = biomeModificationContext.getGenerationSettings();

            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.LITHIUM_DESERT.placedFeatureKey());
        };
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> monaziteOreJungleModifiers() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            var settings = biomeModificationContext.getGenerationSettings();

            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.MONAZITE_JUNGLE.placedFeatureKey());
        };
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> zincOreModifiers() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            var settings = biomeModificationContext.getGenerationSettings();

            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.ZINC.placedFeatureKey());
        };
    }

    private static BiConsumer<BiomeSelectionContext, BiomeModificationContext> zincOreDripstoneCaveModifiers() {
        return (biomeSelectionContext, biomeModificationContext) -> {
            var settings = biomeModificationContext.getGenerationSettings();

            settings.addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, HumanOres.ZINC_DRIPSTONE_CAVES.placedFeatureKey());
        };
    }
}
