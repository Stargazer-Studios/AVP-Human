package com.human.client.render.item;

import com.blib.api.client.render.v1.item.AzItemRenderer;
import com.blib.api.client.render.v1.item.AzItemRendererConfig;
import com.human.HumanResources;

public class SimpleItemRenderer extends AzItemRenderer {

    public SimpleItemRenderer(String path) {
        super(AzItemRendererConfig.builder(HumanResources.itemGeoModelLocation(path), HumanResources.itemTextureLocation(path)).build());
    }
}
