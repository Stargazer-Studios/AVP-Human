package com.human.client.animation.entity;

import com.blib.api.client.animation.v1.animator.AzEntityAnimator;
import com.blib.api.client.animation.v1.controller.AzAnimationController;
import com.blib.api.client.animation.v1.controller.AzAnimationControllerContainer;
import com.human.HumanResources;
import com.human.common.gameplay.entity.nuke.MushroomCloudEntity;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class MushroomCloudAnimator extends AzEntityAnimator<MushroomCloudEntity> {

    private static final ResourceLocation ANIMATIONS = HumanResources.entityAnimationLocation("mushroom_cloud");

    @Override
    public void registerControllers(AzAnimationControllerContainer<MushroomCloudEntity> animationControllerContainer) {
        animationControllerContainer.add(
            AzAnimationController.builder(this, "base_controller")
                .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(MushroomCloudEntity animatable) {
        return ANIMATIONS;
    }
}
