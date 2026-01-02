package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy;

import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.impl.GunStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.impl.MeleeWeaponStrategy;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class WeaponStrategies {

    private static final WeaponStrategy GUN_STRATEGY = new GunStrategy();

    private static final WeaponStrategy MELEE_WEAPON_STRATEGY = new MeleeWeaponStrategy();

    public static final List<WeaponStrategy> STRATEGIES = List.of(
        GUN_STRATEGY,
        MELEE_WEAPON_STRATEGY
    );

    public static boolean isValid(ItemStack itemStack) {
        for (var strategy : STRATEGIES) {
            if (strategy.canUseItemStack(itemStack)) {
                return true;
            }
        }

        return false;
    }
}
