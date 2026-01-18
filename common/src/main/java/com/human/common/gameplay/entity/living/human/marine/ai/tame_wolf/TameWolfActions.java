package com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf;

import com.blib.common.gameplay.goap.action.ActionMasks;
import com.blib.common.gameplay.goap.action.BLibAction;
import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action.EquipBoneAction;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action.MoveToBoneAction;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action.MoveToWolfAction;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action.PickUpBoneAction;
import com.human.common.gameplay.entity.living.human.marine.ai.tame_wolf.action.UseBoneOnWolfAction;
import com.just.goap.action.Action;
import com.just.goap.condition.expression.Expressions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;

public class TameWolfActions {

    public static final Action<PathfinderMob> MOVE_TO_BONE = BLibAction.<PathfinderMob>builder("MoveToBoneAction")
        .addMasks(ActionMasks.MOVE)
        .addPrecondition(TameWolfSensors.HAS_BONE_IN_WORLD.key(), Expressions.Boolean.isTrue())
        .addPrecondition(TameWolfSensors.IS_NEAREST_BONE_IN_RANGE.key(), Expressions.Boolean.isFalse())
        .addEffect(TameWolfSensors.IS_NEAREST_BONE_IN_RANGE.key().asDerived(), true)
        .withPerformCallback(MoveToBoneAction::perform)
        .withFinishCallback(MoveToBoneAction::onFinish)
        .build();

    public static <T extends LivingEntity & BLibInventoryHolder> Action<T> pickUpBoneFactory() {
        return BLibAction.<T>builder("PickUpBoneAction")
            .addPrecondition(TameWolfSensors.HAS_BONE_IN_WORLD.key(), Expressions.Boolean.isTrue())
            .addPrecondition(TameWolfSensors.IS_NEAREST_BONE_IN_RANGE.key(), Expressions.Boolean.isTrue())
            .addEffect(TameWolfSensors.HAS_BONE_IN_INVENTORY.key().asDerived(), true)
            .withPerformCallback(PickUpBoneAction::perform)
            .build();
    }

    public static <T extends LivingEntity & BLibInventoryHolder> Action<T> equipBoneFactory() {
        return BLibAction.<T>builder("EquipBoneAction")
            .addMasks(ActionMasks.USE_MAIN_HAND)
            .addPrecondition(TameWolfSensors.HAS_BONE_IN_INVENTORY.key(), Expressions.Boolean.isTrue())
            .addPrecondition(TameWolfSensors.HAS_BONE_EQUIPPED.key(), Expressions.Boolean.isFalse())
            .addEffect(TameWolfSensors.HAS_BONE_EQUIPPED.key().asDerived(), true)
            .withPerformCallback(EquipBoneAction::perform)
            .build();
    }

    public static final Action<PathfinderMob> MOVE_TO_WOLF = BLibAction.<PathfinderMob>builder("MoveToWolfAction")
        .addMasks(ActionMasks.MOVE)
        .addPrecondition(TameWolfSensors.HAS_UNTAMED_WOLF_NEARBY.key(), Expressions.Boolean.isTrue())
        .addPrecondition(TameWolfSensors.HAS_BONE_EQUIPPED.key(), Expressions.Boolean.isTrue())
        .addPrecondition(TameWolfSensors.IS_WOLF_IN_RANGE.key(), Expressions.Boolean.isFalse())
        .addEffect(TameWolfSensors.IS_WOLF_IN_RANGE.key().asDerived(), true)
        .withPerformCallback(MoveToWolfAction::perform)
        .withFinishCallback(MoveToWolfAction::onFinish)
        .build();

    public static final Action<Marine> USE_BONE_ON_WOLF = BLibAction.<Marine>builder("UseBoneOnWolfAction")
        .addMasks(ActionMasks.USE_MAIN_HAND, ActionMasks.LOOK)
        .addPrecondition(TameWolfSensors.HAS_UNTAMED_WOLF_NEARBY.key(), Expressions.Boolean.isTrue())
        .addPrecondition(TameWolfSensors.HAS_BONE_EQUIPPED.key(), Expressions.Boolean.isTrue())
        .addPrecondition(TameWolfSensors.IS_WOLF_IN_RANGE.key(), Expressions.Boolean.isTrue())
        .addEffect(TameWolfSensors.HAS_UNTAMED_WOLF_NEARBY.key().asDerived(), false)
        .withPerformCallback(UseBoneOnWolfAction::perform)
        .withFinishCallback(UseBoneOnWolfAction::onFinish)
        .build();

    private TameWolfActions() {
        throw new UnsupportedOperationException();
    }
}
