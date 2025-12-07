package com.human.util;

import com.avp.common.util.AVPPredicates;
import com.human.common.registry.init.HumanMobEffects;
import com.human.common.registry.tag.HumanEntityTypeTags;
import com.human.common.registry.tag.HumanItemTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class HumanPredicates {

    public static boolean canBeIrradiated(Entity entity) {
        if (
            // If this is not a living entity...
            !(entity instanceof LivingEntity livingEntity)
                // Or if the entity is radiation-resistant...
                || livingEntity.getType().is(HumanEntityTypeTags.RADIATION_RESISTANT)
                // Or if the living entity is immortal...
                || AVPPredicates.IS_IMMORTAL.test(livingEntity)
                // Or if the living entity already has the radiation effect...
                || livingEntity.hasEffect(HumanMobEffects.RADIATION.getHolder())
                // Or if the entity is no longer alive...
                || !livingEntity.isAlive()
        ) {
            // Then we don't want to or can't reasonably apply the radiation effect. Abort.
            return false;
        }

        var hasFullRadiationResistantArmor = AVPPredicates.hasFullArmorSetMatching(
            livingEntity,
            itemStack -> itemStack.is(HumanItemTags.RADIATION_RESISTANT_ARMORS)
        );

        // Entity should not have a full set of radiation-resistant armor.
        return !hasFullRadiationResistantArmor;
    }
}
