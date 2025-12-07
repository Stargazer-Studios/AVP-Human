package com.human.fabric.data.lang.en_us.provider;

import com.human.common.registry.tag.HumanBlockTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsBlockTagProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add(HumanBlockTags.CONCRETE, "Concrete");
        builder.add(HumanBlockTags.FERROALUMINUM, "Ferroaluminum");
        builder.add(HumanBlockTags.INDUSTRIAL_CONCRETE, "Industrial Concrete");
        builder.add(HumanBlockTags.INDUSTRIAL_GLASS, "Industrial Glass");
        builder.add(HumanBlockTags.INDUSTRIAL_GLASS_BLOCK, "Industrial Glass Blocks");
        builder.add(HumanBlockTags.INDUSTRIAL_GLASS_PANE, "Industrial Glass Panes");
        builder.add(HumanBlockTags.MARINE_SPAWN_BLOCKS, "Marine Spawn Blocks");
        builder.add(HumanBlockTags.PADDING, "Padding");
        builder.add(HumanBlockTags.PLASTIC, "Plastic");
        builder.add(HumanBlockTags.RAZOR_WIRE, "Razor Wire");
        builder.add(HumanBlockTags.STEEL, "Steel");
        builder.add(HumanBlockTags.TITANIUM, "Titanium");
    };
}
