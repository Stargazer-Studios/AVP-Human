package com.human.common.gameplay.entity.living.human.marine.ai.idle;

import com.human.common.gameplay.entity.ai.goap.WanderToLandPosAction;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.just.goap.Action;
import com.just.goap.condition.expression.Expressions;

public class IdleActions {

    public static final Action<Marine> WANDER_ACTION = Action.<Marine>builder("WanderAction")
        .addPrecondition(IdleSensors.IS_BORED.key(), Expressions.Boolean.isTrue())
        .addEffect(IdleSensors.IS_BORED.key().asDerived(), false)
        .withPerformCallback((marine, $2, blackboard) -> {
            var signal = WanderToLandPosAction.perform(marine, blackboard, 0.8D);

            return switch (signal) {
                case FINISHED -> {
                    marine.resetTicksUntilBored();
                    yield Action.Signal.CONTINUE;
                }
                case MOVING -> Action.Signal.CONTINUE;
                case NO_PATH, POSITION_NOT_FOUND -> Action.Signal.ABORT;
            };
        })
        .build();

    private IdleActions() {
        throw new UnsupportedOperationException();
    }
}
