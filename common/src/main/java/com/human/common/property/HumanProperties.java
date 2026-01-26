package com.human.common.property;

import com.blib.api.common.property.v1.BLibPropertyKey;
import com.blib.api.common.property.v1.serializer.BLibPropertySerializers;

public class HumanProperties {

    public static class Blocks {

        private static final BLibPropertyKey.Parent BLOCKS = BLibPropertyKey.parent("blocks");

        public static class Nuke {

            private static final BLibPropertyKey.Parent NUKE = BLOCKS.child("nuke");

            public static final BLibPropertyKey.Leaf<Boolean> ENABLED = NUKE.leaf("enabled", BLibPropertySerializers.BOOLEAN);

        }

        public static class Resonator {

            private static final BLibPropertyKey.Parent RESONATOR = BLOCKS.child("resonator");

            public static final BLibPropertyKey.Leaf<Integer> REPLACE_RADIUS_IN_BLOCKS = RESONATOR.leaf(
                "replace_radius",
                BLibPropertySerializers.INT
            );

            public static final BLibPropertyKey.Leaf<Long> REPLACE_FREQUENCY_IN_TICKS = RESONATOR.leaf(
                "replace_ticks",
                BLibPropertySerializers.LONG
            );
        }

        public static class SentryTurret {

            private static final BLibPropertyKey.Parent SENTRY_TURRET = BLOCKS.child("sentry_turret");

            public static final BLibPropertyKey.Leaf<Integer> AMMO_CHEST_RANGE = SENTRY_TURRET.leaf(
                "ammo_chest_range",
                BLibPropertySerializers.INT
            );

            public static final BLibPropertyKey.Leaf<Float> DAMAGE = SENTRY_TURRET.leaf("damage", BLibPropertySerializers.FLOAT);

            public static final BLibPropertyKey.Leaf<Integer> FOV = SENTRY_TURRET.leaf("fov", BLibPropertySerializers.INT);

            public static final BLibPropertyKey.Leaf<Integer> RANGE = SENTRY_TURRET.leaf("range", BLibPropertySerializers.INT);

        }
    }

    public static class Entities {

        private static final BLibPropertyKey.Parent ENTITIES = BLibPropertyKey.parent("entities");

        public static class Marine {

            private static final BLibPropertyKey.Parent MARINE = ENTITIES.child("marine");

            public static final SpawnProperties SPAWNING = SpawnProperties.createFor(MARINE.child("spawning"));

            public static final StatProperties STATS = StatProperties.createFor(MARINE.child("stats"));
        }
    }

    public static class Weapons {

        private static final BLibPropertyKey.Parent WEAPONS = BLibPropertyKey.parent("weapons");

        public static final BLibPropertyKey.Leaf<Boolean> BULLETS_DAMAGE_BLOCKS_ENABLED = WEAPONS.leaf(
            "bullets_damage_blocks_enabled",
            BLibPropertySerializers.BOOLEAN
        );

    }

    public record SpawnProperties(
        BLibPropertyKey.Leaf<Boolean> enabled,
        BLibPropertyKey.Leaf<Integer> maximumGroupSize,
        BLibPropertyKey.Leaf<Integer> minimumGroupSize,
        BLibPropertyKey.Leaf<Integer> weight
    ) {

        public static SpawnProperties createFor(BLibPropertyKey.Parent parent) {
            return new SpawnProperties(
                parent.leaf("enabled", BLibPropertySerializers.BOOLEAN),
                parent.leaf("maximum_group_size", BLibPropertySerializers.INT),
                parent.leaf("mininum_group_size", BLibPropertySerializers.INT),
                parent.leaf("weight", BLibPropertySerializers.INT)
            );
        }
    }

    public record StatProperties(
        BLibPropertyKey.Leaf<Float> armor,
        BLibPropertyKey.Leaf<Float> armorToughness,
        BLibPropertyKey.Leaf<Float> attackDamage,
        BLibPropertyKey.Leaf<Float> followRange,
        BLibPropertyKey.Leaf<Float> health,
        BLibPropertyKey.Leaf<Float> knockbackResistance,
        BLibPropertyKey.Leaf<Float> movementSpeed
    ) {

        public static StatProperties createFor(BLibPropertyKey.Parent parent) {
            return new StatProperties(
                parent.leaf("armor", BLibPropertySerializers.FLOAT),
                parent.leaf("armor_toughness", BLibPropertySerializers.FLOAT),
                parent.leaf("attack_damage", BLibPropertySerializers.FLOAT),
                parent.leaf("follow_range", BLibPropertySerializers.FLOAT),
                parent.leaf("health", BLibPropertySerializers.FLOAT),
                parent.leaf("knockback_resistance", BLibPropertySerializers.FLOAT),
                parent.leaf("movement_speed", BLibPropertySerializers.FLOAT)
            );
        }
    }
}
