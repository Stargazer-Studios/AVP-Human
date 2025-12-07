package com.human.common.registry.tag;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;

public class HumanDamageTypesTags {

    public static final TagKey<DamageType> DOES_NOT_HURT_SENTRY_TURRETS = create("does_not_hurt_sentry_turrets");

    private static TagKey<DamageType> create(String name) {
        return TagKey.create(Registries.DAMAGE_TYPE, HumanResources.location(name));
    }
}
