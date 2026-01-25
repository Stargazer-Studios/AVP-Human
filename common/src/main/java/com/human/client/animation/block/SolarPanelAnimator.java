package com.human.client.animation.block;

import com.blib.azurelib.common.animation.AzAnimatorConfig;
import com.blib.azurelib.common.animation.controller.AzAnimationController;
import com.blib.azurelib.common.animation.controller.AzAnimationControllerContainer;
import com.blib.azurelib.common.animation.impl.AzBlockAnimator;
import com.human.HumanResources;
import com.human.common.gameplay.block.entity.power.impl.SolarPanelBlockEntity;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class SolarPanelAnimator extends AzBlockAnimator<SolarPanelBlockEntity> {

    private static final ResourceLocation ANIMATIONS = HumanResources.blockAnimationLocation("solar_panel");

    public SolarPanelAnimator() {
        super(AzAnimatorConfig.defaultConfig());
    }

    @Override
    public void registerControllers(AzAnimationControllerContainer<SolarPanelBlockEntity> animationControllerContainer) {
        animationControllerContainer.add(
            AzAnimationController.builder(this, "base_controller")
                .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(SolarPanelBlockEntity animatable) {
        return ANIMATIONS;
    }
}
