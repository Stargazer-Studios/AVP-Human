package com.human.fabric;

import com.human.Human;
import com.human.fabric.common.worldgen.WorldGen;
import com.human.fabric.data.loot.LootTableModifier;
import net.fabricmc.api.ModInitializer;

public class HumanFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Human.initialize();

        // Core
        WorldGen.initialize();

        // Functionality
        LootTableModifier.initialize();
    }
}
