package com.human.common.gameplay.item.gun.animation.dispatcher.impl;

import com.human.common.gameplay.item.gun.animation.dispatcher.GunAnimationDispatcher;
import mod.azure.azurelib.common.animation.dispatch.command.AzCommand;
import mod.azure.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class OldPainlessAnimationDispatcher implements GunAnimationDispatcher {

    public static final OldPainlessAnimationDispatcher INSTANCE = new OldPainlessAnimationDispatcher();

    public static final String CONTROLLER_MAIN = "main";

    public static final String ANIMATION_SPIN_DOWN = "animation.barrelspindown";

    public static final String ANIMATION_SPIN_LOOP = "animation.barrelspinloop";

    public static final String ANIMATION_SPIN_UP = "animation.barrelspinup";

    private final AzCommand SPIN_LOOP = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_SPIN_LOOP,
        AzPlayBehaviors.LOOP
    );

    private final AzCommand SPIN_DOWN = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_SPIN_DOWN,
        AzPlayBehaviors.HOLD_ON_LAST_FRAME
    );

    private final AzCommand SPIN_UP = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_SPIN_UP,
        AzPlayBehaviors.PLAY_ONCE
    );

    @Override
    public void idle(Entity entity, ItemStack itemStack) {
        DEFAULT.idle(entity, itemStack);
    }

    @Override
    public void shoot(Entity entity, ItemStack itemStack) {
        DEFAULT.shoot(entity, itemStack);
    }

    public void spinLoop(Entity entity, ItemStack itemStack) {
        SPIN_LOOP.sendForItem(entity, itemStack);
    }

    public void spinDown(Entity entity, ItemStack itemStack) {
        SPIN_DOWN.sendForItem(entity, itemStack);
    }

    public void spinUp(Entity entity, ItemStack itemStack) {
        SPIN_UP.sendForItem(entity, itemStack);
    }

    private OldPainlessAnimationDispatcher() {}
}
