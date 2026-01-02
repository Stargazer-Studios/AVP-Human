package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy;

import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;

public record WeaponStrategyResult<T extends ItemTarget>(
    T itemTarget,
    WeaponStrategy strategy,
    double score
) {}
