package com.human.common.gameplay.entity.living.human.marine.ai;

import com.blib.common.gameplay.goap.GOAPSensors;
import com.human.common.gameplay.entity.ai.goap.HumanGOAPSensors;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.FRIActions;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.FRIGoals;
import com.human.common.gameplay.entity.living.human.marine.ai.acquire_fire_resistance.FRISensors;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatActions;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatGoals;
import com.human.common.gameplay.entity.living.human.marine.ai.combat.CombatSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.EquipBestArmorActions;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.EquipBestArmorGoals;
import com.human.common.gameplay.entity.living.human.marine.ai.equip_best_armor.EquipBestArmorSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.ExtinguishFireActions;
import com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.ExtinguishFireGoals;
import com.human.common.gameplay.entity.living.human.marine.ai.extinguish_fire.ExtinguishFireSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.follow_leader.FollowLeaderActions;
import com.human.common.gameplay.entity.living.human.marine.ai.follow_leader.FollowLeaderGoals;
import com.human.common.gameplay.entity.living.human.marine.ai.follow_leader.FollowLeaderSensors;
import com.human.common.gameplay.entity.living.human.marine.ai.idle.IdleActions;
import com.human.common.gameplay.entity.living.human.marine.ai.idle.IdleGoals;
import com.human.common.gameplay.entity.living.human.marine.ai.idle.IdleSensors;
import com.just.goap.graph.Graph;
import net.minecraft.world.entity.monster.Monster;

public class MarineGOAP {

    public static final Graph<Marine> GRAPH = Graph.<Marine>builder()
        .apply(MarineGOAP::addSensorsPackage)
        .apply(MarineGOAP::addAcquireFireResistancePackage)
        .apply(MarineGOAP::addCombatPackage)
        .apply(MarineGOAP::addEquipBestArmorPackage)
        .apply(MarineGOAP::addExtinguishSelfPackage)
        .apply(MarineGOAP::addSatisfyBoredomPackage)
        .apply(MarineGOAP::addStayCloseToLeaderPackage)
        .build();

    private static void addSensorsPackage(Graph.Builder<Marine> graphBuilder) {
        // Entities.
        graphBuilder.addSensor(GOAPSensors.NEARBY_ENTITIES);
        graphBuilder.addSensor(GOAPSensors.NEARBY_LIVING_ENTITIES);
        graphBuilder.addSensor(GOAPSensors.NEARBY_ITEM_ENTITIES);
        // Environment.
        graphBuilder.addSensor(GOAPSensors.NEARBY_BLOCK_POSITIONS);
        graphBuilder.addSensor(MarineGOAPSensors.IS_CURRENT_BLOCK_POS_REPLACEABLE);
        graphBuilder.addSensor(HumanGOAPSensors.NEARBY_BIOMES);
        graphBuilder.addSensor(HumanGOAPSensors.IS_NEAR_RADIOACTIVE_BIOME);
        graphBuilder.addSensor(GOAPSensors.IS_IN_LAVA);
        graphBuilder.addSensor(GOAPSensors.IS_ON_GROUND);
        graphBuilder.addSensor(GOAPSensors.IS_UNDERWATER);
        // Self state.
        graphBuilder.addSensor(GOAPSensors.FIRE_RESISTANCE_REMAINING_TICKS);
        graphBuilder.addSensor(GOAPSensors.HAS_FIRE_RESISTANCE);
        graphBuilder.addSensor(GOAPSensors.HEALTH_RATIO);
        graphBuilder.addSensor(GOAPSensors.IS_ON_FIRE);
    }

    private static void addAcquireFireResistancePackage(Graph.Builder<Marine> graphBuilder) {
        // The goal we want to complete.
        graphBuilder.addGoal(FRIGoals.ACQUIRE_FIRE_RESISTANCE_GOAL);

        // Actions that can complete the goal.
        graphBuilder.addAction(FRIActions.MOVE_TO_BEST_FRI);
        graphBuilder.addAction(FRIActions.pickUpBestFRIFactory());
        graphBuilder.addAction(FRIActions.equipBestFRIFactory());
        graphBuilder.addAction(FRIActions.USE_BEST_FRI);

        // Used for locating best FRI.
        graphBuilder.addSensor(FRISensors.BEST_FRI);
        graphBuilder.addSensor(FRISensors.BEST_FRI_LOCATION);
        // Used for locating best FRI on self.
        graphBuilder.addSensor(FRISensors.BEST_FRI_IN_HANDS);
        graphBuilder.addSensor(FRISensors.BEST_FRI_IN_INVENTORY);
        // Used for locating best FRI in world.
        graphBuilder.addSensor(FRISensors.BEST_FRI_IN_WORLD);
        graphBuilder.addSensor(FRISensors.IS_BEST_WORLD_FRI_IN_RANGE);
    }

