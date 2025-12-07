package com.human.common.registry.init.item.block;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import com.human.common.registry.init.block.HumanIndustrialGlassBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HumanIndustrialGlassBlockItems {

    private static final BLibRegistry<BlockItem> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.ITEM);

    public static final BLibHolder<BlockItem> INDUSTRIAL_GLASS = create(
        "industrial_glass",
        HumanIndustrialGlassBlocks.INDUSTRIAL_GLASS
    );

    public static final BLibHolder<BlockItem> INDUSTRIAL_GLASS_DOOR = create(
        "industrial_glass_door",
        HumanIndustrialGlassBlocks.INDUSTRIAL_GLASS_DOOR
    );

    public static final BLibHolder<BlockItem> INDUSTRIAL_GLASS_PANE = create(
        "industrial_glass_pane",
        HumanIndustrialGlassBlocks.INDUSTRIAL_GLASS_PANE
    );

    public static final BLibHolder<BlockItem> INDUSTRIAL_GLASS_SLAB = create(
        "industrial_glass_slab",
        HumanIndustrialGlassBlocks.INDUSTRIAL_GLASS_SLAB
    );

    public static final BLibHolder<BlockItem> INDUSTRIAL_GLASS_STAIRS = create(
        "industrial_glass_stairs",
        HumanIndustrialGlassBlocks.INDUSTRIAL_GLASS_STAIRS
    );

    public static final BLibHolder<BlockItem> INDUSTRIAL_GLASS_TRAP_DOOR = create(
        "industrial_glass_trapdoor",
        HumanIndustrialGlassBlocks.INDUSTRIAL_GLASS_TRAP_DOOR
    );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_INDUSTRIAL_GLASS =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_glass",
                            HumanIndustrialGlassBlocks.DYE_COLOR_TO_INDUSTRIAL_GLASS.get(dyeColor)
                        )
                    )
                )
        );

    public static final Map<DyeColor, Supplier<BlockItem>> DYE_COLOR_TO_INDUSTRIAL_GLASS_PANE =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_glass_pane",
                            HumanIndustrialGlassBlocks.DYE_COLOR_TO_INDUSTRIAL_GLASS_PANE.get(dyeColor)
                        )
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
