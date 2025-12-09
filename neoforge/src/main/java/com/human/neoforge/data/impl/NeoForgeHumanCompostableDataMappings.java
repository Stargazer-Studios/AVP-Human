package com.human.neoforge.data.impl;

import com.avp.neoforge.service.NeoForgeRegistryService;
import com.avp.service.Services;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.Compostable;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class NeoForgeHumanCompostableDataMappings extends DataMapProvider {

    private static final NeoForgeRegistryService REGISTRY = (NeoForgeRegistryService) Services.REGISTRY;

    public NeoForgeHumanCompostableDataMappings(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather() {
        var compostablesBuilder = builder(NeoForgeDataMaps.COMPOSTABLES);

        REGISTRY.getCompostableData()
            .forEach(
                compostableData -> compostablesBuilder.add(
                    compostableData.v1().get().asItem().builtInRegistryHolder(),
                    new Compostable(compostableData.v2(), compostableData.v3()),
                    compostableData.v4()
                )
            );
    }
}
