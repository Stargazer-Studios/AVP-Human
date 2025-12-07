package com.human.mixin;

import com.human.common.gameplay.item.canister.CanisterItem;
import com.human.common.registry.init.HumanDataComponents;
import com.human.common.registry.init.item.HumanItems;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUtils;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Cow.class)
public abstract class MixinCow_FillMilkCanister extends Animal {

    protected MixinCow_FillMilkCanister(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "mobInteract", at = @At("HEAD"), cancellable = true)
    private void mobInteractMixin(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        var itemStack = player.getItemInHand(hand);

        if (this.isBaby() || !isMilkHoldingCanister(itemStack)) {
            // Cow is a baby, can't be milked regardless of canister item.
            // OR is some canister type other than an empty canister or milk canister, then can't fill with milk.
            return;
        }

        int contentAmount = itemStack.getOrDefault(HumanDataComponents.CANISTER_CAPACITY.get(), 0);

        ItemStack updatedStack;

        if (contentAmount == 0) {
            updatedStack = ItemUtils.createFilledResult(itemStack, player, HumanItems.MILK_CANISTER.get().getDefaultInstance());
        } else if (contentAmount < CanisterItem.MAX_CAPACITY) {
            updatedStack = CanisterItem.updateCapacity(player, itemStack, 1);
        } else {
            cir.setReturnValue(InteractionResult.PASS);
            return;
        }

        player.playSound(SoundEvents.COW_MILK, 1.0F, 1.0F);
        player.setItemInHand(hand, updatedStack);
        cir.setReturnValue(InteractionResult.sidedSuccess(this.level().isClientSide));
    }

    @Unique
    private static boolean isMilkHoldingCanister(ItemStack itemStack) {
        return itemStack.is(HumanItems.CANISTER.get()) || (itemStack.is(HumanItems.MILK_CANISTER.get()));
    }
}
