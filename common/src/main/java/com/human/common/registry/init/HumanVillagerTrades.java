package com.human.common.registry.init;

import com.blib.api.common.registry.v1.impl.BLibVillagerTradeRegistry;
import com.human.Human;
import com.human.common.data.CommissaryTradeLevels;

public class HumanVillagerTrades {

    private static final BLibVillagerTradeRegistry REGISTRY = Human.MOD.registries().createVillagerTradeRegistry();

    public static void initialize() {
        REGISTRY.register(HumanVillagerProfessions.COMMISSARY, 1, CommissaryTradeLevels.LEVEL_1);
        REGISTRY.register(HumanVillagerProfessions.COMMISSARY, 2, CommissaryTradeLevels.LEVEL_2);
        REGISTRY.register(HumanVillagerProfessions.COMMISSARY, 3, CommissaryTradeLevels.LEVEL_3);
        REGISTRY.register(HumanVillagerProfessions.COMMISSARY, 4, CommissaryTradeLevels.LEVEL_4);
        REGISTRY.register(HumanVillagerProfessions.COMMISSARY, 5, CommissaryTradeLevels.LEVEL_5);
    }
}
