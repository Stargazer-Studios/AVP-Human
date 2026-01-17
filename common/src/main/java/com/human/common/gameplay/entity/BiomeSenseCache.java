package com.human.common.gameplay.entity;

import com.human.common.gameplay.entity.living.human.marine.ai.sensor.NearbyBiomesSensor;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;

import java.util.HashSet;
import java.util.Set;

public class BiomeSenseCache {

    private final Entity entity;

    private final Set<Holder<Biome>> nearbyBiomes;

    private final int tickFrequency;

    private BlockPos lastSensePosition;

    private int lastSenseTick;

    public BiomeSenseCache(Entity entity, int tickFrequency) {
        this.entity = entity;
        this.nearbyBiomes = new HashSet<>();
        this.tickFrequency = tickFrequency;
        this.lastSensePosition = entity.blockPosition();
        this.lastSenseTick = 0;
    }

    public boolean isNearby(TagKey<Biome> tagKey) {
        tryPopulateCache();

        for (var biome : nearbyBiomes) {
            if (biome.is(tagKey)) {
                return true;
            }
        }

        return false;
    }

    public boolean isNearby(Holder<Biome> biome) {
        tryPopulateCache();

        return nearbyBiomes.contains(biome);
    }

    private void tryPopulateCache() {
        if (
            entity.tickCount <= lastSenseTick + tickFrequency
                && entity.blockPosition().equals(lastSensePosition)
        ) {
            return;
        }

        nearbyBiomes.clear();

        nearbyBiomes.addAll(NearbyBiomesSensor.sense(entity));

        this.lastSensePosition = entity.blockPosition();
        this.lastSenseTick = entity.tickCount;
    }
}
