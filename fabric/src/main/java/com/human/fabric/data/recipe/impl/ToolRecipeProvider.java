package com.human.fabric.data.recipe.impl;

import com.blib.fabric.data.recipe.RecipeTemplates;
import com.blib.fabric.data.recipe.builder.RecipeBuilder;
import com.human.common.registry.init.item.HumanItems;
import com.human.compat.HumanCommonItemTags;

public class ToolRecipeProvider {

    public static void provide(RecipeBuilder builder) {
        createSteelToolsetRecipes(builder);
        createTitaniumToolsetRecipes(builder);
    }

    private static void createSteelToolsetRecipes(RecipeBuilder builder) {
        builder.shaped()
            .apply(RecipeTemplates.AXE.apply(HumanCommonItemTags.INGOTS_STEEL))
            .into(1, HumanItems.STEEL_AXE);
        builder.shaped()
            .apply(RecipeTemplates.HOE.apply(HumanCommonItemTags.INGOTS_STEEL))
            .into(1, HumanItems.STEEL_HOE);
        builder.shaped()
            .apply(RecipeTemplates.PICKAXE.apply(HumanCommonItemTags.INGOTS_STEEL))
            .into(1, HumanItems.STEEL_PICKAXE);
        builder.shaped()
            .apply(RecipeTemplates.SHOVEL.apply(HumanCommonItemTags.INGOTS_STEEL))
            .into(1, HumanItems.STEEL_SHOVEL);
        builder.shaped()
            .apply(RecipeTemplates.SWORD.apply(HumanCommonItemTags.INGOTS_STEEL))
            .into(1, HumanItems.STEEL_SWORD);
    }

    private static void createTitaniumToolsetRecipes(RecipeBuilder builder) {
        builder.shaped()
            .apply(RecipeTemplates.AXE.apply(HumanCommonItemTags.INGOTS_TITANIUM))
            .into(1, HumanItems.TITANIUM_AXE);
        builder.shaped()
            .apply(RecipeTemplates.HOE.apply(HumanCommonItemTags.INGOTS_TITANIUM))
            .into(1, HumanItems.TITANIUM_HOE);
        builder.shaped()
            .apply(RecipeTemplates.PICKAXE.apply(HumanCommonItemTags.INGOTS_TITANIUM))
            .into(1, HumanItems.TITANIUM_PICKAXE);
        builder.shaped()
            .apply(RecipeTemplates.SHOVEL.apply(HumanCommonItemTags.INGOTS_TITANIUM))
            .into(1, HumanItems.TITANIUM_SHOVEL);
        builder.shaped()
            .apply(RecipeTemplates.SWORD.apply(HumanCommonItemTags.INGOTS_TITANIUM))
            .into(1, HumanItems.TITANIUM_SWORD);
    }
}
