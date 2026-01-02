package com.human.common.gameplay.item;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemCooldowns;
import org.jetbrains.annotations.Nullable;

public interface ItemCooldownUser {

    static @Nullable ItemCooldowns getItemCooldownsOrNull(LivingEntity shooter) {
        if (shooter instanceof ItemCooldownUser itemCooldownUser) {
            return itemCooldownUser.getItemCooldowns();
        }

        if (shooter instanceof Player player) {
            return player.getCooldowns();
        }

        return null;
    }

    ItemCooldowns getItemCooldowns();
}
