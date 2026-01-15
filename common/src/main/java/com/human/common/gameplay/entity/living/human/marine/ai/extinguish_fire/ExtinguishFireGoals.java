package com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.just.goap.condition.expression.Expressions;
import com.just.goap.goal.Goal;

public class ExtinguishFireGoals {

    public static final Goal EXTINGUISH_SELF_GOAL = Goal.builder("ExtinguishSelfGoal")
        .addPrecondition(GOAPSensors.HAS_FIRE_RESISTANCE.key(), Expressions.Boolean.isFalse())
        .addDesiredCondition(GOAPSensors.IS_ON_FIRE.key().asDerived(), Expressions.Boolean.isFalse())
        .build();

    private ExtinguishFireGoals() {
        throw new UnsupportedOperationException();
    }
}
