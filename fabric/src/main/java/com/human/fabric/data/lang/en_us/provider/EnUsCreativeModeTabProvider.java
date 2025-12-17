package com.human.fabric.data.lang.en_us.provider;

import com.human.common.registry.key.HumanCreativeModeTabKeys;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsCreativeModeTabProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add(HumanCreativeModeTabKeys.BLOCKS_KEY, "Blocks (AVP: Human)");
        builder.add(HumanCreativeModeTabKeys.COLORED_BLOCKS_KEY, "Colored Blocks (AVP: Human)");
        builder.add(HumanCreativeModeTabKeys.COMBAT_KEY, "Combat (AVP: Human)");
        builder.add(HumanCreativeModeTabKeys.INGREDIENTS_KEY, "Ingredients (AVP: Human)");
        builder.add(HumanCreativeModeTabKeys.SPAWN_EGGS_KEY, "Spawn Eggs (AVP: Human)");
        builder.add(HumanCreativeModeTabKeys.TOOLS_AND_UTILITIES_KEY, "Tools & Utilities (AVP: Human)");
    };
}
