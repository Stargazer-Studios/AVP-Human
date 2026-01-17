package com.human.common.gameplay.entity.living.human.marine.ai.sensor;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.QuartPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.biome.Biome;

import java.util.HashSet;
import java.util.Set;

public final class NearbyBiomesSensor {

    // Radius in blocks.
    private static final int RADIUS_BLOCKS = 4;

    public static Set<Holder<Biome>> sense(Entity entity) {
        var level = entity.level();
        var origin = entity.blockPosition();

        // Convert the block radius into a quart radius (ceil division by 4).
        var radiusQuarts = (RADIUS_BLOCKS + 3) >> 2;

        var originQx = QuartPos.fromBlock(origin.getX());
        var originQy = QuartPos.fromBlock(origin.getY());
        var originQz = QuartPos.fromBlock(origin.getZ());

        var result = new HashSet<Holder<Biome>>();

        for (var qx = originQx - radiusQuarts; qx <= originQx + radiusQuarts; qx++) {
            for (var qy = originQy - radiusQuarts; qy <= originQy + radiusQuarts; qy++) {
                for (var qz = originQz - radiusQuarts; qz <= originQz + radiusQuarts; qz++) {

                    // Pick the "corner" block of that quart cell.
                    var bx = QuartPos.toBlock(qx);
                    var by = QuartPos.toBlock(qy);
                    var bz = QuartPos.toBlock(qz);

                    var samplePos = new BlockPos(bx, by, bz);

                    result.add(level.getBiome(samplePos));
                }
            }
        }

        return result;
    }

    private NearbyBiomesSensor() {
        throw new UnsupportedOperationException();
    }
}
