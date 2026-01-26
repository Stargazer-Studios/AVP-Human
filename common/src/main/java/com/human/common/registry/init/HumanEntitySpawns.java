package com.human.common.registry.init;

import com.blib.api.common.entity.v1.spawning.BLibEntitySpawnData;
import com.blib.api.common.entity.v1.spawning.SpawnSettings;
import com.blib.api.common.registry.v1.impl.BLibEntitySpawnRegistry;
import com.human.Human;
import com.human.common.gameplay.entity.living.human.marine.MarineSpawning;
import com.human.common.property.HumanProperties;
import com.human.common.property.HumanPropertyAccess;

public class HumanEntitySpawns {

    private static final BLibEntitySpawnRegistry REGISTRY = Human.MOD.registries().createEntitySpawnRegistry();

    public static void initialize() {
        REGISTRY.register(
            BLibEntitySpawnData.builder(HumanEntityTypes.MARINE)
                .withSpawnPredicate(MarineSpawning.PREDICATE)
                .withSpawnSettings(convert(HumanProperties.Entities.Marine.SPAWNING))
                // Prevents marine biome spawn configurations from being generated.
                .disableConfig()
                .build()
        );
    }

    private static SpawnSettings convert(HumanProperties.SpawnProperties spawnProperties) {
        return new SpawnSettings(
            HumanPropertyAccess.INSTANCE.getOrThrow(spawnProperties.enabled()),
            HumanPropertyAccess.INSTANCE.getOrThrow(spawnProperties.minimumGroupSize()),
            HumanPropertyAccess.INSTANCE.getOrThrow(spawnProperties.maximumGroupSize()),
            HumanPropertyAccess.INSTANCE.getOrThrow(spawnProperties.weight())
        );
    }
}
