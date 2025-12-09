package com.human.neoforge.data.impl;

import com.avp.neoforge.service.NeoForgeRegistryService;
import com.avp.service.Services;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class NeoForgeHumanFurnaceFuelDataMappings extends DataMapProvider {

    private static final NeoForgeRegistryService REGISTRY = (NeoForgeRegistryService) Services.REGISTRY;

    public NeoForgeHumanFurnaceFuelDataMappings(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        var furnaceFuelBuilder = builder(NeoForgeDataMaps.FURNACE_FUELS);

        REGISTRY.getFurnaceFuelPairs()
            .forEach(
                fuelPair -> furnaceFuelBuilder.add(
                    fuelPair.v1().get().asItem().builtInRegistryHolder(),
                    new FurnaceFuel(fuelPair.v2()),
                    false
                )
            );
    }
}
