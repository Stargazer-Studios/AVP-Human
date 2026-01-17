package com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.blib.common.gameplay.goap.action.ActionMasks;
import com.blib.common.gameplay.goap.action.BLibAction;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.MarineGOAPSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.action.EquipWaterBucketAction;
import com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.action.PlaceWaterAtFeetAction;
import com.just.goap.action.Action;
import com.just.goap.condition.expression.Expressions;

public class ExtinguishFireActions {

    public static final Action<Marine> EQUIP_WATER_BUCKET_ACTION = BLibAction.<Marine>builder("EquipWaterBucketAction")
        .addMasks(ActionMasks.USE_MAIN_HAND)
        .addPrecondition(ExtinguishFireSensors.WATER_BUCKET_IN_INVENTORY.key(), Expressions.Option.isSome())
        .addEffect(ExtinguishFireSensors.HAS_WATER_BUCKET_EQUIPPED.key().asDerived(), true)
        .withPerformCallback(EquipWaterBucketAction::perform)
        .build();

    public static final Action<Marine> PLACE_WATER_AT_FEET_ACTION = BLibAction.<Marine>builder("PlaceWaterAtFeetAction")
        .addMasks(ActionMasks.USE_MAIN_HAND)
        .addPrecondition(GOAPSensors.IS_ON_GROUND.key(), Expressions.Boolean.isTrue())
        .addPrecondition(MarineGOAPSensors.IS_IN_ULTRA_WARM_DIMENSION.key(), Expressions.Boolean.isFalse())
        .addPrecondition(ExtinguishFireSensors.HAS_WATER_BUCKET_EQUIPPED.key(), Expressions.Boolean.isTrue())
        .addPrecondition(MarineGOAPSensors.IS_CURRENT_BLOCK_POS_REPLACEABLE.key(), Expressions.Boolean.isTrue())
        .addEffect(GOAPSensors.IS_ON_FIRE.key().asDerived(), false)
        .withPerformCallback(PlaceWaterAtFeetAction::perform)
        .withFinishCallback(PlaceWaterAtFeetAction::onFinish)
        .build();

    private ExtinguishFireActions() {
        throw new UnsupportedOperationException();
    }
}
