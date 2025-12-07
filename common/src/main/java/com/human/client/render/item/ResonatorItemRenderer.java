package com.human.client.render.item;

import com.human.HumanResources;
import mod.azure.azurelib.common.render.item.AzItemRenderer;
import mod.azure.azurelib.common.render.item.AzItemRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class ResonatorItemRenderer extends AzItemRenderer {

    public static final String NAME = "resonator";

    private static final ResourceLocation MODEL = HumanResources.blockGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.blockTextureLocation(NAME);

    public ResonatorItemRenderer() {
        super(
            AzItemRendererConfig.builder(MODEL, TEXTURE)
                .useNewOffset(true)
                .build()
        );
    }
}
