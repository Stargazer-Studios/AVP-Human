package com.human.fabric.data.lang.en_us.provider;

import com.human.common.registry.tag.HumanDamageTypesTags;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsDamageTypeTagProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add(HumanDamageTypesTags.DOES_NOT_HURT_SENTRY_TURRETS, "Does Not Hurt Sentry Turrets");
    };
}
