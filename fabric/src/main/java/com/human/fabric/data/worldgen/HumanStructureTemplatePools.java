package com.human.fabric.data.worldgen;

import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import com.human.common.registry.key.HumanStructureTemplatePoolKeys;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.Pools;
import net.minecraft.world.level.levelgen.structure.pools.StructurePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;

import java.util.List;

public class HumanStructureTemplatePools {

    public static void bootstrap(BootstrapContext<StructureTemplatePool> registry) {
        var templatePoolLookup = registry.lookup(Registries.TEMPLATE_POOL);

        registry.register(
            HumanStructureTemplatePoolKeys.MARINE_CAMP_GRASS,
            new StructureTemplatePool(
                templatePoolLookup.getOrThrow(Pools.EMPTY),
                List.of(
                    Pair.of(
                        StructurePoolElement.single(Human.MOD.resources().createLocation(HumanMarineCampStructure.NAME).toString())
                            .apply(StructureTemplatePool.Projection.RIGID),
                        1
                    )
                )
            )
        );
    }
}
