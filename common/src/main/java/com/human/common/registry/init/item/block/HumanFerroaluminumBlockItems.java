package com.human.common.registry.init.item.block;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.registry.init.block.HumanFerroaluminumBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class HumanFerroaluminumBlockItems {

    private static final BLibRegistry<Item> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ITEM);

    public static final BLibHolder<BlockItem> CHISELED_FERROALUMINUM = create(
        "chiseled_ferroaluminum",
        HumanFerroaluminumBlocks.CHISELED_FERROALUMINUM
    );

    public static final BLibHolder<BlockItem> CUT_FERROALUMINUM = create(
        "cut_ferroaluminum",
        HumanFerroaluminumBlocks.CUT_FERROALUMINUM
    );

    public static final BLibHolder<BlockItem> CUT_FERROALUMINUM_SLAB = create(
        "cut_ferroaluminum_slab",
        HumanFerroaluminumBlocks.CUT_FERROALUMINUM_SLAB
    );

    public static final BLibHolder<BlockItem> CUT_FERROALUMINUM_STAIRS = create(
        "cut_ferroaluminum_stairs",
        HumanFerroaluminumBlocks.CUT_FERROALUMINUM_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_BLOCK = create(
        "ferroaluminum_block",
        HumanFerroaluminumBlocks.FERROALUMINUM_BLOCK
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_BUTTON = create(
        "ferroaluminum_button",
        HumanFerroaluminumBlocks.FERROALUMINUM_BUTTON
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_CHAIN_FENCE = create(
        "ferroaluminum_chain_fence",
        HumanFerroaluminumBlocks.FERROALUMINUM_CHAIN_FENCE
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_COLUMN = create(
        "ferroaluminum_column",
        HumanFerroaluminumBlocks.FERROALUMINUM_COLUMN
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_DOOR = create(
        "ferroaluminum_door",
        HumanFerroaluminumBlocks.FERROALUMINUM_DOOR
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_FASTENED_SIDING = create(
        "ferroaluminum_fastened_siding",
        HumanFerroaluminumBlocks.FERROALUMINUM_FASTENED_SIDING
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_FASTENED_SIDING_SLAB = create(
        "ferroaluminum_fastened_siding_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_FASTENED_SIDING_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_FASTENED_SIDING_STAIRS = create(
        "ferroaluminum_fastened_siding_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_FASTENED_SIDING_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_FASTENED_STANDING = create(
        "ferroaluminum_fastened_standing",
        HumanFerroaluminumBlocks.FERROALUMINUM_FASTENED_STANDING
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_FASTENED_STANDING_SLAB = create(
        "ferroaluminum_fastened_standing_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_FASTENED_STANDING_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_FASTENED_STANDING_STAIRS = create(
        "ferroaluminum_fastened_standing_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_FASTENED_STANDING_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_GRATE = create(
        "ferroaluminum_grate",
        HumanFerroaluminumBlocks.FERROALUMINUM_GRATE
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_GRATE_SLAB = create(
        "ferroaluminum_grate_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_GRATE_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_GRATE_STAIRS = create(
        "ferroaluminum_grate_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_GRATE_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_PLATING = create(
        "ferroaluminum_plating",
        HumanFerroaluminumBlocks.FERROALUMINUM_PLATING
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_PLATING_SLAB = create(
        "ferroaluminum_plating_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_PLATING_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_PLATING_STAIRS = create(
        "ferroaluminum_plating_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_PLATING_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_PRESSURE_PLATE = create(
        "ferroaluminum_pressure_plate",
        HumanFerroaluminumBlocks.FERROALUMINUM_PRESSURE_PLATE
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_SIDING = create(
        "ferroaluminum_siding",
        HumanFerroaluminumBlocks.FERROALUMINUM_SIDING
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_SIDING_SLAB = create(
        "ferroaluminum_siding_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_SIDING_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_SIDING_STAIRS = create(
        "ferroaluminum_siding_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_SIDING_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_SLAB = create(
        "ferroaluminum_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_STAIRS = create(
        "ferroaluminum_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_STANDING = create(
        "ferroaluminum_standing",
        HumanFerroaluminumBlocks.FERROALUMINUM_STANDING
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_STANDING_SLAB = create(
        "ferroaluminum_standing_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_STANDING_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_STANDING_STAIRS = create(
        "ferroaluminum_standing_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_STANDING_STAIRS
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_TRAP_DOOR = create(
        "ferroaluminum_trapdoor",
        HumanFerroaluminumBlocks.FERROALUMINUM_TRAP_DOOR
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_TREAD = create(
        "ferroaluminum_tread",
        HumanFerroaluminumBlocks.FERROALUMINUM_TREAD
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_TREAD_SLAB = create(
        "ferroaluminum_tread_slab",
        HumanFerroaluminumBlocks.FERROALUMINUM_TREAD_SLAB
    );

    public static final BLibHolder<BlockItem> FERROALUMINUM_TREAD_STAIRS = create(
        "ferroaluminum_tread_stairs",
        HumanFerroaluminumBlocks.FERROALUMINUM_TREAD_STAIRS
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
