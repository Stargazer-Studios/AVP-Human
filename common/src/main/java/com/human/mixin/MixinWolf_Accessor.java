package com.human.mixin;

import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.world.entity.animal.Wolf;
import org.jetbrains.annotations.NotNull;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(Wolf.class)
public interface MixinWolf_Accessor {

    @Accessor(value = "DATA_COLLAR_COLOR")
    static @NotNull EntityDataAccessor<Integer> getDataCollarColor() {
        return null;
    }

}
