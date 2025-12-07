package com.human.common.registry.init;

import com.avp.service.Services;
import com.human.common.registry.init.item.HumanItems;

public class HumanFuels {

    public static void initialize() {
        Services.REGISTRY.registerFurnaceFuel(HumanItems.CARBON_DUST, 800);
    }
}
