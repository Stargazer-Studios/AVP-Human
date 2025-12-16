package com.human.common.registry.init.item;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.blib.common.registry.impl.BLibAzureLibIdentityRegistry;
import com.human.Human;
import com.human.common.gameplay.item.gun.GunData;
import com.human.service.HumanServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class HumanGunItems {

    public static final BLibRegistry<Item> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ITEM);

    private static final BLibAzureLibIdentityRegistry IDENTITY_REGISTRY = Human.MOD.registries().createAzureLibIdentityRegistry();

    public static final BLibHolder<Item> F903WE_RIFLE = create(
        "f903we_rifle",
        HumanServices.FACTORY.createGunSupplier(GunData.F903WE_RIFLE)
    );

    public static final BLibHolder<Item> FLAMETHROWER_SEVASTOPOL = create(
        "flamethrower_sevastopol",
        HumanServices.FACTORY.createGunSupplier(GunData.FLAMETHROWER_SEVASTOPOL)
    );

    public static final BLibHolder<Item> M37_12_SHOTGUN = create(
        "m37_12_shotgun",
        HumanServices.FACTORY.createGunSupplier(GunData.M37_12_SHOTGUN)
    );

    public static final BLibHolder<Item> M41A_PULSE_RIFLE = create(
        "m41a_pulse_rifle",
        HumanServices.FACTORY.createGunSupplier(GunData.M41A_PULSE_RIFLE)
    );

    public static final BLibHolder<Item> M42A3_SNIPER_RIFLE = create(
        "m42a3_sniper_rifle",
        HumanServices.FACTORY.createGunSupplier(GunData.M42A3_SNIPER_RIFLE)
    );

    public static final BLibHolder<Item> M4RA_BATTLE_RIFLE = create(
        "m4ra_battle_rifle",
        HumanServices.FACTORY.createGunSupplier(GunData.M4RA_BATTLE_RIFLE)
    );

    public static final BLibHolder<Item> M56_SMARTGUN = create(
        "m56_smartgun",
        HumanServices.FACTORY.createGunSupplier(GunData.M56_SMARTGUN)
    );

    public static final BLibHolder<Item> M6B_ROCKET_LAUNCHER = create(
        "m6b_rocket_launcher",
        HumanServices.FACTORY.createGunSupplier(GunData.M6B_ROCKET_LAUNCHER)
    );

    public static final BLibHolder<Item> M88MOD4_COMBAT_PISTOL = create(
        "m88mod4_combat_pistol",
        HumanServices.FACTORY.createGunSupplier(GunData.M88_MOD_4_COMBAT_PISTOL)
    );

    public static final BLibHolder<Item> OLD_PAINLESS = create(
        "old_painless",
        HumanServices.FACTORY.createOldPainlessSupplier()
    );

    public static final BLibHolder<Item> ZX_76_SHOTGUN = create(
        "zx_76_shotgun",
        HumanServices.FACTORY.createGunSupplier(GunData.ZX_76_SHOTGUN)
    );

    private static BLibHolder<Item> create(String name, Supplier<Item> itemSupplier) {
        return REGISTRY.createHolder(name, itemSupplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
        IDENTITY_REGISTRY.register(F903WE_RIFLE);
        IDENTITY_REGISTRY.register(FLAMETHROWER_SEVASTOPOL);
        IDENTITY_REGISTRY.register(M37_12_SHOTGUN);
        IDENTITY_REGISTRY.register(M41A_PULSE_RIFLE);
        IDENTITY_REGISTRY.register(M42A3_SNIPER_RIFLE);
        IDENTITY_REGISTRY.register(M4RA_BATTLE_RIFLE);
        IDENTITY_REGISTRY.register(M56_SMARTGUN);
        IDENTITY_REGISTRY.register(M6B_ROCKET_LAUNCHER);
        IDENTITY_REGISTRY.register(M88MOD4_COMBAT_PISTOL);
        IDENTITY_REGISTRY.register(OLD_PAINLESS);
        IDENTITY_REGISTRY.register(ZX_76_SHOTGUN);
    }
}
