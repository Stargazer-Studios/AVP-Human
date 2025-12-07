package com.human.fabric.data.lang.en_us.provider;

import com.human.common.registry.tag.HumanItemTags;
import com.human.compat.HumanCommonItemTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsItemTagProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add(HumanItemTags.AMMO_ITEMS, "Ammo Items");
        builder.add(HumanItemTags.GUNS, "Guns");
        builder.add(HumanItemTags.INDUSTRIAL_GLASS, "Industrial Glass");
        builder.add(HumanItemTags.INDUSTRIAL_GLASS_BLOCK, "Industrial Glass Blocks");
        builder.add(HumanItemTags.INDUSTRIAL_GLASS_PANE, "Industrial Glass Panes");
        builder.add(HumanItemTags.LITHIUM, "Lithium");
        builder.add(HumanItemTags.MK50_ARMOR, "MK50 Armor");
        builder.add(HumanItemTags.PRESSURE_ARMOR, "Pressure Armor");
        builder.add(HumanItemTags.RADIATION_CURE_ITEMS, "Radiation Cure Items");
        builder.add(HumanItemTags.RADIATION_RESISTANT_ARMORS, "Radiation-Resistant Armors");
        builder.add(HumanItemTags.RADIOACTIVE_ITEMS, "Radioactive Items");
        builder.add(HumanItemTags.URANIUM_NUGGET_LIKE, "Uranium Nugget Like");

        // Common Tags
        builder.add(HumanCommonItemTags.INGOTS_ALUMINUM, "Aluminum Ingots");
        builder.add(HumanCommonItemTags.INGOTS_BRASS, "Brass Ingots");
        builder.add(HumanCommonItemTags.INGOTS_LEAD, "Lead Ingots");
        builder.add(HumanCommonItemTags.INGOTS_STEEL, "Steel Ingots");
        builder.add(HumanCommonItemTags.INGOTS_TITANIUM, "Titanium Ingots");
        builder.add(HumanCommonItemTags.INGOTS_URANIUM, "Uranium Ingots");
        builder.add(HumanCommonItemTags.INGOTS_ZINC, "Zinc Ingots");

        builder.add(HumanCommonItemTags.NUGGETS_ALUMINUM, "Aluminum Nuggets");
        builder.add(HumanCommonItemTags.NUGGETS_BRASS, "Brass Nuggets");
        builder.add(HumanCommonItemTags.NUGGETS_LEAD, "Lead Nuggets");
        builder.add(HumanCommonItemTags.NUGGETS_STEEL, "Steel Nuggets");
        builder.add(HumanCommonItemTags.NUGGETS_TITANIUM, "Titanium Nuggets");
        builder.add(HumanCommonItemTags.NUGGETS_ZINC, "Zinc Nuggets");
    };
}
