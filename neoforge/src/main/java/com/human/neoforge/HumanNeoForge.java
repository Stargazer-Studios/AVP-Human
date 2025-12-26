package com.human.neoforge;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanCommissaryVillagerHouseInjector;
import com.human.common.registry.init.HumanVillagerProfessions;
import com.human.common.registry.key.HumanVillagerGiftKeys;
import com.human.mixin.GiveGiftToHeroAccessor;
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

        NeoForge.EVENT_BUS.addListener(HumanNeoForge::addNewVillageBuildings);
        NeoForge.EVENT_BUS.addListener(EventPriority.HIGH, HumanNeoForge::onWorldEndTick);
    }

    private static void addNewVillageBuildings(ServerAboutToStartEvent event) {
        HumanCommissaryVillagerHouseInjector.inject(event.getServer());
    }

    private static void onWorldEndTick(LevelTickEvent.Post event) {
        if (!event.getLevel().isClientSide) {
            var gifts = GiveGiftToHeroAccessor.getGifts();
            gifts.put(HumanVillagerProfessions.COMMISSARY.get(), HumanVillagerGiftKeys.COMMISSARY_GIFT_LOOT_TABLE);
        }
    }
}
