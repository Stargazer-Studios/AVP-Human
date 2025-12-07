package com.human.fabric.data.lang.en_us.provider;

import com.human.common.registry.tag.HumanBiomeTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsBiomeTagProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add(HumanBiomeTags.HAS_MARINE_CAMP_GRASS, "Has Grassy Marine Camp");
        builder.add(HumanBiomeTags.HAS_MOBILE_LAB, "Has Mobile Lab");
        builder.add(HumanBiomeTags.HAS_OUTPOST_COMMS, "Has Communications Outpost");
        builder.add(HumanBiomeTags.HAS_OUTPOST_MUNITION, "Has Munitions Outpost");
        builder.add(HumanBiomeTags.HAS_OUTPOST_SUPPLY_BADLAND, "Has Badlands Supply Outpost");
        builder.add(HumanBiomeTags.HAS_OUTPOST_SUPPLY_DESERT, "Has Desert Supply Outpost");
        builder.add(HumanBiomeTags.IS_IRRADIATED, "Is Irradiated");
    };
}
