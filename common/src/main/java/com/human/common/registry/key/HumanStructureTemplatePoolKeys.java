package com.human.common.registry.key;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanCommunicationsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.gameplay.worldgen.structure.HumanMobileLabStructure;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

public class HumanStructureTemplatePoolKeys {

    public static final ResourceKey<StructureTemplatePool> COMMUNICATIONS_OUTPOST_BOTTOM = create(
        HumanCommunicationsOutpostStructure.NAME
    );

    public static final ResourceKey<StructureTemplatePool> COMMUNICATIONS_OUTPOST_TOP = create(
        HumanCommunicationsOutpostStructure.NAME_TOP
    );

    public static final ResourceKey<StructureTemplatePool> MARINE_CAMP_GRASS = create(HumanMarineCampStructure.NAME);

    public static final ResourceKey<StructureTemplatePool> MOBILE_LAB = create(HumanMobileLabStructure.NAME);

    private static ResourceKey<StructureTemplatePool> create(String path) {
        return Human.MOD.resources().createKey(Registries.TEMPLATE_POOL, path);
    }
}
