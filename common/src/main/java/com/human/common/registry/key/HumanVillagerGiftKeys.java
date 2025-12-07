package com.human.common.registry.key;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.LootTable;
import org.jetbrains.annotations.NotNull;

public class HumanVillagerGiftKeys {

    public static final ResourceKey<LootTable> COMMISSARY_GIFT_LOOT_TABLE = create("commissary_gift");

    private static @NotNull ResourceKey<LootTable> create(String path) {
        return ResourceKey.create(
            Registries.LOOT_TABLE,
            HumanResources.location("gameplay/hero_of_the_village/" + path)
        );
    }
}
