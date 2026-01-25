package com.human.client.render.armor;

import com.blib.azurelib.common.render.armor.AzArmorRenderer;
import com.blib.azurelib.common.render.armor.AzArmorRendererConfig;
import com.human.HumanResources;
import net.minecraft.resources.ResourceLocation;

public class TacticalArmorRenderer extends AzArmorRenderer {

    private static final String NAME = "tactical";

    private static final ResourceLocation MODEL = HumanResources.armorGeoModelLocation(NAME);

    private static final ResourceLocation TEXTURE = HumanResources.armorTextureLocation(NAME);

    public TacticalArmorRenderer() {
        super(AzArmorRendererConfig.builder(MODEL, TEXTURE).build());
    }
}
