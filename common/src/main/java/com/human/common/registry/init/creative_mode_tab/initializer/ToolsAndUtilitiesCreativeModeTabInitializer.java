package com.human.common.registry.init.creative_mode_tab.initializer;

import com.human.common.registry.init.item.HumanItems;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Consumer;

public class ToolsAndUtilitiesCreativeModeTabInitializer {

    public static final Consumer<CreativeModeTab.Output> OUTPUT_CONSUMER = output -> {
        CreativeModeTabUtil.accept(output, HumanItems.ARMOR_CASE);
        CreativeModeTabUtil.accept(output, HumanItems.GENE_READER);
        CreativeModeTabUtil.accept(output, HumanItems.SYRINGE);
        CreativeModeTabUtil.accept(output, HumanItems.CANISTER);
        CreativeModeTabUtil.accept(output, HumanItems.WATER_CANISTER);
        CreativeModeTabUtil.accept(output, HumanItems.LAVA_CANISTER);
        CreativeModeTabUtil.accept(output, HumanItems.MILK_CANISTER);
        CreativeModeTabUtil.accept(output, HumanItems.POWDER_SNOW_CANISTER);
        CreativeModeTabUtil.accept(output, HumanItems.STEEL_AXE);
        CreativeModeTabUtil.accept(output, HumanItems.STEEL_HOE);
        CreativeModeTabUtil.accept(output, HumanItems.STEEL_PICKAXE);
        CreativeModeTabUtil.accept(output, HumanItems.STEEL_SHOVEL);
        CreativeModeTabUtil.accept(output, HumanItems.STEEL_SWORD);
        CreativeModeTabUtil.accept(output, HumanItems.TITANIUM_AXE);
        CreativeModeTabUtil.accept(output, HumanItems.TITANIUM_HOE);
        CreativeModeTabUtil.accept(output, HumanItems.TITANIUM_PICKAXE);
        CreativeModeTabUtil.accept(output, HumanItems.TITANIUM_SHOVEL);
        CreativeModeTabUtil.accept(output, HumanItems.TITANIUM_SWORD);
    };
}
