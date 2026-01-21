package com.human.mixin;

import com.human.common.registry.init.HumanMobEffects;
import com.human.common.registry.tag.HumanItemTags;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Item.class)
public class MixinItem_RemoveRads {

    @Inject(method = "finishUsingItem", at = @At("HEAD"))
    private void removeRadiationEffectWhenUsingGoldenApple(
        ItemStack stack,
        Level level,
        LivingEntity livingEntity,
        CallbackInfoReturnable<ItemStack> cir
    ) {
        if (stack.is(HumanItemTags.RADIATION_CURE_ITEMS) && livingEntity.hasEffect(HumanMobEffects.getRadiationHolder())) {
            livingEntity.removeEffect(HumanMobEffects.getRadiationHolder());
        }
    }

}
