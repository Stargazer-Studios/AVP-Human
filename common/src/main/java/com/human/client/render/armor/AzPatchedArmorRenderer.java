package com.human.client.render.armor;

import com.blib.api.client.render.v1.AzRendererConfig;
import com.blib.api.client.render.v1.AzRendererPipeline;
import com.blib.api.client.render.v1.AzRendererPipelineContext;
import com.blib.api.client.render.v1.armor.AzArmorRenderer;
import com.blib.api.client.render.v1.armor.AzArmorRendererConfig;
import com.blib.api.client.render.v1.armor.pipeline.AzArmorRendererPipeline;
import com.blib.api.client.render.v1.armor.pipeline.AzArmorRendererPipelineContext;
import com.blib.api.common.color.v1.Color;
import net.minecraft.world.item.ItemStack;

import java.util.UUID;

public abstract class AzPatchedArmorRenderer extends AzArmorRenderer {

    public AzPatchedArmorRenderer(AzArmorRendererConfig config) {
        super(config);
    }

    @Override
    protected AzArmorRendererPipeline createPipeline(AzRendererConfig config) {
        return new AzArmorRendererPipeline(config, this) {

            @Override
            protected AzRendererPipelineContext<UUID, ItemStack> createContext(AzRendererPipeline<UUID, ItemStack> rendererPipeline) {
                return new AzArmorRendererPipelineContext(rendererPipeline) {

                    @Override
                    public Color getRenderColor(ItemStack animatable, float partialTick, int packedLight) {
                        return Color.WHITE;
                    }
                };
            }
        };
    }
}
