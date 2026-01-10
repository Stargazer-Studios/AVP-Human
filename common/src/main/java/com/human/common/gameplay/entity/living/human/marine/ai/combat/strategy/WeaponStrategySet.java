package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategySet;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.impl.GunStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.impl.MeleeWeaponStrategy;

import java.util.List;

public class WeaponStrategySet implements ItemStrategySet<WeaponStrategy> {

    public static final WeaponStrategySet INSTANCE = new WeaponStrategySet();

    private final List<WeaponStrategy> strategies;

    private WeaponStrategySet() {
        this.strategies = List.of(new GunStrategy(), new MeleeWeaponStrategy());
    }

    @Override
    public List<WeaponStrategy> getAll() {
        return strategies;
    }
}
