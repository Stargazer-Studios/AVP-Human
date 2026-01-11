package com.human.client.render.armor;

import mod.azure.azurelib.common.render.AzRendererConfig;
import mod.azure.azurelib.common.render.AzRendererPipeline;
import mod.azure.azurelib.common.render.AzRendererPipelineContext;
import mod.azure.azurelib.common.render.armor.AzArmorRenderer;
import mod.azure.azurelib.common.render.armor.AzArmorRendererConfig;
import mod.azure.azurelib.common.render.armor.AzArmorRendererPipeline;
import mod.azure.azurelib.common.render.armor.AzArmorRendererPipelineContext;
import mod.azure.azurelib.core.object.Color;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

import java.util.UUID;

public abstract class AzDyeableArmorRenderer extends AzArmorRenderer {

    public AzDyeableArmorRenderer(AzArmorRendererConfig config) {
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
                        return this.currentStack().is(ItemTags.DYEABLE)
                            ? Color.ofOpaque(
                                DyedItemColor.getOrDefault(this.currentStack(), Color.WHITE.getColor())
                            )
                            : Color.WHITE;
                    }
                };
            }
        };
    }
}
