package com.human.fabric.data.tag;

import com.avp.common.registry.tag.AVPEntityTypeTags;
import com.human.common.registry.init.HumanEntityTypes;
import com.human.common.registry.tag.HumanEntityTypeTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.entity.EntityType;

import java.util.concurrent.CompletableFuture;

public class HumanEntityTypeTagProvider extends FabricTagProvider.EntityTypeTagProvider {

    public HumanEntityTypeTagProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider wrapperLookup) {
        addHumanoids();
        addRadiationResistant();
    }

    private void addHumanoids() {
        getOrCreateTagBuilder(AVPEntityTypeTags.HUMANOIDS)
            .add(
                HumanEntityTypes.MARINE.get()
            );
    }

    private void addRadiationResistant() {
        getOrCreateTagBuilder(HumanEntityTypeTags.RADIATION_RESISTANT)
            .addOptionalTag(EntityTypeTags.UNDEAD)
            .add(EntityType.CREEPER);
    }
}
