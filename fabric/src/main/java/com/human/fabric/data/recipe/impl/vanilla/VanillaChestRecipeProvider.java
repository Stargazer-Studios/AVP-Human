package com.human.fabric.data.recipe.impl.vanilla;

import com.blib.fabric.data.recipe.builder.RecipeBuilder;
import com.human.common.registry.init.item.HumanBlockItems;
import com.human.compat.HumanCommonItemTags;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.world.item.Items;

public class VanillaChestRecipeProvider {

    public static void provide(RecipeBuilder builder) {
        createChestRecipes(builder);
    }

    private static void createChestRecipes(RecipeBuilder builder) {
        builder.shaped()
            .withCategory(RecipeCategory.DECORATIONS)
            .define('#', HumanCommonItemTags.INGOTS_LEAD)
            .define('C', Items.CHEST)
            .pattern("###")
            .pattern("#C#")
            .pattern("###")
            .into(1, HumanBlockItems.LEAD_CHEST);

        builder.shaped()
            .withCategory(RecipeCategory.DECORATIONS)
            .define('#', HumanCommonItemTags.INGOTS_STEEL)
            .define('C', Items.CHEST)
            .pattern("###")
            .pattern("#C#")
            .pattern("###")
            .into(1, HumanBlockItems.AMMO_CHEST);
    }
}
