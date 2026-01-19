package com.human.common.gameplay.entity.ai.utility.item;

import com.human.common.gameplay.entity.living.human.ai.model.ItemTarget;

public interface ItemStrategyResult<T extends ItemTarget, S> {

    T itemTarget();

    S strategy();

    double score();
}
