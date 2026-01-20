package com.human.common.gameplay.level.patrol.impl;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WolfSpawner {

    public static List<Wolf> spawn(Level level, Player player, BlockPos.MutableBlockPos startPos) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return List.of();
        }

        var spawnedWolves = new ArrayList<Wolf>();
        var randomSource = level.random;
        var spawnCount = randomSource.nextInt(3);

        for (var i = 0; i < spawnCount; ++i) {
            startPos.setY(level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, startPos).getY());

            var spawnedWolfOrNull = spawnWolf(serverLevel, startPos);

            if (spawnedWolfOrNull != null) {
                spawnedWolves.add(spawnedWolfOrNull);
            }

            startPos.setX(startPos.getX() + randomSource.nextInt(5) - randomSource.nextInt(5));
            startPos.setZ(startPos.getZ() + randomSource.nextInt(5) - randomSource.nextInt(5));
        }

        return Collections.unmodifiableList(spawnedWolves);
    }

    private static @Nullable Wolf spawnWolf(ServerLevel level, BlockPos pos) {
        var wolf = EntityType.WOLF.create(level);

        if (wolf != null) {
            wolf.setPos(pos.getX(), pos.getY(), pos.getZ());
            wolf.finalizeSpawn(level, level.getCurrentDifficultyAt(pos), MobSpawnType.PATROL, null);
            level.addFreshEntityWithPassengers(wolf);
        }

        return wolf;
    }
}
