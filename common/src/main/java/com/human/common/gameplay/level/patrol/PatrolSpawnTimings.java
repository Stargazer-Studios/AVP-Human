package com.human.common.gameplay.level.patrol;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class PatrolSpawnTimings {

    private static final int TICKS_PER_DAY = (int) TimeUnit.MINUTES.toSeconds(20) * 20;

    public static final PatrolSpawnerTicker.Timing MARINE_PATROLS = createDelayNDaysThenEveryNToNPlus3Days(1);

    public static final PatrolSpawnerTicker.Timing TACTICAL_MARINE_PATROLS = createDelayNDaysThenEveryNToNPlus3Days(2);

    public static final PatrolSpawnerTicker.Timing WY_APE_PATROLS = createDelayNDaysThenEveryNToNPlus3Days(3);

    public static final PatrolSpawnerTicker.Timing WY_COMMANDO_PATROLS = createDelayNDaysThenEveryNToNPlus3Days(4);

    public static final PatrolSpawnerTicker.Timing WY_ELITE_PATROLS = createDelayNDaysThenEveryNToNPlus3Days(5);

    public static final PatrolSpawnerTicker.Timing WY_SPEC_OPS_COMMANDO_PATROLS = createDelayNDaysThenEveryNToNPlus3Days(6);

    public static final PatrolSpawnerTicker.Timing WY_SPEC_OPS_ELITE_PATROLS = createDelayNDaysThenEveryNToNPlus3Days(7);

    private static PatrolSpawnerTicker.@NotNull Timing createDelayNDaysThenEveryNToNPlus3Days(int days) {
        return new PatrolSpawnerTicker.Timing(
            () -> TICKS_PER_DAY * days,
            level -> TICKS_PER_DAY * days + level.random.nextInt(TICKS_PER_DAY * 3)
        );
    }

    private PatrolSpawnTimings() {
        throw new UnsupportedOperationException();
    }
}
