package com.human.common.gameplay.entity.living.human.marine.ai.heal_self.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategyResult;
import com.human.common.gameplay.entity.living.human.ai.model.ItemTarget;

public record HealingStrategyResult<T extends ItemTarget>(
    T itemTarget,
    HealingStrategy strategy,
    double score
) implements ItemStrategyResult<T, HealingStrategy> {}
