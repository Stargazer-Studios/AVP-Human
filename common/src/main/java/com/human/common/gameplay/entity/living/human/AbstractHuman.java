package com.human.common.gameplay.entity.living.human;

import com.blib.api.common.data_sync.v1.DataAccessor;
import com.blib.api.common.data_sync.v1.model.DataUser;
import com.blib.api.common.entity.v1.MovementAnalyzer;
import com.human.common.property.HumanProperties;
import com.human.common.property.HumanPropertyAccess;
import com.human.common.registry.init.HumanDataSyncKeys;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractHuman extends PathfinderMob implements DataUser {

    public static final int MAX_IDLE_TIME_IN_TICKS = 12 * 20;

    public static final int MIN_IDLE_TIME_IN_TICKS = 7 * 20;

    public static AttributeSupplier.Builder applyFrom(HumanProperties.StatProperties statProperties, AttributeSupplier.Builder builder) {
        builder.add(Attributes.ARMOR, HumanPropertyAccess.INSTANCE.getOrThrow(statProperties.armor()));
        builder.add(Attributes.ARMOR_TOUGHNESS, HumanPropertyAccess.INSTANCE.getOrThrow(statProperties.armorToughness()));
        builder.add(Attributes.ATTACK_DAMAGE, HumanPropertyAccess.INSTANCE.getOrThrow(statProperties.attackDamage()));
        builder.add(Attributes.FOLLOW_RANGE, HumanPropertyAccess.INSTANCE.getOrThrow(statProperties.followRange()));
        builder.add(Attributes.KNOCKBACK_RESISTANCE, HumanPropertyAccess.INSTANCE.getOrThrow(statProperties.knockbackResistance()));
        builder.add(Attributes.MAX_HEALTH, HumanPropertyAccess.INSTANCE.getOrThrow(statProperties.health()));
        builder.add(Attributes.MOVEMENT_SPEED, HumanPropertyAccess.INSTANCE.getOrThrow(statProperties.movementSpeed()));

        return builder;
    }

    public final DataAccessor<Integer> beardVariant;

    public final DataAccessor<Integer> eyeColor;

    public final DataAccessor<Integer> hairColor;

    public final DataAccessor<Integer> hairVariant;

    public final DataAccessor<Boolean> isMale;

    public final DataAccessor<Integer> skinColor;

    public final DataAccessor<Integer> ticksUntilBored;

    protected final MovementAnalyzer movementAnalyzer;

    private final HumanNavigationManager navigationManager;

    private final HumanFeatureManager humanFeatureManager;

    public AbstractHuman(EntityType<? extends PathfinderMob> entityType, Level level) {
        super(entityType, level);

        this.beardVariant = new DataAccessor<>(this, HumanDataSyncKeys.MARINE_BEARD_VARIANT.get());
        this.eyeColor = new DataAccessor<>(this, HumanDataSyncKeys.MARINE_EYE_COLOR.get());
        this.hairColor = new DataAccessor<>(this, HumanDataSyncKeys.MARINE_HAIR_COLOR.get());
        this.hairVariant = new DataAccessor<>(this, HumanDataSyncKeys.MARINE_HAIR_VARIANT.get());
        this.isMale = new DataAccessor<>(this, HumanDataSyncKeys.MARINE_IS_MALE.get());
        this.skinColor = new DataAccessor<>(this, HumanDataSyncKeys.MARINE_SKIN_COLOR.get());

        this.movementAnalyzer = new MovementAnalyzer(this);
        this.navigationManager = new HumanNavigationManager(this, moveControl);
        this.humanFeatureManager = new HumanFeatureManager(this);

        this.ticksUntilBored = new DataAccessor<>(this, HumanDataSyncKeys.MARINE_TICKS_UNTIL_BORED.get());
    }

    public abstract void runAttackAnimations();

    @Override
    public int getAmbientSoundInterval() {
        return 120;
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return SoundEvents.EMPTY;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.GENERIC_DEATH;
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return SoundEvents.GENERIC_HURT;
    }

    @Override
    public void tick() {
        super.tick();
        movementAnalyzer.tick();

        if (!level().isClientSide()) {
            ticksUntilBored.set(Math.max(ticksUntilBored.get() - 1, 0));
        }
    }

    @Override
    public void travel(@NotNull Vec3 vec3) {
        if (isControlledByLocalInstance() && isUnderWater()) {
            moveRelative(0.01F, vec3);
            move(MoverType.SELF, getDeltaMovement());
            setDeltaMovement(getDeltaMovement().scale(0.8));
        } else {
            super.travel(vec3);
        }
    }

    @Override
    public void updateSwimming() {
        if (!level().isClientSide) {
            if (isEffectiveAi() && isUnderWater()) {
                navigationManager.switchToWater(this, 4, goalSelector);
                setSwimming(true);
            } else {
                navigationManager.switchToGround(this, 4, goalSelector);
                setSwimming(false);
            }
        }
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        resetTicksUntilBored();
    }

    public HumanFeatureManager getHumanFeatureManager() {
        return humanFeatureManager;
    }

    public Integer getBeardVariantOrNull() {
        return isMale.get()
            ? beardVariant.get()
            : null;
    }

    public void setBeardVariant(int variantIndex) {
        if (!isMale.get()) {
            return;
        }

        beardVariant.set(variantIndex);
    }

    public int getTicksUntilBored() {
        return ticksUntilBored.get();
    }

    public void resetTicksUntilBored() {
        this.ticksUntilBored.set(getRandom().nextIntBetweenInclusive(MIN_IDLE_TIME_IN_TICKS, MAX_IDLE_TIME_IN_TICKS));
    }

    void setMoveControl(MoveControl moveControl) {
        this.moveControl = moveControl;
    }

    void setNavigation(PathNavigation navigation) {
        this.navigation = navigation;
    }
}
