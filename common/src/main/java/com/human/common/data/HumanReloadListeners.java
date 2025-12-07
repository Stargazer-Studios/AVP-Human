package com.human.common.data;

import com.avp.service.Services;
import net.minecraft.server.packs.resources.PreparableReloadListener;

public class HumanReloadListeners {

    public static final PreparableReloadListener GENE_BONUS_DATA_RELOAD_LISTENER = register(
        GeneBonusDataReloadListener.DIRECTORY_NAME,
        new GeneBonusDataReloadListener()
    );

    private static PreparableReloadListener register(String id, PreparableReloadListener listener) {
        return Services.REGISTRY.registerReloadListener(id, listener);
    }

    public static void initialize() {}
}
