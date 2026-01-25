package com.human.common.gameplay.entity.living.human.marine.ai.equip_totem;

import com.blib.api.common.goap.v1.action.ActionMasks;
import com.blib.api.common.goap.v1.action.BLibAction;
import com.blib.api.common.inventory.v1.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_totem.action.EquipTotemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_totem.action.MoveToTotemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_totem.action.PickUpTotemAction;
import com.just.goap.action.Action;
import com.just.goap.condition.expression.Expressions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;

public class TotemActions {

    public static final Action<PathfinderMob> MOVE_TO_TOTEM = BLibAction.<PathfinderMob>builder("MoveToTotemAction")
        .addMasks(ActionMasks.MOVE)
        .addPrecondition(TotemSensors.HAS_TOTEM_IN_WORLD.key(), Expressions.Boolean.isTrue())
        .addPrecondition(TotemSensors.IS_NEAREST_TOTEM_IN_RANGE.key(), Expressions.Boolean.isFalse())
        .addEffect(TotemSensors.IS_NEAREST_TOTEM_IN_RANGE.key().asDerived(), true)
        .withPerformCallback(MoveToTotemAction::perform)
        .withFinishCallback(MoveToTotemAction::onFinish)
        .build();

    public static <T extends LivingEntity & BLibInventoryHolder> Action<T> pickUpTotemFactory() {
        return BLibAction.<T>builder("PickUpTotemAction")
            .addPrecondition(TotemSensors.HAS_TOTEM_IN_WORLD.key(), Expressions.Boolean.isTrue())
            .addPrecondition(TotemSensors.IS_NEAREST_TOTEM_IN_RANGE.key(), Expressions.Boolean.isTrue())
            .addEffect(TotemSensors.HAS_TOTEM_IN_INVENTORY.key().asDerived(), true)
            .withPerformCallback(PickUpTotemAction::perform)
            .build();
    }

    public static <T extends LivingEntity & BLibInventoryHolder> Action<T> equipTotemFactory() {
        return BLibAction.<T>builder("EquipTotemAction")
            .addMasks(ActionMasks.USE_OFF_HAND)
            .addPrecondition(TotemSensors.HAS_TOTEM_IN_INVENTORY.key(), Expressions.Boolean.isTrue())
            .addPrecondition(TotemSensors.HAS_TOTEM_EQUIPPED.key(), Expressions.Boolean.isFalse())
            .addEffect(TotemSensors.HAS_TOTEM_EQUIPPED.key().asDerived(), true)
            .withPerformCallback(EquipTotemAction::perform)
            .build();
    }

    private TotemActions() {
        throw new UnsupportedOperationException();
    }
}
