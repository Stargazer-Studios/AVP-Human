package com.human.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(Wolf.class)
public abstract class MixinWolf_OwnableEntityPatch extends TamableAnimal {

    protected MixinWolf_OwnableEntityPatch(EntityType<? extends TamableAnimal> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public @Nullable LivingEntity getOwner() {
        var uuid = this.getOwnerUUID();

        if (uuid == null) {
            return null;
        }

        if (level() instanceof ServerLevel serverLevel) {
            var entity = serverLevel.getEntity(uuid);
            return entity instanceof LivingEntity livingEntity ? livingEntity : null;
        }

        return null;
    }
}
