package com.human.client.render.armor;

import com.human.HumanResources;
import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import net.minecraft.resources.ResourceLocation;

public class TacticalArmorRenderer extends AzArmorRenderer {

    private static final String NAME = "tactical";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.armorTextureLocation(NAME);

    public TacticalArmorRenderer() {
        super(AzArmorRendererConfig.builder(MODEL, TEXTURE).build());
    }
}
