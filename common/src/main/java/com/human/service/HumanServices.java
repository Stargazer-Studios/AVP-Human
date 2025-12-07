package com.human.service;

import com.human.Human;

import java.util.ServiceLoader;

public class HumanServices {

    public static final HumanFactoryService FACTORY = load(HumanFactoryService.class);

    public static <T> T load(Class<T> clazz) {
        var loadedService = ServiceLoader.load(clazz)
            .findFirst()
            .orElseThrow(() -> new NullPointerException("Failed to load service for " + clazz.getName()));

        Human.LOGGER.debug("Loaded {} for service {}", loadedService, clazz);

        return loadedService;
    }
}
