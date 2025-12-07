package com.human.neoforge.service;

import com.human.common.gameplay.item.gun.GunConfig;
import com.human.neoforge.common.item.NeoForgeGunItem;
import com.human.neoforge.common.item.NeoForgeOldPainlessItem;
import com.human.service.HumanFactoryService;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class NeoForgeHumanFactoryService implements HumanFactoryService {

    @Override
    public Supplier<Item> createGunSupplier(GunConfig gunConfig) {
        return () -> new NeoForgeGunItem(gunConfig);
    }

    @Override
    public Supplier<Item> createOldPainlessSupplier() {
        return NeoForgeOldPainlessItem::new;
    }
}
