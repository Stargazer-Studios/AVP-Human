package com.human.common.gameplay.level.patrol.impl;

import com.human.common.gameplay.level.patrol.PatrolSpawner;
import com.human.common.gameplay.level.patrol.PatrolSpawnerTicker;
import com.human.common.gameplay.level.patrol.decorator.gear.MarineWYSOCGearDecorator;
import com.human.common.gameplay.level.patrol.decorator.squad.MarineSquadLeadershipDecorator;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;

public class WYSOCPatrolSpawnHandle {

    public static final WYSOCPatrolSpawnHandle INSTANCE = new WYSOCPatrolSpawnHandle();

    private final PatrolSpawner spawner;

    private final PatrolSpawnerTicker ticker;

    private WYSOCPatrolSpawnHandle() {
        this.spawner = PatrolSpawner.builder()
            .withCondition(level -> !level.getGameRules().getBoolean(GameRules.RULE_DO_PATROL_SPAWNING))
            .build(this::spawn);
        this.ticker = PatrolSpawnerTicker.builder()
            .withPlayerSelector(PatrolSpawnerTicker.PlayerSelector.RANDOM_NON_SPECTATOR)
            .withTiming(PatrolSpawnerTicker.Timing.EVERY_THREE_TO_SIX_DAYS)
            .build(spawner);
    }

    public void tick(ServerLevel level) {
        ticker.tick(level);
    }

    public PatrolSpawner getSpawner() {
        return spawner;
    }

    private void spawn(Level level, Player player, BlockPos.MutableBlockPos mutableBlockPos) {
        var spawnedMarines = MarineSpawner.spawn(level, player, mutableBlockPos);

        MarineSquadLeadershipDecorator.INSTANCE.decorate(level, spawnedMarines);

        for (var marine : spawnedMarines) {
            MarineWYSOCGearDecorator.INSTANCE.decorate(level, marine);
        }
    }
}
