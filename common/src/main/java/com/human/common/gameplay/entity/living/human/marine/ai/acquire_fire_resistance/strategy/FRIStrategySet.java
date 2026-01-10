package com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategySet;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy.impl.DrinkablePotionFRIStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy.impl.EnchantedGoldenAppleFRIStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy.impl.LingeringPotionFRIStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.strategy.impl.SplashPotionFRIStrategy;

import java.util.List;

public class FRIStrategySet implements ItemStrategySet<FRIStrategy> {

    public static final FRIStrategySet INSTANCE = new FRIStrategySet();

    private final List<FRIStrategy> strategies;

    private FRIStrategySet() {
        this.strategies = List.of(
            new DrinkablePotionFRIStrategy(),
            new EnchantedGoldenAppleFRIStrategy(),
            new LingeringPotionFRIStrategy(),
            new SplashPotionFRIStrategy()
        );
    }

    @Override
    public List<FRIStrategy> getAll() {
        return strategies;
    }

}
