package com.human.neoforge;

import com.human.Human;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(Human.MOD_ID)
public class HumanNeoForge {

    public HumanNeoForge(IEventBus modBus) {
        Human.initialize();
    }
}
