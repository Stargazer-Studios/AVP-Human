package com.human.common.gameplay.level.patrol.decorator.gear;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.level.patrol.decorator.MarineDecorator;
import com.human.common.gameplay.level.patrol.decorator.util.MarineGearDecoratorUtil;
import com.human.common.registry.init.item.HumanArmorItems;
import com.human.common.registry.init.item.HumanGunItems;
import com.human.common.registry.init.item.HumanItems;
import com.just.core.functional.tuple.Tuple2;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;

public class MarineGearDecorator implements MarineDecorator {

    public static final MarineGearDecorator INSTANCE = new MarineGearDecorator();

    private final List<Tuple2<Integer, Supplier<Item>>> weightedPrimaryWeapons;

    private MarineGearDecorator() {
        this.weightedPrimaryWeapons = List.of(
            new Tuple2<>(25, HumanGunItems.F903WE_RIFLE),
            new Tuple2<>(35, HumanGunItems.M4RA_BATTLE_RIFLE),
            new Tuple2<>(20, HumanGunItems.M37_12_SHOTGUN),
            new Tuple2<>(20, HumanGunItems.ZX_76_SHOTGUN)
        );
    }

    @Override
    public void decorate(Level level, Marine marine) {
        applyArmor(marine);
        applyPrimaryWeapon(marine);
        applySecondaryWeapon(marine);
        applyExtras(marine);
        applyExclusives(marine);
    }

    public void applyArmor(Marine marine) {
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.TACTICAL_HELMET.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.TACTICAL_CHESTPLATE.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.TACTICAL_LEGGINGS.get());
        MarineGearDecoratorUtil.equipArmorItem(marine, HumanArmorItems.TACTICAL_BOOTS.get());
    }

    public void applyExclusives(Marine marine) {
        MarineGearDecoratorUtil.giveItem(marine, Items.BONE, 7 + marine.getRandom().nextInt(12));
    }

    public void applyExtras(Marine marine) {
        MarineGearDecoratorUtil.giveItem(marine, HumanItems.GRENADE.get(), 1 + marine.getRandom().nextInt(1));
    }

    public void applyPrimaryWeapon(Marine marine) {
        var randomWeaponSupplier = MarineGearDecoratorUtil.selectFromWeightedList(weightedPrimaryWeapons, marine.getRandom());
        MarineGearDecoratorUtil.giveItem(marine, randomWeaponSupplier.get());
    }

    public void applySecondaryWeapon(Marine marine) {
        MarineGearDecoratorUtil.giveItem(marine, HumanGunItems.M88MOD4_COMBAT_PISTOL.get());
    }

    public List<Tuple2<Integer, Supplier<Item>>> getWeightedPrimaryWeapons() {
        return weightedPrimaryWeapons;
    }
}
