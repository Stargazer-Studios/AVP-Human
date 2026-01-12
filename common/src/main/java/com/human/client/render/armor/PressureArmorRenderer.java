package com.human.client.render.armor;

import com.human.HumanResources;
import com.human.client.render.layer.DyeColorLayer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class PressureArmorRenderer extends AzPatchedArmorRenderer {

    private static final String NAME = "pressure";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation INNER_TEXTURE = HumanResources.armorTextureLocation(NAME + "_inner");

    private static final ResourceLocation OUTER_TEXTURE = HumanResources.armorTextureLocation(NAME + "_outer");

    public PressureArmorRenderer() {
        super(
            AzArmorRendererConfig.builder(MODEL, INNER_TEXTURE)
                .addRenderLayer(new DyeColorLayer(OUTER_TEXTURE))
                .build()
        );
    }
}
