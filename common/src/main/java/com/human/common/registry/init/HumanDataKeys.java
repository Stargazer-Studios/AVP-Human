package com.human.common.registry.init;

import com.blib.common.network.data.DataSyncKey;
import com.blib.common.registry.BLibBuiltInRegistries;
import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.HumanResources;
import com.just.codec.stream.impl.StreamCodecs;
import com.mojang.serialization.Codec;

import java.util.function.Function;

public class HumanDataKeys {

    private static final BLibRegistry<DataSyncKey<?>> REGISTRY = Human.MOD.registries().create(BLibBuiltInRegistries.DATA_SYNC_KEYS);

    public static final BLibHolder<DataSyncKey<Boolean>> ENTITY_HAS_WARP_EFFECT = create(
        "entity_has_warp_effect",
        builder -> builder.networkSynchronized(StreamCodecs.BOOLEAN)
            .build(false)
    );

    public static final BLibHolder<DataSyncKey<Integer>> MARINE_SKIN_COLOR = create(
        "marine_skin_color",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("skinColor", Codec.INT)
            .build(0xEED0B6)
    );

    public static final BLibHolder<DataSyncKey<Integer>> MARINE_BEARD_VARIANT = create(
        "marine_beard_variant",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("beardVariant", Codec.INT)
            .build(0)
    );

    public static final BLibHolder<DataSyncKey<Integer>> MARINE_EYE_COLOR = create(
        "marine_eye_color",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("eyeColor", Codec.INT)
            .build(0xA1CAF1)
    );

    public static final BLibHolder<DataSyncKey<Integer>> MARINE_HAIR_COLOR = create(
        "marine_hair_color",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("hairColor", Codec.INT)
            .build(0x86462C)
    );

    public static final BLibHolder<DataSyncKey<Integer>> MARINE_HAIR_VARIANT = create(
        "marine_hair_variant",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("hairVariant", Codec.INT)
            .build(0)
    );

    public static final BLibHolder<DataSyncKey<Boolean>> MARINE_IS_MALE = create(
        "marine_is_male",
        builder -> builder.networkSynchronized(StreamCodecs.BOOLEAN)
            .persistent("isMale", Codec.BOOL)
            .build(true)
    );

    private static <T> BLibHolder<DataSyncKey<T>> create(String path, Function<DataSyncKey.Builder<T>, DataSyncKey<T>> factory) {
        var resourceLocation = HumanResources.location(path);
        return REGISTRY.createHolder(path, () -> factory.apply(new DataSyncKey.Builder<>(resourceLocation)));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
