package com.human.common.registry.key;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanCommunicationsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.gameplay.worldgen.structure.HumanMobileLabStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.Structure;

public class HumanStructureKeys {

    public static final ResourceKey<Structure> COMMUNICATIONS_OUTPOST = create(HumanCommunicationsOutpostStructure.NAME);

    public static final ResourceKey<Structure> MARINE_CAMP_GRASS = create(HumanMarineCampStructure.NAME);

    public static final ResourceKey<Structure> MOBILE_LAB = create(HumanMobileLabStructure.NAME);

    private static ResourceKey<Structure> create(String path) {
        return Human.MOD.resources().createKey(Registries.STRUCTURE, path);
    }
}
