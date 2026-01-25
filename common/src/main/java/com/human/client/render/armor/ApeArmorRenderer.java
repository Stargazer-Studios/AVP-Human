package com.human.client.render.armor;

import com.blib.azurelib.common.render.armor.AzArmorRendererConfig;
import com.human.HumanResources;
import net.minecraft.resources.ResourceLocation;

public class ApeArmorRenderer extends AzPatchedArmorRenderer {

    private static final String NAME = "ape";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.armorTextureLocation(NAME);

    public ApeArmorRenderer() {
        super(
            AzArmorRendererConfig.builder(MODEL, TEXTURE)
                .build()
        );
    }
}
