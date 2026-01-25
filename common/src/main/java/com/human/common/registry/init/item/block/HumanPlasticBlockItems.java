package com.human.common.registry.init.item.block;

import com.blib.api.common.registry.v1.BLibHolder;
import com.blib.api.common.registry.v1.BLibRegistry;
import com.human.Human;
import com.human.common.registry.init.block.HumanPlasticBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HumanPlasticBlockItems {

    private static final BLibRegistry<Item> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ITEM);

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_CUT_PLASTIC =
        HumanPlasticBlocks.DYE_COLOR_TO_CUT_PLASTIC.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_cut_plastic",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_CUT_PLASTIC_SLAB =
        HumanPlasticBlocks.DYE_COLOR_TO_CUT_PLASTIC_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_cut_plastic_slab",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_CUT_PLASTIC_STAIRS =
        HumanPlasticBlocks.DYE_COLOR_TO_CUT_PLASTIC_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_cut_plastic_stairs",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_FRAMED_PLASTIC =
        HumanPlasticBlocks.DYE_COLOR_TO_FRAMED_PLASTIC.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_framed_plastic",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PITTED_PLASTIC =
        HumanPlasticBlocks.DYE_COLOR_TO_PITTED_PLASTIC.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_pitted_plastic",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PITTED_PLASTIC_SLAB =
        HumanPlasticBlocks.DYE_COLOR_TO_PITTED_PLASTIC_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_pitted_plastic_slab",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PITTED_PLASTIC_STAIRS =
        HumanPlasticBlocks.DYE_COLOR_TO_PITTED_PLASTIC_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_pitted_plastic_stairs",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PLASTIC =
        HumanPlasticBlocks.DYE_COLOR_TO_PLASTIC.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_plastic",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PLASTIC_SLAB =
        HumanPlasticBlocks.DYE_COLOR_TO_PLASTIC_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_plastic_slab",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PLASTIC_STAIRS =
        HumanPlasticBlocks.DYE_COLOR_TO_PLASTIC_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_plastic_stairs",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PLASTIC_GRATE =
        HumanPlasticBlocks.DYE_COLOR_TO_PLASTIC_GRATE.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_plastic_grate",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PLASTIC_GRATE_SLAB =
        HumanPlasticBlocks.DYE_COLOR_TO_PLASTIC_GRATE_SLAB.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_plastic_grate_slab",
                        entry.getValue()
                    ),
                    (a, b) -> b,
                    LinkedHashMap::new
                )
            );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_PLASTIC_GRATE_STAIRS =
        HumanPlasticBlocks.DYE_COLOR_TO_PLASTIC_GRATE_STAIRS.entrySet()
            .stream()
            .collect(
                Collectors.toMap(
                    Map.Entry::getKey,
                    entry -> create(
                        entry.getKey().getName() + "_plastic_grate_stairs",
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
