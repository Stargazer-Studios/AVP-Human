package com.human.common.registry.init;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.HumanResources;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

public class HumanSoundEvents {

    private static final BLibRegistry<SoundEvent> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.SOUND_EVENT);

    public static final BLibHolder<SoundEvent> ITEM_ARMOR_EQUIP_MK50 = create("item.armor.equip_mk50");

    public static final BLibHolder<SoundEvent> ITEM_ARMOR_EQUIP_PRESSURE = create("item.armor.equip_pressure");

    public static final BLibHolder<SoundEvent> ITEM_ARMOR_EQUIP_STEEL = create("item.armor.equip_steel");

    public static final BLibHolder<SoundEvent> ITEM_ARMOR_EQUIP_TACTICAL = create("item.armor.equip_tactical");

    public static final BLibHolder<SoundEvent> ITEM_ARMOR_EQUIP_TITANIUM = create("item.armor.equip_titanium");

    public static final BLibHolder<SoundEvent> WEAPON_FLAMETHROWER_SEVASTOPOL_RELOAD_FINISH = create(
        "item.weapon.flamethrower_sevastopol.reload_finish"
    );

    public static final BLibHolder<SoundEvent> WEAPON_FLAMETHROWER_SEVASTOPOL_RELOAD_START = create(
        "item.weapon.flamethrower_sevastopol.reload_start"
    );

    public static final BLibHolder<SoundEvent> WEAPON_FLAMETHROWER_SEVASTOPOL_SHOOT = create(
        "item.weapon.flamethrower_sevastopol.shoot"
    );

    public static final BLibHolder<SoundEvent> WEAPON_FX_RICOCHET_DIRT = create("item.weapon.fx.ricochet.dirt");

    public static final BLibHolder<SoundEvent> WEAPON_FX_RICOCHET_GENERIC = create("item.weapon.fx.ricochet.generic");

    public static final BLibHolder<SoundEvent> WEAPON_FX_RICOCHET_GLASS = create("item.weapon.fx.ricochet.glass");

    public static final BLibHolder<SoundEvent> WEAPON_FX_RICOCHET_METAL = create("item.weapon.fx.ricochet.metal");

    public static final BLibHolder<SoundEvent> WEAPON_GENERIC_RELOAD = create("item.weapon.generic.reload");

    public static final BLibHolder<SoundEvent> WEAPON_GENERIC_SHOOT = create("item.weapon.generic.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_GENERIC_SHOOT_FAIL = create("item.weapon.generic.shoot_fail");

    public static final BLibHolder<SoundEvent> WEAPON_M37_12_SHOTGUN_SHOOT = create("item.weapon.m37_12_shotgun.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_M41A_PULSE_RIFLE_SHOOT = create("item.weapon.m41a_pulse_rifle.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_M42A3_SNIPER_RIFLE_SHOOT = create("item.weapon.m42a3_sniper_rifle.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_M4RA_BATTLE_RIFLE_SHOOT = create("item.weapon.m4ra_battle_rifle.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_M56_SMARTGUN_SHOOT = create("item.weapon.m56_smartgun.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_M6B_ROCKET_LAUNCHER_RELOAD_FINISH = create(
        "item.weapon.m6b_rocket_launcher.reload_finish"
    );

    public static final BLibHolder<SoundEvent> WEAPON_M6B_ROCKET_LAUNCHER_RELOAD_START = create(
        "item.weapon.m6b_rocket_launcher.reload_start"
    );

    public static final BLibHolder<SoundEvent> WEAPON_M6B_ROCKET_LAUNCHER_SHOOT = create("item.weapon.m6b_rocket_launcher.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_M88_MOD_4_COMBAT_PISTOL_RELOAD = create(
        "item.weapon.m88_mod_4_combat_pistol.reload"
    );

    public static final BLibHolder<SoundEvent> WEAPON_M88_MOD_4_COMBAT_PISTOL_SHOOT = create(
        "item.weapon.m88_mod_4_combat_pistol.shoot"
    );

    public static final BLibHolder<SoundEvent> WEAPON_OLD_PAINLESS_SHOOT = create("item.weapon.old_painless.shoot");

    public static final BLibHolder<SoundEvent> WEAPON_OLD_PAINLESS_SHOOT_FINISH = create("item.weapon.old_painless.shoot_finish");

    public static final BLibHolder<SoundEvent> WEAPON_OLD_PAINLESS_SHOOT_SPINNING = create(
        "item.weapon.old_painless.shoot_spinning"
    );

    public static final BLibHolder<SoundEvent> WEAPON_OLD_PAINLESS_SHOOT_START = create("item.weapon.old_painless.shoot_start");

    public static final BLibHolder<SoundEvent> WEAPON_ZX_76_SHOTGUN_SHOOT = create("item.weapon.zx_76_shotgun.shoot");

    private static BLibHolder<SoundEvent> create(String path) {
        return REGISTRY.createHolder(path, () -> SoundEvent.createVariableRangeEvent(HumanResources.location(path)));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
