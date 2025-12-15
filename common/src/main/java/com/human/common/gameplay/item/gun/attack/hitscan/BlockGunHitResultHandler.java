package com.human.common.gameplay.item.gun.attack.hitscan;

import com.blib.common.data.tag.BLibBlockTags;
import com.blib.common.gameplay.util.EnchantmentUtil;
import com.blib.server.BlockBreakProgressManager;
import com.blib.service.BLibServices;
import com.human.Human;
import com.human.common.config.HumanConfig;
import com.human.common.gameplay.item.gun.attack.GunAttackConfig;
import com.human.common.gameplay.item.gun.attack.GunHitResult;
import com.human.common.network.packet.S2CBulletHitBlockPayload;
import com.human.common.registry.init.HumanSoundEvents;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;

public class BlockGunHitResultHandler {

    public static void handle(GunAttackConfig gunAttackConfig, GunHitResult.Block gunHitResult) {
        var blockPos = gunHitResult.blockPos();
        var direction = gunHitResult.direction();
        var level = gunAttackConfig.shooter().level();
        var blockState = level.getBlockState(blockPos);
        var soundType = blockState.getSoundType();

        var ricochetSoundEvent = getRicochetSoundForSoundType(soundType);
        level.playSound(null, blockPos, ricochetSoundEvent, SoundSource.BLOCKS);

        damageBlock(gunAttackConfig, level, blockPos, blockState);

        var payload = new S2CBulletHitBlockPayload(blockPos, direction);
        BLibServices.SERVER_NETWORKING.sendToAllClients(level.getServer(), payload);
    }

    private static SoundEvent getRicochetSoundForSoundType(SoundType soundType) {
        SoundEvent ricochetSfx;

        if (soundType == SoundType.GLASS) {
            ricochetSfx = HumanSoundEvents.WEAPON_FX_RICOCHET_GLASS.get();
        } else if (soundType == SoundType.GRAVEL) {
            ricochetSfx = HumanSoundEvents.WEAPON_FX_RICOCHET_DIRT.get();
        } else if (soundType == SoundType.METAL) {
            ricochetSfx = HumanSoundEvents.WEAPON_FX_RICOCHET_METAL.get();
        } else {
            ricochetSfx = HumanSoundEvents.WEAPON_FX_RICOCHET_GENERIC.get();
        }
        return ricochetSfx;
    }

    private static void damageBlock(GunAttackConfig gunAttackConfig, Level level, BlockPos blockPos, BlockState blockState) {
        if (
            !HumanConfig.INSTANCE.weaponConfigs.BULLETS_DAMAGE_BLOCKS_ENABLED
                || !level.getGameRules().getBoolean(GameRules.RULE_PROJECTILESCANBREAKBLOCKS)
                // Only damage blocks if they should be destroyed.
                || blockState.is(BLibBlockTags.SHOULD_NOT_BE_DESTROYED)
                || (gunAttackConfig.shooter() instanceof Player player
                    && !Human.MOD.events().beforeBlockBreak().dispatcher().invoke(level, player, blockPos, blockState))
        ) {
            return;
        }

        var powerLevel = EnchantmentUtil.getLevel(level, gunAttackConfig.gunItemStack(), Enchantments.POWER);
        var damage = gunAttackConfig.fireModeConfig().damage() * (1 + (0.25F * powerLevel));
        BlockBreakProgressManager.damage(level, blockPos, damage);
    }
}
