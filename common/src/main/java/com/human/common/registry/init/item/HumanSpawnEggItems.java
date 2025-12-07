package com.human.common.registry.init.item;

import com.avp.service.Services;
import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import com.human.common.registry.init.HumanEntityTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

public class HumanSpawnEggItems {

    public static final BLibRegistry<SpawnEggItem> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.ITEM);

    public static final BLibHolder<SpawnEggItem> MARINE_SPAWN_EGG = create(
        "marine",
        HumanEntityTypes.MARINE,
        0x5a5941,
        0x414441
    );

    private static <E extends Mob> BLibHolder<SpawnEggItem> create(
        String baseId,
        Supplier<EntityType<E>> entityTypeSupplier,
        int primaryColor,
        int secondaryColor
    ) {
        var supplier = Services.BRIDGE.createSpawnEggSupplier(entityTypeSupplier, primaryColor, secondaryColor, new Item.Properties());
        return REGISTRY.createHolder(baseId + "_spawn_egg", supplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
