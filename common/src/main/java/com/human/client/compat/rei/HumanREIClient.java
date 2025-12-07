package com.human.client.compat.rei;

import com.human.client.screen.IndustrialFurnaceScreen;
import com.human.common.gameplay.recipe.IndustrialFurnaceRecipe;
import com.human.common.registry.init.HumanBlocks;
import com.human.common.registry.init.HumanRecipes;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;

public class HumanREIClient implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new IndustrialCategory());

        registry.addWorkstations(IndustrialCategory.INDUSTRIAL_FURNACE, EntryStacks.of(HumanBlocks.INDUSTRIAL_FURNACE.get()));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.registerRecipeFiller(
            IndustrialFurnaceRecipe.class,
            HumanRecipes.INDUSTRIAL_FURNACE_RECIPE_TYPE.get(),
            IndustrialDisplay::new
        );
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerClickArea(
            screen -> new Rectangle(
                ((screen.width - 176) / 2) + 78,
                ((screen.height - 166) / 2) + 30,
                20,
                25
            ),
            IndustrialFurnaceScreen.class,
            IndustrialCategory.INDUSTRIAL_FURNACE
        );
    }
}
