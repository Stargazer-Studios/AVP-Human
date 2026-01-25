package com.human.client.render.item;

import com.blib.azurelib.common.render.item.AzItemRenderer;
import com.blib.azurelib.common.render.item.AzItemRendererConfig;
import com.human.HumanResources;

public class SimpleItemRenderer extends AzItemRenderer {

    public SimpleItemRenderer(String path) {
        super(AzItemRendererConfig.builder(HumanResources.itemGeoModelLocation(path), HumanResources.itemTextureLocation(path)).build());
    }
}
