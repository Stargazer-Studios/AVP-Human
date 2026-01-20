package com.human.common.gameplay.item;

import com.human.common.registry.init.HumanArmorMaterials;
import net.minecraft.world.item.ArmorItem;

public class ApeArmorItem extends ArmorItem {

    private static final int MK50_DURABILITY_MULTIPLIER = 14;

    public ApeArmorItem(Type type) {
        super(HumanArmorMaterials.APE, type, new Properties().durability(type.getDurability(MK50_DURABILITY_MULTIPLIER)));
    }
}
