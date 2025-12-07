package com.human.common.registry.init.item;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.item.MK50ArmorItem;
import com.human.common.gameplay.item.PressureSuitArmorItem;
import com.human.common.registry.init.HumanArmorMaterials;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class HumanArmorItems {

    private static final BLibRegistry<ArmorItem> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.ITEM);

    private static final int STEEL_DURABILITY_MULTIPLIER = 21;

    private static final int TACTICAL_DURABILITY_MULTIPLIER = 18;

    private static final int TITANIUM_DURABILITY_MULTIPLIER = 27;

    private static final int WY_COMMANDO_DURABILITY_MULTIPLIER = 18;

    private static final int WY_ELITE_DURABILITY_MULTIPLIER = 18;

    public static final BLibHolder<ArmorItem> MK50_BOOTS = create("mk50_boots", () -> new MK50ArmorItem(ArmorItem.Type.BOOTS));

    public static final BLibHolder<ArmorItem> MK50_CHESTPLATE = create(
        "mk50_chestplate",
        () -> new MK50ArmorItem(ArmorItem.Type.CHESTPLATE)
    );

    public static final BLibHolder<ArmorItem> MK50_HELMET = create("mk50_helmet", () -> new MK50ArmorItem(ArmorItem.Type.HELMET));

    public static final BLibHolder<ArmorItem> MK50_LEGGINGS = create(
        "mk50_leggings",
        () -> new MK50ArmorItem(ArmorItem.Type.LEGGINGS)
    );

    public static final BLibHolder<ArmorItem> PRESSURE_BOOTS = create(
        "pressure_boots",
        () -> new PressureSuitArmorItem(ArmorItem.Type.BOOTS)
    );

    public static final BLibHolder<ArmorItem> PRESSURE_CHESTPLATE = create(
        "pressure_chestplate",
        () -> new PressureSuitArmorItem(ArmorItem.Type.CHESTPLATE)
    );

    public static final BLibHolder<ArmorItem> PRESSURE_HELMET = create(
        "pressure_helmet",
        () -> new PressureSuitArmorItem(ArmorItem.Type.HELMET)
    );

    public static final BLibHolder<ArmorItem> PRESSURE_LEGGINGS = create(
        "pressure_leggings",
        () -> new PressureSuitArmorItem(ArmorItem.Type.LEGGINGS)
    );

    public static final BLibHolder<ArmorItem> STEEL_BOOTS = create(
        "steel_boots",
        HumanArmorMaterials.STEEL::getHolder,
        ArmorItem.Type.BOOTS,
        STEEL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> STEEL_CHESTPLATE = create(
        "steel_chestplate",
        HumanArmorMaterials.STEEL::getHolder,
        ArmorItem.Type.CHESTPLATE,
        STEEL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> STEEL_HELMET = create(
        "steel_helmet",
        HumanArmorMaterials.STEEL::getHolder,
        ArmorItem.Type.HELMET,
        STEEL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> STEEL_LEGGINGS = create(
        "steel_leggings",
        HumanArmorMaterials.STEEL::getHolder,
        ArmorItem.Type.LEGGINGS,
        STEEL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_BOOTS = create(
        "tactical_boots",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.BOOTS,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_CHESTPLATE = create(
        "tactical_chestplate",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.CHESTPLATE,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_HELMET = create(
        "tactical_helmet",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.HELMET,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_LEGGINGS = create(
        "tactical_leggings",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.LEGGINGS,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_CAMO_BOOTS = create(
        "tactical_camo_boots",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.BOOTS,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_CAMO_CHESTPLATE = create(
        "tactical_camo_chestplate",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.CHESTPLATE,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_CAMO_HELMET = create(
        "tactical_camo_helmet",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.HELMET,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TACTICAL_CAMO_LEGGINGS = create(
        "tactical_camo_leggings",
        HumanArmorMaterials.TACTICAL::getHolder,
        ArmorItem.Type.LEGGINGS,
        TACTICAL_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TITANIUM_BOOTS = create(
        "titanium_boots",
        HumanArmorMaterials.TITANIUM::getHolder,
        ArmorItem.Type.BOOTS,
        TITANIUM_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TITANIUM_CHESTPLATE = create(
        "titanium_chestplate",
        HumanArmorMaterials.TITANIUM::getHolder,
        ArmorItem.Type.CHESTPLATE,
        TITANIUM_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TITANIUM_HELMET = create(
        "titanium_helmet",
        HumanArmorMaterials.TITANIUM::getHolder,
        ArmorItem.Type.HELMET,
        TITANIUM_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> TITANIUM_LEGGINGS = create(
        "titanium_leggings",
        HumanArmorMaterials.TITANIUM::getHolder,
        ArmorItem.Type.LEGGINGS,
        TITANIUM_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_COMMANDO_BOOTS = create(
        "wy_commando_boots",
        HumanArmorMaterials.WY_COMMANDO::getHolder,
        ArmorItem.Type.BOOTS,
        WY_COMMANDO_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_COMMANDO_CHESTPLATE = create(
        "wy_commando_chestplate",
        HumanArmorMaterials.WY_COMMANDO::getHolder,
        ArmorItem.Type.CHESTPLATE,
        WY_COMMANDO_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_COMMANDO_HELMET = create(
        "wy_commando_helmet",
        HumanArmorMaterials.WY_COMMANDO::getHolder,
        ArmorItem.Type.HELMET,
        WY_COMMANDO_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_COMMANDO_LEGGINGS = create(
        "wy_commando_leggings",
        HumanArmorMaterials.WY_COMMANDO::getHolder,
        ArmorItem.Type.LEGGINGS,
        WY_COMMANDO_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_ELITE_BOOTS = create(
        "wy_elite_boots",
        HumanArmorMaterials.WY_ELITE::getHolder,
        ArmorItem.Type.BOOTS,
        WY_ELITE_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_ELITE_CHESTPLATE = create(
        "wy_elite_chestplate",
        HumanArmorMaterials.WY_ELITE::getHolder,
        ArmorItem.Type.CHESTPLATE,
        WY_ELITE_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_ELITE_HELMET = create(
        "wy_elite_helmet",
        HumanArmorMaterials.WY_ELITE::getHolder,
        ArmorItem.Type.HELMET,
        WY_ELITE_DURABILITY_MULTIPLIER
    );

    public static final BLibHolder<ArmorItem> WY_ELITE_LEGGINGS = create(
        "wy_elite_leggings",
        HumanArmorMaterials.WY_ELITE::getHolder,
        ArmorItem.Type.LEGGINGS,
        WY_ELITE_DURABILITY_MULTIPLIER
    );

    private static BLibHolder<ArmorItem> create(
        String path,
        Supplier<Holder<ArmorMaterial>> holderSupplier,
        ArmorItem.Type type,
        int durabilityMultiplier
    ) {
        return create(path, holderSupplier, type, durabilityMultiplier, new Item.Properties());
    }

    private static BLibHolder<ArmorItem> create(
        String path,
        Supplier<Holder<ArmorMaterial>> holderSupplier,
        ArmorItem.Type type,
        int durabilityMultiplier,
        Item.Properties properties
    ) {
        return create(path, () -> createArmorItem(holderSupplier.get(), type, durabilityMultiplier, properties));
    }

    private static <T extends ArmorItem> BLibHolder<T> create(String path, Supplier<T> itemSupplier) {
        return REGISTRY.createHolder(path, itemSupplier);
    }

    private static ArmorItem createArmorItem(
        Holder<ArmorMaterial> holder,
        ArmorItem.Type type,
        int durabilityMultiplier,
        Item.Properties properties
    ) {
        var durability = type.getDurability(durabilityMultiplier);
        properties = properties.durability(durability);
        return new ArmorItem(holder, type, properties);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
