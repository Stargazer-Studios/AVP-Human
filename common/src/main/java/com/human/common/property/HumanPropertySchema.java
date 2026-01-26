package com.human.common.property;

import com.blib.api.common.property.v1.BLibPropertySchema;

public class HumanPropertySchema {

    static final BLibPropertySchema SCHEMA = BLibPropertySchema.builder()
        .withPropertyValueAlignment(true)
        .addComment("Radius in blocks a Resonator will look for resin blocks.")
        .addProperty(HumanProperties.Blocks.Resonator.REPLACE_FREQUENCY_IN_TICKS, 600L)
        .addComment("Resonator will replace resin N ticks, where this value is N.")
        .addComment("1 second is 20 ticks. Default of 30 seconds.")
        .addProperty(HumanProperties.Blocks.Resonator.REPLACE_RADIUS_IN_BLOCKS, 25)
        .addBlankLine()
        .addComment("If enabled, nukes will explode on dedicated servers.")
        .addComment("By default, nukes are always enabled on singleplayer.")
        .addProperty(HumanProperties.Blocks.Nuke.ENABLED, false)
        .addBlankLine()
        .addComment("Block radius that a turret looks for an ammo chest.")
        .addProperty(HumanProperties.Blocks.SentryTurret.AMMO_CHEST_RANGE, 5)
        .addComment("Turret damage value.")
        .addProperty(HumanProperties.Blocks.SentryTurret.DAMAGE, 2f)
        .addComment("FOV range that turrets can target.")
        .addProperty(HumanProperties.Blocks.SentryTurret.FOV, 45)
        .addComment("Block range that turrets can target.")
        .addProperty(HumanProperties.Blocks.SentryTurret.RANGE, 32)
        .addBlankLine()
        .addComment("If enabled, bullets from guns will damage blocks.")
        .addProperty(HumanProperties.Weapons.BULLETS_DAMAGE_BLOCKS_ENABLED, true)
        .build();

    private HumanPropertySchema() {
        throw new UnsupportedOperationException();
    }
}
