package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategy;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public interface ArmorStrategy extends ItemStrategy {

    ArmorItem.Type type();

    @Override
    default boolean isValidItemStack(ItemStack itemStack) {
        return itemStack.getItem() instanceof ArmorItem armorItem
            && armorItem.getEquipmentSlot() == type().getSlot();
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
