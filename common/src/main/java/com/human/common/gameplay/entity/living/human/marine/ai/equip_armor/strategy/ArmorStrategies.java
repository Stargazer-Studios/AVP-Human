package com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy;

import com.human.common.gameplay.entity.living.human.marine.ai.equip_armor.strategy.impl.OverallDefenseStrategy;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ArmorStrategies {

    private static final ArmorStrategy HEAD_OVERALL_DEFENSE = new OverallDefenseStrategy(ArmorItem.Type.HELMET);

    private static final ArmorStrategy CHEST_OVERALL_DEFENSE = new OverallDefenseStrategy(ArmorItem.Type.CHESTPLATE);

    private static final ArmorStrategy LEGS_OVERALL_DEFENSE = new OverallDefenseStrategy(ArmorItem.Type.LEGGINGS);

    private static final ArmorStrategy FEET_OVERALL_DEFENSE = new OverallDefenseStrategy(ArmorItem.Type.BOOTS);

    public static final List<ArmorStrategy> ALL_STRATEGIES = List.of(
        HEAD_OVERALL_DEFENSE,
        CHEST_OVERALL_DEFENSE,
        LEGS_OVERALL_DEFENSE,
        FEET_OVERALL_DEFENSE
    );

    private static final Map<ArmorItem.Type, List<ArmorStrategy>> STRATEGIES_BY_TYPE = ALL_STRATEGIES
        .stream()
        .collect(Collectors.groupingBy(ArmorStrategy::type, Collectors.toList()));

    public static List<ArmorStrategy> getForType(ArmorItem.Type type) {
        return STRATEGIES_BY_TYPE.getOrDefault(type, List.of());
    }

    public static boolean isValidItemStack(ItemStack itemStack) {
        if (itemStack.getItem() instanceof ArmorItem armorItem) {
            for (var strategy : getForType(armorItem.getType())) {
                if (strategy.isValidItemStack(itemStack)) {
                    return true;
                }
            }
        }

        return false;
    }
}
