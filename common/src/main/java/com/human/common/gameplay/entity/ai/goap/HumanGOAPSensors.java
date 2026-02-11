package com.blib.api.common.goap.v1.action.impl;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.registry.tag.HumanBiomeTags;
import com.just.goap.StateKey;
import com.just.goap.sensor.Sensor;
import com.just.goap.sensor.Sensors;

public class HumanGOAPSensors {

    public static final Sensor.Mono<Marine, Boolean> IS_NEAR_RADIOACTIVE_BIOME = Sensors.map(
        StateKey.sensed("is_near_radioactive_biome"),
        marine -> marine.getBiomeSenseCache().isNearby(HumanBiomeTags.IS_IRRADIATED)
    );
}
