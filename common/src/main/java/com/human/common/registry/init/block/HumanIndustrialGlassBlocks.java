package com.human.common.registry.init.block;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.blib.common.gameplay.block.property.BlockPropertyBuilder;
import com.human.Human;
import com.human.common.gameplay.block.property.HumanBlockProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.IronBarsBlock;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TransparentBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HumanIndustrialGlassBlocks {

    public static final BLibRegistry<Block> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.BLOCK);

    public static final BLibHolder<Block> INDUSTRIAL_GLASS = create(
        "industrial_glass",
        () -> new TransparentBlock(HumanBlockProperties.INDUSTRIAL_GLASS.build())
    );

    public static final BLibHolder<Block> INDUSTRIAL_GLASS_STAIRS = create(
        "industrial_glass_stairs",
        () -> new StairBlock(INDUSTRIAL_GLASS.get().defaultBlockState(), HumanBlockProperties.INDUSTRIAL_GLASS.build())
    );

    public static final BLibHolder<Block> INDUSTRIAL_GLASS_DOOR = create(
        "industrial_glass_door",
        () -> new DoorBlock(BlockSetType.COPPER, HumanBlockProperties.INDUSTRIAL_GLASS.build().noOcclusion())
    );

    public static final BLibHolder<Block> INDUSTRIAL_GLASS_TRAP_DOOR = create(
        "industrial_glass_trapdoor",
        () -> new TrapDoorBlock(BlockSetType.COPPER, HumanBlockProperties.INDUSTRIAL_GLASS.build().noOcclusion())
    );

    public static final BLibHolder<Block> INDUSTRIAL_GLASS_PANE = create(
        "industrial_glass_pane",
        () -> new IronBarsBlock(HumanBlockProperties.INDUSTRIAL_GLASS_PANE.build())
    );

    // Slabs And Stairs
    public static final BLibHolder<Block> INDUSTRIAL_GLASS_SLAB = create(
        "industrial_glass_slab",
        () -> new SlabBlock(HumanBlockProperties.INDUSTRIAL_GLASS.build())
    );

    public static final Map<DyeColor, BLibHolder<Block>> DYE_COLOR_TO_INDUSTRIAL_GLASS =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_glass",
                            () -> new StainedGlassBlock(
                                dyeColor,
                                HumanBlockProperties.DYE_COLOR_TO_INDUSTRIAL_GLASS_PROPERTIES.get(dyeColor).build()
                            )
                        )
                    )
                )
        );

    public static final Map<DyeColor, BLibHolder<Block>> DYE_COLOR_TO_INDUSTRIAL_GLASS_PANE =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_glass_pane",
                            () -> new IronBarsBlock(
                                HumanBlockProperties.DYE_COLOR_TO_INDUSTRIAL_GLASS_PANE_PROPERTIES.get(dyeColor).build()
                            )
                        )
                    )
                )
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
