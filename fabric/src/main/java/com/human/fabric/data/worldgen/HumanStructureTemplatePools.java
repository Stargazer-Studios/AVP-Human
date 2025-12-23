package com.human.fabric.data.worldgen;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanCommunicationsOutpostStructure;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.gameplay.worldgen.structure.HumanMobileLabStructure;
import com.human.common.registry.key.HumanStructureTemplatePoolKeys;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class HumanStructureTemplatePools {

    public static final String BASE_PATH = "outpost/comm/";

    public static void bootstrap(BootstrapContext<StructureTemplatePool> registry) {
        var templatePoolLookup = registry.lookup(Registries.TEMPLATE_POOL);

        registry.register(
            HumanStructureTemplatePoolKeys.COMMUNICATIONS_OUTPOST_BOTTOM,
            createCommunicationsOutpostBottomTemplatePool(templatePoolLookup)
        );
        registry.register(
            HumanStructureTemplatePoolKeys.COMMUNICATIONS_OUTPOST_TOP,
            createCommunicationsOutpostTopTemplatePool(templatePoolLookup)
        );
        registry.register(HumanStructureTemplatePoolKeys.MARINE_CAMP_GRASS, createMarineCampGrassStructureTemplatePool(templatePoolLookup));
        registry.register(HumanStructureTemplatePoolKeys.MOBILE_LAB, createMobileLabStructureTemplatePool(templatePoolLookup));
    }

    private static @NotNull StructureTemplatePool createCommunicationsOutpostBottomTemplatePool(
        HolderGetter<StructureTemplatePool> templatePoolLookup
    ) {
        return new StructureTemplatePool(
            templatePoolLookup.getOrThrow(Pools.EMPTY),
            List.of(
                Pair.of(
                    StructurePoolElement.single(
                        Human.MOD.resources().createLocation(BASE_PATH + HumanCommunicationsOutpostStructure.NAME).toString()
                    )
                        .apply(StructureTemplatePool.Projection.RIGID),
                    1
                )
            )
        );
    }

    private static @NotNull StructureTemplatePool createCommunicationsOutpostTopTemplatePool(
        HolderGetter<StructureTemplatePool> templatePoolLookup
    ) {
        return new StructureTemplatePool(
            templatePoolLookup.getOrThrow(Pools.EMPTY),
            List.of(
                Pair.of(
                    StructurePoolElement.single(
                        Human.MOD.resources().createLocation(BASE_PATH + HumanCommunicationsOutpostStructure.NAME_TOP).toString()
                    )
                        .apply(StructureTemplatePool.Projection.RIGID),
                    1
                )
            )
        );
    }

    private static @NotNull StructureTemplatePool createMarineCampGrassStructureTemplatePool(
        HolderGetter<StructureTemplatePool> templatePoolLookup
    ) {
        return new StructureTemplatePool(
            templatePoolLookup.getOrThrow(Pools.EMPTY),
            List.of(
                Pair.of(
                    StructurePoolElement.single(Human.MOD.resources().createLocation(HumanMarineCampStructure.NAME).toString())
                        .apply(StructureTemplatePool.Projection.RIGID),
                    1
                )
            )
        );
    }

    private static @NotNull StructureTemplatePool createMobileLabStructureTemplatePool(
        HolderGetter<StructureTemplatePool> templatePoolLookup
    ) {
        return new StructureTemplatePool(
            templatePoolLookup.getOrThrow(Pools.EMPTY),
            List.of(
                Pair.of(
                    StructurePoolElement.single(Human.MOD.resources().createLocation(HumanMobileLabStructure.NAME).toString())
                        .apply(StructureTemplatePool.Projection.RIGID),
                    1
                )
            )
        );
    }
}
