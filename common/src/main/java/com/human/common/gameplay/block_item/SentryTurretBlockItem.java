package com.human.common.gameplay.block_item;

import com.blib.api.common.tooltip.v1.TooltipCategoryType;
import com.blib.api.common.tooltip.v1.TooltipHintBuilder;
import com.human.common.data.HumanTooltipTranslationKeys;
import com.human.common.registry.init.HumanBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SentryTurretBlockItem extends BlockItem {

    private static final List<Component> TOOLTIP_COMPONENTS = new TooltipHintBuilder()
        .addCategory(TooltipCategoryType.REQUIREMENTS)
        .addNegativeEffect(HumanTooltipTranslationKeys.REQUIRES_REDSTONE_POWER)
        .addNegativeEffect(HumanTooltipTranslationKeys.REQUIRES_NEARBY_AMMO_CHEST_WITH_AMMO)
        .build();

    public SentryTurretBlockItem() {
        super(HumanBlocks.SENTRY_TURRET.get(), new Item.Properties());
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
