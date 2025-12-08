package com.human.common.registry.init;

import com.avp.service.Services;
import com.blib.common.gameplay.model.spawning.BLibEntitySpawnData;
import com.blib.common.gameplay.model.spawning.SpawnSettings;
import com.human.common.config.HumanConfig;
import com.human.common.gameplay.entity.living.human.marine.MarineSpawning;

public class HumanEntitySpawns {

    public static void initialize() {
        Services.REGISTRY.registerEntitySpawnData(
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
