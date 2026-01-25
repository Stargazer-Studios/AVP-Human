package com.human.common.gameplay.item;

import com.blib.api.common.tooltip.v1.TooltipCategoryType;
import com.blib.api.common.tooltip.v1.TooltipHintBuilder;
import com.blib.api.common.tooltip.v1.TooltipTranslationKeys;
import com.human.common.registry.init.HumanArmorMaterials;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PressureSuitArmorItem extends ArmorItem {

    private static final int PRESSURE_DURABILITY_MULTIPLIER = 12;

    private static final List<Component> TOOLTIP_COMPONENTS = new TooltipHintBuilder()
        .addCategory(TooltipCategoryType.WHEN_FULL_ARMOR_SET_EQUIPPED)
        .addPositiveEffect(TooltipTranslationKeys.EFFECT_WATER_BREATHING)
        .build();

    public PressureSuitArmorItem(Type type) {
        super(
            HumanArmorMaterials.PRESSURE,
            type,
            new Properties().durability(type.getDurability(PRESSURE_DURABILITY_MULTIPLIER))
        );
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
