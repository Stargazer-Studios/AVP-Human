package com.human.client.render.block;

import com.blib.api.client.render.v1.block.AzBlockEntityRenderer;
import com.blib.api.client.render.v1.block.AzBlockEntityRendererConfig;
import com.human.HumanResources;
import com.human.client.animation.block.SolarPanelAnimator;
import com.human.common.gameplay.block.entity.power.impl.SolarPanelBlockEntity;
import net.minecraft.resources.ResourceLocation;

public class SolarPanelRenderer extends AzBlockEntityRenderer<SolarPanelBlockEntity> {

    public static final String NAME = "solar_panel";

    private static final ResourceLocation MODEL_LOCATION = HumanResources.blockGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE_LOCATION = HumanResources.blockTextureLocation(NAME);

    public SolarPanelRenderer() {
        super(
            AzBlockEntityRendererConfig.<SolarPanelBlockEntity>builder(MODEL_LOCATION, TEXTURE_LOCATION)
                .setAnimatorProvider(SolarPanelAnimator::new)
                .build()
        );
    }
}
