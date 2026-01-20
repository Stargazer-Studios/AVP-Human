package com.human.common.registry.init.creative_mode_tab.initializer;

import com.human.common.registry.init.item.HumanItems;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Consumer;

public class FoodAndDrinksCreativeModeTabInitializer {

    public static final Consumer<CreativeModeTab.Output> OUTPUT_CONSUMER = output -> {
        CreativeModeTabUtil.accept(output, HumanItems.CORNBREAD);
    };
}
