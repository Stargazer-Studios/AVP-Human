package com.human.client.render.layer;

import mod.azure.azurelib.common.model.AzBone;
import mod.azure.azurelib.common.render.AzRendererPipelineContext;
import mod.azure.azurelib.common.render.layer.AzRenderLayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public class DyeColorLayer implements AzRenderLayer<UUID, ItemStack> {

    private final ResourceLocation outerLayerResourceLocation;

    public DyeColorLayer(ResourceLocation outerLayerResourceLocation) {
        this.outerLayerResourceLocation = outerLayerResourceLocation;
    }

    @Override
    public void preRender(AzRendererPipelineContext<UUID, ItemStack> context) {}

    @Override
    public void render(AzRendererPipelineContext<UUID, ItemStack> context) {
        var renderPipeline = context.rendererPipeline();
        context.setRenderColor(-1);
        context.setVertexConsumer(
            context.multiBufferSource()
                .getBuffer(RenderType.armorCutoutNoCull(outerLayerResourceLocation))
        );
        renderPipeline.reRender(context);
    }

    @Override
    public void renderForBone(AzRendererPipelineContext context, AzBone bone) {}
}
