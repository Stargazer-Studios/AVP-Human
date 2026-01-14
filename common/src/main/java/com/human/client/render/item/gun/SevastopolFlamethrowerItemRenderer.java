package com.human.client.render.item.gun;

import com.human.HumanResources;
import com.human.client.animation.item.SevastopolFlamethrowerAnimator;
import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;

public class SevastopolFlamethrowerItemRenderer extends AzItemRenderer {

    public SevastopolFlamethrowerItemRenderer(String name) {
        super(
            AzItemRendererConfig.builder(
                HumanResources.itemGeoModelLocation(name),
                HumanResources.itemTextureLocation(name)
            )
                .setAnimatorProvider(SevastopolFlamethrowerAnimator::new)
                .useNewOffset(true)
                .build()
        );
    }
}
