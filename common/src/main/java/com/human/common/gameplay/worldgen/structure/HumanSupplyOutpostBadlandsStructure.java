package com.human.common.gameplay.worldgen.structure;

import com.human.common.registry.init.HumanStructureTypes;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.Holder;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pools.StructureTemplatePool;
import org.jetbrains.annotations.NotNull;

public class HumanSupplyOutpostBadlandsStructure extends HumanSupplyOutpostStructure {

    public static final MapCodec<HumanSupplyOutpostBadlandsStructure> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            settingsCodec(instance),
            StructureTemplatePool.CODEC.fieldOf("start_pool").forGetter((structure) -> structure.startPool)
        )
            .apply(instance, HumanSupplyOutpostBadlandsStructure::new)
    );

    public static final String NAME = "outpost_supply_badland";

    public HumanSupplyOutpostBadlandsStructure(StructureSettings structureSettings, Holder<StructureTemplatePool> startPool) {
        super(structureSettings, startPool);
    }

    @Override
    public @NotNull StructureType<?> type() {
        return HumanStructureTypes.SUPPLY_OUTPOST_BADLANDS.get();
    }
}
