package com.human.client.render.block;

import com.blib.api.client.render.v1.block.AzBlockEntityRenderer;
import com.blib.api.client.render.v1.block.AzBlockEntityRendererConfig;
import com.human.HumanResources;
import com.human.client.animation.block.ResonatorAnimator;
import com.human.common.gameplay.block.entity.power.impl.ResonatorBlockEntity;
import net.minecraft.resources.ResourceLocation;

public class ResonatorRenderer extends AzBlockEntityRenderer<ResonatorBlockEntity> {

    public static final String NAME = "resonator";

    private static final ResourceLocation MODEL_LOCATION = HumanResources.blockGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE_LOCATION = HumanResources.blockTextureLocation(NAME);

    public ResonatorRenderer() {
        super(
            AzBlockEntityRendererConfig.<ResonatorBlockEntity>builder(MODEL_LOCATION, TEXTURE_LOCATION)
                .setAnimatorProvider(ResonatorAnimator::new)
                .build()
        );
    }
}
