package com.human.common.gameplay.worldgen.structure;

import com.human.Human;
import com.human.common.data.worldgen.HumanVillageInjection;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;

public class HumanCommissaryVillagerHouseInjector {

    public static void inject(MinecraftServer minecraftServer) {
        var registryAccess = minecraftServer.registryAccess();
        var templatePoolRegistry = registryAccess.registry(Registries.TEMPLATE_POOL)
            .orElseThrow();
        var processorListRegistry = registryAccess.registry(Registries.PROCESSOR_LIST)
            .orElseThrow();

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/plains/houses"),
            Human.MOD.resources().createLocation("village/plains/houses/plains_commissary"),
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/snowy/houses"),
            Human.MOD.resources().createLocation("village/snowy/houses/snowy_commissary"),
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/savanna/houses"),
            Human.MOD.resources().createLocation("village/savanna/houses/savanna_commissary"),
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/taiga/houses"),
            Human.MOD.resources().createLocation("village/taiga/houses/taiga_commissary"),
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/desert/houses"),
            Human.MOD.resources().createLocation("village/desert/houses/desert_commissary"),
            5
        );
    }
}
