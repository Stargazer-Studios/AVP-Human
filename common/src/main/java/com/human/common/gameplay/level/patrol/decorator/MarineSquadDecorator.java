package com.human.common.gameplay.level.patrol.decorator;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import net.minecraft.world.level.Level;

import java.util.List;

public interface MarineSquadDecorator {

    void decorate(Level level, List<Marine> marines);
}
