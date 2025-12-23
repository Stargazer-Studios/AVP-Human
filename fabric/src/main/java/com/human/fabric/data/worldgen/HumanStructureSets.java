package com.human.fabric.data.worldgen;

import com.human.common.registry.key.HumanStructureKeys;
import com.human.common.registry.key.HumanStructureSetKeys;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadType;

public class HumanStructureSets {

    public static void bootstrap(BootstrapContext<StructureSet> registry) {
        var structureLookup = registry.lookup(Registries.STRUCTURE);

        registry.register(
            HumanStructureSetKeys.MARINE_CAMP_GRASS,
            new StructureSet(
                structureLookup.getOrThrow(HumanStructureKeys.MARINE_CAMP_GRASS),
                new RandomSpreadStructurePlacement(40, 15, RandomSpreadType.TRIANGULAR, 1234767890)
            )
        );
    }
}