    private static void addCombatPackage(Graph.Builder<Marine> graphBuilder) {
        // The goal we want to complete.
        graphBuilder.addGoal(CombatGoals.HAS_WEAPON_GOAL);
        graphBuilder.addGoal(CombatGoals.NO_ATTACK_TARGET_GOAL);

        // Actions that can complete the goal.
        graphBuilder.addAction(CombatActions.MOVE_TO_BEST_WEAPON);
        graphBuilder.addAction(CombatActions.pickUpBestWeaponFactory());
        graphBuilder.addAction(CombatActions.equipBestWeaponFactory());
        graphBuilder.addAction(CombatActions.MOVE_UNTIL_ATTACK_TARGET_IN_RANGE_FOR_EQUIPPED_BEST_WEAPON_ACTION);
        graphBuilder.addAction(CombatActions.USE_BEST_WEAPON);

        // Used for sensing attackable targets.
        graphBuilder.addSensor(
            CombatSensors.nearbyAttackableTargetsFactory(
                (marine, livingEntity) -> livingEntity instanceof Monster
                    && marine.getSensing().hasLineOfSight(livingEntity)
            )
        );
        // Used for sensing attackable targets in a sorted order based on distance.
        graphBuilder.addSensor(CombatSensors.NEAREST_ATTACKABLE_TARGETS);
        // Used for picking out the closest attackable target.
        graphBuilder.addSensor(CombatSensors.NEAREST_ATTACKABLE_TARGET);
        // Used for locating best weapon.
        graphBuilder.addSensor(CombatSensors.BEST_WEAPON);
        graphBuilder.addSensor(CombatSensors.BEST_WEAPON_LOCATION);
        // Used for locating best weapon on self.
        graphBuilder.addSensor(CombatSensors.BEST_WEAPON_IN_HANDS);
        graphBuilder.addSensor(CombatSensors.BEST_WEAPON_IN_INVENTORY);
        // Used for locating best weapon in world.
        graphBuilder.addSensor(CombatSensors.BEST_WEAPON_IN_WORLD);
        graphBuilder.addSensor(CombatSensors.IS_BEST_WORLD_WEAPON_IN_RANGE);
        // Used for checking if entity has an attack target.
        graphBuilder.addSensor(CombatSensors.HAS_ATTACK_TARGET);
        // Used for checking if the entity has a weapon (either in their inventory or in their hands).
        graphBuilder.addSensor(CombatSensors.HAS_WEAPON);
        // Used for checking if the attack target is in range of the agent's currently equipped best weapon.
        graphBuilder.addSensor(CombatSensors.IS_ATTACK_TARGET_IN_RANGE_OF_EQUIPPED_BEST_WEAPON);
    }

    private static void addEquipBestArmorPackage(Graph.Builder<Marine> graphBuilder) {
        graphBuilder.addGoal(EquipBestArmorGoals.EQUIP_BEST_ARMOR_GOAL);

        graphBuilder.addAction(EquipBestArmorActions.EQUIP_BEST_ARMOR_PIECES_FROM_INVENTORY_ACTION);

        // Best armor set sensor.
        graphBuilder.addSensor(EquipBestArmorSensors.BEST_ARMOR_SET_TARGET);
        graphBuilder.addSensor(EquipBestArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_WORLD);
        graphBuilder.addSensor(EquipBestArmorSensors.IS_ANY_BEST_ARMOR_SET_PIECE_IN_INVENTORY);
        graphBuilder.addSensor(EquipBestArmorSensors.ARE_ALL_BEST_ARMOR_SET_PIECES_EQUIPPED);
        // Full set armor sensors.
        graphBuilder.addSensor(EquipBestArmorSensors.MK50_ARMOR_SET_TARGET);
        graphBuilder.addSensor(EquipBestArmorSensors.NETHER_CHITIN_ARMOR_SET_TARGET);
        graphBuilder.addSensor(EquipBestArmorSensors.PLATED_NETHER_CHITIN_ARMOR_SET_TARGET);
        graphBuilder.addSensor(EquipBestArmorSensors.PRESSURE_SUIT_ARMOR_SET_TARGET);
    }

    private static void addExtinguishSelfPackage(Graph.Builder<Marine> graphBuilder) {
        graphBuilder.addGoal(ExtinguishFireGoals.EXTINGUISH_SELF_GOAL);

        graphBuilder.addAction(ExtinguishFireActions.EQUIP_WATER_BUCKET_ACTION);
        graphBuilder.addAction(ExtinguishFireActions.PLACE_WATER_AT_FEET_ACTION);

        graphBuilder.addSensor(ExtinguishFireSensors.HAS_WATER_BUCKET_EQUIPPED);
        graphBuilder.addSensor(MarineGOAPSensors.IS_IN_ULTRA_WARM_DIMENSION);
        graphBuilder.addSensor(ExtinguishFireSensors.WATER_BUCKET_IN_INVENTORY);
    }

    private static void addSatisfyBoredomPackage(Graph.Builder<Marine> graphBuilder) {
        // The goal we want to complete.
        graphBuilder.addGoal(IdleGoals.SATISFY_BOREDOM_GOAL);

        // Actions that can complete the goal.
        graphBuilder.addAction(IdleActions.WANDER_ACTION);

        // Used for preventing wandering if marine has a leader.
        graphBuilder.addSensor(FollowLeaderSensors.HAS_LEADER);
        // Used for determining when the marine should wander around.
        graphBuilder.addSensor(IdleSensors.IS_BORED);
    }

    private static void addStayCloseToLeaderPackage(Graph.Builder<Marine> graphBuilder) {
        // The goal we want to complete.
        graphBuilder.addGoal(FollowLeaderGoals.STAY_CLOSE_TO_LEADER_GOAL);

        // Actions that can complete the goal.
        graphBuilder.addAction(FollowLeaderActions.MOVE_CLOSER_TO_LEADER_ACTION);

        // Used for determining if the marine is able to follow the leader.
        graphBuilder.addSensor(FollowLeaderSensors.CAN_FOLLOW_LEADER);
        // Used for determining if the marine has a leader to follow.
        graphBuilder.addSensor(FollowLeaderSensors.HAS_LEADER);
        // Used for determining if the marine is too far away from the leader.
        graphBuilder.addSensor(FollowLeaderSensors.IS_CLOSE_TO_LEADER);
    }

    public static void initialize() {}

    private MarineGOAP() {
        throw new UnsupportedOperationException();
    }
}
