package com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor;

import com.alien.common.registry.init.item.AlienArmorItems;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.ArmorInInventorySensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.ArmorInWorldSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.BestArmorSetTargetSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.BestBootsSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.BestChestplateSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.BestHelmetSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.BestLeggingsSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.EquippedArmorSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.strategy.ArmorStrategyResult;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ArmorSet;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ArmorSetTarget;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.human.common.gameplay.entity.living.human.marine.ai.util.ItemSenseUtil;
import com.human.common.registry.init.item.HumanArmorItems;
import com.human.compatibility.avp_alien.AVPAlien;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.sensor.Sensor;
import com.just.goap.sensor.Sensors;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;

public class EquipBestArmorSensors {

    private static final ArmorSet MK50_ARMOR_SET = new ArmorSet(
        HumanArmorItems.MK50_HELMET,
        HumanArmorItems.MK50_CHESTPLATE,
        HumanArmorItems.MK50_LEGGINGS,
        HumanArmorItems.MK50_BOOTS
    );

    private static final ArmorSet PRESSURE_SUIT_ARMOR_SET = new ArmorSet(
        HumanArmorItems.PRESSURE_HELMET,
        HumanArmorItems.PRESSURE_CHESTPLATE,
        HumanArmorItems.PRESSURE_LEGGINGS,
        HumanArmorItems.PRESSURE_BOOTS
    );

    private static final Option<ArmorSet> NETHER_CHITIN_ARMOR_SET_OPTION = Option.ofNullable(
        AVPAlien.MOD.isLoaded()
            ? new ArmorSet(
                AlienArmorItems.NETHER_CHITIN_HELMET,
                AlienArmorItems.NETHER_CHITIN_CHESTPLATE,
                AlienArmorItems.NETHER_CHITIN_LEGGINGS,
                AlienArmorItems.NETHER_CHITIN_BOOTS
            )
            : null
    );

