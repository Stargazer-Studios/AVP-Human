package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor;

import com.human.common.gameplay.entity.living.human.ai.HumanGOAPExpressions;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.action.EquipBestArmorSetFromInventoryAction;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ArmorSetTarget;
import com.just.goap.Action;
import com.just.goap.condition.expression.Expressions;

public class EquipArmorActions {

    public static final Action<Marine> PICK_UP_BEST_ARMOR_PIECES_ACTION = Action.<Marine>builder("PickUpBestArmorPiecesAction")
        .addPrecondition(EquipArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_WORLD.key(), Expressions.Boolean.isTrue())
        .addEffect(EquipArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_INVENTORY.key().asDerived(), true)
        .withPerformCallback((a, b, c) -> {
            var bestArmorTargetOption = b.getOrDefault(EquipArmorSensors.BEST_ARMOR_SET_TARGET.key(), ArmorSetTarget.EMPTY);

            if (bestArmorTargetOption.isEmpty()) {
                return Action.Signal.ABORT;
            }

            return Action.Signal.CONTINUE;
        })
        .build();

    public static final Action<Marine> EQUIP_BEST_ARMOR_PIECES_FROM_INVENTORY_ACTION = Action.<Marine>builder(
        "EquipBestArmorPiecesFromInventoryAction"
    )
        .addPrecondition(EquipArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_INVENTORY.key(), Expressions.Boolean.isTrue())
        .addPrecondition(EquipArmorSensors.BEST_ARMOR_SET_TARGET.key(), HumanGOAPExpressions.ArmorSetTarget.isNotEmpty())
        .addEffect(EquipArmorSensors.ARE_ALL_BEST_ARMOR_SET_PIECES_EQUIPPED.key().asDerived(), true)
        .withPerformCallback(EquipBestArmorSetFromInventoryAction::perform)
        .build();

    private EquipArmorActions() {
        throw new UnsupportedOperationException();
    }
}
