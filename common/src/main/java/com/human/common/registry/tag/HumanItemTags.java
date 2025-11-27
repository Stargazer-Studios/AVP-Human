package com.human.common.registry.tag;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class HumanItemTags {

    private static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, HumanResources.location(name));
    }
}
