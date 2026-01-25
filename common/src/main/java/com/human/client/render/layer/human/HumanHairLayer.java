package com.human.client.render.layer.human;

import com.blib.azurelib.common.model.AzBone;
import com.blib.azurelib.common.render.AzRendererPipelineContext;
import com.blib.azurelib.common.render.layer.AzRenderLayer;
import com.human.common.gameplay.entity.living.human.AbstractHuman;

import java.util.UUID;

public class HumanHairLayer<T extends AbstractHuman> implements AzRenderLayer<UUID, T> {

    @Override
    public void preRender(AzRendererPipelineContext<UUID, T> context) {}

    @Override
    public void render(AzRendererPipelineContext<UUID, T> context) {
        var animatable = context.animatable();
        var textureLocation = animatable.getHumanFeatureManager().getHairTexture();
        HumanRenderLayerUtil.applyColorWithInvisibility(context, textureLocation, context.animatable().hairColor.get());
    }

    @Override
    public void renderForBone(AzRendererPipelineContext<UUID, T> context, AzBone bone) {}
}
