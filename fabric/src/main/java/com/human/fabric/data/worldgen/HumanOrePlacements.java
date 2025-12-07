package com.human.fabric.data.worldgen;

import com.human.common.data.worldgen.HumanOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

public class HumanOrePlacements {

    public static void bootstrap(BootstrapContext<PlacedFeature> registry) {
        var configuredFeatureLookup = registry.lookup(Registries.CONFIGURED_FEATURE);

        HumanOres.getAll().forEach(data -> registry.register(data.placedFeatureKey(), data.createPlacedFeature(configuredFeatureLookup)));
    }
}
