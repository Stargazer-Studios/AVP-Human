package com.human.common.registry.init.block;

import com.blib.common.gameplay.block.property.BlockPropertyBuilder;
import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.block.property.HumanBlockProperties;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class HumanIndustrialConcreteBlocks {

    public static final BLibRegistry<Block> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.BLOCK);

    public static final Map<DyeColor, BLibHolder<Block>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_concrete",
                            () -> new Block(HumanBlockProperties.DYE_COLOR_TO_INDUSTRIAL_CONCRETE_PROPERTIES.get(dyeColor).build())
                        ),
                        (a, b) -> b,
                        LinkedHashMap::new
                    )
                )
        );

    public static final Map<DyeColor, BLibHolder<Block>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE_STAIRS =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_concrete_stairs",
                            () -> new StairBlock(
                                DYE_COLOR_TO_INDUSTRIAL_CONCRETE.get(dyeColor).get().defaultBlockState(),
                                HumanBlockProperties.DYE_COLOR_TO_INDUSTRIAL_CONCRETE_PROPERTIES.get(dyeColor).build()
                            )
                        ),
                        (a, b) -> b,
                        LinkedHashMap::new
                    )
                )
        );

    public static final Map<DyeColor, BLibHolder<Block>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE_SLAB =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_concrete_slab",
                            () -> new SlabBlock(HumanBlockProperties.DYE_COLOR_TO_INDUSTRIAL_CONCRETE_PROPERTIES.get(dyeColor).build())
                        ),
                        (a, b) -> b,
                        LinkedHashMap::new
                    )
                )
        );

    public static final Map<DyeColor, BLibHolder<Block>> DYE_COLOR_TO_INDUSTRIAL_CONCRETE_WALL =
        Collections.unmodifiableMap(
            Arrays.stream(DyeColor.values())
                .collect(
                    Collectors.toMap(
                        Function.identity(),
                        dyeColor -> create(
                            dyeColor.getName() + "_industrial_concrete_wall",
                            () -> new WallBlock(HumanBlockProperties.DYE_COLOR_TO_INDUSTRIAL_CONCRETE_PROPERTIES.get(dyeColor).build())
                        ),
                        (a, b) -> b,
                        LinkedHashMap::new
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
