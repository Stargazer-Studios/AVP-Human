package com.human.common.registry.init;

import com.human.HumanResources;
import com.just.codec.stream.impl.StreamCodecs;
import com.lib.common.network.DataKey;
import com.lib.common.registry.DataKeyRegistry;
import com.mojang.serialization.Codec;

import java.util.function.Function;

public class HumanDataKeys {

    public static final DataKey<Integer> MARINE_SKIN_COLOR = register(
        "marine_skin_color",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("skinColor", Codec.INT)
            .build(0xEED0B6)
    );

    public static final DataKey<Integer> MARINE_BEARD_VARIANT = register(
        "marine_beard_variant",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("beardVariant", Codec.INT)
            .build(0)
    );

    public static final DataKey<Integer> MARINE_EYE_COLOR = register(
        "marine_eye_color",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("eyeColor", Codec.INT)
            .build(0xA1CAF1)
    );

    public static final DataKey<Integer> MARINE_HAIR_COLOR = register(
        "marine_hair_color",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("hairColor", Codec.INT)
            .build(0x86462C)
    );

    public static final DataKey<Integer> MARINE_HAIR_VARIANT = register(
        "marine_hair_variant",
        builder -> builder.networkSynchronized(StreamCodecs.INT)
            .persistent("hairVariant", Codec.INT)
            .build(0)
    );

    public static final DataKey<Boolean> MARINE_IS_MALE = register(
        "marine_is_male",
        builder -> builder.networkSynchronized(StreamCodecs.BOOLEAN)
            .persistent("isMale", Codec.BOOL)
            .build(true)
    );

    private static <T> DataKey<T> register(String id, Function<DataKey.Builder<T>, DataKey<T>> factory) {
        var resourceLocation = HumanResources.location(id);
        var dataAccessor = factory.apply(new DataKey.Builder<>(resourceLocation));
        return DataKeyRegistry.register(resourceLocation, dataAccessor);
    }

    public static void initialize() {}
}
