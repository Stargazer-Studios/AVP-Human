package com.human.mixin;

import com.human.common.gameplay.item.GeneReaderItem;
import com.human.common.gameplay.item.SyringeItem;
import com.human.common.registry.GeneBonusDataRegistry;
import com.human.common.registry.init.item.HumanItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class MixinEntity_ForceInteractions {

    @Inject(at = @At("HEAD"), method = "interact", cancellable = true)
    public void avp_human$interact(Player player, InteractionHand hand, CallbackInfoReturnable<InteractionResult> cir) {
        var self = Entity.class.cast(this);

        var itemstack = player.getItemInHand(hand);

        if (self instanceof LivingEntity livingSelf) {

            if (avp_human$syringeCheck(itemstack, self) || avp_human$geneReaderCheck(itemstack)) {
                var item = itemstack.getItem();

                if (!livingSelf.level().isClientSide) {
                    if (item instanceof SyringeItem) {
                        SyringeItem.interact(itemstack, player, livingSelf, hand);
                    } else if (item instanceof GeneReaderItem) {
                        GeneReaderItem.interact(itemstack, player, livingSelf, hand);
                    }
                }

                cir.setReturnValue(InteractionResult.sidedSuccess(self.level().isClientSide));
            }
        }
    }

    @Unique
    private static boolean avp_human$syringeCheck(ItemStack itemstack, Entity self) {
        return itemstack.is(HumanItems.SYRINGE.get()) && GeneBonusDataRegistry.has(self.getType());
    }

    @Unique
    private static boolean avp_human$geneReaderCheck(ItemStack itemstack) {
        return itemstack.is(HumanItems.GENE_READER.get());
    }
}
