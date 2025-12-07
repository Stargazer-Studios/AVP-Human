package com.human.common.gameplay.menu;

import com.human.common.registry.init.HumanMenuTypes;
import com.human.common.registry.init.HumanRecipes;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractFurnaceMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.RecipeBookType;

public class IndustrialFurnaceMenu extends AbstractFurnaceMenu {

    public IndustrialFurnaceMenu(int containerId, Inventory inventory) {
        super(
            HumanMenuTypes.INDUSTRIAL_FURNACE_MENU.get(),
            HumanRecipes.INDUSTRIAL_FURNACE_RECIPE_TYPE.get(),
            // TODO: Look into if we need to change this.
            RecipeBookType.BLAST_FURNACE,
            containerId,
            inventory
        );
    }

    public IndustrialFurnaceMenu(
        int containerId,
        Inventory inventory,
        Container industrialFurnaceContainer,
        ContainerData industrialFurnaceData
    ) {
        super(
            HumanMenuTypes.INDUSTRIAL_FURNACE_MENU.get(),
            HumanRecipes.INDUSTRIAL_FURNACE_RECIPE_TYPE.get(),
            // TODO: Look into if we need to change this.
            RecipeBookType.BLAST_FURNACE,
            containerId,
            inventory,
            industrialFurnaceContainer,
            industrialFurnaceData
        );
    }
}
