package com.human.fabric.data.lang.en_us;

import com.human.fabric.data.lang.en_us.provider.EnUsAdvancementProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsBlockProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsBlockTagProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsConfigProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsCreativeModeTabProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsEntityProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsEntityTypeTagProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsItemProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsItemTagProvider;
import com.human.fabric.data.lang.en_us.provider.EnUsSoundEventProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;

import java.util.concurrent.CompletableFuture;

public class EnglishLanguageProvider extends FabricLanguageProvider {

    public EnglishLanguageProvider(FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(HolderLookup.Provider registryLookup, TranslationBuilder builder) {
        // Blocks
        EnUsBlockProvider.CONSUMER.accept(builder);

        // Creative Mode Tabs
        EnUsCreativeModeTabProvider.CONSUMER.accept(builder);

        // Entities
        EnUsEntityProvider.CONSUMER.accept(builder);

        // Items
        EnUsItemProvider.CONSUMER.accept(builder);

        // Sounds
        EnUsSoundEventProvider.CONSUMER.accept(builder);

        // Advancements
        EnUsAdvancementProvider.CONSUMER.accept(builder);

        // Configs
        EnUsConfigProvider.CONSUMER.accept(builder);

        // Tags
        EnUsBlockTagProvider.CONSUMER.accept(builder);
        EnUsItemTagProvider.CONSUMER.accept(builder);
        EnUsEntityTypeTagProvider.CONSUMER.accept(builder);
    }
}
