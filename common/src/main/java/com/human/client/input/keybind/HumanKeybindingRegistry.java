package com.human.client.input.keybind;

import com.blib.client.model.KeyInteractType;
import com.blib.service.BLibServices;
import com.human.Human;
import com.human.common.model.Crawler;
import com.human.common.network.packet.C2SGunReloadPayload;
import com.human.common.network.packet.C2SPlayerToggleCrawlPayload;
import com.just.core.functional.tuple.Tuple2;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class HumanKeybindingRegistry {

    public static final Supplier<Tuple2<KeyMapping, Consumer<KeyInteractType>>> CRAWL = register(
        "crawl",
        "movement",
        GLFW.GLFW_KEY_LEFT_ALT,
        keyMapping -> {
            var player = Minecraft.getInstance().player;

            if (player != null) {
                var crawler = (Crawler) player;
                var shouldCrawl = keyMapping == KeyInteractType.PRESS;
                crawler.setCrawling(shouldCrawl);
                BLibServices.CLIENT_NETWORKING.sendToServer(new C2SPlayerToggleCrawlPayload(shouldCrawl));
            }
        }
    );

    public static final Supplier<Tuple2<KeyMapping, Consumer<KeyInteractType>>> RELOAD = register(
        "reload",
        "weapons",
        GLFW.GLFW_KEY_R,
        keyMapping -> {
            var player = Minecraft.getInstance().player;

            if (player != null) {
                BLibServices.CLIENT_NETWORKING.sendToServer(C2SGunReloadPayload.INSTANCE);
            }
        }
    );

    private static Supplier<Tuple2<KeyMapping, Consumer<KeyInteractType>>> register(
        String path,
        String category,
        int key,
        Consumer<KeyInteractType> onKeyMappingActivated
    ) {
        return BLibServices.CLIENT_REGISTRY.registerKeyMapping(
            Human.MOD.createResourceLocation(path),
            category,
            key,
            onKeyMappingActivated
        );
    }

    public static void initialize() {}
}
