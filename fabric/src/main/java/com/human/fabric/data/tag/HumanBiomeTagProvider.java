package com.human.fabric.data.tag;

import com.human.common.registry.key.HumanBiomeKeys;
import com.human.common.registry.tag.HumanBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;

import java.util.concurrent.CompletableFuture;

public class HumanBiomeTagProvider extends FabricTagProvider<Biome> {

    public HumanBiomeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, Registries.BIOME, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        getOrCreateTagBuilder(HumanBiomeTags.HAS_MARINE_CAMP_GRASS)
            .add(Biomes.BIRCH_FOREST)
            .add(Biomes.FOREST)
            .add(Biomes.MEADOW)
            .add(Biomes.PLAINS);

        applyStandardMarineBiomes(HumanBiomeTags.HAS_MARINE_PATROLS)
            .addOptionalTag(BiomeTags.IS_SAVANNA);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_MOBILE_LAB)
            .add(Biomes.BADLANDS)
            .add(Biomes.CHERRY_GROVE)
            .add(Biomes.DESERT)
            .add(Biomes.SAVANNA)
            .add(Biomes.STONY_SHORE)
            .add(Biomes.SNOWY_PLAINS);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_COMMS)
            .add(Biomes.FLOWER_FOREST)
            .add(Biomes.SUNFLOWER_PLAINS)
            .add(Biomes.WINDSWEPT_HILLS)
            .add(Biomes.WINDSWEPT_SAVANNA);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_MUNITION)
            .add(Biomes.SNOWY_TAIGA)
            .add(Biomes.TAIGA);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_SUPPLY_BADLAND)
            .add(Biomes.BADLANDS);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_SUPPLY_DESERT)
            .add(Biomes.DESERT);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_TACTICAL_MARINE_PATROLS)
            .addOptionalTag(BiomeTags.IS_JUNGLE)
            .add(Biomes.DARK_FOREST)
            .add(Biomes.MANGROVE_SWAMP)
            .add(Biomes.SWAMP);

        applyStandardWYBiomes(HumanBiomeTags.HAS_WY_APE_PATROLS);
        applyStandardWYBiomes(HumanBiomeTags.HAS_WY_COMMANDO_PATROLS)
            .add(Biomes.DARK_FOREST);
        applyStandardWYBiomes(HumanBiomeTags.HAS_WY_ELITE_PATROLS);
        applyStandardWYBiomes(HumanBiomeTags.HAS_WY_SPEC_OPS_COMMANDO_PATROLS)
            .add(Biomes.DARK_FOREST);
        applyStandardWYBiomes(HumanBiomeTags.HAS_WY_SPEC_OPS_ELITE_PATROLS)
            .add(Biomes.DARK_FOREST);

        getOrCreateTagBuilder(HumanBiomeTags.IS_IRRADIATED)
            .addOptional(HumanBiomeKeys.NUKED_BIOME);
    }

    private FabricTagProvider<Biome>.FabricTagBuilder applyStandardMarineBiomes(TagKey<Biome> biomeTag) {
        return getOrCreateTagBuilder(biomeTag)
            .addOptionalTag(BiomeTags.IS_TAIGA)
            .add(Biomes.BADLANDS)
            .add(Biomes.BIRCH_FOREST)
            .add(Biomes.DESERT)
            .add(Biomes.FLOWER_FOREST)
            .add(Biomes.FOREST)
            .add(Biomes.GROVE)
            .add(Biomes.MEADOW)
            .add(Biomes.OLD_GROWTH_BIRCH_FOREST)
            .add(Biomes.PLAINS)
            .add(Biomes.SUNFLOWER_PLAINS)
            .add(Biomes.WINDSWEPT_HILLS)
            .add(Biomes.WINDSWEPT_SAVANNA);
    }

    private FabricTagProvider<Biome>.FabricTagBuilder applyStandardWYBiomes(TagKey<Biome> biomeTag) {
        return getOrCreateTagBuilder(biomeTag)
            .addOptionalTag(BiomeTags.IS_TAIGA)
            .add(Biomes.BIRCH_FOREST)
            .add(Biomes.OLD_GROWTH_BIRCH_FOREST);
    }
}
