package com.human.common.gameplay.level.patrol;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.function.Function;
import java.util.function.IntSupplier;

public class PatrolSpawnerTicker {

    public static Builder builder() {
        return new Builder();
    }

    private final PlayerSelector playerSelector;

    private final PatrolSpawner patrolSpawner;

    private final Timing timing;

    private int ticksUntilSpawn;

    private PatrolSpawnerTicker(
        PlayerSelector playerSelector,
        PatrolSpawner patrolSpawner,
        Timing timing
    ) {
        this.playerSelector = playerSelector;
        this.patrolSpawner = patrolSpawner;
        this.timing = timing;
        this.ticksUntilSpawn = timing.getInitialDelayInTicks();
    }

    public void tick(Level level) {
        this.ticksUntilSpawn = Math.max(ticksUntilSpawn - 1, 0);

        if (ticksUntilSpawn > 0) {
            return;
        }

        if (!patrolSpawner.canSpawn(level)) {
            return;
        }

        var players = playerSelector.select(level);

        for (var player : players) {
            patrolSpawner.spawnFor(player);
        }

        this.ticksUntilSpawn = timing.getFrequencyInTicks(level);
    }

    public static class Builder {

        private PlayerSelector playerSelector;

        private Timing timing;

        private Builder() {
            this.playerSelector = PlayerSelector.RANDOM_NON_SPECTATOR;
            this.timing = Timing.EVERY_THREE_TO_SIX_DAYS;
        }

        public Builder withPlayerSelector(PlayerSelector playerSelector) {
            this.playerSelector = playerSelector;
            return this;
        }

        public Builder withTiming(Timing timing) {
            this.timing = timing;
            return this;
        }

        public PatrolSpawnerTicker build(PatrolSpawner patrolSpawner) {
            return new PatrolSpawnerTicker(playerSelector, patrolSpawner, timing);
        }
    }

    public interface PlayerSelector {

        PlayerSelector RANDOM_NON_SPECTATOR = PlayerSelector::getRandomNonSpectator;

        List<Player> select(Level level);

        static List<Player> getRandomNonSpectator(Level level) {
            var players = level.players()
                .stream()
                .filter(player -> !player.isSpectator())
                .toList();

            if (players.isEmpty()) {
                return null;
            }

            var randomIndex = level.random.nextInt(players.size());

            return List.of(players.get(randomIndex));
        }
    }

    public record Timing(
        IntSupplier initialDelayInTicksSupplier,
        Function<Level, Integer> frequencyInTicksSupplier
    ) {

        public static final int TICKS_PER_DAY = 24_000;

        public static final Timing EVERY_THREE_TO_SIX_DAYS = new Timing(
            () -> TICKS_PER_DAY,
            level -> TICKS_PER_DAY * 3 + level.random.nextInt(TICKS_PER_DAY * 3)
        );

        public int getFrequencyInTicks(Level level) {
            return frequencyInTicksSupplier.apply(level);
        }

        public int getInitialDelayInTicks() {
            return initialDelayInTicksSupplier.getAsInt();
        }
    }
}
