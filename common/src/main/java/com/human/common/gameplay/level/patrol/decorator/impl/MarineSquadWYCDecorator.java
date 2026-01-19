package com.human.common.gameplay.level.patrol.decorator.impl;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.level.patrol.decorator.MarineSquadDecorator;
import com.human.common.registry.init.item.HumanArmorItems;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import java.util.List;

public class MarineSquadWYCDecorator implements MarineSquadDecorator {

    public static final MarineSquadWYCDecorator INSTANCE = new MarineSquadWYCDecorator();

    private MarineSquadWYCDecorator() {}

    @Override
    public void decorate(Level level, List<Marine> marines) {
        for (var marine : marines) {
            equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_HELMET.get());
            equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_CHESTPLATE.get());
            equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_LEGGINGS.get());
            equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_BOOTS.get());
        }
    }

    private void equipArmorItem(Marine marine, ArmorItem armorItem) {
        var slot = armorItem.getEquipmentSlot();
        var stack = new ItemStack(armorItem, 1);

        marine.setItemSlot(slot, stack);
    }
}
