package com.human.common.registry.init.item;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.item.gun.GunData;
import com.human.service.HumanServices;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

public class HumanGunItems {

    public static final BLibRegistry<Item> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.ITEM);

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
        // FIXME:
        // Services.REGISTRY.registerAzureLibIdentity(F903WE_RIFLE);
        // Services.REGISTRY.registerAzureLibIdentity(FLAMETHROWER_SEVASTOPOL);
        // Services.REGISTRY.registerAzureLibIdentity(M37_12_SHOTGUN);
        // Services.REGISTRY.registerAzureLibIdentity(M41A_PULSE_RIFLE);
        // Services.REGISTRY.registerAzureLibIdentity(M42A3_SNIPER_RIFLE);
        // Services.REGISTRY.registerAzureLibIdentity(M4RA_BATTLE_RIFLE);
        // Services.REGISTRY.registerAzureLibIdentity(M56_SMARTGUN);
        // Services.REGISTRY.registerAzureLibIdentity(M6B_ROCKET_LAUNCHER);
        // Services.REGISTRY.registerAzureLibIdentity(M88MOD4_COMBAT_PISTOL);
        // Services.REGISTRY.registerAzureLibIdentity(OLD_PAINLESS);
        // Services.REGISTRY.registerAzureLibIdentity(ZX_76_SHOTGUN);
    }
}
