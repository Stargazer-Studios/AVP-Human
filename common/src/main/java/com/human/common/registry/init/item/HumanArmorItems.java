package com.human.common.registry.init.item;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.ArmorItem;

import java.util.function.Supplier;

public class HumanArmorItems {

    private static final BLibRegistry<ArmorItem> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.ITEM);

    private static <T extends ArmorItem> BLibHolder<T> create(String name, Supplier<T> itemSupplier) {
        return REGISTRY.createHolder(name, itemSupplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
