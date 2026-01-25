package com.human.common.data.worldgen;

import com.blib.api.common.worldgen.v1.key.BLibStructureProcessorListKeys;
import com.blib.internal.mixin.StructurePoolAccessor;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.pools.SinglePoolElement;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorList;

import java.util.ArrayList;

public class HumanVillageInjection {

    public static void addBuildingToPool(
        Registry<StructureTemplatePool> templatePoolRegistry,
        Registry<StructureProcessorList> processorListRegistry,
        ResourceLocation targetResourceLocation,
        ResourceLocation resourceLocation,
        int weight
    ) {
        var holderOptional = processorListRegistry.getHolder(BLibStructureProcessorListKeys.EMPTY_PROCESSOR_LIST_KEY);

        if (holderOptional.isEmpty()) {
            return;
        }

        var emptyProcessorList = holderOptional.get();
        var structureTemplatePool = templatePoolRegistry.get(targetResourceLocation);

        if (structureTemplatePool == null) {
            return;
        }

        var legacySinglePoolElement = SinglePoolElement.legacy(resourceLocation.toString(), emptyProcessorList)
            .apply(StructureTemplatePool.Projection.RIGID);
        var structurePoolAccessor = (StructurePoolAccessor) structureTemplatePool;

        for (var i = 0; i < weight; i++) {
            structurePoolAccessor.getElements().add(legacySinglePoolElement);
        }

        var listOfPieceEntries = new ArrayList<>(structurePoolAccessor.getElementCounts());

        listOfPieceEntries.add(new Pair<>(legacySinglePoolElement, weight));

        structurePoolAccessor.setElementCounts(listOfPieceEntries);
    }
}
