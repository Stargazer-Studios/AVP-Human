package com.human.common.gameplay.level.patrol.decorator;

import com.human.common.gameplay.entity.living.human.marine.Marine;
import net.minecraft.world.level.Level;

public interface MarineDecorator {

    void decorate(Level level, Marine marine);
}
