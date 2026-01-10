package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy;

import com.human.common.gameplay.entity.ai.utility.item.ItemStrategySet;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.impl.OverallDefenseStrategy;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArmorStrategySet implements ItemStrategySet<ArmorStrategy> {

    public static final ArmorStrategySet INSTANCE = new ArmorStrategySet();

    private final List<ArmorStrategy> strategies;

    private final Map<ArmorItem.Type, List<ArmorStrategy>> strategiesByType;

    private ArmorStrategySet() {
        this.strategies = List.of(
            new OverallDefenseStrategy(ArmorItem.Type.HELMET),
            new OverallDefenseStrategy(ArmorItem.Type.CHESTPLATE),
            new OverallDefenseStrategy(ArmorItem.Type.LEGGINGS),
            new OverallDefenseStrategy(ArmorItem.Type.BOOTS)
        );
        this.strategiesByType = strategies
            .stream()
            .collect(Collectors.groupingBy(ArmorStrategy::type, Collectors.toList()));
    }

    @Override
    public boolean isAnyValidFor(ItemStack itemStack) {
        if (itemStack.getItem() instanceof ArmorItem armorItem) {
            for (var strategy : getForType(armorItem.getType())) {
                if (strategy.isValidItemStack(itemStack)) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public List<ArmorStrategy> getAll() {
        return strategies;
    }

    public List<ArmorStrategy> getForType(ArmorItem.Type type) {
        return strategiesByType.getOrDefault(type, List.of());
    }
}
