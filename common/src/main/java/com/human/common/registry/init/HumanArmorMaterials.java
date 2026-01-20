package com.human.common.registry.init;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.HumanResources;
import com.human.compatibility.HumanCommonItemTags;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class HumanArmorMaterials {

    public static final BLibRegistry<ArmorMaterial> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ARMOR_MATERIAL);

    public static final BLibHolder<ArmorMaterial> APE = create(
        "ape",
        relativeDefense(
            ArmorMaterials.IRON,
            Map.ofEntries(
                Map.entry(ArmorItem.Type.CHESTPLATE, -2),
                Map.entry(ArmorItem.Type.LEGGINGS, -1)
            )
        ),
        6,
        HumanSoundEvents.ITEM_ARMOR_EQUIP_APE,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_LEAD),
        0,
        0
    );

    public static final BLibHolder<ArmorMaterial> MK50 = create(
        "mk50",
        relativeDefense(
            ArmorMaterials.IRON,
            Map.ofEntries(
                Map.entry(ArmorItem.Type.CHESTPLATE, -2),
                Map.entry(ArmorItem.Type.LEGGINGS, -1)
            )
        ),
        6,
        HumanSoundEvents.ITEM_ARMOR_EQUIP_MK50,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_LEAD),
        0,
        0
    );

    public static final BLibHolder<ArmorMaterial> PRESSURE = create(
        "pressure",
        relativeDefense(
            ArmorMaterials.IRON,
            Map.ofEntries(
                Map.entry(ArmorItem.Type.CHESTPLATE, -2),
                Map.entry(ArmorItem.Type.LEGGINGS, -1)
            )
        ),
        6,
        HumanSoundEvents.ITEM_ARMOR_EQUIP_PRESSURE,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_ALUMINUM),
        0,
        0
    );

    public static final BLibHolder<ArmorMaterial> STEEL = create(
        "steel",
        relativeDefense(
            ArmorMaterials.IRON,
            Map.ofEntries(
                Map.entry(ArmorItem.Type.HELMET, 1),
                Map.entry(ArmorItem.Type.CHESTPLATE, 1),
                Map.entry(ArmorItem.Type.LEGGINGS, 1),
                Map.entry(ArmorItem.Type.BOOTS, 1)
            )
        ),
        5, // TODO:
        HumanSoundEvents.ITEM_ARMOR_EQUIP_STEEL,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_STEEL),
        0,
        0
    );

    public static final BLibHolder<ArmorMaterial> TACTICAL = create(
        "tactical",
        Map.ofEntries(
            Map.entry(ArmorItem.Type.HELMET, 2),
            Map.entry(ArmorItem.Type.CHESTPLATE, 6),
            Map.entry(ArmorItem.Type.LEGGINGS, 3),
            Map.entry(ArmorItem.Type.BOOTS, 2)
        ),
        5,
        HumanSoundEvents.ITEM_ARMOR_EQUIP_TACTICAL,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_STEEL),
        0,
        0
    );

    public static final BLibHolder<ArmorMaterial> TITANIUM = create(
        "titanium",
        relativeDefense(
            ArmorMaterials.IRON,
            Map.ofEntries(
                Map.entry(ArmorItem.Type.HELMET, 1),
                Map.entry(ArmorItem.Type.CHESTPLATE, 2),
                Map.entry(ArmorItem.Type.LEGGINGS, 1),
                Map.entry(ArmorItem.Type.BOOTS, 1)
            )
        ),
        5,
        HumanSoundEvents.ITEM_ARMOR_EQUIP_TITANIUM,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_TITANIUM),
        1,
        0
    );

    public static final BLibHolder<ArmorMaterial> WY_COMMANDO = create(
        "wy_commando",
        Map.ofEntries(
            Map.entry(ArmorItem.Type.HELMET, 2),
            Map.entry(ArmorItem.Type.CHESTPLATE, 6),
            Map.entry(ArmorItem.Type.LEGGINGS, 3),
            Map.entry(ArmorItem.Type.BOOTS, 2)
        ),
        5,
        HumanSoundEvents.ITEM_ARMOR_EQUIP_TACTICAL,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_STEEL),
        0,
        0
    );

    public static final BLibHolder<ArmorMaterial> WY_ELITE = create(
        "wy_elite",
        Map.ofEntries(
            Map.entry(ArmorItem.Type.HELMET, 2),
            Map.entry(ArmorItem.Type.CHESTPLATE, 6),
            Map.entry(ArmorItem.Type.LEGGINGS, 3),
            Map.entry(ArmorItem.Type.BOOTS, 2)
        ),
        5,
        HumanSoundEvents.ITEM_ARMOR_EQUIP_TACTICAL,
        () -> Ingredient.of(HumanCommonItemTags.INGOTS_STEEL),
        0,
        0
    );

    public static BLibHolder<ArmorMaterial> create(
        String path,
        Map<ArmorItem.Type, Integer> defensePoints,
        int enchantability,
        BLibHolder<SoundEvent> holder,
        Supplier<Ingredient> repairIngredientSupplier,
        float toughness,
        float knockbackResistance
    ) {
        var resourceLocation = HumanResources.location(path);

        List<ArmorMaterial.Layer> layers = List.of(
            new ArmorMaterial.Layer(resourceLocation, "", false)
        );

        return REGISTRY.createHolder(
            path,
            () -> new ArmorMaterial(
                defensePoints,
                enchantability,
                holder,
                repairIngredientSupplier,
                layers,
                toughness,
                knockbackResistance
            )
        );
    }

    public static Map<ArmorItem.Type, Integer> relativeDefense(
        Holder<ArmorMaterial> armorMaterialHolder,
        Map<ArmorItem.Type, Integer> additiveDefense
    ) {
        var armorMaterial = armorMaterialHolder.value();

        return Map.ofEntries(
            compute(ArmorItem.Type.HELMET, additiveDefense, armorMaterial),
            compute(ArmorItem.Type.CHESTPLATE, additiveDefense, armorMaterial),
            compute(ArmorItem.Type.LEGGINGS, additiveDefense, armorMaterial),
            compute(ArmorItem.Type.BOOTS, additiveDefense, armorMaterial)
        );
    }

    private static @NotNull Map.Entry<ArmorItem.Type, Integer> compute(
        ArmorItem.Type type,
        Map<ArmorItem.Type, Integer> additiveDefense,
        ArmorMaterial armorMaterial
    ) {
        return Map.entry(type, armorMaterial.getDefense(type) + additiveDefense.getOrDefault(type, 0));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
