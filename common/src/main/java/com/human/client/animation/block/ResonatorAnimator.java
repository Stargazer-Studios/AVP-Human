package com.human.client.animation.block;

import com.blib.azurelib.common.animation.AzAnimatorConfig;
import com.blib.azurelib.common.animation.controller.AzAnimationController;
import com.blib.azurelib.common.animation.controller.AzAnimationControllerContainer;
import com.blib.azurelib.common.animation.impl.AzBlockAnimator;
import com.human.HumanResources;
import com.human.common.gameplay.block.entity.power.impl.ResonatorBlockEntity;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ResonatorAnimator extends AzBlockAnimator<ResonatorBlockEntity> {

    private static final ResourceLocation ANIMATIONS = HumanResources.blockAnimationLocation("resonator");

    public ResonatorAnimator() {
        super(AzAnimatorConfig.defaultConfig());
    }

    @Override
    public void registerControllers(AzAnimationControllerContainer<ResonatorBlockEntity> animationControllerContainer) {
        animationControllerContainer.add(
            AzAnimationController.builder(this, "base_controller")
                .build()
        );
    }

    @Override
    public @NotNull ResourceLocation getAnimationLocation(ResonatorBlockEntity animatable) {
        return ANIMATIONS;
    }
}
