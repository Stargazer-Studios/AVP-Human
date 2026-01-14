package com.human.common.gameplay.item.gun.animation.dispatcher;

import com.human.common.gameplay.item.gun.animation.dispatcher.impl.DefaultGunAnimationDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public interface GunAnimationDispatcher {

    GunAnimationDispatcher DEFAULT = DefaultGunAnimationDispatcher.INSTANCE;

    void idle(Entity entity, ItemStack itemStack);

    void shoot(Entity entity, ItemStack itemStack);

    default void reload(Entity entity, ItemStack itemStack) { /* NO-OP */ }
}
