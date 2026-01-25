package com.human.mixin;

import com.blib.api.common.entity.v1.BLibEntityPredicates;
import com.human.common.registry.tag.HumanItemTags;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity_ApplyArmorEffects extends Entity {

    @Shadow
    protected abstract int increaseAirSupply(int airSupply);

    protected MixinLivingEntity_ApplyArmorEffects(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("HEAD"), method = "tick")
    public void tick(CallbackInfo callbackInfo) {
        var self = LivingEntity.class.cast(this);

        var supplyAir = false;

        if (isWearingFullMK50SuitArmor(self)) {
            self.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 5, 0, true, false, true));
            supplyAir = true;
        } else if (isWearingFullPressureSuitArmor(self)) {
            supplyAir = true;
        }

        if (supplyAir) {
            setAirSupply(increaseAirSupply(getAirSupply()));
        }
    }

    @Unique
    private boolean isWearingFullMK50SuitArmor(LivingEntity self) {
        return BLibEntityPredicates.hasFullArmorSetMatching(self, (itemStack -> itemStack.is(HumanItemTags.MK50_ARMOR)));
    }

    @Unique
    private boolean isWearingFullPressureSuitArmor(LivingEntity self) {
        return BLibEntityPredicates.hasFullArmorSetMatching(self, (itemStack -> itemStack.is(HumanItemTags.PRESSURE_ARMOR)));
    }
}
