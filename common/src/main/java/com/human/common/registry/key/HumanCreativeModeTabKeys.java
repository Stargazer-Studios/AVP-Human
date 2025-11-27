package com.human.common.registry.key;

import com.human.HumanResources;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;

public class HumanCreativeModeTabKeys {

    public static final ResourceKey<CreativeModeTab> BLOCKS_KEY = createResourceKey("human_blocks");

    public static final ResourceKey<CreativeModeTab> COMBAT_KEY = createResourceKey("human_combat");

    public static final ResourceKey<CreativeModeTab> INGREDIENTS_KEY = createResourceKey("human_ingredients");

    public static final ResourceKey<CreativeModeTab> SPAWN_EGGS_KEY = createResourceKey("human_spawn_eggs");

    public static final ResourceKey<CreativeModeTab> TOOLS_AND_UTILITIES_KEY = createResourceKey("human_tools_and_utilities");

    public static ResourceKey<CreativeModeTab> createResourceKey(String name) {
        return ResourceKey.create(
            BuiltInRegistries.CREATIVE_MODE_TAB.key(),
            HumanResources.location(name)
        );
    }

    public static void initialize() {}
}
