package com.human.fabric.data.tag;

import com.alien.common.registry.tag.AlienEntityTypeTags;
import com.blib.common.data.tag.BLibEntityTypeTags;
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

        // Compatibility
        addHatedByXenomorphs();
        addHosts();
    }

    private void addHumanoids() {
        getOrCreateTagBuilder(BLibEntityTypeTags.HUMANOIDS)
            .add(
                HumanEntityTypes.MARINE.get()
            );
    }

    private void addRadiationResistant() {
        getOrCreateTagBuilder(HumanEntityTypeTags.RADIATION_RESISTANT)
            .addOptionalTag(EntityTypeTags.UNDEAD)
            .add(EntityType.CREEPER);
    }

    private void addHatedByXenomorphs() {
        getOrCreateTagBuilder(AlienEntityTypeTags.HATED_BY_XENOMORPHS)
            .add(HumanEntityTypes.MARINE.get());
    }

    private void addHosts() {
        getOrCreateTagBuilder(AlienEntityTypeTags.HOSTS)
            .add(HumanEntityTypes.MARINE.get());
    }
}
