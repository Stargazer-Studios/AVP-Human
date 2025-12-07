package com.human.common.registry.key;

import com.human.HumanResources;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;

public class HumanVillagerPoiKeys {

    public static final ResourceKey<PoiType> COMMISSARY_POI_KEY = create("commissary_poi");

    private static ResourceKey<PoiType> create(String path) {
        return ResourceKey.create(Registries.POINT_OF_INTEREST_TYPE, HumanResources.location(path));
    }
}
