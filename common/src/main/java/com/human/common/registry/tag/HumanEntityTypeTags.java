package com.human.common.registry.tag;

import com.human.Human;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;

public class HumanEntityTypeTags {

    public static final TagKey<EntityType<?>> HATED_BY_MARINES = create("hated_by_marines");

    public static final TagKey<EntityType<?>> RADIATION_RESISTANT = create("radiation_resistant");

    private static TagKey<EntityType<?>> create(String name) {
        return Human.MOD.resources().createTagKey(Registries.ENTITY_TYPE, name);
    }
}
