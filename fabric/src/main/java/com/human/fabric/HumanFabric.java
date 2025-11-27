package com.human.fabric;

import com.avp.fabric.data.loot.LootTableModifier;
import com.human.Human;
import net.fabricmc.api.ModInitializer;

public class HumanFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Human.initialize();

        // Functionality
        LootTableModifier.initialize();
    }
}
