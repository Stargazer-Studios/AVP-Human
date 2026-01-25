package com.human.common.config;

public @interface Configurable {

    @interface Comment {

        String[] value();
    }

    @interface Synchronized {}
}
