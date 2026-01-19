package com.human.common.gameplay.level.patrol.decorator.gear;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.level.patrol.decorator.MarineDecorator;
import com.human.common.gameplay.level.patrol.decorator.util.MarineGearDecoratorUtil;
import com.human.common.registry.init.item.HumanArmorItems;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.Level;

public class MarineWYCGearDecorator implements MarineDecorator {

    public static final MarineWYCGearDecorator INSTANCE = new MarineWYCGearDecorator();

    private MarineWYCGearDecorator() {}

    @Override
    public void decorate(Level level, Marine marine) {
        applyArmor(marine);
        applyPrimaryWeapon(marine);
        applySecondaryWeapon(marine);
        applyExtras(marine);
        applyExclusives(marine);
    }

    public void applyArmor(Marine marine) {
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_HELMET.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_CHESTPLATE.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_LEGGINGS.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.WY_COMMANDO_BOOTS.get());
    }

    public void applyExclusives(Marine marine) {}

    public void applyExtras(Marine marine) {
        TacticalMarineGearDecorator.INSTANCE.applyExtras(marine);

        MarineGearDecoratorUtil.giveItem(marine, Items.TOTEM_OF_UNDYING);
        MarineGearDecoratorUtil.giveItem(marine, Items.GOLDEN_APPLE, 4);

        var healingPotion = PotionContents.createItemStack(Items.SPLASH_POTION, Potions.HEALING);
        MarineGearDecoratorUtil.giveItem(marine, healingPotion);

        var regenerationPotion = PotionContents.createItemStack(Items.SPLASH_POTION, Potions.REGENERATION);
        MarineGearDecoratorUtil.giveItem(marine, regenerationPotion);
    }

    public void applyPrimaryWeapon(Marine marine) {
        TacticalMarineGearDecorator.INSTANCE.applyPrimaryWeapon(marine);
    }

    public void applySecondaryWeapon(Marine marine) {
        TacticalMarineGearDecorator.INSTANCE.applySecondaryWeapon(marine);
    }
}
