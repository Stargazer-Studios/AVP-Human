package com.human.common.gameplay.block.entity.power.impl;

import com.alien.common.data.AlienVariantTypes;
import com.alien.common.registry.tag.AlienBlockTags;
import com.human.common.gameplay.block.entity.power.PowerConsumerBlockEntity;
import com.human.common.property.HumanProperties;
import com.human.common.property.HumanPropertyAccess;
import com.human.common.registry.init.HumanBlockEntityTypes;
import com.human.compatibility.avp_alien.AVPAlien;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ResonatorBlockEntity extends PowerConsumerBlockEntity {

    private int tickCounter;

    private final ResonatorAnimationDispatcher animationDispatcher;

    private final Map<Item, Integer> resinBallCounts;

    public ResonatorBlockEntity(BlockPos pos, BlockState blockState) {
        super(HumanBlockEntityTypes.RESONATOR.get(), pos, blockState);
        this.tickCounter = 0;
        this.animationDispatcher = new ResonatorAnimationDispatcher();
        this.resinBallCounts = new HashMap<>();
    }

    @Override
    public long getRequestedPower() {
        return 1000;
    }

    @Override
    public void unpoweredTick(Level level, BlockPos blockPos, BlockState blockState) {
        animationDispatcher.unpowered(this);
    }

    @Override
    public void poweredTick(Level level, BlockPos blockPos, BlockState blockState) {
        animationDispatcher.powered(this);

        tickCounter++;

        var tickValue = HumanPropertyAccess.INSTANCE.get(HumanProperties.Blocks.Resonator.REPLACE_FREQUENCY_IN_TICKS);

        if (tickCounter % tickValue != 0) {
            return;
        }

        var radius = HumanPropertyAccess.INSTANCE.get(HumanProperties.Blocks.Resonator.REPLACE_RADIUS_IN_BLOCKS);

        if (!AVPAlien.MOD.isLoaded()) {
            return;
        }

        BlockPos.betweenClosedStream(blockPos.offset(-radius, -radius, -radius), blockPos.offset(radius, radius, radius))
            .forEach(currentPos -> {
                var currentState = level.getBlockState(currentPos);

                AlienVariantTypes.getFor(currentState)
                    .ifSome(alienVariantType -> {
                        // TODO: Use variant-specific tag here.
                        if (currentState.is(AlienBlockTags.RESIN_VEINS)) {
                            level.setBlockAndUpdate(currentPos, Blocks.AIR.defaultBlockState());

                            var resinBallItem = alienVariantType.resinBall().get();
                            addResinBallItem(resinBallItem);

                            setChanged();

                            return;
                        }

                        // TODO: Use variant-specific tag here.
                        if (currentState.is(AlienBlockTags.RESIN)) {
                            // TODO: This is not a safe assumption to make!
                            var replacementBlock = currentPos.getY() <= 0 ? Blocks.DEEPSLATE : Blocks.STONE;

                            level.setBlockAndUpdate(currentPos, replacementBlock.defaultBlockState());

                            var resinBallItem = alienVariantType.resinBall().get();
                            addResinBallItem(resinBallItem);

                            setChanged();
                        }
                    });
            });
    }

    public void addResinBallItem(Item resinBallItem) {
        resinBallCounts.merge(resinBallItem, 1, Integer::sum);
        setChanged();
    }

    public Map<Item, Integer> getResinBallCounts() {
        return Collections.unmodifiableMap(resinBallCounts);
    }

    public void onRightClick(Player player) {
        if (level == null || level.isClientSide) {
            return;
        }

        if (!resinBallCounts.isEmpty()) {
            for (var entry : resinBallCounts.entrySet()) {
                var resinBallItem = entry.getKey();
                var count = entry.getValue();

                if (count > 0) {
                    var resinBallStack = new ItemStack(resinBallItem, count);
                    var resinBallEntity = new ItemEntity(level, player.getX(), player.getY(), player.getZ(), resinBallStack);
                    level.addFreshEntity(resinBallEntity);
                }
            }

            resinBallCounts.clear();
            setChanged();
        }
    }
}
