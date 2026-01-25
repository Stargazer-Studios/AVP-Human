package com.human.common.registry.init;

import com.blib.api.common.registry.v1.BLibHolder;
import com.blib.api.common.registry.v1.BLibRegistry;
import com.human.Human;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.level.block.Block;

import java.util.HashSet;
import java.util.function.Supplier;

public class HumanVillagerPoiTypes {

    private static final BLibRegistry<PoiType> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.POINT_OF_INTEREST_TYPE);

    public static final BLibHolder<PoiType> COMMISSARY_POI = register("commissary_poi", HumanBlocks.BLUEPRINT_BLOCK, 1, 1);

    private static BLibHolder<PoiType> register(String path, Supplier<Block> blockSupplier, int ticketCount, int searchDistance) {
        return REGISTRY.createHolder(
            path,
            () -> new PoiType(new HashSet<>(blockSupplier.get().getStateDefinition().getPossibleStates()), ticketCount, searchDistance)
        );
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
