package com.human.common.gameplay.entity.living.human.marine;

import com.just.codec.Codec;
import com.just.codec.schema.CodecSchema;
import com.just.core.functional.result.Result;

import java.util.HashMap;
import java.util.Map;

// TODO: Move this to just in the future.
public final class EnumCodec<E extends Enum<E>> implements Codec<E> {

    private final Class<E> enumClass;

    private final Map<String, E> byName;

    public EnumCodec(Class<E> enumClass) {
        this.enumClass = enumClass;
        this.byName = new HashMap<>();

        for (var constant : enumClass.getEnumConstants()) {
            byName.put(constant.name(), constant);
        }
    }

    @Override
    public <T> T encode(CodecSchema<T> schema, E value) {
        return schema.createStringValue(value.name());
    }

    @Override
    public <T> Result<E, T> decode(CodecSchema<T> schema, T input) {
        return schema.getStringValue(input)
            .andThen(name -> {
                E value = byName.get(name);
                if (value == null) {
                    return Result.err(input);
                }
                return Result.ok(value);
            });
    }

    @Override
    public String toString() {
        return "EnumCodec[" + enumClass.getSimpleName() + "]";
    }

    public static <E extends Enum<E>> EnumCodec<E> of(Class<E> enumClass) {
        return new EnumCodec<>(enumClass);
    }
}
