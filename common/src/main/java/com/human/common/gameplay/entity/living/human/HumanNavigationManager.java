package com.human.common.gameplay.entity.living.human;

import com.blib.common.gameplay.entity.ai.goal.WaterMoveControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.level.pathfinder.PathType;

public class HumanNavigationManager {

    private final GroundPathNavigation groundNavigation;

    private final MoveControl groundMoveControl;

    private final WaterBoundPathNavigation waterNavigation;

    private final WaterMoveControl waterMoveControl;

    public HumanNavigationManager(AbstractHuman humanMob, MoveControl moveControl) {
        this.groundMoveControl = moveControl;
        this.groundNavigation = new GroundPathNavigation(humanMob, humanMob.level());

        // Water navigation.
        humanMob.setPathfindingMalus(PathType.WATER, 0.5F);
        this.waterMoveControl = new WaterMoveControl(humanMob);
        this.waterNavigation = new WaterBoundPathNavigation(humanMob, humanMob.level());
    }

    public void switchToGround(AbstractHuman humanMob, int priority, GoalSelector goalSelector) {
        humanMob.setMoveControl(groundMoveControl);
        humanMob.setNavigation(groundNavigation);
    }

    public void switchToWater(AbstractHuman humanMob, int priority, GoalSelector goalSelector) {
        humanMob.setMoveControl(waterMoveControl);
        humanMob.setNavigation(waterNavigation);
    }
}
