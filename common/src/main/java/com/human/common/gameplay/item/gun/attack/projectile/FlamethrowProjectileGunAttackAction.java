package com.human.common.gameplay.item.gun.attack.projectile;

import com.blib.common.gameplay.util.EnchantmentUtil;
import com.blib.service.BLibServices;
import com.human.common.gameplay.entity.projectile.Flamethrow;
import com.human.common.gameplay.item.gun.attack.GunAttackAction;
import com.human.common.gameplay.item.gun.attack.GunAttackConfig;
import com.human.common.gameplay.item.gun.pipeline.GunShootResult;
import com.human.common.network.packet.S2CGunRecoilPayload;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.enchantment.Enchantments;

public class FlamethrowProjectileGunAttackAction implements GunAttackAction {

    public static final FlamethrowProjectileGunAttackAction INSTANCE = new FlamethrowProjectileGunAttackAction();

    private FlamethrowProjectileGunAttackAction() {}

    @Override
    public GunShootResult shoot(GunAttackConfig gunAttackConfig) {
        var shooter = gunAttackConfig.shooter();
        var level = shooter.level();

        if (level.isClientSide) {
            // Flamethrow projectile shots do nothing on the client-side.
            return GunShootResult.FAILURE;
        }

        var flamethrow = new Flamethrow(level, shooter);
        flamethrow.setEnhanced(EnchantmentUtil.getLevel(level, gunAttackConfig.gunItemStack(), Enchantments.FLAME) > 0);
        flamethrow.shootFromRotation(shooter, shooter.getXRot(), shooter.getYRot(), 0.0F, 1.5F, 1.0F);

        if (shooter instanceof ServerPlayer serverPlayer) {
            BLibServices.SERVER_NETWORKING.sendToClient(serverPlayer, new S2CGunRecoilPayload(gunAttackConfig.fireModeConfig().recoil()));
        }

        level.addFreshEntity(flamethrow);

        return GunShootResult.SHOT;
    }
}
