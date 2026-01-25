package com.human.common.registry.init;

import com.blib.api.common.registry.v1.BLibHolder;
import com.blib.api.common.registry.v1.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanCommunicationsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.gameplay.worldgen.structure.HumanMobileLabStructure;
import com.human.common.gameplay.worldgen.structure.HumanMunitionsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanSupplyOutpostBadlandsStructure;
import com.human.common.gameplay.worldgen.structure.HumanSupplyOutpostDesertStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class HumanStructureTypes {

    private static final BLibRegistry<StructureType<?>> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.STRUCTURE_TYPE);

    public static final BLibHolder<StructureType<HumanCommunicationsOutpostStructure>> COMMUNICATIONS_OUTPOST = create(
        HumanCommunicationsOutpostStructure.NAME,
        HumanCommunicationsOutpostStructure.CODEC
    );

    public static final BLibHolder<StructureType<HumanMarineCampStructure>> MARINE_CAMP = create(
        HumanMarineCampStructure.NAME,
        HumanMarineCampStructure.CODEC
    );

    public static final BLibHolder<StructureType<HumanMobileLabStructure>> MOBILE_LAB = create(
        HumanMobileLabStructure.NAME,
        HumanMobileLabStructure.CODEC
    );

    public static final BLibHolder<StructureType<HumanMunitionsOutpostStructure>> MUNITIONS_OUTPOST = create(
        HumanMunitionsOutpostStructure.NAME,
        HumanMunitionsOutpostStructure.CODEC
    );

    public static final BLibHolder<StructureType<HumanSupplyOutpostBadlandsStructure>> SUPPLY_OUTPOST_BADLANDS = create(
        HumanSupplyOutpostBadlandsStructure.NAME,
        HumanSupplyOutpostBadlandsStructure.CODEC
    );

    public static final BLibHolder<StructureType<HumanSupplyOutpostDesertStructure>> SUPPLY_OUTPOST_DESERT = create(
        HumanSupplyOutpostDesertStructure.NAME,
        HumanSupplyOutpostDesertStructure.CODEC
    );

    private static <T extends Structure> BLibHolder<StructureType<T>> create(String path, MapCodec<T> codec) {
        return REGISTRY.createHolder(path, () -> () -> codec);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
