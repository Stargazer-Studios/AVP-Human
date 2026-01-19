package com.human.common.gameplay.command;

import com.human.common.gameplay.level.patrol.impl.MarinePatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYCPatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYEPatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYSOCPatrolSpawnHandle;
import com.human.common.gameplay.level.patrol.impl.WYSOEPatrolSpawnHandle;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class SpawnPatrolCommand {

    public static LiteralArgumentBuilder<CommandSourceStack> create() {
        return Commands.literal("patrol")
            .then(
                Commands.literal("spawn")
                    .then(
                        Commands.literal("marine")
                            .executes(context -> {
                                if (context.getSource().isPlayer()) {
                                    MarinePatrolSpawnHandle.INSTANCE.getSpawner().spawnFor(context.getSource().getPlayer());
                                }
                                return 1;
                            })
                    )
                    .then(
                        Commands.literal("wyc")
                            .executes(context -> {
                                if (context.getSource().isPlayer()) {
                                    WYCPatrolSpawnHandle.INSTANCE.getSpawner().spawnFor(context.getSource().getPlayer());
                                }
                                return 1;
                            })
                    )
                    .then(
                        Commands.literal("wye")
                            .executes(context -> {
                                if (context.getSource().isPlayer()) {
                                    WYEPatrolSpawnHandle.INSTANCE.getSpawner().spawnFor(context.getSource().getPlayer());
                                }
                                return 1;
                            })
                    )
                    .then(
                        Commands.literal("wysoc")
                            .executes(context -> {
                                if (context.getSource().isPlayer()) {
                                    WYSOCPatrolSpawnHandle.INSTANCE.getSpawner().spawnFor(context.getSource().getPlayer());
                                }
                                return 1;
                            })
                    )
                    .then(
                        Commands.literal("wysoe")
                            .executes(context -> {
                                if (context.getSource().isPlayer()) {
                                    WYSOEPatrolSpawnHandle.INSTANCE.getSpawner().spawnFor(context.getSource().getPlayer());
                                }
                                return 1;
                            })
                    )
            );
    }
}
