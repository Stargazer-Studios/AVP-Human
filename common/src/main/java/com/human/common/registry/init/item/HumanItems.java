package com.human.common.registry.init.item;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class HumanItems {

    public static final BLibRegistry<Item> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.ITEM);

    private static BLibHolder<Item> create(String name, Item.Properties properties) {
        return create(name, () -> new Item(properties));
    }

    private static <T extends Item> BLibHolder<T> create(String name, Supplier<T> itemSupplier) {
        return REGISTRY.createHolder(name, itemSupplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
