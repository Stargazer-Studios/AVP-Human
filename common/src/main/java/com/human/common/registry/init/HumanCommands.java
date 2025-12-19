package com.human.common.registry.init;

import com.blib.common.registry.impl.BLibCommandRegistry;
import com.human.Human;
import com.human.common.gameplay.command.nuke.NukeCommand;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class HumanCommands {

    private static final BLibCommandRegistry REGISTRY = Human.MOD.registries().createCommandRegistry();

    public static void initialize() {
        REGISTRY.register(
            LiteralArgumentBuilder.<CommandSourceStack>literal(Human.MOD.id())
                .then(
                    LiteralArgumentBuilder.<CommandSourceStack>literal("test")
                        .requires(commandSourceStack -> commandSourceStack.hasPermission(Commands.LEVEL_GAMEMASTERS))
                        .then(NukeCommand.create())
                )
        );
    }
}
