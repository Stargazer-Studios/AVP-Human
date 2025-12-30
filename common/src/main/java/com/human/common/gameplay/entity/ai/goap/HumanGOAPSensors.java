package com.human.common.gameplay.entity.ai.goap;

import com.human.common.gameplay.entity.living.human.marine.ai.sensor.NearbyBiomesSensor;
import com.human.common.registry.tag.HumanBiomeTags;
import com.just.goap.StateKey;
import com.just.goap.sensor.Sensor;
import com.just.goap.sensor.Sensors;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;

import java.util.Set;

public class HumanGOAPSensors {

    public static final Sensor.Mono<Entity, Set<Holder<Biome>>> NEARBY_BIOMES = Sensors.map(
        StateKey.sensed("nearby_biomes"),
        NearbyBiomesSensor::sense
    );

    public static final Sensor.Mono<Entity, Boolean> IS_NEAR_RADIOACTIVE_BIOME = Sensors.compose(
        NEARBY_BIOMES.key(),
        StateKey.sensed("is_near_radioactive_biome"),
        (entity, nearbyBiomes) -> nearbyBiomes.stream()
            .anyMatch(biome -> biome.is(HumanBiomeTags.IS_IRRADIATED))
    );
}
