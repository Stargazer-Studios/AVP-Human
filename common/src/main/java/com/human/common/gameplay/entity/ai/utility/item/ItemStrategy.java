package com.human.common.gameplay.entity.ai.utility.item;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public interface ItemStrategy {

    boolean isValidWorldState(LivingEntity livingEntity, ReadableWorldState worldState);

    double score(LivingEntity livingEntity, ReadableWorldState worldState, ItemStack itemStack);

    boolean isValidItemStack(ItemStack itemStack);

    default Collection<BLibInventory.Entry> selectEntriesFromInventory(BLibInventory inventory) {
        return inventory.filterEntriesByStack(this::isValidItemStack);
    }
}
