package com.human.common.gameplay.entity.living.human.marine.ai.follow_leader;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.follow_leader.action.MoveCloserToLeaderAction;
import com.just.goap.Action;
import com.just.goap.condition.expression.Expressions;

public class FollowLeaderActions {

    public static final Action<Marine> MOVE_CLOSER_TO_LEADER_ACTION = Action.<Marine>builder("MoveCloserToLeaderAction")
        .addPrecondition(FollowLeaderSensors.CAN_FOLLOW_LEADER.key(), Expressions.Boolean.isTrue())
        .addPrecondition(FollowLeaderSensors.IS_CLOSE_TO_LEADER.key(), Expressions.Boolean.isFalse())
        .addEffect(FollowLeaderSensors.IS_CLOSE_TO_LEADER.key().asDerived(), true)
        .withStartCallback(MoveCloserToLeaderAction::onStart)
        .withPerformCallback(MoveCloserToLeaderAction::perform)
        .withFinishCallback(MoveCloserToLeaderAction::onFinish)
        .build();

    private FollowLeaderActions() {
        throw new UnsupportedOperationException();
    }
}
