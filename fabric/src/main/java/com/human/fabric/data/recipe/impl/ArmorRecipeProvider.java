package com.human.fabric.data.recipe.impl;

import com.avp.fabric.data.recipe.RecipeTemplates;
import com.avp.fabric.data.recipe.builder.RecipeBuilder;
import com.avp.fabric.data.recipe.builder.ShapedRecipeBuilder;
import com.compat.CommonItemTags;
import com.human.common.registry.init.item.HumanArmorItems;
import com.human.common.registry.init.item.HumanItems;
import com.human.common.registry.tag.HumanItemTags;
import com.human.compat.HumanCommonItemTags;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class ArmorRecipeProvider {

    public static void provide(RecipeBuilder builder) {
        createMk50ArmorSetRecipes(builder);
        createPressureArmorSetRecipes(builder);
        createTacticalArmorSetRecipes(builder);
        createWYCommandoArmorSetRecipes(builder);
        createWYEliteArmorSetRecipes(builder);
        createStandardArmorSetRecipes(
            builder,
            HumanCommonItemTags.INGOTS_STEEL,
            HumanArmorItems.STEEL_HELMET.get(),
            HumanArmorItems.STEEL_CHESTPLATE.get(),
            HumanArmorItems.STEEL_LEGGINGS.get(),
            HumanArmorItems.STEEL_BOOTS.get()
        );
        createStandardArmorSetRecipes(
            builder,
            HumanCommonItemTags.INGOTS_TITANIUM,
            HumanArmorItems.TITANIUM_HELMET.get(),
            HumanArmorItems.TITANIUM_CHESTPLATE.get(),
            HumanArmorItems.TITANIUM_LEGGINGS.get(),
            HumanArmorItems.TITANIUM_BOOTS.get()
        );
    }

    private static void createMk50ArmorSetRecipes(RecipeBuilder builder) {
        Supplier<ShapedRecipeBuilder> mk50ArmorBuilder = () -> builder.shaped()
            .withCategory(RecipeCategory.COMBAT)
            .define('A', HumanCommonItemTags.INGOTS_ALUMINUM)
            .define('C', HumanCommonItemTags.INGOTS_LEAD);

        mk50ArmorBuilder.get()
            .define('B', HumanItemTags.INDUSTRIAL_GLASS_PANE)
            .define('E', CommonItemTags.DUSTS_COAL)
            .pattern("CAC")
            .pattern("B B")
            .pattern("AEA")
            .into(1, HumanArmorItems.MK50_HELMET);

        mk50ArmorBuilder.get()
            .define('D', CommonItemTags.LEATHERS)
            .pattern("A A")
            .pattern("CAC")
            .pattern("DAD")
            .into(1, HumanArmorItems.MK50_CHESTPLATE);

        mk50ArmorBuilder.get()
            .define('D', CommonItemTags.LEATHERS)
            .pattern("CDC")
            .pattern("D D")
            .pattern("A A")
            .into(1, HumanArmorItems.MK50_LEGGINGS);

        mk50ArmorBuilder.get()
            .pattern("C C")
            .pattern("A A")
            .into(1, HumanArmorItems.MK50_BOOTS);
    }

    private static void createPressureArmorSetRecipes(RecipeBuilder builder) {
        Supplier<ShapedRecipeBuilder> pressureArmorBuilder = () -> builder.shaped()
            .withCategory(RecipeCategory.COMBAT)
            .define('A', HumanCommonItemTags.INGOTS_ALUMINUM);

        pressureArmorBuilder.get()
            .define('B', HumanItemTags.INDUSTRIAL_GLASS_PANE)
            .define('E', CommonItemTags.DUSTS_COAL)
            .pattern("AAA")
            .pattern("B B")
            .pattern("EEE")
            .into(1, HumanArmorItems.PRESSURE_HELMET);

        pressureArmorBuilder.get()
            .define('D', ItemTags.WOOL)
            .pattern("A A")
            .pattern("ADA")
            .pattern("DAD")
            .into(1, HumanArmorItems.PRESSURE_CHESTPLATE);

        pressureArmorBuilder.get()
            .define('D', ItemTags.WOOL)
            .pattern("ADA")
            .pattern("D D")
            .pattern("A A")
            .into(1, HumanArmorItems.PRESSURE_LEGGINGS);

        pressureArmorBuilder.get()
            .define('D', ItemTags.WOOL)
            .pattern("D D")
            .pattern("A A")
            .into(1, HumanArmorItems.PRESSURE_BOOTS);
    }

    private static void createTacticalArmorSetRecipes(RecipeBuilder builder) {
        Supplier<ShapedRecipeBuilder> tacticalArmorBuilder = () -> builder.shaped()
            .withCategory(RecipeCategory.COMBAT)
            .define('A', HumanCommonItemTags.INGOTS_STEEL)
            .define('B', ItemTags.WOOL);

        tacticalArmorBuilder.get()
            .define('C', HumanItems.POLYMER)
            .pattern("ABA")
            .pattern("C C")
            .into(1, HumanArmorItems.TACTICAL_HELMET);

        tacticalArmorBuilder.get()
            .define('C', HumanItems.POLYMER)
            .pattern("C C")
            .pattern("ABA")
            .pattern("CAC")
            .into(1, HumanArmorItems.TACTICAL_CHESTPLATE);

        tacticalArmorBuilder.get()
            .define('C', HumanItems.POLYMER)
            .pattern("CBC")
            .pattern("A A")
            .pattern("C C")
            .into(1, HumanArmorItems.TACTICAL_LEGGINGS);

        tacticalArmorBuilder.get()
            .pattern("B B")
            .pattern("A A")
            .into(1, HumanArmorItems.TACTICAL_BOOTS);
    }

    private static void createWYCommandoArmorSetRecipes(RecipeBuilder builder) {
        Supplier<ShapedRecipeBuilder> wyCommandoArmorBuilder = () -> builder.shaped()
            .withCategory(RecipeCategory.COMBAT)
            .define('A', HumanCommonItemTags.INGOTS_STEEL)
            .define('B', HumanItemTags.PLASTIC);

        wyCommandoArmorBuilder.get()
            .define('C', HumanItems.POLYMER)
            .define('D', HumanItemTags.INDUSTRIAL_GLASS_PANE)
            .pattern("ABA")
            .pattern("CDC")
            .into(1, HumanArmorItems.WY_COMMANDO_HELMET);

        wyCommandoArmorBuilder.get()
            .define('C', HumanItems.POLYMER)
            .pattern("C C")
            .pattern("ABA")
            .pattern("CAC")
            .into(1, HumanArmorItems.WY_COMMANDO_CHESTPLATE);

        wyCommandoArmorBuilder.get()
            .define('C', HumanItems.POLYMER)
            .pattern("CBC")
            .pattern("A A")
            .pattern("C C")
            .into(1, HumanArmorItems.WY_COMMANDO_LEGGINGS);

        wyCommandoArmorBuilder.get()
            .pattern("B B")
            .pattern("A A")
            .into(1, HumanArmorItems.WY_COMMANDO_BOOTS);
    }

    private static void createWYEliteArmorSetRecipes(RecipeBuilder builder) {
        Supplier<ShapedRecipeBuilder> wyEliteArmorBuilder = () -> builder.shaped()
            .withCategory(RecipeCategory.COMBAT)
            .define('A', HumanCommonItemTags.INGOTS_STEEL)
            .define('B', HumanItemTags.PLASTIC);

        wyEliteArmorBuilder.get()
            .define('C', HumanItemTags.INDUSTRIAL_GLASS_PANE)
            .pattern("ABA")
            .pattern("BCB")
            .into(1, HumanArmorItems.WY_ELITE_HELMET);

        wyEliteArmorBuilder.get()
            .pattern("B B")
            .pattern("ABA")
            .pattern("BAB")
            .into(1, HumanArmorItems.WY_ELITE_CHESTPLATE);

        wyEliteArmorBuilder.get()
            .pattern("BBB")
            .pattern("A A")
            .pattern("B B")
            .into(1, HumanArmorItems.WY_ELITE_LEGGINGS);

        wyEliteArmorBuilder.get()
            .pattern("B B")
            .pattern("A A")
            .into(1, HumanArmorItems.WY_ELITE_BOOTS);
    }

    private static void createStandardArmorSetRecipes(
        RecipeBuilder builder,
        TagKey<Item> base,
        Item helmet,
        Item chestplate,
        Item leggings,
        Item boots
    ) {
        builder.shaped()
            .apply(RecipeTemplates.HELMET_TAG_FRIENDLY.apply(base))
            .into(1, helmet);

        builder.shaped()
            .apply(RecipeTemplates.CHESTPLATE_TAG_FRIENDLY.apply(base))
            .into(1, chestplate);

        builder.shaped()
            .apply(RecipeTemplates.LEGGINGS_TAG_FRIENDLY.apply(base))
            .into(1, leggings);

        builder.shaped()
            .apply(RecipeTemplates.BOOTS_TAG_FRIENDLY.apply(base))
            .into(1, boots);
    }
}
