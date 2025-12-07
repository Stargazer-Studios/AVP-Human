package com.human.common.registry.init;

import com.avp.common.config.AVPConfig;
import com.avp.common.model.spawning.AVPEntitySpawnData;
import com.avp.service.Services;
import com.human.common.config.HumanConfig;
import com.human.common.gameplay.entity.living.human.marine.MarineSpawning;

public class HumanEntitySpawns {

    public static void initialize() {
        Services.REGISTRY.registerEntitySpawnData(
            AVPEntitySpawnData.builder(HumanEntityTypes.MARINE)
                .withSpawnPredicate(MarineSpawning.PREDICATE)
                .withSpawnSettings(convert(HumanConfig.INSTANCE.spawnConfigs.MARINE_SPAWN))
                // Prevents marine biome spawn configurations from being generated.
                .disableConfig()
                .build()
        );
    }

    private static AVPConfig.SpawnConfigs.SpawnSettings convert(HumanConfig.SpawnConfigs.SpawnSettings spawnSettings) {
        return new AVPConfig.SpawnConfigs.SpawnSettings(
            spawnSettings.enabled,
            spawnSettings.minGroupSize,
            spawnSettings.maxGroupSize,
            spawnSettings.weight
        );
    }
}
