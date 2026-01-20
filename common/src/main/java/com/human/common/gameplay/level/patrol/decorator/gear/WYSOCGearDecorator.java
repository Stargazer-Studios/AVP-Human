package com.human.common.gameplay.level.patrol.decorator.gear;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.level.patrol.decorator.MarineDecorator;
import com.human.common.gameplay.level.patrol.decorator.util.MarineGearDecoratorUtil;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

public class WYSOCGearDecorator implements MarineDecorator {

    public static final WYSOCGearDecorator INSTANCE = new WYSOCGearDecorator();

    private WYSOCGearDecorator() {}

    @Override
    public void decorate(Level level, Marine marine) {
        applyArmor(marine);
        MarineGearDecoratorUtil.applyDyeColorToArmor(marine, DyeColor.BLACK);
        applyPrimaryWeapon(marine);
        applySecondaryWeapon(marine);
        applyExtras(marine);
        applyExclusives(marine);
    }

    public void applyArmor(Marine marine) {
        WYCGearDecorator.INSTANCE.applyArmor(marine);
    }

    public void applyExclusives(Marine marine) {}

    public void applyExtras(Marine marine) {
        WYEGearDecorator.INSTANCE.applyExtras(marine);

        MarineGearDecoratorUtil.giveItem(marine, Items.ENCHANTED_GOLDEN_APPLE, 4);
        MarineGearDecoratorUtil.giveItem(marine, Items.TOTEM_OF_UNDYING, 2);

        var healingPotion = PotionContents.createItemStack(Items.SPLASH_POTION, Potions.INVISIBILITY);
        MarineGearDecoratorUtil.giveItem(marine, healingPotion);
    }

    public void applyPrimaryWeapon(Marine marine) {
        WYEGearDecorator.INSTANCE.applyPrimaryWeapon(marine);
    }

    public void applySecondaryWeapon(Marine marine) {
        WYEGearDecorator.INSTANCE.applySecondaryWeapon(marine);
    }
}
