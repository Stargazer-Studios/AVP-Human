package com.human.mixin_util;

import com.alien.common.util.AcidBleedUtil;
import com.human.common.gameplay.gene.GeneOperationType;
import com.human.common.gameplay.gene.Genes;
import com.human.common.model.GeneCarrier;
import com.human.compatibility.avp_alien.AVPAlien;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

// TODO: Move this to alien module.
public class MixinLivingEntity_GeneCarrier$Compatibility {

    public static <T extends Entity & GeneCarrier> void runAcidicBloodGeneEffects(
        T geneCarryingEntity,
        DamageSource damageSource,
        float damage
    ) {
        if (!AVPAlien.MOD.isLoaded() || !(geneCarryingEntity instanceof LivingEntity livingEntity)) {
            return;
        }

        // TODO: Factor in additive in here.
        var acidBloodChance = geneCarryingEntity.getOrCreateGeneManager()
            .getGeneContainer()
            .getActiveGeneMap()
            .getValue(Genes.ACIDIC_BLOOD, GeneOperationType.MULTIPLICATIVE);

        if (livingEntity.getRandom().nextDouble() < acidBloodChance && damageSource != livingEntity.damageSources().genericKill()) {
            var randomPos = AcidBleedUtil.computeRandomPosFromBoundingBox(livingEntity);
            AcidBleedUtil.spawnAcid(livingEntity, damage, randomPos);
        }
    }
}
