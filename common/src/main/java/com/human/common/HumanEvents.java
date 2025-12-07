package com.human.common;

import com.human.common.registry.GeneBonusDataRegistry;

public class HumanEvents {

    public static void onTagsUpdated() {
        GeneBonusDataRegistry.rebuildLookupMappings();
    }
}
