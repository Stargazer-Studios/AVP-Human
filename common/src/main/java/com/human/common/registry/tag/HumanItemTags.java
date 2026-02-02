package com.human.common.registry.tag;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

public class HumanItemTags {

    public static final TagKey<Item> AMMO_ITEMS = create("ammo_items");

    public static final TagKey<Item> APE_ARMOR = create("ape_armor");

    public static final TagKey<Item> GUNS = create("guns");

    public static final TagKey<Item> INDUSTRIAL_GLASS = create("industrial_glass");

    public static final TagKey<Item> INDUSTRIAL_GLASS_BLOCK = create("industrial_glass_block");

    public static final TagKey<Item> INDUSTRIAL_GLASS_PANE = create("industrial_glass_pane");

    public static final TagKey<Item> LITHIUM = create("lithium");

    public static final TagKey<Item> MK50_ARMOR = create("mk50_armor");

    public static final TagKey<Item> PLASTIC = create("plastic");

    public static final TagKey<Item> PRESSURE_ARMOR = create("pressure_armor");

    public static final TagKey<Item> RADIATION_CURE_ITEMS = create("radiation_cure_items");

    public static final TagKey<Item> RADIATION_RESISTANT_ARMORS = create("radiation_resistant_armors");

    public static final TagKey<Item> RADIOACTIVE_ITEMS = create("radioactive_items");

    public static final TagKey<Item> URANIUM_NUGGET_LIKE = create("uranium_nugget_like");

    public static final TagKey<Item> WY_COMMANDO_ARMOR = create("wy_commando_armor");

    public static final TagKey<Item> WY_ELITE_ARMOR = create("wy_elite_armor");

    private static TagKey<Item> create(String name) {
        return TagKey.create(Registries.ITEM, HumanResources.location(name));
    }
}
