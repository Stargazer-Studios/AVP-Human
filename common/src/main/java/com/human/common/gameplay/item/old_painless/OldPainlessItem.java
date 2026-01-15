package com.human.common.gameplay.item.old_painless;

import com.human.common.gameplay.item.GunItem;
import com.human.common.gameplay.item.gun.GunData;
import com.human.common.gameplay.item.gun.animation.dispatcher.impl.OldPainlessAnimationDispatcher;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class OldPainlessItem extends GunItem {

    public OldPainlessItem() {
        super(GunData.OLD_PAINLESS);
    }

    @Override
    public void onUseTick(@NotNull Level level, @NotNull LivingEntity livingEntity, @NotNull ItemStack itemStack, int tickCountdown) {
        var tickProgress = Math.abs(START_TICK_PROGRESS - tickCountdown);
        var isFirstTick = tickProgress == 0;

        if (isFirstTick) {
            OldPainlessAnimationDispatcher.INSTANCE.spinUp(livingEntity, itemStack);
        }

        super.onUseTick(level, livingEntity, itemStack, tickCountdown);
    }

    @Override
    public void releaseUsing(@NotNull ItemStack itemStack, @NotNull Level level, @NotNull LivingEntity livingEntity, int i) {
        var fireModeConfig = getGunConfig().getDefaultFireMode();
        var shootFinishSoundEvent = fireModeConfig.shootFinishSoundEvent();

        if (shootFinishSoundEvent != null) {
            OldPainlessAnimationDispatcher.INSTANCE.spinDown(livingEntity, itemStack);
        }

        super.releaseUsing(itemStack, level, livingEntity, i);
    }

    @Override
    protected void playUseAnimations(Entity shooter, ItemStack itemStack) {
        OldPainlessAnimationDispatcher.INSTANCE.spinLoop(shooter, itemStack);
    }
}
