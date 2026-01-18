package com.human.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.OwnableEntity;
import net.minecraft.world.level.EntityGetter;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.UUID;

@Mixin(OwnableEntity.class)
public interface MixinOwnableEntity_NPCOwnerPatch {

    @Shadow
    @Nullable
    UUID getOwnerUUID();

    @Shadow
    EntityGetter level();

    @Inject(at = @At("RETURN"), method = "getOwner", cancellable = true)
    default void getOwner(CallbackInfoReturnable<LivingEntity> callbackInfo) {
        var owner = callbackInfo.getReturnValue();

        if (owner != null) {
            return;
        }

        var ownerUUID = getOwnerUUID();

        if (ownerUUID == null) {
            return;
        }

        if (level() instanceof ServerLevel serverLevel) {
            var entity = serverLevel.getEntity(ownerUUID);
            callbackInfo.setReturnValue(entity instanceof LivingEntity livingEntity ? livingEntity : null);
            callbackInfo.cancel();
        }
    }
}
