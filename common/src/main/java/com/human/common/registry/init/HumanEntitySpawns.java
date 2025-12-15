package com.human.common.registry.init;

import com.blib.common.gameplay.model.spawning.BLibEntitySpawnData;
import com.blib.common.gameplay.model.spawning.SpawnSettings;
import com.blib.common.registry.impl.BLibEntitySpawnRegistry;
import com.human.Human;
import com.human.common.config.HumanConfig;
import com.human.common.gameplay.entity.living.human.marine.MarineSpawning;

public class HumanEntitySpawns {

    private static final BLibEntitySpawnRegistry REGISTRY = Human.MOD.registries().createEntitySpawnRegistry();

    public static void initialize() {
        REGISTRY.register(
            BLibEntitySpawnData.builder(HumanEntityTypes.MARINE)
                .withSpawnPredicate(MarineSpawning.PREDICATE)
                .withSpawnSettings(convert(HumanConfig.INSTANCE.spawnConfigs.MARINE_SPAWN))
                // Prevents marine biome spawn configurations from being generated.
                .disableConfig()
                .build()
        );
    }

    private static SpawnSettings convert(HumanConfig.SpawnConfigs.SpawnSettings spawnSettings) {
        return new SpawnSettings(
            spawnSettings.enabled,
            spawnSettings.minGroupSize,
            spawnSettings.maxGroupSize,
            spawnSettings.weight
        );
    }
}
