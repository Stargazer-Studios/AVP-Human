package com.human.common.registry.key;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanCommunicationsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.gameplay.worldgen.structure.HumanMobileLabStructure;
import com.human.common.gameplay.worldgen.structure.HumanMunitionsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanSupplyOutpostBadlandsStructure;
import com.human.common.gameplay.worldgen.structure.HumanSupplyOutpostDesertStructure;
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

    public static final ResourceKey<StructureTemplatePool> MUNITIONS_OUTPOST = create(HumanMunitionsOutpostStructure.NAME);

    public static final ResourceKey<StructureTemplatePool> SUPPLY_OUTPOST_BADLANDS = create(HumanSupplyOutpostBadlandsStructure.NAME);

    public static final ResourceKey<StructureTemplatePool> SUPPLY_OUTPOST_DESERT = create(HumanSupplyOutpostDesertStructure.NAME);

    private static ResourceKey<StructureTemplatePool> create(String path) {
        return Human.MOD.resources().createKey(Registries.TEMPLATE_POOL, path);
    }
}
