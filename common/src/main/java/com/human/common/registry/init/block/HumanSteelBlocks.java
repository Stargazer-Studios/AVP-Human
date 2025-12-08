package com.human.common.registry.init.block;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.blib.common.gameplay.block.property.BlockPropertyBuilder;
import com.human.Human;
import com.human.common.gameplay.block.HumanBlockSetTypes;
import com.human.common.gameplay.block.property.HumanBlockProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.WaterloggedTransparentBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.function.Supplier;

public class HumanSteelBlocks {

    public static final BLibRegistry<Block> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.BLOCK);

    public static final BLibHolder<Block> CHISELED_STEEL = create("chiseled_steel", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> CUT_STEEL = create("cut_steel", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> CUT_STEEL_STAIRS = create(
        "cut_steel_stairs",
        () -> new StairBlock(
            CUT_STEEL.get().defaultBlockState(),
            HumanBlockProperties.STEEL.build()
        )
    );

    public static final BLibHolder<Block> CUT_STEEL_SLAB = create(
        "cut_steel_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_BLOCK = create("steel_block", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> STEEL_STAIRS = create(
        "steel_stairs",
        () -> new StairBlock(STEEL_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(STEEL_BLOCK.get()))
    );

    public static final BLibHolder<Block> STEEL_SLAB = create(
        "steel_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(STEEL_BLOCK.get()))
    );

    public static final BLibHolder<Block> STEEL_BUTTON = create(
        "steel_button",
        () -> new ButtonBlock(HumanBlockSetTypes.STEEL, 20, HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_BARS = create(
        "steel_bars",
        () -> new IronBarsBlock(HumanBlockProperties.STEEL_BARS.build())
    );

    public static final BLibHolder<Block> STEEL_CHAIN_FENCE = create(
        "steel_chain_fence",
        () -> new IronBarsBlock(HumanBlockProperties.STEEL_BARS.build().sound(SoundType.CHAIN))
    );

    public static final BLibHolder<Block> STEEL_COLUMN = create(
        "steel_column",
        () -> new RotatedPillarBlock(HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_DOOR = create(
        "steel_door",
        () -> new DoorBlock(BlockSetType.COPPER, HumanBlockProperties.STEEL.build().noOcclusion())
    );

    public static final BLibHolder<Block> STEEL_FASTENED_SIDING = create("steel_fastened_siding", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> STEEL_FASTENED_SIDING_STAIRS = create(
        "steel_fastened_siding_stairs",
        () -> new StairBlock(STEEL_FASTENED_SIDING.get().defaultBlockState(), HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_FASTENED_SIDING_SLAB = create(
        "steel_fastened_siding_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_FASTENED_STANDING = create(
        "steel_fastened_standing",
        HumanBlockProperties.STEEL
    );

    public static final BLibHolder<Block> STEEL_FASTENED_STANDING_STAIRS = create(
        "steel_fastened_standing_stairs",
        () -> new StairBlock(STEEL_FASTENED_STANDING.get().defaultBlockState(), HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_FASTENED_STANDING_SLAB = create(
        "steel_fastened_standing_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_GRATE = create(
        "steel_grate",
        () -> new WaterloggedTransparentBlock(HumanBlockProperties.STEEL_GRATE.build())
    );

    public static final BLibHolder<Block> STEEL_GRATE_STAIRS = create(
        "steel_grate_stairs",
        () -> new StairBlock(STEEL_GRATE.get().defaultBlockState(), HumanBlockProperties.STEEL.build().noOcclusion())
    );

    public static final BLibHolder<Block> STEEL_GRATE_SLAB = create(
        "steel_grate_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build().noOcclusion())
    );

    public static final BLibHolder<Block> STEEL_PLATING = create("steel_plating", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> STEEL_PLATING_STAIRS = create(
        "steel_plating_stairs",
        () -> new StairBlock(STEEL_PLATING.get().defaultBlockState(), HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_PLATING_SLAB = create(
        "steel_plating_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_PRESSURE_PLATE = create(
        "steel_pressure_plate",
        () -> new PressurePlateBlock(BlockSetType.COPPER, HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_SIDING = create("steel_siding", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> STEEL_SIDING_STAIRS = create(
        "steel_siding_stairs",
        () -> new StairBlock(STEEL_SIDING.get().defaultBlockState(), HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_SIDING_SLAB = create(
        "steel_siding_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_STANDING = create("steel_standing", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> STEEL_STANDING_STAIRS = create(
        "steel_standing_stairs",
        () -> new StairBlock(STEEL_STANDING.get().defaultBlockState(), HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_STANDING_SLAB = create(
        "steel_standing_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_TRAP_DOOR = create(
        "steel_trapdoor",
        () -> new TrapDoorBlock(BlockSetType.COPPER, HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_TREAD = create("steel_tread", HumanBlockProperties.STEEL);

    public static final BLibHolder<Block> STEEL_TREAD_STAIRS = create(
        "steel_tread_stairs",
        () -> new StairBlock(STEEL_TREAD.get().defaultBlockState(), HumanBlockProperties.STEEL.build())
    );

    public static final BLibHolder<Block> STEEL_TREAD_SLAB = create(
        "steel_tread_slab",
        () -> new SlabBlock(HumanBlockProperties.STEEL.build())
    );

    private static BLibHolder<Block> create(String path, BlockPropertyBuilder blockPropertyBuilder) {
        return create(path, () -> new Block(blockPropertyBuilder.build()));
    }

    private static <T extends Block> BLibHolder<T> create(String path, Supplier<T> blockSupplier) {
        return REGISTRY.createHolder(path, blockSupplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
