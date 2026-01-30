package com.human.client.render.item.gun;

import com.blib.api.client.render.v1.item.AzItemRenderer;
import com.blib.api.client.render.v1.item.AzItemRendererConfig;
import com.human.HumanResources;
import com.human.client.animation.item.SevastopolFlamethrowerAnimator;

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
