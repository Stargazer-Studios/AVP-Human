package com.human.common.network;

import com.avp.service.Services;
import com.blib.common.network.model.NetworkHandler;
import com.human.client.network.HumanClientListener;
import com.human.common.network.packet.C2SGunHitResultsPayload;
import com.human.common.network.packet.C2SGunReloadPayload;
import com.human.common.network.packet.C2SPlayerToggleCrawlPayload;
import com.human.common.network.packet.S2CBulletHitBlockPayload;
import com.human.common.network.packet.S2CGunRecoilPayload;

public class HumanServerPacketHandlerRegistry {

    public static void initialize() {
        registerServerBoundPacketHandlers();
        registerClientBoundPacketHandlers();
    }

    private static void registerServerBoundPacketHandlers() {
        Services.REGISTRY.registerPacketHandlers(
            new NetworkHandler.FromClient<>(
                C2SGunHitResultsPayload.TYPE,
                C2SGunHitResultsPayload.CODEC,
                HumanServerListener::handleGunHitResultsPayload
            )
        );
        Services.REGISTRY.registerPacketHandlers(
            new NetworkHandler.FromClient<>(
                C2SGunReloadPayload.TYPE,
                C2SGunReloadPayload.CODEC,
                HumanServerListener::handleGunReloadPayload
            )
        );
        Services.REGISTRY.registerPacketHandlers(
            new NetworkHandler.FromClient<>(
                C2SPlayerToggleCrawlPayload.TYPE,
                C2SPlayerToggleCrawlPayload.CODEC,
                HumanServerListener::handlePlayerToggleCrawlPayload
            )
        );
    }

    private static void registerClientBoundPacketHandlers() {
        Services.REGISTRY.registerPacketHandlers(
            new NetworkHandler.FromServer<>(
                S2CBulletHitBlockPayload.TYPE,
                S2CBulletHitBlockPayload.CODEC,
                (payload, player) -> HumanClientListener.handleBulletHitBlockPayload(payload)
            )
        );
        Services.REGISTRY.registerPacketHandlers(
            new NetworkHandler.FromServer<>(
                S2CGunRecoilPayload.TYPE,
                S2CGunRecoilPayload.CODEC,
                HumanClientListener::handleGunRecoil
            )
        );
    }
}
