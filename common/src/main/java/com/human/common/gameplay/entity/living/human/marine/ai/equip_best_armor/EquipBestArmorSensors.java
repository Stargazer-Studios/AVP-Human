package com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor;

import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.sensor.BestArmorSetTargetSensor;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ArmorSet;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ArmorSetTarget;
import com.human.common.gameplay.entity.living.human.marine.ai.model.ItemTarget;
import com.human.common.gameplay.entity.living.human.marine.ai.util.ItemSenseUtil;
import com.human.common.registry.init.item.HumanArmorItems;
import com.just.goap.StateKey;
import com.just.goap.sensor.Sensor;
import com.just.goap.sensor.Sensors;
import net.minecraft.world.entity.LivingEntity;

public class EquipBestArmorSensors {

    private static final ArmorSet MK50_ARMOR_SET = new ArmorSet(
        HumanArmorItems.MK50_HELMET,
        HumanArmorItems.MK50_CHESTPLATE,
        HumanArmorItems.MK50_LEGGINGS,
        HumanArmorItems.MK50_BOOTS
    );

    // FIXME:
    // private static final ArmorSet NETHER_CHITIN_ARMOR_SET = new ArmorSet(
    // AlienArmorItems.NETHER_CHITIN_HELMET,
    // AlienArmorItems.NETHER_CHITIN_CHESTPLATE,
    // AlienArmorItems.NETHER_CHITIN_LEGGINGS,
    // AlienArmorItems.NETHER_CHITIN_BOOTS
    // );
    //
    // private static final ArmorSet PLATED_NETHER_CHITIN_ARMOR_SET = new ArmorSet(
    // AlienArmorItems.PLATED_NETHER_CHITIN_HELMET,
    // AlienArmorItems.PLATED_NETHER_CHITIN_CHESTPLATE,
    // AlienArmorItems.PLATED_NETHER_CHITIN_LEGGINGS,
    // AlienArmorItems.PLATED_NETHER_CHITIN_BOOTS
    // );

    private static final ArmorSet PRESSURE_SUIT_ARMOR_SET = new ArmorSet(
        HumanArmorItems.PRESSURE_HELMET,
        HumanArmorItems.PRESSURE_CHESTPLATE,
        HumanArmorItems.PRESSURE_LEGGINGS,
        HumanArmorItems.PRESSURE_BOOTS
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> MK50_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("mk50_armor_set"),
        (livingEntity, worldState) -> ItemSenseUtil.findFullArmorSetInWorldState(livingEntity, worldState, MK50_ARMOR_SET)
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> NETHER_CHITIN_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("nether_chitin_armor_set"),
        (livingEntity, worldState) -> ArmorSetTarget.EMPTY
        // FIXME:
        // (livingEntity, worldState) -> getFullArmorSetOrEmpty(livingEntity, worldState, NETHER_CHITIN_ARMOR_SET)
    );

    public static final Sensor.Mono<LivingEntity, ArmorSetTarget> PLATED_NETHER_CHITIN_ARMOR_SET_TARGET = Sensors.lazyCompose(
        StateKey.sensed("plated_nether_chitin_armor_set"),
        (livingEntity, worldState) -> ArmorSetTarget.EMPTY
        // FIXME:
        // (livingEntity, worldState) -> getFullArmorSetOrEmpty(livingEntity, worldState,
        // PLATED_NETHER_CHITIN_ARMOR_SET)
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
