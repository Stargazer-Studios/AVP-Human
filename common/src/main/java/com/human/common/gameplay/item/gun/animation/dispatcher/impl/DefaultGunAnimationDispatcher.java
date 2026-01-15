package com.human.common.gameplay.item.gun.animation.dispatcher.impl;

import com.human.common.gameplay.item.gun.animation.dispatcher.GunAnimationDispatcher;
import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class DefaultGunAnimationDispatcher implements GunAnimationDispatcher {

    public static final DefaultGunAnimationDispatcher INSTANCE = new DefaultGunAnimationDispatcher();

    public static final String CONTROLLER_MAIN = "main";

    private static final String ANIMATION_IDLE = "animation.idle";

    private static final String ANIMATION_RELOAD = "animation.reload";

    private static final String ANIMATION_SHOOT = "animation.shoot";

    private static final AzCommand IDLE = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_IDLE,
        AzPlayBehaviors.PLAY_ONCE
    );

    private static final AzCommand RELOAD = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_RELOAD,
        AzPlayBehaviors.PLAY_ONCE
    );

    private static final AzCommand SHOOT = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_SHOOT,
        AzPlayBehaviors.PLAY_ONCE
    );

    @Override
    public void idle(Entity entity, ItemStack itemStack) {
        IDLE.sendForItem(entity, itemStack);
    }

    @Override
    public void reload(Entity entity, ItemStack itemStack) {
        RELOAD.sendForItem(entity, itemStack);
    }

    @Override
    public void shoot(Entity entity, ItemStack itemStack) {
        SHOOT.sendForItem(entity, itemStack);
    }

    private DefaultGunAnimationDispatcher() {}
}
