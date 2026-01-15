package com.human.common.gameplay.entity.living.human.marine.ai.combat;

import com.just.goap.condition.expression.Expressions;
import com.just.goap.goal.Goal;

public class CombatGoals {

    public static final Goal HAS_WEAPON_GOAL = Goal.builder("HasWeaponGoal")
        .addPrecondition(CombatSensors.HAS_WEAPON.key(), Expressions.Boolean.isFalse())
        .addDesiredCondition(CombatSensors.HAS_WEAPON.key().asDerived(), Expressions.Boolean.isTrue())
        .build();

    public static final Goal NO_ATTACK_TARGET_GOAL = Goal.builder("NoAttackTargetGoal")
        .addPrecondition(CombatSensors.HAS_ATTACK_TARGET.key(), Expressions.Boolean.isTrue())
        .addDesiredCondition(CombatSensors.HAS_ATTACK_TARGET.key().asDerived(), Expressions.Boolean.isFalse())
        .build();

    private CombatGoals() {
        throw new UnsupportedOperationException();
    }
}
