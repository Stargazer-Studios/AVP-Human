package com.human.common.gameplay.entity.living.human.marine.ai.heal_self.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategySet;
import com.human.common.gameplay.entity.living.human.marine.ai.heal_self.strategy.impl.*;

import java.util.List;

public class HealingStrategySet implements ItemStrategySet<HealingStrategy> {

    public static final HealingStrategySet INSTANCE = new HealingStrategySet();

    private final List<HealingStrategy> strategies;

    private HealingStrategySet() {
        this.strategies = List.of(
            // Instant healing potions (highest priority for urgent healing).
            new DrinkableHealingPotionStrategy(),
            new SplashHealingPotionStrategy(),
            new LingeringHealingPotionStrategy(),
            // Regeneration potions (good for sustained healing).
            new DrinkableRegenPotionStrategy(),
            new SplashRegenPotionStrategy(),
            new LingeringRegenPotionStrategy(),
            // Golden apples (special items with additional effects).
            new EnchantedGoldenAppleStrategy(),
            new GoldenAppleStrategy(),
            // Honey bottle (removes poison, uses drink sound).
            new HoneyBottleStrategy(),
            // General food (saturation-based healing).
            new FoodStrategy(),
            // Last resort items (negative side effects).
            new RottenFleshStrategy(),
            new PoisonousPotatoStrategy()
        );
    }

    @Override
    public List<HealingStrategy> getAll() {
        return strategies;
    }
}
