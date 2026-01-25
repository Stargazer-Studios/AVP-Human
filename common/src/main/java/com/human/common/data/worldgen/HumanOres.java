package com.human.common.data.worldgen;

import com.blib.api.common.worldgen.v1.BLibOreData;
import com.human.HumanResources;
import com.human.common.registry.init.block.CoreBlocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HumanOres {

    private static final RuleTest DEEPSLATE_ORE_REPLACEABLES_RULE = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

    private static final RuleTest GRAVEL_REPLACEABLES_RULE = new BlockMatchTest(Blocks.GRAVEL);

    private static final RuleTest STONE_ORE_REPLACEABLES_RULE = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);

    private static final List<BLibOreData> ORE_DATA = new ArrayList<>();

    public static List<BLibOreData> getAll() {
        return Collections.unmodifiableList(ORE_DATA);
    }

    public static final BLibOreData BAUXITE_UPPER = create(
        builder(
            "bauxite_ore_upper",
            OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.BAUXITE_ORE.get().defaultBlockState())
        )
            .count(75)
            .heightRange(HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(512)))
            .veinSize(9)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData BAUXITE_MIDDLE = create(
        builder(
            "bauxite_ore_middle",
            OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.BAUXITE_ORE.get().defaultBlockState())
        )
            .count(20)
            .heightRange(HeightRangePlacement.uniform(VerticalAnchor.absolute(9), VerticalAnchor.absolute(79)))
            .veinSize(9)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData GALENA = create(
        builder("galena_ore", OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.GALENA_ORE.get().defaultBlockState()))
            .count(36)
            .heightRange(HeightRangePlacement.uniform(VerticalAnchor.absolute(9), VerticalAnchor.absolute(96)))
            .veinSize(9)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData LEAD_SWAMP = create(
        builder("lead_ore_swamp", OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.GALENA_ORE.get().defaultBlockState()))
            .count(40)
            .heightRange(HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(64)))
            .veinSize(9)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData LITHIUM = create(
        builder("lithium_ore", OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.LITHIUM_ORE.get().defaultBlockState()))
            .count(8)
            .heightRange(HeightRangePlacement.uniform(VerticalAnchor.absolute(9), VerticalAnchor.absolute(40)))
            .veinSize(9)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData LITHIUM_DESERT = create(
        builder(
            "lithium_ore_desert",
            OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.LITHIUM_ORE.get().defaultBlockState())
        )
            .count(20)
            .heightRange(HeightRangePlacement.uniform(VerticalAnchor.absolute(9), VerticalAnchor.absolute(64)))
            .veinSize(6)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData MONAZITE = create(
        builder("monazite_ore", OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.MONAZITE_ORE.get().defaultBlockState()))
            .count(2)
            .heightRange(HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(16)))
            .veinSize(6)
            .normalizedAirDiscardChance(0.5F)
    );

    public static final BLibOreData MONAZITE_JUNGLE = create(
        builder(
            "monazite_ore_jungle",
            OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.MONAZITE_ORE.get().defaultBlockState())
        )
            .count(15)
            .heightRange(HeightRangePlacement.triangle(VerticalAnchor.absolute(-48), VerticalAnchor.absolute(48)))
            .veinSize(6)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData SILICON_GRAVEL = create(
        builder("silicon_gravel", OreConfiguration.target(GRAVEL_REPLACEABLES_RULE, CoreBlocks.SILICA_GRAVEL.get().defaultBlockState()))
            .count(25)
            .heightRange(HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)))
            .veinSize(13)
            .normalizedAirDiscardChance(0F)
    );

    public static final BLibOreData TITANIUM_LOWER = create(
        builder(
            "titanium_ore_lower",
            OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES_RULE, CoreBlocks.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())
        )
            .count(10)
            .heightRange(HeightRangePlacement.triangle(VerticalAnchor.absolute(-128), VerticalAnchor.absolute(0)))
            .veinSize(9)
            .normalizedAirDiscardChance(0F)
    );

    private static final List<OreConfiguration.TargetBlockState> ZINC_TARGETS = List.of(
        OreConfiguration.target(DEEPSLATE_ORE_REPLACEABLES_RULE, CoreBlocks.DEEPSLATE_ZINC_ORE.get().defaultBlockState()),
        OreConfiguration.target(STONE_ORE_REPLACEABLES_RULE, CoreBlocks.ZINC_ORE.get().defaultBlockState())
    );

    public static final BLibOreData ZINC = create(
        builder("zinc_ore", ZINC_TARGETS)
            .count(16)
            .heightRange(HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))
            .veinSize(10)
            .normalizedAirDiscardChance(0.0F)
    );

    public static final BLibOreData ZINC_DRIPSTONE_CAVES = create(
        builder("zinc_ore_dripstone_caves", ZINC_TARGETS)
            .count(16)
            .heightRange(HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))
            .veinSize(20)
            .normalizedAirDiscardChance(0.0F)
    );

    private static BLibOreData.Builder builder(String name, OreConfiguration.TargetBlockState targetBlockState) {
        return builder(name, List.of(targetBlockState));
    }

    private static BLibOreData.Builder builder(String name, List<OreConfiguration.TargetBlockState> targetBlockStates) {
        return BLibOreData.builder(HumanResources.location(name), targetBlockStates)
            .biomeFilter(BiomeFilter.biome())
            .spread();
    }

    private static BLibOreData create(BLibOreData.Builder builder) {
        var data = builder.build();
        ORE_DATA.add(data);
        return data;
    }
}
