package com.human;

import com.avp.AVP;
import com.avp.common.config.AVPConfig;
import com.blib.BLib;
import com.blib.BLibMod;
import com.blib.service.BLibServices;
import com.human.common.registry.init.HumanArmorMaterials;
import com.human.common.registry.init.HumanBlockEntityTypes;
import com.human.common.registry.init.HumanBlocks;
import com.human.common.registry.init.HumanEntitySpawns;
import com.human.common.registry.init.HumanEntityTypes;
import com.human.common.registry.init.HumanSoundEvents;
import com.human.common.registry.init.creative_mode_tab.HumanCreativeModeTabs;
import com.human.common.registry.init.item.HumanArmorItems;
import com.human.common.registry.init.item.HumanBlockItems;
import com.human.common.registry.init.item.HumanItems;
import com.human.common.registry.init.item.block.HumanSpawnEggItems;
import mod.azure.azurelib.common.config.format.ConfigFormats;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Human {

    public static final String MOD_ID = "avp_human";

    public static final BLibMod MOD = BLib.createMod(MOD_ID);

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void initialize() {
        // FIXME:
        AVP.config = AVP.registerConfig(AVPConfig.class, ConfigFormats.json()).getConfigInstance();

        LOGGER.info("Initializing AVP (Human) for mod loader '{}'", BLibServices.MOD_LOADER.getModLoaderName());

        // No dependencies.
        HumanBlocks.initialize();
        HumanItems.initialize();
        HumanEntityTypes.initialize();
        HumanSoundEvents.initialize();

        // Depends on blocks.
        HumanBlockItems.initialize();
        // Depends on sound events.
        HumanArmorMaterials.initialize();
        // Depends on armor materials.
        HumanArmorItems.initialize();
        // Depends on entity types.
        HumanSpawnEggItems.initialize();
        // Depends on blocks.
        HumanBlockEntityTypes.initialize();
        // Depends on blocks, items, block items, etc.
        HumanCreativeModeTabs.initialize();

        // Functionality
        HumanEntitySpawns.initialize();
    }
}
