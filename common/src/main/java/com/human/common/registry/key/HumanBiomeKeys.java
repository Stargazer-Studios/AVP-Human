package com.human.common.registry.key;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public class HumanBiomeKeys {

    public static final ResourceKey<Biome> NUKED_BIOME = create("nuked_biome");

    private static ResourceKey<Biome> create(String id) {
        return ResourceKey.create(Registries.BIOME, HumanResources.location(id));
    }
}
