package com.human.common.registry.key;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class HumanPlacedFeatureKeys {

    public static final ResourceKey<PlacedFeature> AUTUNITE_GEODE = ResourceKey.create(
        Registries.PLACED_FEATURE,
        HumanResources.location("autunite_geode")
    );
}
