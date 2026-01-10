package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;

public record ArmorStrategyResult<T extends ItemTarget>(
    T itemTarget,
    ArmorStrategy strategy,
    double score
) implements ItemStrategyResult<T, ArmorStrategy> {}
