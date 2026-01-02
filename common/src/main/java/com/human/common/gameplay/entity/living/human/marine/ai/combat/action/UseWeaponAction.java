package com.human.common.gameplay.entity.living.human.marine.ai.combat.action;

import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.just.core.functional.option.Option;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;

public class UseWeaponAction {

    public static Action.Signal perform(LivingEntity livingEntity, ReadableWorldState worldState, Blackboard blackboard) {
        var itemTargetOption = worldState.getOrDefault(CombatSensors.BEST_WEAPON.key(), Option.none());

        if (itemTargetOption.isNone()) {
            return Action.Signal.ABORT;
        }

        return itemTargetOption.unwrap().strategy().execute(livingEntity, worldState, blackboard);
    }

    private UseWeaponAction() {
        throw new UnsupportedOperationException();
    }
}
