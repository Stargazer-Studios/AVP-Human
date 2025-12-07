package com.human.fabric;

import com.human.Human;
import com.human.common.data.worldgen.HumanVillageInjection;
import com.human.common.registry.init.HumanVillagerProfessions;
import com.human.common.registry.key.HumanVillagerGiftKeys;
import com.human.fabric.common.worldgen.WorldGen;
import com.human.fabric.data.loot.LootTableModifier;
import com.human.mixin.GiveGiftToHeroAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;

public class HumanFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Human.initialize();

        // Core
        WorldGen.initialize();

        // Functionality
        LootTableModifier.initialize();
        ServerTickEvents.START_WORLD_TICK.register(this::onWorldTick);
        ServerLifecycleEvents.SERVER_STARTING.register(this::addNewVillageBuilding);
    }

    private void onWorldTick(ServerLevel serverLevel) {
        Human.CUSTOM_SPAWNER.tick(serverLevel, serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING), true);
        Human.NUKED_ASH_PLACEMENT.tick(serverLevel);
        modifyGifts();
    }

    public static void modifyGifts() {
        var gifts = GiveGiftToHeroAccessor.getGifts();

        gifts.put(HumanVillagerProfessions.COMMISSARY.get(), HumanVillagerGiftKeys.COMMISSARY_GIFT_LOOT_TABLE);
    }

    public void addNewVillageBuilding(final MinecraftServer event) {
        var templatePoolRegistry = event.registryAccess().registryOrThrow(Registries.TEMPLATE_POOL);
        var processorListRegistry = event.registryAccess().registryOrThrow(Registries.PROCESSOR_LIST);

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/plains/houses"),
            "avp:village/plains/houses/plains_commissary",
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/snowy/houses"),
            "avp:village/snowy/houses/snowy_commissary",
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/savanna/houses"),
            "avp:village/savanna/houses/savanna_commissary",
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/taiga/houses"),
            "avp:village/taiga/houses/taiga_commissary",
            5
        );

        HumanVillageInjection.addBuildingToPool(
            templatePoolRegistry,
            processorListRegistry,
            ResourceLocation.withDefaultNamespace("village/desert/houses"),
            "avp:village/desert/houses/desert_commissary",
            5
        );
    }
}
