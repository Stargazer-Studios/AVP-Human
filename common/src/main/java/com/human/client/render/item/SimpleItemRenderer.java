package com.human.client.render.item;

import com.human.HumanResources;
import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;

public class SimpleItemRenderer extends AzItemRenderer {

    public SimpleItemRenderer(String path) {
        super(AzItemRendererConfig.builder(HumanResources.itemGeoModelLocation(path), HumanResources.itemTextureLocation(path)).build());
    }
}
