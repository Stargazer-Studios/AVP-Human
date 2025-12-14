package com.human.mixin;

import com.human.common.gameplay.effect.RadiationStatusEffect;
import com.human.common.registry.init.HumanMobEffects;
import com.human.common.registry.tag.HumanItemTags;
import com.human.util.HumanPredicates;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Item.class)
public class MixinItem_GiveRads {

    @Inject(method = "inventoryTick", at = @At("HEAD"))
    private void giveRads(ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected, CallbackInfo ci) {
        if (
            // Only want to run this logic server-side.
            level.isClientSide()
                // Only run this logic for radiation-emitting items.
                || !stack.is(HumanItemTags.RADIOACTIVE_ITEMS)
                // Only run this logic if the entity can be irradiated.
                || !HumanPredicates.canBeIrradiated(entity)
                // Sanity check + allow compiler to assert entity type to get livingEntity ref access.
                || !(entity instanceof LivingEntity livingEntity)
        ) {
            return;
        }

        // Apply the radiation effect.
        var mobEffectInstance = new MobEffectInstance(
            HumanMobEffects.RADIATION,
            RadiationStatusEffect.EFFECT_DURATION_IN_TICKS,
            0
        );
        livingEntity.addEffect(mobEffectInstance);
    }
}
