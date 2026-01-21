package com.human.mixin;

import com.blib.common.gameplay.util.BLibEntityPredicates;
import com.human.common.gameplay.effect.RadiationStatusEffect;
import com.human.common.registry.init.HumanMobEffects;
import com.human.common.registry.tag.HumanEntityTypeTags;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Handles radiation damage and side effects based on effect duration progress.
 * <p>
 * Phases based on progress through the effect:
 * <ul>
 * <li><b>Incubation (0-20%):</b> No damage, no side effects</li>
 * <li><b>Ramp-up (20-80%):</b> Damage frequency increases</li>
 * <li><b>Taper-off (80-100%):</b> Damage frequency decreases</li>
 * </ul>
 */
@Mixin(LivingEntity.class)
public abstract class MixinLivingEntity_RadiationDamage extends Entity {

    @Unique
    private static final String NBT_INITIAL_RADIATION_DURATION = "initialRadiationDuration";

    @Unique
    private int avp_human$initialRadiationDuration = 0;

    protected MixinLivingEntity_RadiationDamage(EntityType<?> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(at = @At("TAIL"), method = "addAdditionalSaveData")
    private void avp_human$saveRadiationData(CompoundTag tag, CallbackInfo ci) {
        if (avp_human$initialRadiationDuration > 0) {
            tag.putInt(NBT_INITIAL_RADIATION_DURATION, avp_human$initialRadiationDuration);
        }
    }

    @Inject(at = @At("TAIL"), method = "readAdditionalSaveData")
    private void avp_human$loadRadiationData(CompoundTag tag, CallbackInfo ci) {
        if (tag.contains(NBT_INITIAL_RADIATION_DURATION)) {
            avp_human$initialRadiationDuration = tag.getInt(NBT_INITIAL_RADIATION_DURATION);
        }
    }

    @Inject(at = @At("HEAD"), method = "tick")
    private void avp_human$tickRadiation(CallbackInfo ci) {
        var self = LivingEntity.class.cast(this);

        if (self.level().isClientSide()) {
            return;
        }

        var effectInstance = self.getEffect(HumanMobEffects.getRadiationHolder());

        if (effectInstance == null) {
            avp_human$initialRadiationDuration = 0;
            return;
        }

        if (
            BLibEntityPredicates.isInvulnerable(self)
                || self.getType().is(HumanEntityTypeTags.RADIATION_RESISTANT)
        ) {
            self.removeEffect(HumanMobEffects.getRadiationHolder());
            avp_human$initialRadiationDuration = 0;
            return;
        }

        var remainingDuration = effectInstance.getDuration();

        if (avp_human$initialRadiationDuration == 0 || remainingDuration > avp_human$initialRadiationDuration) {
            avp_human$initialRadiationDuration = remainingDuration;
        }

        var progress = 1.0f - ((float) remainingDuration / avp_human$initialRadiationDuration);
        progress = Math.clamp(progress, 0.0f, 1.0f);

        if (progress < RadiationStatusEffect.INCUBATION_RATIO) {
            return;
        }

        var amplifier = effectInstance.getAmplifier();
        RadiationStatusEffect.applyRadiationSideEffects(self, amplifier);

        var damageInterval = RadiationStatusEffect.calculateDamageInterval(progress);

        if (self.tickCount % damageInterval == 0) {
            var damage = RadiationStatusEffect.BASE_DAMAGE + (amplifier * RadiationStatusEffect.DAMAGE_PER_AMPLIFIER);
            self.hurt(RadiationStatusEffect.createRadiationDamageSource(self), damage);
        }
    }
}
