package com.human.common.config;

import com.blib.common.constant.PlayerStatConstants;
import com.blib.config.BLibConfigs;
import com.human.Human;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import mod.azure.azurelib.common.config.Config;
import mod.azure.azurelib.common.config.Configurable;
import mod.azure.azurelib.common.config.format.ConfigFormats;

@Config(id = Human.MOD_ID)
public class HumanConfig {

    public static HumanConfig INSTANCE;

    public static void initialize() {
        INSTANCE = BLibConfigs.register(HumanConfig.class, ConfigFormats.json()).getConfigInstance();
    }

    @Configurable
    @Configurable.Synchronized
    @Configurable.Comment("Controls the settings of the various blocks")
    public BlockConfigs blockConfigs = new BlockConfigs();

    public static class BlockConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment({ "Resonator will replace every time this value is met", "1 second is 20 ticks. Default of 30 seconds" })
        public int RESONATOR_REPLACE_TICKS = 600;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("Radius in blocks a Resonator will look for resin blocks")
        public int RESONATOR_REPLACE_RADIUS = 25;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("If enabled, nukes will explode.")
        public boolean ENABLE_NUKE_BLOCK_MECHS = false;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("FOV range that turrets can target")
        public int TURRET_FOV = 45;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("Block range that turrets can target")
        public int TURRET_RANGE = 32;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("Turret damage value")
        public float TURRET_DAMAGE = 2F;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("Block radius that a turret looks for an ammo chest")
        public int TURRET_AMMO_CHEST_SEARCH_RANGE = 5;

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("Block radius that a trip mine looks for a living entity")
        public double TRIP_MINE_SEARCH_RADIUS = 2;
    }

    @Configurable
    @Configurable.Synchronized
    @Configurable.Comment("Controls the Mobs Spawn Settings")
    public SpawnConfigs spawnConfigs = new SpawnConfigs();

    public static class SpawnConfigs {

        public SpawnSettings MARINE_SPAWN = new SpawnSettings(true, 1, 1, 1);

        public static class SpawnSettings {

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("If true, spawning is enabled.")
            public boolean enabled;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The minimum group size for this entity's spawn.")
            public int minGroupSize;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The maximum group size for this entity's spawn.")
            public int maxGroupSize;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The spawn weight for this entity.")
            public int weight;

            public SpawnSettings(
                boolean enabled,
                int minGroupSize,
                int maxGroupSize,
                int weight
            ) {
                this.enabled = enabled;
                this.minGroupSize = minGroupSize;
                this.maxGroupSize = maxGroupSize;
                this.weight = weight;
            }
        }
    }

    @Configurable
    @Configurable.Synchronized
    @Configurable.Comment("Controls the Mobs Stats")
    public StatsConfigs statsConfigs = new StatsConfigs();

    public static class StatsConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("Modifying any of these will require restarting the game.")
        public AdvancedStats MARINE_STATS = new AdvancedStats(
            PlayerStatConstants.BASE_HEALTH,
            Marine.ATTACK_DAMAGE,
            0.0f,
            0.0f,
            PlayerStatConstants.BASE_SPRINT_JUMP_SPEED,
            Marine.ARMOR,
            0.0f,
            0,
            Marine.FOLLOW_RANGE
        );

        public static class AdvancedStats {

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's health.")
            public float health;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's attack damage.")
            public float attackDamage;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The amount of health the entity regenerates per second.")
            public float healthRegenPerSecond;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's knockback resistance.")
            public float knockbackResistance;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's movement speed.")
            public float moveSpeed;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's armor value.")
            public float armor;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's armor toughness.")
            public float armorToughness;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's nest tick rate.")
            public int nestTickrate;

            @Configurable
            @Configurable.Synchronized
            @Configurable.Comment("The entity's max follow range.")
            public float followRange;

            public AdvancedStats(
                float health,
                float attackDamage,
                float healthRegenPerSecond,
                float knockbackResistance,
                float moveSpeed,
                float armor,
                float armorToughness,
                int nestTickrate,
                float followRange
            ) {
                this.health = health;
                this.attackDamage = attackDamage;
                this.healthRegenPerSecond = healthRegenPerSecond;
                this.knockbackResistance = knockbackResistance;
                this.moveSpeed = moveSpeed;
                this.armor = armor;
                this.nestTickrate = nestTickrate;
                this.armorToughness = armorToughness;
                this.followRange = followRange;
            }
        }
    }

    @Configurable
    @Configurable.Synchronized
    public WeaponConfigs weaponConfigs = new WeaponConfigs();

    public static class WeaponConfigs {

        @Configurable
        @Configurable.Synchronized
        @Configurable.Comment("If enabled, bullets from guns will damage blocks.")
        public boolean BULLETS_DAMAGE_BLOCKS_ENABLED = true;
    }
}
