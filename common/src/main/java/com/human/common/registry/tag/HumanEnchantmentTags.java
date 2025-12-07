package com.human.common.registry.tag;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.enchantment.Enchantment;

public class HumanEnchantmentTags {

    public static final TagKey<Enchantment> GUN_ENCHANTMENTS = create("gun_enchantments");

    private static TagKey<Enchantment> create(String id) {
        return TagKey.create(Registries.ENCHANTMENT, HumanResources.location(id));
    }
}
