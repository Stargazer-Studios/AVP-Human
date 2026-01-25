package com.human.client.render.armor;

import com.blib.azurelib.common.render.AzRendererConfig;
import com.blib.azurelib.common.render.AzRendererPipeline;
import com.blib.azurelib.common.render.AzRendererPipelineContext;
import com.blib.azurelib.common.render.armor.AzArmorRenderer;
import com.blib.azurelib.common.render.armor.AzArmorRendererConfig;
import com.blib.azurelib.common.render.armor.AzArmorRendererPipeline;
import com.blib.azurelib.common.render.armor.AzArmorRendererPipelineContext;
import com.blib.azurelib.core.object.Color;
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
