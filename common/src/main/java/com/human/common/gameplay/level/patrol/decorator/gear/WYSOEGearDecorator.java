package com.human.common.gameplay.level.patrol.decorator.gear;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.level.patrol.decorator.MarineDecorator;
import com.human.common.gameplay.level.patrol.decorator.util.MarineGearDecoratorUtil;
import com.human.common.registry.init.item.HumanGunItems;
import com.just.core.functional.tuple.Tuple2;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Supplier;

public class WYSOEGearDecorator implements MarineDecorator {

    public static final WYSOEGearDecorator INSTANCE = new WYSOEGearDecorator();

    private final List<Tuple2<Integer, Supplier<Item>>> weightedPrimaryWeapons;

    private WYSOEGearDecorator() {
        this.weightedPrimaryWeapons = List.of(
            new Tuple2<>(25, HumanGunItems.M56_SMARTGUN),
            new Tuple2<>(50, HumanGunItems.M41A_PULSE_RIFLE),
            new Tuple2<>(15, HumanGunItems.M6B_ROCKET_LAUNCHER)
        );
    }

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
        WYEGearDecorator.INSTANCE.applyArmor(marine);
    }

    public void applyExclusives(Marine marine) {}

    public void applyExtras(Marine marine) {
        WYSOCGearDecorator.INSTANCE.applyExtras(marine);

        MarineGearDecoratorUtil.giveItem(marine, Items.ENCHANTED_GOLDEN_APPLE, 8);
    }

    public void applyPrimaryWeapon(Marine marine) {
        var randomWeaponSupplier = MarineGearDecoratorUtil.selectFromWeightedList(weightedPrimaryWeapons, marine.getRandom());
        MarineGearDecoratorUtil.giveItem(marine, randomWeaponSupplier.get());
    }

    public void applySecondaryWeapon(Marine marine) {
        WYSOCGearDecorator.INSTANCE.applySecondaryWeapon(marine);
    }
}