    private static final Option<ArmorSet> PLATED_NETHER_CHITIN_ARMOR_SET_OPTION = Option.ofNullable(
        AVPAlien.MOD.isLoaded()
            ? new ArmorSet(
                AlienArmorItems.PLATED_NETHER_CHITIN_HELMET,
                AlienArmorItems.PLATED_NETHER_CHITIN_CHESTPLATE,
                AlienArmorItems.PLATED_NETHER_CHITIN_LEGGINGS,
                AlienArmorItems.PLATED_NETHER_CHITIN_BOOTS
            )
            : null
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<? extends ItemTarget>>> BEST_HELMET = Sensors.lazyCompose(
        StateKey.sensed("best_helmet"),
        BestHelmetSensor::sense
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Equipped>>> BEST_HELMET_EQUIPPED = Sensors.lazyCompose(
        StateKey.sensed("best_helmet_equipped"),
        (livingEntity, worldState) -> EquippedArmorSensor.sense(ArmorItem.Type.HELMET, livingEntity, worldState)
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Inventory>>> BEST_HELMET_IN_INVENTORY = Sensors
        .lazyCompose(
            StateKey.sensed("best_helmet_in_inventory"),
            (livingEntity, worldState) -> ArmorInInventorySensor.sense(ArmorItem.Type.HELMET, livingEntity, worldState)
        );

    public static final Sensor.Mono<LivingEntity, Option<ArmorStrategyResult<ItemTarget.World>>> BEST_HELMET_IN_WORLD = Sensors.lazyCompose(
        StateKey.sensed("best_helmet_in_world"),
        (livingEntity, worldState) -> ArmorInWorldSensor.sense(ArmorItem.Type.HELMET, livingEntity, worldState)
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<? extends ItemTarget>>> BEST_CHESTPLATE = Sensors.lazyCompose(
        StateKey.sensed("best_chestplate"),
        BestChestplateSensor::sense
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Equipped>>> BEST_CHESTPLATE_EQUIPPED = Sensors
        .lazyCompose(
            StateKey.sensed("best_chestplate_equipped"),
            (livingEntity, worldState) -> EquippedArmorSensor.sense(ArmorItem.Type.CHESTPLATE, livingEntity, worldState)
        );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Inventory>>> BEST_CHESTPLATE_IN_INVENTORY = Sensors
        .lazyCompose(
            StateKey.sensed("best_chestplate_in_inventory"),
            (livingEntity, worldState) -> ArmorInInventorySensor.sense(ArmorItem.Type.CHESTPLATE, livingEntity, worldState)
        );

    public static final Sensor.Mono<LivingEntity, Option<ArmorStrategyResult<ItemTarget.World>>> BEST_CHESTPLATE_IN_WORLD = Sensors
        .lazyCompose(
            StateKey.sensed("best_chestplate_in_world"),
            (livingEntity, worldState) -> ArmorInWorldSensor.sense(ArmorItem.Type.CHESTPLATE, livingEntity, worldState)
        );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<? extends ItemTarget>>> BEST_LEGGINGS = Sensors.lazyCompose(
        StateKey.sensed("best_leggings"),
        BestLeggingsSensor::sense
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Equipped>>> BEST_LEGGINGS_EQUIPPED = Sensors.lazyCompose(
        StateKey.sensed("best_leggings_equipped"),
        (livingEntity, worldState) -> EquippedArmorSensor.sense(ArmorItem.Type.LEGGINGS, livingEntity, worldState)
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Inventory>>> BEST_LEGGINGS_IN_INVENTORY = Sensors
        .lazyCompose(
            StateKey.sensed("best_leggings_in_inventory"),
            (livingEntity, worldState) -> ArmorInInventorySensor.sense(ArmorItem.Type.LEGGINGS, livingEntity, worldState)
        );

    public static final Sensor.Mono<LivingEntity, Option<ArmorStrategyResult<ItemTarget.World>>> BEST_LEGGINGS_IN_WORLD = Sensors
        .lazyCompose(
            StateKey.sensed("best_leggings_in_world"),
            (livingEntity, worldState) -> ArmorInWorldSensor.sense(ArmorItem.Type.LEGGINGS, livingEntity, worldState)
        );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<? extends ItemTarget>>> BEST_BOOTS = Sensors.lazyCompose(
        StateKey.sensed("best_boots"),
        BestBootsSensor::sense
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Equipped>>> BEST_BOOTS_EQUIPPED = Sensors.lazyCompose(
        StateKey.sensed("best_boots_equipped"),
        (livingEntity, worldState) -> EquippedArmorSensor.sense(ArmorItem.Type.BOOTS, livingEntity, worldState)
    );

    public static final Sensor.Mono<Marine, Option<ArmorStrategyResult<ItemTarget.Inventory>>> BEST_BOOTS_IN_INVENTORY = Sensors
        .lazyCompose(
            StateKey.sensed("best_boots_in_inventory"),
            (livingEntity, worldState) -> ArmorInInventorySensor.sense(ArmorItem.Type.BOOTS, livingEntity, worldState)
        );

    public static final Sensor.Mono<LivingEntity, Option<ArmorStrategyResult<ItemTarget.World>>> BEST_BOOTS_IN_WORLD = Sensors.lazyCompose(
        StateKey.sensed("best_boots_in_world"),
        (livingEntity, worldState) -> ArmorInWorldSensor.sense(ArmorItem.Type.BOOTS, livingEntity, worldState)
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> MK50_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("mk50_armor_set"),
        (livingEntity, worldState) -> ItemSenseUtil.findFullArmorSetInWorldState(livingEntity, worldState, MK50_ARMOR_SET)
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> NETHER_CHITIN_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("nether_chitin_armor_set"),
        (livingEntity, worldState) -> NETHER_CHITIN_ARMOR_SET_OPTION.map(
            armorSet -> ItemSenseUtil.findFullArmorSetInWorldState(livingEntity, worldState, armorSet)
        ).unwrapOr(ArmorSetTarget.EMPTY)
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> PLATED_NETHER_CHITIN_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("plated_nether_chitin_armor_set"),
        (livingEntity, worldState) -> PLATED_NETHER_CHITIN_ARMOR_SET_OPTION.map(
            armorSet -> ItemSenseUtil.findFullArmorSetInWorldState(livingEntity, worldState, armorSet)
        ).unwrapOr(ArmorSetTarget.EMPTY)
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> PRESSURE_SUIT_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("pressure_suit_armor_set"),
        (livingEntity, worldState) -> ItemSenseUtil.findFullArmorSetInWorldState(livingEntity, worldState, PRESSURE_SUIT_ARMOR_SET)
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> BEST_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("best_armor_set"),
        BestArmorSetTargetSensor::sense
    );

    public static final Sensor.Mono<LivingEntity, Boolean> IS_ANY_BEST_ARMOR_SET_PIECE_IN_WORLD = Sensors.compose(
        BEST_ARMOR_SET_TARGET.key(),
        StateKey.sensed("is_any_best_armor_set_piece_in_world"),
        (livingEntity, bestArmorSetTarget) -> bestArmorSetTarget.anyMatch(ItemTarget.Location.WORLD)
    );

    public static final Sensor.Mono<LivingEntity, Boolean> IS_ANY_BEST_ARMOR_SET_PIECE_IN_INVENTORY = Sensors.compose(
        BEST_ARMOR_SET_TARGET.key(),
        StateKey.sensed("is_any_best_armor_set_piece_in_inventory"),
        (livingEntity, bestArmorSetTarget) -> bestArmorSetTarget.anyMatch(ItemTarget.Location.INVENTORY)
    );

    public static final Sensor.Mono<LivingEntity, Boolean> ARE_ALL_BEST_ARMOR_SET_PIECES_EQUIPPED = Sensors.compose(
        BEST_ARMOR_SET_TARGET.key(),
        StateKey.sensed("are_all_best_armor_set_pieces_equipped"),
        (livingEntity, bestArmorSetTarget) -> bestArmorSetTarget.allNoneOrMatch(ItemTarget.Location.EQUIPPED)
    );

    private EquipBestArmorSensors() {
        throw new UnsupportedOperationException();
    }
}
