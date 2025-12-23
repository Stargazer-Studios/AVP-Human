package com.human.common.registry.key;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.StructureSet;

public class HumanStructureSetKeys {

    public static final ResourceKey<StructureSet> MARINE_CAMP_GRASS = create(HumanMarineCampStructure.NAME);

    private static ResourceKey<StructureSet> create(String path) {
        return Human.MOD.resources().createKey(Registries.STRUCTURE_SET, path);
    }
}
