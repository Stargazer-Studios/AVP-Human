package com.human.client.compat.jei;

import com.human.Human;
import com.human.HumanResources;
import com.human.common.gameplay.recipe.IndustrialFurnaceRecipe;
import com.human.common.registry.init.HumanBlocks;
import com.human.common.registry.init.HumanRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IModInfoRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

@JeiPlugin
public class HumanJEIPlugin implements IModPlugin {

    public static final RecipeType<IndustrialFurnaceRecipe> INDUSTRIAL_FURNACE_TYPE = RecipeType.create(
        Human.MOD_ID,
        "smeltery",
        IndustrialFurnaceRecipe.class
    );

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return HumanResources.location("plugin_" + Human.MOD_ID);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new IndustrialCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        if (Minecraft.getInstance().level == null) {
            return;
        }
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
        registration.addRecipes(
            INDUSTRIAL_FURNACE_TYPE,
            recipeManager.getAllRecipesFor(HumanRecipes.INDUSTRIAL_FURNACE_RECIPE_TYPE.get())
                .stream()
                .map(RecipeHolder::value)
                .toList()
        );
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(HumanBlocks.INDUSTRIAL_FURNACE.get()), INDUSTRIAL_FURNACE_TYPE);
    }

    @Override
    public void registerModInfo(IModInfoRegistration modAliasRegistration) {
        modAliasRegistration.addModAliases(Human.MOD_ID, "avp", "avp_human");
    }
}
