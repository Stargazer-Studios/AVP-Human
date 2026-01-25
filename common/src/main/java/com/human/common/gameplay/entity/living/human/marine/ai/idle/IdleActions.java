package com.human.common.gameplay.entity.living.human.marine.ai.idle;

import com.blib.api.common.goap.v1.action.ActionMasks;
import com.blib.api.common.goap.v1.action.BLibAction;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.follow_leader.FollowLeaderSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.idle.action.WanderAction;
import com.just.goap.action.Action;
import com.just.goap.condition.expression.Expressions;

public class IdleActions {

    public static final Action<Marine> WANDER_ACTION = BLibAction.<Marine>builder("WanderAction")
        .addMasks(ActionMasks.MOVE)
        .addPrecondition(FollowLeaderSensors.HAS_PLAYER_LEADER.key(), Expressions.Boolean.isFalse())
        .addPrecondition(CombatSensors.HAS_ATTACK_TARGET.key(), Expressions.Boolean.isFalse())
        .addPrecondition(IdleSensors.IS_BORED.key(), Expressions.Boolean.isTrue())
        .addEffect(IdleSensors.IS_BORED.key().asDerived(), false)
        .withPerformCallback(WanderAction::perform)
        .withFinishCallback(WanderAction::onFinish)
        .build();

    private IdleActions() {
        throw new UnsupportedOperationException();
    }
}
