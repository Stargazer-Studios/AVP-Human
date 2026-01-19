package com.human.common.gameplay.level.patrol.decorator.gear;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.level.patrol.decorator.MarineDecorator;
import com.human.common.gameplay.level.patrol.decorator.util.MarineGearDecoratorUtil;
import com.human.common.registry.init.item.HumanArmorItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public class MarineWYEGearDecorator implements MarineDecorator {

    public static final MarineWYEGearDecorator INSTANCE = new MarineWYEGearDecorator();

    private MarineWYEGearDecorator() {}

    @Override
    public void decorate(Level level, Marine marine) {
        applyArmor(marine);
        applyPrimaryWeapon(marine);
        applySecondaryWeapon(marine);
        applyExtras(marine);
        applyExclusives(marine);
    }

    public void applyArmor(Marine marine) {
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_ELITE_HELMET.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_ELITE_CHESTPLATE.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_ELITE_LEGGINGS.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_ELITE_BOOTS.get());
    }

    public void applyExclusives(Marine marine) {}

    public void applyExtras(Marine marine) {
        MarineWYCGearDecorator.INSTANCE.applyExtras(marine);

        MarineGearDecoratorUtil.giveItem(marine, Items.GOLDEN_APPLE, 8);
    }

    public void applyPrimaryWeapon(Marine marine) {
        MarineWYCGearDecorator.INSTANCE.applyPrimaryWeapon(marine);
    }

    public void applySecondaryWeapon(Marine marine) {
        MarineWYCGearDecorator.INSTANCE.applySecondaryWeapon(marine);
    }
}
