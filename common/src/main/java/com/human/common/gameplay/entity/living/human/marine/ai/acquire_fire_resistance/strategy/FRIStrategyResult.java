package com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategyResult;
import com.human.common.gameplay.entity.living.human.ai.model.ItemTarget;

public record FRIStrategyResult<T extends ItemTarget>(
    T itemTarget,
    FRIStrategy strategy,
    double score
) implements ItemStrategyResult<T, FRIStrategy> {}
