package com.human.fabric.data.lang.en_us.provider;

import com.human.common.data.HumanTooltipTranslationKeys;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;

import java.util.function.Consumer;

public class EnUsTooltipProvider {

    public static final Consumer<FabricLanguageProvider.TranslationBuilder> CONSUMER = builder -> {
        builder.add("tooltip.avp.accuracy", "Accuracy: ");
        builder.add("tooltip.avp.ammunition", "Ammo: ");
        builder.add("tooltip.avp.ammunition_type", "Fires: ");
        builder.add("tooltip.avp.damage", "Damage: ");
        builder.add("tooltip.avp.fire_mode", "Fire Mode: ");
        builder.add("tooltip.avp.fire_rate", "Fire Rate: ");
        builder.add("tooltip.avp.knockback", "Knockback: ");
        builder.add("tooltip.avp.recoil", "Recoil: ");
        builder.add("tooltip.avp.capacity", "Capacity: ");

        builder.add(HumanTooltipTranslationKeys.EFFECT_AUTO_EQUIP_ARMOR_SET, "Auto-Equips Armor Sets");
        builder.add(HumanTooltipTranslationKeys.EFFECT_AUTO_EQUIP_ARMOR_STAND_ARMOR_SET, "Auto-Equips Armor Stand Armor Sets");
        builder.add(HumanTooltipTranslationKeys.EFFECT_AUTO_STORE_IRRADIATED_ITEMS, "Irradiated Items Auto-Stored in Chest");
        builder.add(HumanTooltipTranslationKeys.EFFECT_GUNS_AUTO_RELOAD_FROM_CHEST, "Guns Auto-Reload Ammo from Chest");
        builder.add(HumanTooltipTranslationKeys.EFFECT_NEARBY_TURRETS_USE_AMMO_FROM_CHEST, "Nearby Turrets use Ammo from Chest");
        builder.add(HumanTooltipTranslationKeys.EFFECT_RADIATION_RESISTANCE, "Radiation Resistance");

        builder.add(HumanTooltipTranslationKeys.REQUIRES_REDSTONE_POWER, "Redstone Power");
        builder.add(HumanTooltipTranslationKeys.REQUIRES_NEARBY_AMMO_CHEST_WITH_AMMO, "Nearby Ammo Chest with Medium Bullets");
    };
}
