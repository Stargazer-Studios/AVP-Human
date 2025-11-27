package com.human.neoforge.client;

import com.human.Human;
import com.human.client.HumanClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = Human.MOD_ID, dist = Dist.CLIENT)
public class HumanNeoForgeClient {

    static {
        // We want this to run before any of the other events, as this sets up queues of data pairs (for example, pairs
        // of item suppliers to item renderers) prior the registration events firing.
        HumanClient.initialize();
    }

    public HumanNeoForgeClient(IEventBus modBus) {}
}
