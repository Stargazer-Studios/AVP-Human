package com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategyResult;
import com.human.common.gameplay.entity.living.human.ai.model.ItemTarget;

public record WeaponStrategyResult<T extends ItemTarget>(
    T itemTarget,
    WeaponStrategy strategy,
    double score
) implements ItemStrategyResult<T, WeaponStrategy> {}
