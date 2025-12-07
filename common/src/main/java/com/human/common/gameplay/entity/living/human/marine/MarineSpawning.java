package com.human.common.gameplay.entity.living.human.marine;

import com.human.common.registry.tag.HumanBlockTags;
import net.minecraft.world.entity.SpawnPlacements;

public class MarineSpawning {

    public static final SpawnPlacements.SpawnPredicate<Marine> PREDICATE = (
        entityType,
        serverLevelAccessor,
        mobSpawnType,
        blockPos,
        randomSource
    ) -> {
        var belowState = serverLevelAccessor.getBlockState(blockPos.below());
        var spawnableBlock = HumanBlockTags.MARINE_SPAWN_BLOCKS;

        return belowState.is(spawnableBlock);
    };
}
