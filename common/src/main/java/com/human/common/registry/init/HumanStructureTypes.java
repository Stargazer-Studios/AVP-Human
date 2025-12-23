package com.human.common.registry.init;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.gameplay.worldgen.structure.HumanMobileLabStructure;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;

public class HumanStructureTypes {

    private static final BLibRegistry<StructureType<?>> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.STRUCTURE_TYPE);

    public static final BLibHolder<StructureType<HumanMarineCampStructure>> MARINE_CAMP = create(
        HumanMarineCampStructure.NAME,
        HumanMarineCampStructure.CODEC
    );

    public static final BLibHolder<StructureType<HumanMobileLabStructure>> MOBILE_LAB = create(
        HumanMobileLabStructure.NAME,
        HumanMobileLabStructure.CODEC
    );

    private static <T extends Structure> BLibHolder<StructureType<T>> create(String path, MapCodec<T> codec) {
        return REGISTRY.createHolder(path, () -> () -> codec);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
