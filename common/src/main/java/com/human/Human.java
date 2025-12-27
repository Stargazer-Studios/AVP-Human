package com.human;

import com.blib.BLib;
import com.blib.BLibMod;
import com.human.common.config.HumanConfig;
import com.human.common.data.HumanReloadListeners;
import com.human.common.data.fixer.migration.HumanDataMigrations;
import com.human.common.gameplay.entity.living.human.marine.ai.MarineGOAP;
import com.human.common.gameplay.gene.Genes;
import com.human.common.gameplay.level.patrol.MarinePatrolSpawner;
import com.human.common.gameplay.power.PowerSystem;
import com.human.common.gameplay.worldgen.biome.NukedAshPlacement;
import com.human.common.gameplay.worldgen.structure.HumanCommissaryVillagerHouseInjector;
import com.human.common.network.HumanPacketDirectionRegistry;
import com.human.common.network.HumanServerPacketHandlerRegistry;
import com.human.common.registry.GeneBonusDataRegistry;
import com.human.common.registry.init.HumanArmorMaterials;
import com.human.common.registry.init.HumanBlockEntityTypes;
import com.human.common.registry.init.HumanBlocks;
import com.human.common.registry.init.HumanCommands;
import com.human.common.registry.init.HumanDataComponents;
import com.human.common.registry.init.HumanDataSyncKeys;
import com.human.common.registry.init.HumanEntitySpawns;
import com.human.common.registry.init.HumanEntityTypes;
import com.human.common.registry.init.HumanFuels;
import com.human.common.registry.init.HumanMenuTypes;
import com.human.common.registry.init.HumanMobEffects;
import com.human.common.registry.init.HumanRecipes;
import com.human.common.registry.init.HumanSoundEvents;
import com.human.common.registry.init.HumanStructureTypes;
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
import com.human.common.registry.key.HumanVillagerGiftKeys;
import com.human.mixin.GiveGiftToHeroAccessor;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Human {

    public static final String MOD_ID = "avp_human";

    public static final BLibMod MOD = BLib.createMod(MOD_ID);

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final MarinePatrolSpawner MARINE_PATROL_SPAWNER = new MarinePatrolSpawner();

    public static final NukedAshPlacement NUKED_ASH_PLACEMENT = new NukedAshPlacement();

    public static void initialize() {
        LOGGER.info("Initializing AVP (Human) for mod loader '{}'", BLib.getModLoaderType());

        HumanConfig.initialize();

        MOD.initialize(Human::runInitialization);
    }

    private static void runInitialization() {
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

        // Villagers
        HumanVillagerPoiTypes.initialize();
        HumanVillagerProfessions.initialize();
        HumanVillagerTrades.initialize();

        HumanDataSyncKeys.initialize();

        HumanPacketDirectionRegistry.initialize();
        HumanServerPacketHandlerRegistry.initialize();
        HumanMenuTypes.initialize();
        HumanMobEffects.initialize();

        HumanArmorItems.initialize();

        HumanRecipes.initialize();

        HumanEntitySpawns.initialize();
        HumanFuels.initialize();

        HumanCreativeModeTabs.initialize();

        HumanCommands.initialize();

        HumanStructureTypes.initialize();

        // AI
        Genes.initialize();
        MarineGOAP.initialize();

        // Listeners / Events
        HumanReloadListeners.initialize();

        HumanDataMigrations.initialize();

        MOD.events().postLevelTick().register(Human::tickMarinePatrolSpawner);
        MOD.events().postLevelTick().register(Human::tickNukeAshPlacement);
        MOD.events().postLevelTick().register(Human::tickPowerSystem);
        MOD.events().onTagsUpdated().register(($1, $2) -> GeneBonusDataRegistry.rebuildLookupMappings());
        MOD.events().serverStarting().register(HumanCommissaryVillagerHouseInjector::inject);
        MOD.events().serverStarting().register(Human::injectVillagerGifts);
    }

    private static void injectVillagerGifts(MinecraftServer minecraftServer) {
        var gifts = GiveGiftToHeroAccessor.getGifts();
        gifts.put(HumanVillagerProfessions.COMMISSARY.get(), HumanVillagerGiftKeys.COMMISSARY_GIFT_LOOT_TABLE);
    }

    private static void tickMarinePatrolSpawner(Level level) {
        if (!level.isClientSide) {
            var serverLevel = (ServerLevel) level;
            Human.MARINE_PATROL_SPAWNER.tick(serverLevel, serverLevel.getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING), true);
        }
    }

    private static void tickNukeAshPlacement(Level level) {
        if (!level.isClientSide) {
            Human.NUKED_ASH_PLACEMENT.tick((ServerLevel) level);
        }
    }

    private static void tickPowerSystem(Level level) {
        if (!level.isClientSide) {
            PowerSystem.get((ServerLevel) level).tick();
        }
    }
}
