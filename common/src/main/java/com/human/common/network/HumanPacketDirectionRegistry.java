package com.human.common.network;

import com.avp.service.Services;
import com.blib.common.network.model.PacketDirection;
import com.human.common.network.packet.C2SGunHitResultsPayload;
import com.human.common.network.packet.C2SGunReloadPayload;
import com.human.common.network.packet.C2SPlayerToggleCrawlPayload;
import com.human.common.network.packet.S2CBulletHitBlockPayload;
import com.human.common.network.packet.S2CGunRecoilPayload;

public class HumanPacketDirectionRegistry {

    public static void initialize() {
        Services.REGISTRY.registerPacketDirection(new PacketDirection.C2S<>(C2SGunHitResultsPayload.TYPE, C2SGunHitResultsPayload.CODEC));
        Services.REGISTRY.registerPacketDirection(new PacketDirection.C2S<>(C2SGunReloadPayload.TYPE, C2SGunReloadPayload.CODEC));
        Services.REGISTRY.registerPacketDirection(
            new PacketDirection.C2S<>(C2SPlayerToggleCrawlPayload.TYPE, C2SPlayerToggleCrawlPayload.CODEC)
        );

        Services.REGISTRY.registerPacketDirection(
            new PacketDirection.S2C<>(S2CBulletHitBlockPayload.TYPE, S2CBulletHitBlockPayload.CODEC)
        );
        Services.REGISTRY.registerPacketDirection(new PacketDirection.S2C<>(S2CGunRecoilPayload.TYPE, S2CGunRecoilPayload.CODEC));
    }
}
