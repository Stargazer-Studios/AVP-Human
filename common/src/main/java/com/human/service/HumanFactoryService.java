package com.human.service;

import com.human.common.gameplay.item.gun.GunConfig;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public interface HumanFactoryService {

    Supplier<Item> createGunSupplier(GunConfig gunConfig);

    Supplier<Item> createOldPainlessSupplier();
}
