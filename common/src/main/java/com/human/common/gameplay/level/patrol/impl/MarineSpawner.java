package com.human.common.gameplay.level.patrol.impl;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.registry.init.HumanEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MarineSpawner {

    public static List<Marine> spawn(Level level, Player player, BlockPos.MutableBlockPos startPos) {
        if (!(level instanceof ServerLevel serverLevel)) {
            return List.of();
        }

        var spawnedMarines = new ArrayList<Marine>();
        var randomSource = level.random;
        var spawnCount = 4;

        for (var i = 0; i < spawnCount; ++i) {
            startPos.setY(level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, startPos).getY());

            var spawnedMarineOrNull = spawnMarine(serverLevel, startPos);

            if (spawnedMarineOrNull != null) {
                spawnedMarines.add(spawnedMarineOrNull);
            }

            startPos.setX(startPos.getX() + randomSource.nextInt(5) - randomSource.nextInt(5));
            startPos.setZ(startPos.getZ() + randomSource.nextInt(5) - randomSource.nextInt(5));
        }

        return Collections.unmodifiableList(spawnedMarines);
    }

    private static @Nullable Marine spawnMarine(ServerLevel level, BlockPos pos) {
        var marine = HumanEntityTypes.MARINE.get().create(level);

        if (marine != null) {
            marine.setPos(pos.getX(), pos.getY(), pos.getZ());
            marine.finalizeSpawn(level, level.getCurrentDifficultyAt(pos), MobSpawnType.PATROL, null);
            level.addFreshEntityWithPassengers(marine);
        }

        return marine;
    }

    public sealed interface Result {

        Failure FAILURE = Failure.INSTANCE;

        enum Failure implements Result {
            INSTANCE
        }

        record Success(
            Marine leader,
            List<Marine> others
        ) implements Result {}
    }
}
