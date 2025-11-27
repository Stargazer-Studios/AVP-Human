package com.human.common.registry.init;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class HumanBlockEntityTypes {

    private static final BLibRegistry<BlockEntityType<?>> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.BLOCK_ENTITY_TYPE);

    private static <T extends BlockEntity> BLibHolder<BlockEntityType<T>> create(
        String path,
        Supplier<BlockEntityType.Builder<T>> builder
    ) {
        return REGISTRY.createHolder(path, () -> builder.get().build(null));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
