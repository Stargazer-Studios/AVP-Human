package com.human.client.render.layer;

import com.blib.api.client.model.v1.AzBone;
import com.blib.api.client.render.v1.AzRendererPipelineContext;
import com.blib.api.client.render.v1.layer.AzRenderLayer;
import com.blib.api.common.color.v1.Color;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

import java.util.UUID;

public class DyedRenderLayer implements AzRenderLayer<UUID, ItemStack> {

    private final ResourceLocation outerLayerResourceLocation;

    public DyedRenderLayer(ResourceLocation outerLayerResourceLocation) {
        this.outerLayerResourceLocation = outerLayerResourceLocation;
    }

    @Override
    public void preRender(AzRendererPipelineContext<UUID, ItemStack> context) {}

    @Override
    public void render(AzRendererPipelineContext<UUID, ItemStack> context) {
        var renderPipeline = context.rendererPipeline();

        var previousRenderColor = context.renderColor();

        var color = DyedItemColor.getOrDefault(context.animatable(), Color.WHITE.getColor());
        var vertexConsumer = context.multiBufferSource()
            .getBuffer(RenderType.armorCutoutNoCull(outerLayerResourceLocation));

        context.setRenderColor(color);
        context.setVertexConsumer(vertexConsumer);

        renderPipeline.reRender(context);

        context.setRenderColor(previousRenderColor);
    }

    @Override
    public void renderForBone(AzRendererPipelineContext context, AzBone bone) {}
}
