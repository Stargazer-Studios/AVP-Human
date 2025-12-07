package com.human.fabric.data.tag;

import com.human.common.registry.key.HumanBiomeKeys;
import com.human.common.registry.tag.HumanBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
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
            .add(Biomes.MEADOW)
            .add(Biomes.PLAINS)
            .add(Biomes.FOREST)
            .add(Biomes.BIRCH_FOREST);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_MOBILE_LAB)
            .add(Biomes.SAVANNA)
            .add(Biomes.STONY_SHORE)
            .add(Biomes.SNOWY_PLAINS)
            .add(Biomes.BADLANDS)
            .add(Biomes.CHERRY_GROVE)
            .add(Biomes.DESERT);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_COMMS)
            .add(Biomes.WINDSWEPT_SAVANNA)
            .add(Biomes.WINDSWEPT_HILLS)
            .add(Biomes.FLOWER_FOREST)
            .add(Biomes.SUNFLOWER_PLAINS);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_MUNITION)
            .add(Biomes.TAIGA)
            .add(Biomes.SNOWY_TAIGA);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_SUPPLY_BADLAND)
            .add(Biomes.BADLANDS);

        getOrCreateTagBuilder(HumanBiomeTags.HAS_OUTPOST_SUPPLY_DESERT)
            .add(Biomes.DESERT);

        getOrCreateTagBuilder(HumanBiomeTags.IS_IRRADIATED)
            .addOptional(HumanBiomeKeys.NUKED_BIOME);
    }
}
