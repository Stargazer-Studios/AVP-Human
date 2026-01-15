package com.human.client.animation.item;

import com.human.HumanResources;
import com.human.common.gameplay.item.gun.animation.dispatcher.impl.DefaultGunAnimationDispatcher;
import mod.azure.azurelib.common.animation.AzAnimatorConfig;
import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzItemAnimator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class ZX76ShotgunAnimator extends AzItemAnimator {

    private static final String NAME = "zx_76_shotgun";

    private static final ResourceLocation ANIMATION = HumanResources.itemAnimationLocation(NAME);

    public ZX76ShotgunAnimator() {
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
