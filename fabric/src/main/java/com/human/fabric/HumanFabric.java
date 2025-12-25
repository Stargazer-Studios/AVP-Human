package com.human.fabric;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanCommissaryVillagerHouseInjector;
import com.human.common.registry.init.HumanVillagerProfessions;
import com.human.common.registry.key.HumanVillagerGiftKeys;
import com.human.fabric.common.worldgen.WorldGen;
import com.human.fabric.data.loot.LootTableModifier;
import com.human.mixin.GiveGiftToHeroAccessor;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
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
        ServerLifecycleEvents.SERVER_STARTING.register(HumanCommissaryVillagerHouseInjector::inject);
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
}
