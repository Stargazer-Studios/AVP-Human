package com.human.common.gameplay.entity.living.human.marine.ai.idle;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.follow_leader.FollowLeaderSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.idle.action.WanderAction;
import com.just.goap.action.Action;
import com.just.goap.condition.expression.Expressions;

public class IdleActions {

    public static final Action<Marine> WANDER_ACTION = Action.<Marine>builder("WanderAction")
        .addPrecondition(FollowLeaderSensors.HAS_LEADER.key(), Expressions.Boolean.isFalse())
        .addPrecondition(IdleSensors.IS_BORED.key(), Expressions.Boolean.isTrue())
        .addEffect(IdleSensors.IS_BORED.key().asDerived(), false)
        .withPerformCallback(WanderAction::perform)
        .withFinishCallback(WanderAction::onFinish)
        .build();

    private IdleActions() {
        throw new UnsupportedOperationException();
    }
}
