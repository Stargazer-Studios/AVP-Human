package com.human.fabric.data.lang.en_us.provider;

import com.human.common.registry.tag.HumanEnchantmentTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsEnchantmentTagProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add(HumanEnchantmentTags.GUN_ENCHANTMENTS, "Gun Enchantments");
    };
}
