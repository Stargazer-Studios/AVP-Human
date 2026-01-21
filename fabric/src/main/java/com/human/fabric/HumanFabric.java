package com.human.fabric;

import com.human.Human;
import com.human.common.data.loot.LootTableModifiers;
import com.human.fabric.common.worldgen.WorldGen;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;

public class HumanFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        Human.initialize();

        // Core
        WorldGen.initialize();

        // Functionality
        LootTableEvents.MODIFY.register(HumanFabric::applyLootModifiers);
    }

    private static void applyLootModifiers(
        ResourceKey<LootTable> key,
        LootTable.Builder builder,
        LootTableSource source,
        HolderLookup.Provider provider
    ) {
        if (!source.isBuiltin()) {
            return;
        }

        // Early-game loot
        LootTableModifiers.VILLAGE_LOOT_TABLE_MODIFIER.apply(key, builder);
        LootTableModifiers.EARLY_GAME_LOOT_TABLE_MODIFIER.apply(key, builder);

        // Mid-game loot
        LootTableModifiers.MID_GAME_LOOT_TABLE_MODIFIER.apply(key, builder);
        LootTableModifiers.NETHER_BRIDGE_LOOT_TABLE_MODIFIER.apply(key, builder);
        LootTableModifiers.BASTION_TREASURE_LOOT_TABLE_MODIFIER.apply(key, builder);

        // End-game loot
        LootTableModifiers.END_GAME_LOOT_TABLE_MODIFIER.apply(key, builder);
    }
}
