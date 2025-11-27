package com.human.fabric.data;

import com.human.fabric.data.gene_bonus_data.GeneBonusDataSubProvider;
import com.human.fabric.data.lang.en_us.EnglishLanguageProvider;
import com.human.fabric.data.loot.BlockLootTableProvider;
import com.human.fabric.data.loot.EntityLootTableProvider;
import com.human.fabric.data.model.BlockModelProvider;
import com.human.fabric.data.model.ItemModelProvider;
import com.human.fabric.data.recipe.RecipeProvider;
import com.human.fabric.data.tag.HumanBlockTagProvider;
import com.human.fabric.data.tag.HumanEntityTypeTagProvider;
import com.human.fabric.data.tag.HumanItemTagProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;

public class HumanDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        var pack = fabricDataGenerator.createPack();
        // Language providers
        pack.addProvider(EnglishLanguageProvider::new);

        // Model providers
        pack.addProvider(BlockModelProvider::new);
        pack.addProvider(ItemModelProvider::new);

        // Recipe providers
        pack.addProvider(RecipeProvider::new);

        // Tag providers
        pack.addProvider(HumanBlockTagProvider::new);
        pack.addProvider(HumanEntityTypeTagProvider::new);
        pack.addProvider(HumanItemTagProvider::new);

        // Loot providers
        pack.addProvider(BlockLootTableProvider::new);
        pack.addProvider(EntityLootTableProvider::new);

        // Custom Providers
        pack.addProvider(GeneBonusDataSubProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {}
}
