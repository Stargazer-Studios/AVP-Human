package com.human.fabric.service;

import com.human.common.gameplay.item.gun.GunConfig;
import com.human.fabric.common.item.FabricGunItem;
import com.human.fabric.common.item.FabricOldPainlessItem;
import com.human.service.HumanFactoryService;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class FabricHumanFactoryService implements HumanFactoryService {

    @Override
    public Supplier<Item> createGunSupplier(GunConfig gunConfig) {
        return () -> new FabricGunItem(gunConfig);
    }

    @Override
    public Supplier<Item> createOldPainlessSupplier() {
        return FabricOldPainlessItem::new;
    }
}
