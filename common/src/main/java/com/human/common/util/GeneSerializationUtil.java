package com.human.common.util;

import com.human.Human;
import com.human.common.gameplay.entity.manager.GeneMap;
import com.human.common.gameplay.gene.GeneBonusDataEntry;
import com.human.common.gameplay.gene.GeneModifierKey;
import com.mojang.serialization.Dynamic;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.NbtOps;

public class GeneSerializationUtil {

    public static void loadGeneModifiers(String geneListKey, CompoundTag compoundTag, GeneMap geneMap) {
        if (compoundTag.contains(geneListKey, CompoundTag.TAG_LIST)) {
            var listTag = compoundTag.getList(geneListKey, CompoundTag.TAG_COMPOUND);

            for (var i = 0; i < listTag.size(); i++) {
                var elementTag = listTag.getCompound(i);

                GeneBonusDataEntry.CODEC.parse(new Dynamic<>(NbtOps.INSTANCE, elementTag))
                    .resultOrPartial(Human.LOGGER::error)
                    .ifPresent(entry -> geneMap.add(new GeneModifierKey(entry.id(), entry.operation()), entry.value()));
            }
        }
    }

    public static void saveGeneModifiers(String geneListKey, CompoundTag compoundTag, GeneMap geneMap) {
        var listTag = new ListTag();

        for (var entry : geneMap.getBackingMap().entrySet()) {
            var geneEntry = new GeneBonusDataEntry(entry.getKey().resourceLocation(), entry.getKey().operation(), entry.getValue());
            GeneBonusDataEntry.CODEC.encodeStart(NbtOps.INSTANCE, geneEntry)
                .resultOrPartial(Human.LOGGER::error)
                .ifPresent(listTag::add);
        }

        compoundTag.put(geneListKey, listTag);
    }
}
