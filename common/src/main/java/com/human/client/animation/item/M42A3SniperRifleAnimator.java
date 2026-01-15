package com.human.client.animation.item;

import com.human.HumanResources;
import com.human.common.gameplay.item.gun.animation.dispatcher.impl.M42A3SniperRifleAnimationDispatcher;
import mod.azure.azurelib.common.animation.AzAnimatorConfig;
import mod.azure.azurelib.common.animation.controller.AzAnimationController;
import mod.azure.azurelib.common.animation.controller.AzAnimationControllerContainer;
import mod.azure.azurelib.common.animation.impl.AzItemAnimator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class M42A3SniperRifleAnimator extends AzItemAnimator {

    private static final String NAME = "m42a3_sniper_rifle";

    private static final ResourceLocation ANIMATION = HumanResources.itemAnimationLocation(NAME);

    public M42A3SniperRifleAnimator() {
        super(AzAnimatorConfig.defaultConfig());
    }

    @Override
    public void registerControllers(AzAnimationControllerContainer<ItemStack> animationControllerContainer) {
        animationControllerContainer.add(
            AzAnimationController.builder(this, M42A3SniperRifleAnimationDispatcher.CONTROLLER_MAIN)
                .setTransitionLength(1)
                .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ItemStack animatable) {
        return ANIMATION;
    }
}
