package com.human.client.render.block;

import com.human.HumanResources;
import com.human.common.gameplay.block.entity.power.impl.DeskTerminalBlockEntity;
import mod.azure.azurelib.common.render.block.AzBlockEntityRenderer;
import mod.azure.azurelib.common.render.block.AzBlockEntityRendererConfig;
import mod.azure.azurelib.common.render.layer.AzAutoGlowingLayer;
import net.minecraft.resources.ResourceLocation;

public class DeskTerminalRenderer extends AzBlockEntityRenderer<DeskTerminalBlockEntity> {

    public static final String NAME = "desk_terminal";

    private static final ResourceLocation GEO = HumanResources.blockGeoModelLocation(NAME);

    private static final ResourceLocation TEX = HumanResources.blockTextureLocation(NAME);

    public DeskTerminalRenderer() {
        super(
            AzBlockEntityRendererConfig.<DeskTerminalBlockEntity>builder(GEO, TEX)
                .addRenderLayer(new AzAutoGlowingLayer<>())
                .build()
        );
    }
}
