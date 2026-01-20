package com.human.common.gameplay.command;

import com.human.common.gameplay.level.patrol.PatrolSpawner;
import com.human.common.gameplay.level.patrol.impl.ApePatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.MarinePatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.TacticalMarinePatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYCPatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYEPatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYSOCPatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYSOEPatrolSpawnHandle;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class SpawnPatrolCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> create() {
        return Commands.literal("patrol")
            .then(
                Commands.literal("spawn")
                    .then(
                        Commands.literal("ape")
                            .executes(context -> spawnPatrol(context, ApePatrolSpawnHandle.INSTANCE.getSpawner()))
                    )
                    .then(
                        Commands.literal("marine")
                            .executes(context -> spawnPatrol(context, MarinePatrolSpawnHandle.INSTANCE.getSpawner()))
                    )
                    .then(
                        Commands.literal("tactical")
                            .executes(context -> spawnPatrol(context, TacticalMarinePatrolSpawnHandle.INSTANCE.getSpawner()))
                    )
                    .then(
                        Commands.literal("wyc")
                            .executes(context -> spawnPatrol(context, WYCPatrolSpawnHandle.INSTANCE.getSpawner()))
                    )
                    .then(
                        Commands.literal("wye")
                            .executes(context -> spawnPatrol(context, WYEPatrolSpawnHandle.INSTANCE.getSpawner()))
                    )
                    .then(
                        Commands.literal("wysoc")
                            .executes(context -> spawnPatrol(context, WYSOCPatrolSpawnHandle.INSTANCE.getSpawner()))
                    )
                    .then(
                        Commands.literal("wysoe")
                            .executes(context -> spawnPatrol(context, WYSOEPatrolSpawnHandle.INSTANCE.getSpawner()))
                    )
            );
    }

    private static int spawnPatrol(CommandContext<CommandSourceStack> context, PatrolSpawner INSTANCE) {
        if (context.getSource().isPlayer()) {
            INSTANCE.spawnFor(context.getSource().getPlayer());
        }

        return 1;
    }
}
