package com.human.common.property;

import com.blib.api.common.property.v1.BLibPropertyKey;

public record HumanProperty<T>(
    BLibPropertyKey.Leaf<T> key,
    T defaultValue
) {}
