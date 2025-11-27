package com.human.fabric.data.lang.en_us.provider;

import com.human.common.registry.key.HumanCreativeModeTabKeys;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsCreativeModeTabProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add(HumanCreativeModeTabKeys.BLOCKS_KEY, "Human Blocks");
        builder.add(HumanCreativeModeTabKeys.COMBAT_KEY, "Human Combat");
        builder.add(HumanCreativeModeTabKeys.INGREDIENTS_KEY, "Human Ingredients");
        builder.add(HumanCreativeModeTabKeys.SPAWN_EGGS_KEY, "Human Spawn Eggs");
        builder.add(HumanCreativeModeTabKeys.TOOLS_AND_UTILITIES_KEY, "Human Tools & Utilities");
    };
}
