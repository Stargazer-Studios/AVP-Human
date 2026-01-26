package com.human.common.property;

import com.blib.api.common.entity.v1.PlayerStatConstants;
import com.blib.api.common.property.v1.BLibPropertySchema;
import com.human.common.gameplay.entity.living.human.marine.Marine;

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
        .apply(HumanPropertySchema::addMarineSpawnProperties)
        .addBlankLine()
        .apply(HumanPropertySchema::addMarineStatsProperties)
        .addBlankLine()
        .addComment("If enabled, bullets from guns will damage blocks.")
        .addProperty(HumanProperties.Weapons.BULLETS_DAMAGE_BLOCKS_ENABLED, true)
        .build();

    private static BLibPropertySchema.Builder addMarineSpawnProperties(BLibPropertySchema.Builder builder) {
        var spawnProperties = HumanProperties.Entities.Marine.SPAWNING;

        return builder
            .addComment("If true, spawning is enabled.")
            .addProperty(spawnProperties.enabled(), true)
            .addComment("The maximum group size for this entity's spawn.")
            .addProperty(spawnProperties.maximumGroupSize(), 1)
            .addComment("The minimum group size for this entity's spawn.")
            .addProperty(spawnProperties.minimumGroupSize(), 1)
            .addComment("The spawn weight for this entity.")
            .addProperty(spawnProperties.weight(), 1);
    }

    private static BLibPropertySchema.Builder addMarineStatsProperties(BLibPropertySchema.Builder builder) {
        var spawnProperties = HumanProperties.Entities.Marine.STATS;

        return builder
            .addComment("The entity's armor value.")
            .addProperty(spawnProperties.armor(), Marine.ARMOR)
            .addComment("The entity's armor toughness.")
            .addProperty(spawnProperties.armorToughness(), 0f)
            .addComment("The entity's attack damage.")
            .addProperty(spawnProperties.attackDamage(), Marine.ATTACK_DAMAGE)
            .addComment("The entity's max follow range.")
            .addProperty(spawnProperties.followRange(), Marine.FOLLOW_RANGE)
            .addComment("The entity's health.")
            .addProperty(spawnProperties.health(), PlayerStatConstants.BASE_HEALTH)
            .addComment("The entity's knockback resistance.")
            .addProperty(spawnProperties.knockbackResistance(), 0f)
            .addComment("The entity's movement speed.")
            .addProperty(spawnProperties.movementSpeed(), PlayerStatConstants.BASE_SPRINT_JUMP_SPEED);
    }

    private HumanPropertySchema() {
        throw new UnsupportedOperationException();
    }
}
