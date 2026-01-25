package com.human.common.gameplay.block_item;

import com.blib.api.common.tooltip.v1.TooltipCategoryType;
import com.blib.api.common.tooltip.v1.TooltipHintBuilder;
import com.human.common.data.HumanTooltipTranslationKeys;
import com.human.common.registry.init.HumanBlocks;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.ItemContainerContents;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class LeadChestBlockItem extends BlockItem {

    private static final List<Component> TOOLTIP_COMPONENTS = new TooltipHintBuilder()
        .addCategory(TooltipCategoryType.WHEN_IN_INVENTORY)
        .addPositiveEffect(HumanTooltipTranslationKeys.EFFECT_AUTO_STORE_IRRADIATED_ITEMS)
        .build();

    public LeadChestBlockItem() {
        super(
            HumanBlocks.LEAD_CHEST.get(),
            new Item.Properties().component(DataComponents.CONTAINER, ItemContainerContents.EMPTY)
                .component(DataComponents.MAX_STACK_SIZE, 1)
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
