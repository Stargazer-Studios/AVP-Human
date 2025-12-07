package com.human.common.network.packet;

import com.human.HumanResources;
import com.just.codec.stream.RecordStreamCodec;
import com.just.codec.stream.StreamCodec;
import com.just.codec.stream.impl.StreamCodecs;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public record C2SPlayerToggleCrawlPayload(
    boolean shouldCrawl
) implements CustomPacketPayload {

    public static final ResourceLocation PAYLOAD_ID = HumanResources.location("player_toggle_crawl");

    public static final Type<C2SPlayerToggleCrawlPayload> TYPE = new Type<>(PAYLOAD_ID);

    public static final StreamCodec<C2SPlayerToggleCrawlPayload> CODEC = RecordStreamCodec.of(
        StreamCodecs.BOOLEAN,
        C2SPlayerToggleCrawlPayload::shouldCrawl,
        C2SPlayerToggleCrawlPayload::new
    );

    @Override
    public @NotNull Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
