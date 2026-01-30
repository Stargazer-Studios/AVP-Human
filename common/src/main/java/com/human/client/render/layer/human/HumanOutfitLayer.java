package com.human.client.render.layer.human;

import com.blib.api.client.model.v1.AzBone;
import com.blib.api.client.render.v1.AzRendererPipelineContext;
import com.blib.api.client.render.v1.layer.AzRenderLayer;
import com.human.common.gameplay.entity.living.human.AbstractHuman;

import java.util.UUID;

public class HumanOutfitLayer<T extends AbstractHuman> implements AzRenderLayer<UUID, T> {

    @Override
    public void preRender(AzRendererPipelineContext<UUID, T> context) {}

    @Override
    public void render(AzRendererPipelineContext<UUID, T> context) {
        var animatable = context.animatable();
        var textureLocation = animatable.getHumanFeatureManager().getOutfitTexture();
        // Use -1 here to represent white.
        HumanRenderLayerUtil.applyColorWithInvisibility(context, textureLocation, -1);
    }

    @Override
    public void renderForBone(AzRendererPipelineContext<UUID, T> context, AzBone bone) {}
}
