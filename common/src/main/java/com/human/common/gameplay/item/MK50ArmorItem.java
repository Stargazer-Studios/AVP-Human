package com.human.common.gameplay.item;

import com.blib.api.common.tooltip.v1.TooltipCategoryType;
import com.blib.api.common.tooltip.v1.TooltipHintBuilder;
import com.blib.api.common.tooltip.v1.TooltipTranslationKeys;
import com.human.common.data.HumanTooltipTranslationKeys;
import com.human.common.registry.init.HumanArmorMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class MK50ArmorItem extends ArmorItem {

    private static final int MK50_DURABILITY_MULTIPLIER = 14;

    private static final List<Component> TOOLTIP_COMPONENTS = new TooltipHintBuilder()
        .addCategory(TooltipCategoryType.WHEN_FULL_ARMOR_SET_EQUIPPED)
        .addPositiveEffect(HumanTooltipTranslationKeys.EFFECT_RADIATION_RESISTANCE)
        .addPositiveEffect(TooltipTranslationKeys.EFFECT_WATER_BREATHING)
        .addNegativeEffect(TooltipTranslationKeys.EFFECT_SLOWNESS)
        .build();

    public MK50ArmorItem(ArmorItem.Type type) {
        super(HumanArmorMaterials.MK50, type, new Item.Properties().durability(type.getDurability(MK50_DURABILITY_MULTIPLIER)));
    }

    @Override
    public void appendHoverText(
        @NotNull ItemStack stack,
        @NotNull TooltipContext context,
        @NotNull List<Component> tooltipComponents,
        @NotNull TooltipFlag tooltipFlag
    ) {
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
        tooltipComponents.addAll(TOOLTIP_COMPONENTS);
    }
}
