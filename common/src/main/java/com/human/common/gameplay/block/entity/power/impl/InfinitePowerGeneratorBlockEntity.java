package com.human.common.gameplay.block.entity.power.impl;

import com.human.common.gameplay.block.entity.power.PowerNodeBlockEntity;
import com.human.common.gameplay.power.PowerNode;
import com.human.common.registry.init.HumanBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class InfinitePowerGeneratorBlockEntity extends PowerNodeBlockEntity implements PowerNode.PowerProducer {

    private static final long INFINITE_POWER = 1_000_000_000;

    public InfinitePowerGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(HumanBlockEntityTypes.INFINITE_POWER_GENERATOR.get(), pos, state);
    }

    @Override
    public long getAvailablePower() {
        return INFINITE_POWER;
    }

    @Override
    public long extractPower(long maxAmount) {
        // Always gives exactly what was requested.
        return maxAmount;
    }
}
