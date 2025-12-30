package com.human.common.gameplay.entity.living.human.marine;

import com.just.codec.schema.CodecSchema;
import com.just.core.functional.result.Result;

import java.util.function.Function;

public final class MarineModeCodec {

    private static final String KEY_FOLLOW = "follow";

    private static final String KEY_HOLD = "hold";

    private static final String TYPE = "type";

    public static <T> Result<MarineMode, T> decode(
        CodecSchema<T> schema,
        T input
    ) {
        return schema.getField(input, TYPE)
            .andThen(schema::getStringValue)
            .andThen(type -> switch (type) {
                case KEY_FOLLOW -> MarineMode.Follow.CODEC
                    .decode(schema, input)
                    .map(Function.identity());
                case KEY_HOLD -> MarineMode.Hold.CODEC
                    .decode(schema, input)
                    .map(Function.identity());
                default -> Result.err(input);
            });
    }

    public static <T> T encode(
        CodecSchema<T> schema,
        MarineMode value
    ) {
        if (value == MarineMode.FOLLOW) {
            return schema.createField(
                MarineMode.Follow.CODEC.encode(schema, MarineMode.Follow.INSTANCE),
                TYPE,
                schema.createStringValue(KEY_FOLLOW)
            );
        }

        if (value == MarineMode.HOLD) {
            return schema.createField(
                MarineMode.Hold.CODEC.encode(schema, MarineMode.Hold.INSTANCE),
                TYPE,
                schema.createStringValue(KEY_HOLD)
            );
        }

        throw new IllegalStateException("Unknown MarineMode: " + value);
    }

    private MarineModeCodec() {
        throw new UnsupportedOperationException();
    }
}
