package com.human.common.registry.tag;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class HumanEntityTypeTags {

    public static final TagKey<EntityType<?>> RADIATION_RESISTANT = create("radiation_resistant");

    private static TagKey<EntityType<?>> create(String name) {
        return TagKey.create(Registries.ENTITY_TYPE, HumanResources.location(name));
    }
}
