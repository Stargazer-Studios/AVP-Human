package com.human.common.registry.init;

import com.blib.api.common.entity.v1.spawning.BLibEntitySpawnData;
import com.blib.api.common.entity.v1.spawning.SpawnSettings;
import com.blib.api.common.registry.v1.impl.BLibEntitySpawnRegistry;
import com.human.Human;
import com.human.common.gameplay.entity.living.human.marine.MarineSpawning;

public class HumanEntitySpawns {

    private static final BLibEntitySpawnRegistry REGISTRY = Human.MOD.registries().createEntitySpawnRegistry();

    public static void initialize() {
        REGISTRY.register(
            BLibEntitySpawnData.builder(HumanEntityTypes.MARINE)
                .withSpawnPredicate(MarineSpawning.PREDICATE)
                .withSpawnSettings(new SpawnSettings(true, 1, 1, 1))
                // Prevents marine biome spawn configurations from being generated.
                .disableConfig()
                .build()
        );
    }
}
