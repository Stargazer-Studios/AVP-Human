package com.human.common.registry.init.item.block;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.registry.init.block.HumanPaddingBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HumanPaddingBlockItems {

    private static final BLibRegistry<Item> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ITEM);

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PADDING =
        HumanPaddingBlocks.DYE_COLOR_TO_PADDING.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_padding",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PADDING_SLAB =
        HumanPaddingBlocks.DYE_COLOR_TO_PADDING_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_padding_slab",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PADDING_STAIRS =
        HumanPaddingBlocks.DYE_COLOR_TO_PADDING_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_padding_stairs",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PANEL_PADDING =
        HumanPaddingBlocks.DYE_COLOR_TO_PANEL_PADDING.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_panel_padding",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PANEL_PADDING_SLAB =
        HumanPaddingBlocks.DYE_COLOR_TO_PANEL_PADDING_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_panel_padding_slab",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PANEL_PADDING_STAIRS =
        HumanPaddingBlocks.DYE_COLOR_TO_PANEL_PADDING_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_panel_padding_stairs",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PIPE_PADDING =
        HumanPaddingBlocks.DYE_COLOR_TO_PIPE_PADDING.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_pipe_padding",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PIPE_PADDING_SLAB =
        HumanPaddingBlocks.DYE_COLOR_TO_PIPE_PADDING_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_pipe_padding_slab",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PIPE_PADDING_STAIRS =
        HumanPaddingBlocks.DYE_COLOR_TO_PIPE_PADDING_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_pipe_padding_stairs",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_TILE_PADDING =
        HumanPaddingBlocks.DYE_COLOR_TO_TILE_PADDING.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_tile_padding",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_TILE_PADDING_SLAB =
        HumanPaddingBlocks.DYE_COLOR_TO_TILE_PADDING_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_tile_padding_slab",
                        entry.getValue()
                    )
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_TILE_PADDING_STAIRS =
        HumanPaddingBlocks.DYE_COLOR_TO_TILE_PADDING_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_tile_padding_stairs",
                        entry.getValue()
                    )
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
