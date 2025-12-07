package com.human.client.render.item.gun;

import com.human.HumanResources;
import com.human.client.animation.item.FlameThrowerAnimator;
import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;

public class FlamethrowerItemRenderer extends AzItemRenderer {

    public FlamethrowerItemRenderer(String name) {
        super(
            AzItemRendererConfig.builder(
                HumanResources.itemGeoModelLocation(name),
                HumanResources.itemTextureLocation(name)
            )
                .setAnimatorProvider(FlameThrowerAnimator::new)
                .useNewOffset(true)
                .build()
        );
    }
}
