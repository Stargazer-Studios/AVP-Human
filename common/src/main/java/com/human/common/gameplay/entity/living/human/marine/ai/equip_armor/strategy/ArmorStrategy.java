package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public interface ArmorStrategy {

    ArmorItem.Type type();

    boolean isValidWorldState(LivingEntity livingEntity, ReadableWorldState worldState);

    double score(LivingEntity livingEntity, ReadableWorldState worldState, ItemStack itemStack);

    default boolean isValidItemStack(ItemStack itemStack) {
        return itemStack.getItem() instanceof ArmorItem armorItem
            && armorItem.getEquipmentSlot() == type().getSlot();
    }

    default Collection<BLibInventory.Entry> selectEntriesFromInventory(BLibInventory inventory) {
        return inventory.filterEntriesByStack(this::isValidItemStack);
    }

    /**
     * @param defense
     */
    record Weights(
        double defense,
        double toughness,
        double enchantment,
        double knockback
    ) {

        public static final Weights DEFAULT = new Weights(
            0.4,
            0.3,
            0.2,
            0.1
        );
    }
}
