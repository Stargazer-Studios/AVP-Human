package com.human.neoforge.data.impl;

import com.avp.neoforge.data.BiomeFilterRegistryLookup;
import com.avp.neoforge.service.NeoForgeRegistryService;
import com.avp.service.Services;
import com.human.HumanResources;
import com.human.common.data.worldgen.HumanOres;
import com.human.common.registry.key.HumanPlacedFeatureKeys;
import com.human.neoforge.data.HumanFeatureKeys;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.holdersets.AndHolderSet;
import net.neoforged.neoforge.registries.holdersets.NotHolderSet;

import java.util.List;

public class NeoForgeHumanBiomeModifiers {

    private static final NeoForgeRegistryService REGISTRY = (NeoForgeRegistryService) Services.REGISTRY;

    public static void bootstrapBiomeModifiers(BootstrapContext<BiomeModifier> bootstrap) {
        var biomes = bootstrap.lookup(Registries.BIOME);
        var placedFeatures = bootstrap.lookup(Registries.PLACED_FEATURE);
        var biomes0 = new BiomeFilterRegistryLookup(biomes);
        var excludedBiomes = HolderSet.direct(biomes.getOrThrow(Biomes.DRIPSTONE_CAVES));
        var underGround = GenerationStep.Decoration.UNDERGROUND_ORES;

        for (var spawnData : REGISTRY.getEntitySpawnDataEntries()) {
            if (spawnData.isConfigDisabled()) {
                continue;
            }

            var entityType = spawnData.getEntityType();
            var entityTypePath = BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath();
            var spawnKey = ResourceKey.create(
                NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                HumanResources.location("add_spawns_" + entityTypePath)
            );
            var config = spawnData.getConfigData();
            var spawnSettings = config.spawnSettings();

            bootstrap.register(
                spawnKey,
                new BiomeModifiers.AddSpawnsBiomeModifier(
                    biomes.getOrThrow(config.biomeTagKey()),
                    List.of(
                        new MobSpawnSettings.SpawnerData(
                            entityType,
                            spawnSettings.weight(),
                            spawnSettings.minGroupSize(),
                            spawnSettings.maxGroupSize()
                        )
                    )
                )
            );
        }
        bootstrap.register(
            HumanFeatureKeys.ADD_AUTUNITE_GEODE,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanPlacedFeatureKeys.AUTUNITE_GEODE)),
                GenerationStep.Decoration.LOCAL_MODIFICATIONS
            )
        );

        bootstrap.register(
            HumanFeatureKeys.ADD_BAUXITE_MIDDLE,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.BAUXITE_MIDDLE.placedFeatureKey())),
                underGround
            )
        );
        bootstrap.register(
            HumanFeatureKeys.ADD_BAUXITE_UPPER,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.BAUXITE_UPPER.placedFeatureKey())),
                underGround
            )
        );
        bootstrap.register(
            HumanFeatureKeys.ADD_GALENA,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.GALENA.placedFeatureKey())),
                underGround
            )
        );
        bootstrap.register(
            HumanFeatureKeys.ADD_LITHIUM,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.LITHIUM.placedFeatureKey())),
                underGround
            )
        );
        bootstrap.register(
            HumanFeatureKeys.ADD_MONAZITE,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.MONAZITE.placedFeatureKey())),
                underGround
            )
        );
        bootstrap.register(
            HumanFeatureKeys.ADD_SILICON_GRAVEL,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.SILICON_GRAVEL.placedFeatureKey())),
                underGround
            )
        );
        bootstrap.register(
            HumanFeatureKeys.ADD_TITANIUM_LOWER,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.TITANIUM_LOWER.placedFeatureKey())),
                underGround
            )
        );

        bootstrap.register(
            HumanFeatureKeys.ADD_LEAD_SWAMP,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                    List.of(biomes.getOrThrow(Biomes.SWAMP), biomes.getOrThrow(Biomes.MANGROVE_SWAMP))
                ),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.LEAD_SWAMP.placedFeatureKey())),
                underGround
            )
        );

        bootstrap.register(
            HumanFeatureKeys.ADD_LITHIUM_DESERT,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                    List.of(biomes.getOrThrow(Biomes.DESERT), biomes.getOrThrow(Biomes.BADLANDS))
                ),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.LITHIUM_DESERT.placedFeatureKey())),
                underGround
            )
        );

        bootstrap.register(
            HumanFeatureKeys.ADD_MONAZITE_JUNGLE,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_JUNGLE),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.MONAZITE_JUNGLE.placedFeatureKey())),
                underGround
            )
        );

        bootstrap.register(
            HumanFeatureKeys.ADD_ZINC,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                new AndHolderSet<>(
                    biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                    new NotHolderSet<>(biomes0, excludedBiomes)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.ZINC.placedFeatureKey())),
                underGround
            )
        );

        bootstrap.register(
            HumanFeatureKeys.ADD_ZINC_DRIPSTONE_CAVES,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.DRIPSTONE_CAVES)),
                HolderSet.direct(placedFeatures.getOrThrow(HumanOres.ZINC_DRIPSTONE_CAVES.placedFeatureKey())),
                underGround
            )
        );
    }
}
