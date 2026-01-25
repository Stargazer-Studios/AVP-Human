package com.human.common.registry.init;

import com.blib.api.common.data_sync.v1.model.DataSyncKey;
import com.blib.api.common.registry.v1.BLibBuiltInRegistries;
import com.blib.api.common.registry.v1.BLibHolder;
import com.blib.api.common.registry.v1.BLibRegistry;
import com.human.Human;
import com.human.HumanResources;
import com.human.common.gameplay.entity.living.human.AbstractHuman;
import com.just.codec.stream.impl.StreamCodecs;
import com.mojang.serialization.Codec;

import java.util.function.Function;

public class HumanDataSyncKeys {

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

    public static final BLibHolder<DataSyncKey<Integer>> MARINE_TICKS_UNTIL_BORED = create(
        "marine_ticks_until_bored",
        builder -> builder.persistent("marineTicksUntilBored", Codec.INT)
            .build(AbstractHuman.MIN_IDLE_TIME_IN_TICKS)
    );

    private static <T> BLibHolder<DataSyncKey<T>> create(String path, Function<DataSyncKey.Builder<T>, DataSyncKey<T>> factory) {
        var resourceLocation = HumanResources.location(path);
        return REGISTRY.createHolder(path, () -> factory.apply(new DataSyncKey.Builder<>(resourceLocation)));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
