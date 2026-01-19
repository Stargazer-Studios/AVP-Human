package com.human.common.gameplay.level.patrol.decorator.impl;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.item.DyeItemColorUtil;
import com.human.common.gameplay.level.patrol.decorator.MarineSquadDecorator;
import com.human.common.registry.init.item.HumanArmorItems;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class MarineSquadWYSOEDecorator implements MarineSquadDecorator {

    public static final MarineSquadWYSOEDecorator INSTANCE = new MarineSquadWYSOEDecorator();

    private MarineSquadWYSOEDecorator() {}

    @Override
    public void decorate(Level level, List<Marine> marines) {
        // Very small chance that the squad spawns wearing pink.
        var dyeColor = level.random.nextInt(500) == 0
            ? DyeColor.PINK
            : DyeColor.BLACK;

        for (var marine : marines) {
            equipArmorItem(marine, HumanArmorItems.WY_ELITE_HELMET.get(), dyeColor);
            equipArmorItem(marine, HumanArmorItems.WY_ELITE_CHESTPLATE.get(), dyeColor);
            equipArmorItem(marine, HumanArmorItems.WY_ELITE_LEGGINGS.get(), dyeColor);
            equipArmorItem(marine, HumanArmorItems.WY_ELITE_BOOTS.get(), dyeColor);
        }
    }

    private void equipArmorItem(Marine marine, ArmorItem armorItem, DyeColor dyeColor) {
        var dyes = List.of(DyeItem.byColor(dyeColor));
        var slot = armorItem.getEquipmentSlot();
        var stack = DyeItemColorUtil.applyDyesForced(new ItemStack(armorItem, 1), dyes);

        marine.setItemSlot(slot, stack);
    }
}
