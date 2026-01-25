package com.human.client.animation.item;

import com.blib.azurelib.common.animation.AzAnimatorConfig;
import com.blib.azurelib.common.animation.controller.AzAnimationController;
import com.blib.azurelib.common.animation.controller.AzAnimationControllerContainer;
import com.blib.azurelib.common.animation.impl.AzItemAnimator;
import com.human.HumanResources;
import com.human.common.gameplay.item.gun.animation.dispatcher.impl.DefaultGunAnimationDispatcher;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class M3712ShotgunAnimator extends AzItemAnimator {

    private static final String NAME = "m37_12_shotgun";

    private static final ResourceLocation ANIMATION = HumanResources.itemAnimationLocation(NAME);

    public M3712ShotgunAnimator() {
        super(AzAnimatorConfig.defaultConfig());
    }

    @Override
    public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
        animationControllerContainer.add(
            AzAnimationController.builder(this, DefaultGunAnimationDispatcher.CONTROLLER_MAIN)
                .setTransitionLength(1)
                .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
        return ANIMATION;
    }
}
