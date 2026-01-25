package com.human.client.render.armor;

import com.blib.azurelib.common.render.armor.AzArmorRendererConfig;
import com.human.HumanResources;
import com.human.client.render.layer.DyedRenderLayer;
import net.minecraft.resources.ResourceLocation;

public class WYEliteArmorRenderer extends AzPatchedArmorRenderer {

    private static final String NAME = "wy_elite";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.armorTextureLocation(NAME);

    private static final ResourceLocation DYEABLE_TEXTURE = HumanResources.armorTextureLocation(NAME + "_dyeable");

    public WYEliteArmorRenderer() {
        super(
            AzArmorRendererConfig.builder(MODEL, TEXTURE)
                .addRenderLayer(new DyedRenderLayer(DYEABLE_TEXTURE))
                .build()
        );
    }
}
