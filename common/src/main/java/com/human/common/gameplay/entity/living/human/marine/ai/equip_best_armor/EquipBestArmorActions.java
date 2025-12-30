package com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor;

import com.human.common.gameplay.entity.living.human.ai.HumanGOAPExpressions;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.action.EquipBestArmorPiecesFromInventoryAction;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ArmorSetTarget;
import com.just.goap.Action;
import com.just.goap.condition.expression.Expressions;

public class EquipBestArmorActions {

    public static final Action<Marine> PICK_UP_BEST_ARMOR_PIECES_ACTION = Action.<Marine>builder("PickUpBestArmorPiecesAction")
        .addPrecondition(EquipBestArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_WORLD.key(), Expressions.Boolean.isTrue())
        .addEffect(EquipBestArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_WORLD.key().asDerived(), false)
        .addEffect(EquipBestArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_INVENTORY.key().asDerived(), true)
        .withPerformCallback((a, b, c) -> {
            var bestArmorTargetOption = b.getOrDefault(EquipBestArmorSensors.BEST_ARMOR_SET_TARGET.key(), ArmorSetTarget.EMPTY);

            if (bestArmorTargetOption.isEmpty()) {
                return Action.Signal.ABORT;
            }

            // TODO: Take off current armor pieces and put them back into the inventory.
            // TODO: Equip the parts of the "BETTER_ARMOR" state that are present.
            return Action.Signal.CONTINUE;
        })
        .build();

    public static final Action<Marine> EQUIP_BEST_ARMOR_PIECES_FROM_INVENTORY_ACTION = Action.<Marine>builder(
        "EquipBestArmorPiecesFromInventoryAction"
    )
        .addPrecondition(EquipBestArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_INVENTORY.key(), Expressions.Boolean.isTrue())
        .addPrecondition(EquipBestArmorSensors.BEST_ARMOR_SET_TARGET.key(), HumanGOAPExpressions.ArmorSetTarget.isNotEmpty())
        .addEffect(EquipBestArmorSensors.ARE_ALL_BEST_ARMOR_SET_PIECES_EQUIPPED.key().asDerived(), true)
        .withPerformCallback(EquipBestArmorPiecesFromInventoryAction::perform)
        .build();

    private EquipBestArmorActions() {
        throw new UnsupportedOperationException();
    }
}
