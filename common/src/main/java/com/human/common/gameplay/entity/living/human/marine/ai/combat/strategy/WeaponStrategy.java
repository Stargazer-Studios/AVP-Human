package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.just.goap.Action;
import com.just.goap.state.Blackboard;
import com.just.goap.state.ReadableWorldState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public interface WeaponStrategy {

    boolean canUseItemStack(ItemStack itemStack);

    boolean isValid(LivingEntity livingEntity, ReadableWorldState worldState);

    Collection<BLibInventory.Entry> selectEntriesFromInventory(BLibInventory inventory);

    double score(LivingEntity livingEntity, ReadableWorldState worldState, ItemStack itemStack);

    double getRangeForWeapon(LivingEntity livingEntity, ItemStack itemStack);

    Action.Signal execute(LivingEntity livingEntity, ReadableWorldState worldState, Blackboard blackboard);
}
