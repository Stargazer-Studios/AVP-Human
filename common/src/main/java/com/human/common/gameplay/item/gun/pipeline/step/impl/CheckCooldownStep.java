package com.human.common.gameplay.item.gun.pipeline.step.impl;

import com.human.common.gameplay.item.ItemCooldownUser;
import com.human.common.gameplay.item.gun.pipeline.GunShootContext;
import com.human.common.gameplay.item.gun.pipeline.GunShootResult;
import com.human.common.gameplay.item.gun.pipeline.step.GunShootStep;

public class CheckCooldownStep implements GunShootStep {

    public static final CheckCooldownStep INSTANCE = new CheckCooldownStep();

    private CheckCooldownStep() {}

    @Override
    public GunShootResult apply(GunShootContext context) {
        var shooter = context.shooter();

        var itemCooldowns = ItemCooldownUser.getItemCooldownsOrNull(shooter);

        if (itemCooldowns == null) {
            return GunShootResult.CONTINUE;
        }

        if (itemCooldowns.isOnCooldown(context.gunItem())) {
            return GunShootResult.COOLDOWN;
        }

        return GunShootResult.CONTINUE;
    }
}
