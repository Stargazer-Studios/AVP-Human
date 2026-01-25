package com.human.client.animation.entity;

import com.blib.api.client.animation.v1.BLibEntityAnimationUtils;
import com.blib.azurelib.common.animation.AzAnimatorConfig;
import com.blib.azurelib.common.animation.controller.AzAnimationController;
import com.blib.azurelib.common.animation.controller.AzAnimationControllerContainer;
import com.blib.azurelib.common.animation.impl.AzEntityAnimator;
import com.human.HumanResources;
import com.human.common.gameplay.entity.machine.SentryTurret;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class SentryTurretAnimator extends AzEntityAnimator<SentryTurret> {

    private static final ResourceLocation ANIMATIONS = HumanResources.blockAnimationLocation("sentry_turret");

    public SentryTurretAnimator() {
        super(AzAnimatorConfig.defaultConfig());
    }

    @Override
    public void registerControllers(AzAnimationControllerContainer<SentryTurret> animationControllerContainer) {
        animationControllerContainer.add(
            AzAnimationController.builder(this, "base_controller")
                .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(SentryTurret animatable) {
        return ANIMATIONS;
    }

    @Override
    public void setCustomAnimations(SentryTurret animatable, float partialTicks) {
        BLibEntityAnimationUtils.applyHeadRotations(animatable, context(), partialTicks, "gRotationJoint", 0F);
    }
}
