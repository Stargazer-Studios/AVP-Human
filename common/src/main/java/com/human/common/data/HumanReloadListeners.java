package com.human.common.data;

import com.blib.api.common.registry.v1.impl.BLibReloadListenerRegistry;
import com.human.Human;
import net.minecraft.server.packs.resources.PreparableReloadListener;

public class HumanReloadListeners {

    private static final BLibReloadListenerRegistry REGISTRY = Human.MOD.registries().createReloadListenerRegistry();

    public static final PreparableReloadListener GENE_BONUS_DATA_RELOAD_LISTENER = new GeneBonusDataReloadListener();

    public static void initialize() {
        REGISTRY.register(GeneBonusDataReloadListener.DIRECTORY_NAME, GENE_BONUS_DATA_RELOAD_LISTENER);
    }
}
