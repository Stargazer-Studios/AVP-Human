package com.human.common.gameplay.entity.living.human.marine.ai.combat;

import com.blib.api.common.entity.v1.BLibEntityPredicates;
import com.human.common.gameplay.entity.ai.utility.sensor.BestItemSensor;
import com.human.common.gameplay.entity.ai.utility.sensor.EquippedItemSensor;
import com.human.common.gameplay.entity.ai.utility.sensor.ItemInInventorySensor;
import com.human.common.gameplay.entity.ai.utility.sensor.ItemInWorldSensor;
import com.human.common.gameplay.entity.living.human.ai.model.ItemTarget;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategy;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.strategy.WeaponStrategySet;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.sensor.Compose;
import com.just.goap.sensor.Compose2;
import com.just.goap.sensor.Map;
import com.just.goap.sensor.Sensor;
import com.just.goap.sensor.Sensors;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class CombatSensors {

    public static final StateKey.Sensed<List<LivingEntity>> NEARBY_ATTACKABLE_TARGETS_KEY = StateKey.sensed("nearby_attackable_targets");

    public static Map<Marine, List<LivingEntity>> nearbyAttackableTargetsFactory(
        BiPredicate<Marine, LivingEntity> targetPredicate
    ) {
        return Sensors.map(
            NEARBY_ATTACKABLE_TARGETS_KEY,
            marine -> marine.getEntitySenseCache()
                .getByClass(LivingEntity.class)
                .stream()
                .filter(
                    livingEntity -> BLibEntityPredicates.isAlive(livingEntity)
                        && targetPredicate.test(marine, livingEntity)
                )
                .toList()
        );
    }

    public static Compose<Mob, List<LivingEntity>, List<LivingEntity>> NEAREST_ATTACKABLE_TARGETS = Sensors.compose(
        NEARBY_ATTACKABLE_TARGETS_KEY,
        StateKey.sensed("nearest_attackable_targets"),
        (mob, nearbyAttackableTargets) -> nearbyAttackableTargets.stream()
            .sorted(Comparator.comparingDouble(mob::distanceToSqr))
            .toList()
    );

    public static Compose<Mob, List<LivingEntity>, Option<LivingEntity>> NEAREST_ATTACKABLE_TARGET = Sensors.compose(
        NEAREST_ATTACKABLE_TARGETS.key(),
        StateKey.sensed("nearest_attackable_target"),
        (mob, nearestAttackableTargets) -> {
            var targetOption = nearestAttackableTargets.stream()
                .findFirst()
                .<Option<LivingEntity>>map(Option::some)
                .orElse(Option.none());

            targetOption.ifSome(mob::setTarget);

            return targetOption;
        }
    );

    public static final Sensor.Mono<LivingEntity, Option<WeaponStrategyResult<ItemTarget.Equipped>>> BEST_WEAPON_IN_HANDS = Sensors
        .lazyCompose(
            StateKey.sensed("best_weapon_in_hands"),
            EquippedItemSensor.builder(WeaponStrategySet.INSTANCE::getAll, WeaponStrategyResult::new)
                .withEquipmentSlots(new EquipmentSlot[] { EquipmentSlot.MAINHAND, EquipmentSlot.OFFHAND })
                .build()::sense
        );

    public static final Sensor.Mono<Marine, Option<WeaponStrategyResult<ItemTarget.Inventory>>> BEST_WEAPON_IN_INVENTORY =
        Sensors.lazyCompose(
            StateKey.sensed("best_weapon_in_inventory"),
            ItemInInventorySensor.builder(WeaponStrategySet.INSTANCE::getAll, WeaponStrategyResult::new)
                .build()::sense
        );

    public static final Sensor.Mono<Marine, Option<WeaponStrategyResult<ItemTarget.World>>> BEST_WEAPON_IN_WORLD = Sensors
        .lazyCompose(
            StateKey.sensed("best_weapon_in_world"),
            ItemInWorldSensor.builder(WeaponStrategySet.INSTANCE::getAll, WeaponStrategyResult::new)
                .build()::sense
        );

    public static final Sensor.Mono<LivingEntity, Option<WeaponStrategyResult<? extends ItemTarget>>> BEST_WEAPON = Sensors.lazyCompose(
        StateKey.sensed("best_weapon"),
        BestItemSensor.<WeaponStrategy, WeaponStrategyResult<? extends ItemTarget>>builder()
            .withSensor(BEST_WEAPON_IN_HANDS)
            .withSensor(BEST_WEAPON_IN_INVENTORY)
            .withSensor(BEST_WEAPON_IN_WORLD)
            .build()::sense
    );

    public static final Compose2<Marine, Option<WeaponStrategyResult<ItemTarget.Equipped>>, Option<WeaponStrategyResult<ItemTarget.Inventory>>, Boolean> HAS_WEAPON =
        Sensors.compose(
            BEST_WEAPON_IN_HANDS.key(),
            BEST_WEAPON_IN_INVENTORY.key(),
            StateKey.sensed("has_weapon"),
            ($1, equippedWeapon, inventoryWeapon) -> equippedWeapon.isSome()
                || inventoryWeapon.isSome()
        );

    // TODO: We don't need the marine here, GOAP should support this case.
    public static final Compose<Object, Option<WeaponStrategyResult<? extends ItemTarget>>, ItemTarget.Location> BEST_WEAPON_LOCATION =
        Sensors.compose(
            BEST_WEAPON.key(),
            StateKey.sensed("best_weapon_location"),
            ($1, bwOption) -> bwOption.map(result -> result.itemTarget().location()).unwrapOr(ItemTarget.Location.NONE)
        );

    public static final Compose<Mob, Option<LivingEntity>, Boolean> HAS_ATTACK_TARGET = Sensors.compose(
        NEAREST_ATTACKABLE_TARGET.key(),
        StateKey.sensed("has_attack_target"),
        (mob, attackTargetOption) -> attackTargetOption.isSome()
    );

    public static final Compose2<Mob, Option<LivingEntity>, Option<WeaponStrategyResult<ItemTarget.Equipped>>, Boolean> IS_ATTACK_TARGET_IN_RANGE_OF_EQUIPPED_BEST_WEAPON =
        Sensors.compose(
            NEAREST_ATTACKABLE_TARGET.key(),
            BEST_WEAPON_IN_HANDS.key(),
            StateKey.sensed("is_attack_target_in_range_of_equipped_best_weapon"),
            (mob, attackTargetOption, bwOption) -> bwOption.isSomeAnd(weaponStrategyResult -> {
                var itemStackOrNull = mob.getItemBySlot(weaponStrategyResult.itemTarget().equipmentSlot());

                if (attackTargetOption.isNone()) {
                    return false;
                }

                var attackTarget = attackTargetOption.unwrap();
                var rangeInBlocks = weaponStrategyResult.strategy().getRangeForWeapon(mob, itemStackOrNull);
                var rangeInBlocksSqr = rangeInBlocks * rangeInBlocks;

                return mob.distanceToSqr(attackTarget) <= rangeInBlocksSqr;
            })
        );

    public static final Compose<LivingEntity, Option<WeaponStrategyResult<ItemTarget.World>>, Boolean> IS_BEST_WORLD_WEAPON_IN_RANGE =
        Sensors
            .compose(
                BEST_WEAPON_IN_WORLD.key(),
                StateKey.sensed("is_best_world_weapon_in_range"),
                (livingEntity, bwOption) -> bwOption.isSomeAnd(
                    result -> livingEntity.distanceToSqr(result.itemTarget().itemEntity()) < 4
                )
            );

    private CombatSensors() {
        throw new UnsupportedOperationException();
    }
}
