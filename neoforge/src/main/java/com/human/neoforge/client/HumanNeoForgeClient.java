package com.human.neoforge.client;

import com.human.Human;
import com.human.client.HumanClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Human.MOD_ID, dist = Dist.CLIENT)
public class HumanNeoForgeClient {

    static {}

    public HumanNeoForgeClient(IEventBus modBus) {
        HumanClient.initialize();
    }
}
