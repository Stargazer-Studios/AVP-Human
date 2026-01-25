package com.human.common.registry.init.block;

import com.blib.api.common.block.v1.BlockPropertyBuilder;
import com.blib.api.common.registry.v1.BLibHolder;
import com.blib.api.common.registry.v1.BLibRegistry;
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

public class HumanTitaniumBlocks {

    public static final BLibRegistry<Block> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.BLOCK);

    public static final BLibHolder<Block> CHISELED_TITANIUM = create("chiseled_titanium", HumanBlockProperties.TITANIUM);

    public static final BLibHolder<Block> CUT_TITANIUM = create("cut_titanium", HumanBlockProperties.TITANIUM);

    public static final BLibHolder<Block> CUT_TITANIUM_STAIRS = create(
        "cut_titanium_stairs",
        () -> new StairBlock(
            CUT_TITANIUM.get().defaultBlockState(),
            HumanBlockProperties.TITANIUM.build()
        )
    );

    public static final BLibHolder<Block> CUT_TITANIUM_SLAB = create(
        "cut_titanium_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_BLOCK = create("titanium_block", HumanBlockProperties.TITANIUM);

    public static final BLibHolder<Block> TITANIUM_STAIRS = create(
        "titanium_stairs",
        () -> new StairBlock(TITANIUM_BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(TITANIUM_BLOCK.get()))
    );

    public static final BLibHolder<Block> TITANIUM_SLAB = create(
        "titanium_slab",
        () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(TITANIUM_BLOCK.get()))
    );

    public static final BLibHolder<Block> TITANIUM_BUTTON = create(
        "titanium_button",
        () -> new ButtonBlock(HumanBlockSetTypes.TITANIUM, 20, HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_CHAIN_FENCE = create(
        "titanium_chain_fence",
        () -> new IronBarsBlock(HumanBlockProperties.TITANIUM_BARS.build().sound(SoundType.CHAIN))
    );

    public static final BLibHolder<Block> TITANIUM_COLUMN = create(
        "titanium_column",
        () -> new RotatedPillarBlock(HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_DOOR = create(
        "titanium_door",
        () -> new DoorBlock(BlockSetType.COPPER, HumanBlockProperties.TITANIUM.build().noOcclusion())
    );

    public static final BLibHolder<Block> TITANIUM_FASTENED_SIDING = create(
        "titanium_fastened_siding",
        HumanBlockProperties.TITANIUM
    );

    public static final BLibHolder<Block> TITANIUM_FASTENED_SIDING_STAIRS = create(
        "titanium_fastened_siding_stairs",
        () -> new StairBlock(TITANIUM_FASTENED_SIDING.get().defaultBlockState(), HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_FASTENED_SIDING_SLAB = create(
        "titanium_fastened_siding_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_FASTENED_STANDING = create(
        "titanium_fastened_standing",
        HumanBlockProperties.TITANIUM
    );

    public static final BLibHolder<Block> TITANIUM_FASTENED_STANDING_STAIRS = create(
        "titanium_fastened_standing_stairs",
        () -> new StairBlock(TITANIUM_FASTENED_STANDING.get().defaultBlockState(), HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_FASTENED_STANDING_SLAB = create(
        "titanium_fastened_standing_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_GRATE = create(
        "titanium_grate",
        () -> new WaterloggedTransparentBlock(HumanBlockProperties.TITANIUM_GRATE.build())
    );

    public static final BLibHolder<Block> TITANIUM_GRATE_STAIRS = create(
        "titanium_grate_stairs",
        () -> new StairBlock(TITANIUM_GRATE.get().defaultBlockState(), HumanBlockProperties.TITANIUM.build().noOcclusion())
    );

    public static final BLibHolder<Block> TITANIUM_GRATE_SLAB = create(
        "titanium_grate_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build().noOcclusion())
    );

    public static final BLibHolder<Block> TITANIUM_PLATING = create("titanium_plating", HumanBlockProperties.TITANIUM);

    public static final BLibHolder<Block> TITANIUM_PLATING_STAIRS = create(
        "titanium_plating_stairs",
        () -> new StairBlock(TITANIUM_PLATING.get().defaultBlockState(), HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_PLATING_SLAB = create(
        "titanium_plating_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_PRESSURE_PLATE = create(
        "titanium_pressure_plate",
        () -> new PressurePlateBlock(BlockSetType.COPPER, HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_SIDING = create("titanium_siding", HumanBlockProperties.TITANIUM);

    public static final BLibHolder<Block> TITANIUM_SIDING_STAIRS = create(
        "titanium_siding_stairs",
        () -> new StairBlock(TITANIUM_SIDING.get().defaultBlockState(), HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_SIDING_SLAB = create(
        "titanium_siding_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_STANDING = create("titanium_standing", HumanBlockProperties.TITANIUM);

    public static final BLibHolder<Block> TITANIUM_STANDING_STAIRS = create(
        "titanium_standing_stairs",
        () -> new StairBlock(TITANIUM_STANDING.get().defaultBlockState(), HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_STANDING_SLAB = create(
        "titanium_standing_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_TRAP_DOOR = create(
        "titanium_trapdoor",
        () -> new TrapDoorBlock(BlockSetType.COPPER, HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_TREAD = create("titanium_tread", HumanBlockProperties.TITANIUM);

    public static final BLibHolder<Block> TITANIUM_TREAD_STAIRS = create(
        "titanium_tread_stairs",
        () -> new StairBlock(TITANIUM_TREAD.get().defaultBlockState(), HumanBlockProperties.TITANIUM.build())
    );

    public static final BLibHolder<Block> TITANIUM_TREAD_SLAB = create(
        "titanium_tread_slab",
        () -> new SlabBlock(HumanBlockProperties.TITANIUM.build())
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
