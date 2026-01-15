package com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.just.goap.condition.expression.Expressions;
import com.just.goap.goal.Goal;

public class FRIGoals {

    public static final Goal ACQUIRE_FIRE_RESISTANCE_GOAL = Goal.builder("AcquireFireResistanceGoal")
        .addPrecondition(GOAPSensors.IS_ON_FIRE.key(), Expressions.Boolean.isTrue())
        .addDesiredCondition(GOAPSensors.HAS_FIRE_RESISTANCE.key().asDerived(), Expressions.Boolean.isTrue())
        .build();
}
