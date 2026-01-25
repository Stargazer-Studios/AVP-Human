package com.human.common.registry.init;

import com.blib.api.common.registry.v1.BLibHolder;
import com.blib.api.common.registry.v1.BLibRegistry;
import com.google.common.collect.ImmutableSet;
import com.human.Human;
import com.human.common.registry.key.HumanVillagerPoiKeys;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;

public class HumanVillagerProfessions {

    private static final BLibRegistry<VillagerProfession> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.VILLAGER_PROFESSION);

    public static final BLibHolder<VillagerProfession> COMMISSARY = create("commissary", HumanVillagerPoiKeys.COMMISSARY_POI_KEY);

    private static BLibHolder<VillagerProfession> create(String path, ResourceKey<PoiType> type) {
        return REGISTRY.createHolder(
            path,
            () -> new VillagerProfession(
                path,
                entry -> entry.is(type),
                entry -> entry.is(type),
                ImmutableSet.of(),
                ImmutableSet.of(),
                SoundEvents.VILLAGER_WORK_WEAPONSMITH
            )
        );
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
