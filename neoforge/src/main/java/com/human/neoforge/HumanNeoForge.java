package com.human.neoforge;

import com.human.Human;
import com.human.common.data.worldgen.HumanVillageInjection;
import com.human.common.registry.init.HumanVillagerProfessions;
import com.human.common.registry.key.HumanVillagerGiftKeys;
import com.human.mixin.GiveGiftToHeroAccessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerAboutToStartEvent;
import net.neoforged.neoforge.event.tick.LevelTickEvent;

@Mod(Human.MOD_ID)
public class HumanNeoForge {

    public HumanNeoForge(IEventBus modBus) {
        Human.initialize();

        NeoForge.EVENT_BUS.addListener(HumanNeoForge::addNewVillageBuilding);
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGH, HumanNeoForge::onWorldEndTick);
    }

    // Inject Village houses
    private static void addNewVillageBuilding(ServerAboutToStartEvent event) {
        var templatePoolRegistry = event.getServer().registryAccess().registry(Registries.TEMPLATE_POOL).orElseThrow();
        var processorListRegistry = event.getServer().registryAccess().registry(Registries.PROCESSOR_LIST).orElseThrow();

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

    // Marine Spawns and Ash placement in nuked zones
    private static void onWorldEndTick(LevelTickEvent.Post event) {
        if (event.getLevel().isClientSide)
            return;

        var serverLevel = (ServerLevel) event.getLevel();
        var gifts = GiveGiftToHeroAccessor.getGifts();

        Human.CUSTOM_SPAWNER.tick(serverLevel, serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING), true);
        Human.NUKED_ASH_PLACEMENT.tick(serverLevel);
        gifts.put(HumanVillagerProfessions.COMMISSARY.get(), HumanVillagerGiftKeys.COMMISSARY_GIFT_LOOT_TABLE);
    }
}
