package com.human.common.registry.init;

import com.blib.common.registry.impl.BLibFurnaceFuelRegistry;
import com.human.Human;
import com.human.common.registry.init.item.HumanItems;

public class HumanFuels {

    private static final BLibFurnaceFuelRegistry REGISTRY = Human.MOD.registries().createFurnaceFuelRegistry();

    public static void initialize() {
        REGISTRY.register(HumanItems.CARBON_DUST, 800);
    }
}
