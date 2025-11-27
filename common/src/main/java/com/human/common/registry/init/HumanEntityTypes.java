package com.human.common.registry.init;

import com.avp.common.registry.init.entity_type.SilencedEntityTypeBuilder;
import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class HumanEntityTypes {

    public static final BLibRegistry<EntityType<?>> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.ENTITY_TYPE);

    public static <T extends Entity> BLibHolder<EntityType<T>> create(String id, EntityType.Builder<T> builder) {
        return REGISTRY.createHolder(id, () -> ((SilencedEntityTypeBuilder) builder).avp$buildWithoutDataFixerCheck());
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
