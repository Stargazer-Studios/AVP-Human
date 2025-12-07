package com.human.client.render.armor;

import com.human.HumanResources;
import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class WYEliteArmorRenderer extends AzArmorRenderer {

    private static final String NAME = "wy_elite";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.armorTextureLocation(NAME);

    public WYEliteArmorRenderer() {
        super(AzArmorRendererConfig.builder(MODEL, TEXTURE).build());
    }
}
