package com.human.common.gameplay.entity.ai.goap;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.human.common.registry.tag.HumanBiomeTags;
import com.just.goap.StateKey;
import com.just.goap.sensor.Sensor;
import com.just.goap.sensor.Sensors;
import net.minecraft.world.entity.Entity;

public class HumanGOAPSensors {

    public static final Sensor.Mono<Entity, Boolean> IS_NEAR_RADIOACTIVE_BIOME = Sensors.compose(
        GOAPSensors.NEARBY_BLOCK_POSITIONS.key(),
        StateKey.sensed("is_near_radioactive_biome"),
        (entity, nearbyBlockPositions) -> nearbyBlockPositions.stream()
            .anyMatch(blockPos -> entity.level().getBiome(blockPos).is(HumanBiomeTags.IS_IRRADIATED))
    );
}
