package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategy;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface WeaponStrategy extends ItemStrategy {

    double getRangeForWeapon(LivingEntity livingEntity, ItemStack itemStack);

    Action.Signal execute(LivingEntity livingEntity, ReadableWorldState worldState, Blackboard blackboard);
}
