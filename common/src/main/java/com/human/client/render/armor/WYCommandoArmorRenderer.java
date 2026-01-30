package com.human.client.render.armor;

import com.blib.api.client.render.v1.armor.AzArmorRendererConfig;
import com.human.HumanResources;
import com.human.client.render.layer.AzPatchedAutoGlowingLayer;
import com.human.client.render.layer.DyedRenderLayer;
import net.minecraft.resources.ResourceLocation;

public class WYCommandoArmorRenderer extends AzPatchedArmorRenderer {

    private static final String NAME = "wy_commando";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.armorTextureLocation(NAME);

    private static final ResourceLocation DYEABLE_TEXTURE = HumanResources.armorTextureLocation(NAME + "_dyeable");

    public WYCommandoArmorRenderer() {
        super(
            AzArmorRendererConfig.builder(MODEL, TEXTURE)
                .addRenderLayer(new AzPatchedAutoGlowingLayer<>(TEXTURE))
                .addRenderLayer(new DyedRenderLayer(DYEABLE_TEXTURE))
                .build()
        );
    }
}
