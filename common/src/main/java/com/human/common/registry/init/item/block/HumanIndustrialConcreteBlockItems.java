package com.human.common.registry.init.item.block;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.registry.init.block.HumanIndustrialConcreteBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HumanIndustrialConcreteBlockItems {

    private static final BLibRegistry<Item> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ITEM);

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE =
        HumanIndustrialConcreteBlocks.DYE_COLOR_TO_INDUSTRIAL_CONCRETE.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_industrial_concrete",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE_SLAB =
        HumanIndustrialConcreteBlocks.DYE_COLOR_TO_INDUSTRIAL_CONCRETE_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_industrial_concrete_slab",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE_STAIRS =
        HumanIndustrialConcreteBlocks.DYE_COLOR_TO_INDUSTRIAL_CONCRETE_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_industrial_concrete_stairs",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE_WALL =
        HumanIndustrialConcreteBlocks.DYE_COLOR_TO_INDUSTRIAL_CONCRETE_WALL.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_industrial_concrete_wall",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    private static BLibHolder<BlockItem> create(String path, Supplier<? extends Block> blockSupplier) {
        return create(path, blockSupplier, new Item.Properties());
    }

    private static BLibHolder<BlockItem> create(String path, Supplier<? extends Block> blockSupplier, Item.Properties properties) {
        return createBlockItem(path, () -> new BlockItem(blockSupplier.get(), properties));
    }

    private static BLibHolder<BlockItem> createBlockItem(String path, Supplier<BlockItem> blockItemSupplier) {
        return REGISTRY.createHolder(path, blockItemSupplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
