package com.human.common.gameplay.entity.living.human.marine.ai.heal_self;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.blib.common.gameplay.goap.action.ActionMasks;
import com.blib.common.gameplay.goap.action.BLibAction;
import com.blib.common.gameplay.model.inventory.BLibInventoryHolder;
import com.human.common.gameplay.entity.living.human.ai.model.ItemTarget;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.action.EquipHealingItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.action.MoveToHealingItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.action.PickUpHealingItemAction;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.action.UseHealingItemAction;
import com.just.goap.action.Action;
import com.just.goap.condition.expression.Expressions;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.PathfinderMob;

public class HealingActions {

    public static final Action<PathfinderMob> MOVE_TO_BEST_HEALING_ITEM = BLibAction.<PathfinderMob>builder("MoveToBestHealingItemAction")
        .addMasks(ActionMasks.MOVE)
        .addPrecondition(HealingSensors.BEST_HEALING_ITEM_LOCATION.key(), Expressions.Compare.equalTo(ItemTarget.Location.WORLD))
        .addPrecondition(HealingSensors.IS_BEST_WORLD_HEALING_ITEM_IN_RANGE.key(), Expressions.Boolean.isFalse())
        .addEffect(HealingSensors.IS_BEST_WORLD_HEALING_ITEM_IN_RANGE.key().asDerived(), true)
        .withPerformCallback(MoveToHealingItemAction::perform)
        .withFinishCallback(MoveToHealingItemAction::onFinish)
        .build();

    public static <T extends LivingEntity & BLibInventoryHolder> Action<T> pickUpBestHealingItemFactory() {
        return BLibAction.<T>builder("PickUpBestHealingItemAction")
            .addPrecondition(HealingSensors.BEST_HEALING_ITEM_LOCATION.key(), Expressions.Compare.equalTo(ItemTarget.Location.WORLD))
            .addPrecondition(HealingSensors.IS_BEST_WORLD_HEALING_ITEM_IN_RANGE.key(), Expressions.Boolean.isTrue())
            .addEffect(HealingSensors.BEST_HEALING_ITEM_LOCATION.key().asDerived(), ItemTarget.Location.INVENTORY)
            .withPerformCallback(PickUpHealingItemAction::perform)
            .build();
    }

    public static <T extends LivingEntity & BLibInventoryHolder> Action<T> equipBestHealingItemFactory() {
        return BLibAction.<T>builder("EquipBestHealingItemAction")
            .addMasks(ActionMasks.USE_MAIN_HAND)
            .addPrecondition(HealingSensors.BEST_HEALING_ITEM_LOCATION.key(), Expressions.Compare.equalTo(ItemTarget.Location.INVENTORY))
            .addEffect(HealingSensors.BEST_HEALING_ITEM_LOCATION.key().asDerived(), ItemTarget.Location.EQUIPPED)
            .withPerformCallback(EquipHealingItemAction::perform)
            .build();
    }

    public static final Action<LivingEntity> USE_BEST_HEALING_ITEM = BLibAction.<LivingEntity>builder("UseBestHealingItemAction")
        .addMasks(ActionMasks.USE_MAIN_HAND)
        .addPrecondition(HealingSensors.BEST_HEALING_ITEM_LOCATION.key(), Expressions.Compare.equalTo(ItemTarget.Location.EQUIPPED))
        .addEffect(GOAPSensors.HEALTH_RATIO.key().asDerived(), 1.0F)
        .withPerformCallback(UseHealingItemAction::perform)
        .build();
}
