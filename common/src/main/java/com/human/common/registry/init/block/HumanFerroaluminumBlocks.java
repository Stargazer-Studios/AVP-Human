package com.human.common.registry.init.block;

import com.blib.common.gameplay.block.property.BlockPropertyBuilder;
import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
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

public class HumanFerroaluminumBlocks {

    public static final BLibRegistry<Block> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.BLOCK);

    public static final BLibHolder<Block> CHISELED_FERROALUMINUM = create(
        "chiseled_ferroaluminum",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> CUT_FERROALUMINUM = create("cut_ferroaluminum", HumanBlockProperties.FERROALUMINUM);

    public static final BLibHolder<Block> CUT_FERROALUMINUM_STAIRS = create(
        "cut_ferroaluminum_stairs",
        () -> new StairBlock(
            CUT_FERROALUMINUM.get().defaultBlockState(),
            HumanBlockProperties.FERROALUMINUM.build()
        )
    );

    public static final BLibHolder<Block> CUT_FERROALUMINUM_SLAB = create(
        "cut_ferroaluminum_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_BLOCK = create(
        "ferroaluminum_block",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> FERROALUMINUM_STAIRS = create(
        "ferroaluminum_stairs",
        () -> new StairBlock(FERROALUMINUM_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(FERROALUMINUM_BLOCK.get()))
    );

    public static final BLibHolder<Block> FERROALUMINUM_SLAB = create(
        "ferroaluminum_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(FERROALUMINUM_BLOCK.get()))
    );

    public static final BLibHolder<Block> FERROALUMINUM_BUTTON = create(
        "ferroaluminum_button",
        () -> new ButtonBlock(HumanBlockSetTypes.FERROALUMINUM, 20, HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_CHAIN_FENCE = create(
        "ferroaluminum_chain_fence",
        () -> new IronBarsBlock(HumanBlockProperties.FERROALUMINUM_BARS.build().sound(SoundType.CHAIN))
    );

    public static final BLibHolder<Block> FERROALUMINUM_COLUMN = create(
        "ferroaluminum_column",
        () -> new RotatedPillarBlock(HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_DOOR = create(
        "ferroaluminum_door",
        () -> new DoorBlock(BlockSetType.COPPER, HumanBlockProperties.FERROALUMINUM.build().noOcclusion())
    );

    public static final BLibHolder<Block> FERROALUMINUM_FASTENED_SIDING = create(
        "ferroaluminum_fastened_siding",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> FERROALUMINUM_FASTENED_SIDING_STAIRS = create(
        "ferroaluminum_fastened_siding_stairs",
        () -> new StairBlock(FERROALUMINUM_FASTENED_SIDING.get().defaultBlockState(), HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_FASTENED_SIDING_SLAB = create(
        "ferroaluminum_fastened_siding_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_FASTENED_STANDING = create(
        "ferroaluminum_fastened_standing",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> FERROALUMINUM_FASTENED_STANDING_STAIRS = create(
        "ferroaluminum_fastened_standing_stairs",
        () -> new StairBlock(FERROALUMINUM_FASTENED_STANDING.get().defaultBlockState(), HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_FASTENED_STANDING_SLAB = create(
        "ferroaluminum_fastened_standing_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_GRATE = create(
        "ferroaluminum_grate",
        () -> new WaterloggedTransparentBlock(HumanBlockProperties.FERROALUMINUM_GRATE.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_GRATE_STAIRS = create(
        "ferroaluminum_grate_stairs",
        () -> new StairBlock(FERROALUMINUM_GRATE.get().defaultBlockState(), HumanBlockProperties.FERROALUMINUM.build().noOcclusion())
    );

    public static final BLibHolder<Block> FERROALUMINUM_GRATE_SLAB = create(
        "ferroaluminum_grate_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build().noOcclusion())
    );

    public static final BLibHolder<Block> FERROALUMINUM_PLATING = create(
        "ferroaluminum_plating",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> FERROALUMINUM_PLATING_STAIRS = create(
        "ferroaluminum_plating_stairs",
        () -> new StairBlock(FERROALUMINUM_PLATING.get().defaultBlockState(), HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_PLATING_SLAB = create(
        "ferroaluminum_plating_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_PRESSURE_PLATE = create(
        "ferroaluminum_pressure_plate",
        () -> new PressurePlateBlock(BlockSetType.COPPER, HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_SIDING = create(
        "ferroaluminum_siding",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> FERROALUMINUM_SIDING_STAIRS = create(
        "ferroaluminum_siding_stairs",
        () -> new StairBlock(FERROALUMINUM_SIDING.get().defaultBlockState(), HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_SIDING_SLAB = create(
        "ferroaluminum_siding_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_STANDING = create(
        "ferroaluminum_standing",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> FERROALUMINUM_STANDING_STAIRS = create(
        "ferroaluminum_standing_stairs",
        () -> new StairBlock(FERROALUMINUM_STANDING.get().defaultBlockState(), HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_STANDING_SLAB = create(
        "ferroaluminum_standing_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_TRAP_DOOR = create(
        "ferroaluminum_trapdoor",
        () -> new TrapDoorBlock(BlockSetType.COPPER, HumanBlockProperties.FERROALUMINUM.build().noOcclusion())
    );

    public static final BLibHolder<Block> FERROALUMINUM_TREAD = create(
        "ferroaluminum_tread",
        HumanBlockProperties.FERROALUMINUM
    );

    public static final BLibHolder<Block> FERROALUMINUM_TREAD_STAIRS = create(
        "ferroaluminum_tread_stairs",
        () -> new StairBlock(FERROALUMINUM_TREAD.get().defaultBlockState(), HumanBlockProperties.FERROALUMINUM.build())
    );

    public static final BLibHolder<Block> FERROALUMINUM_TREAD_SLAB = create(
        "ferroaluminum_tread_slab",
        () -> new SlabBlock(HumanBlockProperties.FERROALUMINUM.build())
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
