package com.human.fabric.data.recipe.impl.vanilla;

import com.avp.fabric.data.recipe.builder.RecipeBuilder;
import com.avp.fabric.data.recipe.util.RecipeUtil;
import com.human.common.gameplay.block.property.HumanBlockProperties;
import com.human.common.registry.init.HumanBlocks;

public class VanillaConcreteRecipeProvider {

    public static void provide(RecipeBuilder builder) {
        createConcreteBlockRecipes(builder);
    }

    private static void createConcreteBlockRecipes(RecipeBuilder builder) {
        HumanBlockProperties.DYE_COLOR_TO_CONCRETE_BLOCKS.forEach(((dyeColor, block) -> {
            var slabBlock = HumanBlocks.DYE_COLOR_TO_CONCRETE_SLAB.get(dyeColor).get();
            RecipeUtil.createSlabBlockManualAndStonecutterRecipes(builder, block, slabBlock);

            var stairBlock = HumanBlocks.DYE_COLOR_TO_CONCRETE_STAIRS.get(dyeColor).get();
            RecipeUtil.createStairBlockManualAndStonecutterRecipes(builder, block, stairBlock);
        }));
    }
}
