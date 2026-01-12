package com.human.client.render.armor;

import com.human.HumanResources;
import com.human.client.render.layer.DyedRenderLayer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class PressureArmorRenderer extends AzPatchedArmorRenderer {

    private static final String NAME = "pressure";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.armorTextureLocation(NAME);

    private static final ResourceLocation DYEABLE_TEXTURE = HumanResources.armorTextureLocation(NAME + "_dyeable");

    public PressureArmorRenderer() {
        super(
            AzArmorRendererConfig.builder(MODEL, TEXTURE)
                .addRenderLayer(new DyedRenderLayer(DYEABLE_TEXTURE))
                .build()
        );
    }
}
