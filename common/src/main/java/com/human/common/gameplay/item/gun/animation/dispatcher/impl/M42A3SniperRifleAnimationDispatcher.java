package com.human.common.gameplay.item.gun.animation.dispatcher.impl;

import com.blib.azurelib.common.animation.dispatch.command.AzCommand;
import com.blib.azurelib.common.animation.play_behavior.AzPlayBehaviors;
import com.human.common.gameplay.item.gun.animation.dispatcher.GunAnimationDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;

public class M42A3SniperRifleAnimationDispatcher implements GunAnimationDispatcher {

    public static final M42A3SniperRifleAnimationDispatcher INSTANCE = new M42A3SniperRifleAnimationDispatcher();

    public static final String CONTROLLER_MAIN = "main";

    private static final String ANIMATION_IDLE = "animation.idle";

    private static final String ANIMATION_RECHAMBER = "animation.rechamber";

    private static final String ANIMATION_SHOOT = "animation.shoot";

    private static final AzCommand IDLE = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_IDLE,
        AzPlayBehaviors.LOOP
    );

    private static final AzCommand RECHAMBER = AzCommand.create(
        CONTROLLER_MAIN,
        ANIMATION_RECHAMBER,
        AzPlayBehaviors.PLAY_ONCE
    );

    private static final AzCommand SHOOT = AzCommand.compose(
        AzCommand.create(
            CONTROLLER_MAIN,
            ANIMATION_SHOOT,
            AzPlayBehaviors.PLAY_ONCE
        ),
        RECHAMBER
    );

    @Override
    public void idle(Entity entity, ItemStack itemStack) {
        IDLE.sendForItem(entity, itemStack);
    }

    @Override
    public void reload(Entity entity, ItemStack itemStack) {
        DEFAULT.reload(entity, itemStack);
    }

    @Override
    public void shoot(Entity entity, ItemStack itemStack) {
        SHOOT.sendForItem(entity, itemStack);
    }

    private M42A3SniperRifleAnimationDispatcher() {}
}
