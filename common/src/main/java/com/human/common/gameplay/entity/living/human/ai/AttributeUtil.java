package com.human.common.gameplay.entity.living.human.ai;

import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import org.jetbrains.annotations.Nullable;

public class AttributeUtil {

    public static double getAttributeBaseOrDefaultValue(LivingEntity livingEntity, Holder<Attribute> attribute) {
        var attributes = livingEntity.getAttributes();
        return attributes.hasAttribute(attribute)
            ? attributes.getBaseValue(attribute)
            : attribute.value().getDefaultValue();
    }

    public static double computeModifiedAttributeValue(
        Mob mob,
        Holder<Attribute> attribute,
        ItemStack itemStack,
        @Nullable EquipmentSlot equipmentSlot
    ) {
        var baseValue = getAttributeBaseOrDefaultValue(mob, attribute);
        return computeModifiedAttributeValue(itemStack, attribute, equipmentSlot, baseValue);
    }

    private static double computeModifiedAttributeValue(
        ItemStack itemStack,
        Holder<Attribute> attribute,
        @Nullable EquipmentSlot slot,
        double baseValue
    ) {
        var modifiers = itemStack.getOrDefault(DataComponents.ATTRIBUTE_MODIFIERS, ItemAttributeModifiers.EMPTY);

        var value = baseValue;

        for (var entry : modifiers.modifiers()) {
            if ((slot != null && !entry.slot().test(slot)) || !entry.attribute().equals(attribute)) {
                continue;
            }

            var mod = entry.modifier();

            switch (mod.operation()) {
                case ADD_VALUE -> value += mod.amount();
                case ADD_MULTIPLIED_BASE -> value += baseValue * mod.amount();
            }
        }

        for (var entry : modifiers.modifiers()) {
            if ((slot != null && !entry.slot().test(slot)) || !entry.attribute().equals(attribute)) {
                continue;
            }

            var mod = entry.modifier();

            if (mod.operation() == AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL) {
                value += value * mod.amount();
            }
        }

        return value;
    }
}
