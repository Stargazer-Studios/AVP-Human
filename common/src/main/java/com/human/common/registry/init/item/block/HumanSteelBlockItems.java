package com.human.common.registry.init.item.block;

import com.blib.api.common.registry.v1.BLibHolder;
import com.blib.api.common.registry.v1.BLibRegistry;
import com.human.Human;
import com.human.common.registry.init.block.HumanSteelBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public class HumanSteelBlockItems {

    private static final BLibRegistry<Item> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ITEM);

    public static final BLibHolder<BlockItem> CHISELED_STEEL = create(
        "chiseled_steel",
        HumanSteelBlocks.CHISELED_STEEL
    );

    public static final BLibHolder<BlockItem> CUT_STEEL = create("cut_steel", HumanSteelBlocks.CUT_STEEL);

    public static final BLibHolder<BlockItem> CUT_STEEL_SLAB = create(
        "cut_steel_slab",
        HumanSteelBlocks.CUT_STEEL_SLAB
    );

    public static final BLibHolder<BlockItem> CUT_STEEL_STAIRS = create(
        "cut_steel_stairs",
        HumanSteelBlocks.CUT_STEEL_STAIRS
    );

    public static final BLibHolder<BlockItem> STEEL_BARS = create("steel_bars", HumanSteelBlocks.STEEL_BARS);

    public static final BLibHolder<BlockItem> STEEL_BLOCK = create("steel_block", HumanSteelBlocks.STEEL_BLOCK);

    public static final BLibHolder<BlockItem> STEEL_BUTTON = create("steel_button", HumanSteelBlocks.STEEL_BUTTON);

    public static final BLibHolder<BlockItem> STEEL_CHAIN_FENCE = create(
        "steel_chain_fence",
        HumanSteelBlocks.STEEL_CHAIN_FENCE
    );

    public static final BLibHolder<BlockItem> STEEL_COLUMN = create("steel_column", HumanSteelBlocks.STEEL_COLUMN);

    public static final BLibHolder<BlockItem> STEEL_DOOR = create("steel_door", HumanSteelBlocks.STEEL_DOOR);

    public static final BLibHolder<BlockItem> STEEL_FASTENED_SIDING = create(
        "steel_fastened_siding",
        HumanSteelBlocks.STEEL_FASTENED_SIDING
    );

    public static final BLibHolder<BlockItem> STEEL_FASTENED_SIDING_SLAB = create(
        "steel_fastened_siding_slab",
        HumanSteelBlocks.STEEL_FASTENED_SIDING_SLAB
    );

    public static final BLibHolder<BlockItem> STEEL_FASTENED_SIDING_STAIRS = create(
        "steel_fastened_siding_stairs",
        HumanSteelBlocks.STEEL_FASTENED_SIDING_STAIRS
    );

    public static final BLibHolder<BlockItem> STEEL_FASTENED_STANDING = create(
        "steel_fastened_standing",
        HumanSteelBlocks.STEEL_FASTENED_STANDING
    );

    public static final BLibHolder<BlockItem> STEEL_FASTENED_STANDING_SLAB = create(
        "steel_fastened_standing_slab",
        HumanSteelBlocks.STEEL_FASTENED_STANDING_SLAB
    );

    public static final BLibHolder<BlockItem> STEEL_FASTENED_STANDING_STAIRS = create(
        "steel_fastened_standing_stairs",
        HumanSteelBlocks.STEEL_FASTENED_STANDING_STAIRS
    );

    public static final BLibHolder<BlockItem> STEEL_GRATE = create("steel_grate", HumanSteelBlocks.STEEL_GRATE);

    public static final BLibHolder<BlockItem> STEEL_GRATE_SLAB = create(
        "steel_grate_slab",
        HumanSteelBlocks.STEEL_GRATE_SLAB
    );

    public static final BLibHolder<BlockItem> STEEL_GRATE_STAIRS = create(
        "steel_grate_stairs",
        HumanSteelBlocks.STEEL_GRATE_STAIRS
    );

    public static final BLibHolder<BlockItem> STEEL_PLATING = create(
        "steel_plating",
        HumanSteelBlocks.STEEL_PLATING
    );

    public static final BLibHolder<BlockItem> STEEL_PLATING_SLAB = create(
        "steel_plating_slab",
        HumanSteelBlocks.STEEL_PLATING_SLAB
    );

    public static final BLibHolder<BlockItem> STEEL_PLATING_STAIRS = create(
        "steel_plating_stairs",
        HumanSteelBlocks.STEEL_PLATING_STAIRS
    );

    public static final BLibHolder<BlockItem> STEEL_PRESSURE_PLATE = create(
        "steel_pressure_plate",
        HumanSteelBlocks.STEEL_PRESSURE_PLATE
    );

    public static final BLibHolder<BlockItem> STEEL_SIDING = create("steel_siding", HumanSteelBlocks.STEEL_SIDING);

    public static final BLibHolder<BlockItem> STEEL_SIDING_SLAB = create(
        "steel_siding_slab",
        HumanSteelBlocks.STEEL_SIDING_SLAB
    );

    public static final BLibHolder<BlockItem> STEEL_SIDING_STAIRS = create(
        "steel_siding_stairs",
        HumanSteelBlocks.STEEL_SIDING_STAIRS
    );

    public static final BLibHolder<BlockItem> STEEL_SLAB = create("steel_slab", HumanSteelBlocks.STEEL_SLAB);

    public static final BLibHolder<BlockItem> STEEL_STAIRS = create("steel_stairs", HumanSteelBlocks.STEEL_STAIRS);

    public static final BLibHolder<BlockItem> STEEL_STANDING = create(
        "steel_standing",
        HumanSteelBlocks.STEEL_STANDING
    );

    public static final BLibHolder<BlockItem> STEEL_STANDING_SLAB = create(
        "steel_standing_slab",
        HumanSteelBlocks.STEEL_STANDING_SLAB
    );

    public static final BLibHolder<BlockItem> STEEL_STANDING_STAIRS = create(
        "steel_standing_stairs",
        HumanSteelBlocks.STEEL_STANDING_STAIRS
    );

    public static final BLibHolder<BlockItem> STEEL_TRAP_DOOR = create(
        "steel_trapdoor",
        HumanSteelBlocks.STEEL_TRAP_DOOR
    );

    public static final BLibHolder<BlockItem> STEEL_TREAD = create("steel_tread", HumanSteelBlocks.STEEL_TREAD);

    public static final BLibHolder<BlockItem> STEEL_TREAD_SLAB = create(
        "steel_tread_slab",
        HumanSteelBlocks.STEEL_TREAD_SLAB
    );

    public static final BLibHolder<BlockItem> STEEL_TREAD_STAIRS = create(
        "steel_tread_stairs",
        HumanSteelBlocks.STEEL_TREAD_STAIRS
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
