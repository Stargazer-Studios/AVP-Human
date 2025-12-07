package com.human;

import com.blib.BLib;
import com.blib.BLibMod;
import com.blib.event.BLibLevelTickEvent;
import com.blib.event.key.BLibEventKeys;
import com.blib.service.BLibServices;
import com.human.common.HumanEvents;
import com.human.common.config.HumanConfig;
import com.human.common.data.HumanReloadListeners;
import com.human.common.gameplay.entity.living.human.marine.ai.MarineGOAP;
import com.human.common.gameplay.gene.Genes;
import com.human.common.gameplay.level.patrol.MarinePatrolSpawner;
import com.human.common.gameplay.power.PowerSystem;
import com.human.common.gameplay.worldgen.biome.NukedAshPlacement;
import com.human.common.registry.init.HumanArmorMaterials;
import com.human.common.registry.init.HumanBlockEntityTypes;
import com.human.common.registry.init.HumanBlocks;
import com.human.common.registry.init.HumanDataComponents;
import com.human.common.registry.init.HumanDataKeys;
import com.human.common.registry.init.HumanEntitySpawns;
import com.human.common.registry.init.HumanEntityTypes;
import com.human.common.registry.init.HumanFuels;
import com.human.common.registry.init.HumanMenuTypes;
import com.human.common.registry.init.HumanMobEffects;
import com.human.common.registry.init.HumanRecipes;
import com.human.common.registry.init.HumanSoundEvents;
import com.human.common.registry.init.HumanVillagerPoiTypes;
import com.human.common.registry.init.HumanVillagerProfessions;
import com.human.common.registry.init.HumanVillagerTrades;
import com.human.common.registry.init.block.CoreBlocks;
import com.human.common.registry.init.block.HumanFerroaluminumBlocks;
import com.human.common.registry.init.block.HumanIndustrialConcreteBlocks;
import com.human.common.registry.init.block.HumanIndustrialGlassBlocks;
import com.human.common.registry.init.block.HumanPaddingBlocks;
import com.human.common.registry.init.block.HumanPlasticBlocks;
import com.human.common.registry.init.block.HumanSteelBlocks;
import com.human.common.registry.init.block.HumanTitaniumBlocks;
import com.human.common.registry.init.creative_mode_tab.HumanCreativeModeTabs;
import com.human.common.registry.init.item.HumanArmorItems;
import com.human.common.registry.init.item.HumanBlockItems;
import com.human.common.registry.init.item.HumanGunItems;
import com.human.common.registry.init.item.HumanItems;
import com.human.common.registry.init.item.HumanSpawnEggItems;
import com.human.common.registry.init.item.block.HumanFerroaluminumBlockItems;
import com.human.common.registry.init.item.block.HumanIndustrialConcreteBlockItems;
import com.human.common.registry.init.item.block.HumanIndustrialGlassBlockItems;
import com.human.common.registry.init.item.block.HumanPaddingBlockItems;
import com.human.common.registry.init.item.block.HumanPlasticBlockItems;
import com.human.common.registry.init.item.block.HumanSteelBlockItems;
import com.human.common.registry.init.item.block.HumanTitaniumBlockItems;
import net.minecraft.server.level.ServerLevel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Human {

    public static final String MOD_ID = "avp_human";

    public static final BLibMod MOD = BLib.createMod(MOD_ID);

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final MarinePatrolSpawner CUSTOM_SPAWNER = new MarinePatrolSpawner();

    public static final NukedAshPlacement NUKED_ASH_PLACEMENT = new NukedAshPlacement();

    public static void initialize() {
        LOGGER.info("Initializing AVP (Human) for mod loader '{}'", BLibServices.MOD_LOADER.getModLoaderName());

        HumanConfig.initialize();

        HumanSoundEvents.initialize();
        HumanArmorMaterials.initialize();
        HumanDataComponents.initialize();
        HumanEntityTypes.initialize();

        // Blocks
        CoreBlocks.initialize();
        HumanBlocks.initialize();
        HumanFerroaluminumBlocks.initialize();
        HumanIndustrialConcreteBlocks.initialize();
        HumanIndustrialGlassBlocks.initialize();
        HumanPaddingBlocks.initialize();
        HumanPlasticBlocks.initialize();
        HumanSteelBlocks.initialize();
        HumanTitaniumBlocks.initialize();

        HumanBlockEntityTypes.initialize();

        // Items
        HumanItems.initialize();
        HumanGunItems.initialize();
        HumanBlockItems.initialize();
        HumanFerroaluminumBlockItems.initialize();
        HumanIndustrialConcreteBlockItems.initialize();
        HumanIndustrialGlassBlockItems.initialize();
        HumanPaddingBlockItems.initialize();
        HumanPlasticBlockItems.initialize();
        HumanSpawnEggItems.initialize();
        HumanSteelBlockItems.initialize();
        HumanTitaniumBlockItems.initialize();

        HumanVillagerPoiTypes.initialize();
        HumanVillagerProfessions.initialize();
        HumanVillagerTrades.initialize();

        HumanDataKeys.initialize();
        HumanMenuTypes.initialize();
        HumanMobEffects.initialize();

        HumanArmorItems.initialize();

        HumanRecipes.initialize();

        HumanEntitySpawns.initialize();
        HumanFuels.initialize();

        HumanCreativeModeTabs.initialize();

        // AI
        Genes.initialize();
        MarineGOAP.initialize();

        // Listeners / Events
        HumanReloadListeners.initialize();

        MOD.addEventListener(BLibEventKeys.LEVEL_TICK_POST, Human::updatePowerSystem);
        MOD.addEventListener(BLibEventKeys.TAGS_UPDATED, $ -> HumanEvents.onTagsUpdated());
    }

    private static void updatePowerSystem(BLibLevelTickEvent.Post event) {
        var level = event.level();

        if (level.isClientSide) {
            return;
        }

        PowerSystem.get((ServerLevel) level).tick();
    }
}
