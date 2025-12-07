package com.human.fabric.data.worldgen;

import com.human.common.data.worldgen.HumanOres;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class HumanOreConfigurations {

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> registry) {
        var placedFeatureLookup = registry.lookup(Registries.PLACED_FEATURE);

        HumanOres.getAll().forEach(data -> registry.register(data.configuredFeatureKey(), data.createConfiguredFeature()));
    }
}
