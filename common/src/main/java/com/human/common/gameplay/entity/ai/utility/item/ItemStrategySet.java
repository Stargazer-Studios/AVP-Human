package com.human.common.gameplay.entity.ai.utility.item;

import net.minecraft.world.item.ItemStack;

import java.util.List;

public interface ItemStrategySet<S extends ItemStrategy> {

    List<S> getAll();

    default boolean isAnyValidFor(ItemStack itemStack) {
        for (var strategy : getAll()) {
            if (strategy.isValidItemStack(itemStack)) {
                return true;
            }
        }

        return false;
    }
}
