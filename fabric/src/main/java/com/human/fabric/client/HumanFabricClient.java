package com.human.fabric.client;

import com.human.client.HumanClient;
import net.fabricmc.api.ClientModInitializer;

public class HumanFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HumanClient.initialize();
    }
}
