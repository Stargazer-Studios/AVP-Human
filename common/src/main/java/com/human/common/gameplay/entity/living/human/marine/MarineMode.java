package com.human.common.gameplay.entity.living.human.marine;

import com.just.codec.Codec;

public interface MarineMode {

    Follow FOLLOW = Follow.INSTANCE;

    Hold HOLD = Hold.INSTANCE;

    enum Follow implements MarineMode {

        INSTANCE;

        public static final Codec<MarineMode.Follow> CODEC = EnumCodec.of(MarineMode.Follow.class);
    }

    enum Hold implements MarineMode {

        INSTANCE;

        public static final Codec<MarineMode.Hold> CODEC = EnumCodec.of(MarineMode.Hold.class);
    }

    Codec<MarineMode> CODEC = Codec.of("MarineMode", MarineModeCodec::decode, MarineModeCodec::encode);
}
