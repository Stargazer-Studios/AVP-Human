package com.human.common.model;

import com.human.common.gameplay.entity.manager.GeneManager;
import org.jetbrains.annotations.Nullable;

public interface GeneCarrier {

    GeneManager getOrCreateGeneManager();

    void setGeneManager(@Nullable GeneManager geneManager);
}
