package com.human.common.gameplay.effect;

import com.blib.api.common.color.v1.Color;
import com.human.common.registry.key.HumanDamageTypeKeys;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;

import java.util.concurrent.TimeUnit;

/**
 * Radiation status effect (display only).
 * <p>
 * This effect serves as a visual indicator of radiation exposure. The actual damage and side effects are handled by
 * {@code MixinLivingEntity_RadiationDamage}.
 * <p>
 * The effect progresses through phases based on remaining duration:
 * <ul>
 * <li><b>Incubation (0-20% progress):</b> No damage, no side effects</li>
 * <li><b>Ramp-up (20-80% progress):</b> Damage frequency increases, side effects applied</li>
 * <li><b>Taper-off (80-100% progress):</b> Damage frequency decreases as effect subsides</li>
 * </ul>
 * <p>
 * The amplifier affects damage amount per hit, not frequency.
 */
public class RadiationStatusEffect extends MobEffect {

    public static final int SHORT_EFFECT_DURATION_IN_TICKS = (int) TimeUnit.MINUTES.toSeconds(1) * 20;

    public static final int MEDIUM_EFFECT_DURATION_IN_TICKS = (int) (TimeUnit.MINUTES.toSeconds(2) + 30) * 20;

    public static final int LONG_EFFECT_DURATION_IN_TICKS = (int) TimeUnit.MINUTES.toSeconds(5) * 20;

    public static final float INCUBATION_RATIO = 0.20f;

    public static final float PEAK_DAMAGE_RATIO = 0.80f;

    public static final float BASE_DAMAGE = 1.0f;

    public static final float DAMAGE_PER_AMPLIFIER = 0.5f;

    public static final int MAX_DAMAGE_INTERVAL_TICKS = 4 * 20;

    public static final int MIN_DAMAGE_INTERVAL_TICKS = 20;

    public RadiationStatusEffect() {
        super(MobEffectCategory.HARMFUL, Color.GREEN.getColor());
    }

    public static int calculateDamageInterval(float progress) {
        float damageIntensity;

        if (progress < RadiationStatusEffect.PEAK_DAMAGE_RATIO) {
            var rampProgress = (progress - RadiationStatusEffect.INCUBATION_RATIO) / (RadiationStatusEffect.PEAK_DAMAGE_RATIO
                - RadiationStatusEffect.INCUBATION_RATIO);
            damageIntensity = rampProgress;
        } else {
            var taperProgress = (progress - RadiationStatusEffect.PEAK_DAMAGE_RATIO) / (1.0f - RadiationStatusEffect.PEAK_DAMAGE_RATIO);
            damageIntensity = 1.0f - taperProgress;
        }

        var interval = (int) (RadiationStatusEffect.MAX_DAMAGE_INTERVAL_TICKS - (damageIntensity
            * (RadiationStatusEffect.MAX_DAMAGE_INTERVAL_TICKS - RadiationStatusEffect.MIN_DAMAGE_INTERVAL_TICKS)));
        return Math.max(RadiationStatusEffect.MIN_DAMAGE_INTERVAL_TICKS, interval);
    }

    public static void applyRadiationSideEffects(LivingEntity entity, int amplifier) {
        handleStatusEffects(entity, amplifier, MobEffects.WEAKNESS, MobEffects.HUNGER);

        if (amplifier >= 1) {
            handleStatusEffects(entity, amplifier, MobEffects.MOVEMENT_SLOWDOWN);
        }

        if (amplifier >= 2) {
            handleStatusEffects(entity, amplifier, MobEffects.BLINDNESS);
        }
    }

    @SafeVarargs
    public static void handleStatusEffects(LivingEntity entity, int amplifier, Holder<MobEffect>... statusEffects) {
        for (var effect : statusEffects) {
            if (!entity.hasEffect(effect)) {
                entity.addEffect(new MobEffectInstance(effect, 5 * 20, amplifier, true, true));
            }
        }
    }

    public static DamageSource createRadiationDamageSource(LivingEntity entity) {
        return new DamageSource(
            entity.registryAccess()
                .registryOrThrow(Registries.DAMAGE_TYPE)
                .getHolderOrThrow(HumanDamageTypeKeys.RADIATION)
        );
    }
}
