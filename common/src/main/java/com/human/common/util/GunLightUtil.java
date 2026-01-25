package com.human.common.util;

import com.blib.azurelib.common.util.AzureLibUtil;
import net.minecraft.world.entity.Entity;

public class GunLightUtil {

    public static void spawnLightSource(Entity entity) {
        var lightBlockPos = AzureLibUtil.findFreeSpace(entity.level(), entity.blockPosition(), 2);

        if (entity.level().isClientSide() || lightBlockPos == null) {
            return;
        }

        // FIXME:
        // entity.level().setBlockAndUpdate(lightBlockPos,
        // AzureBlocksRegistry.TICKING_LIGHT_BLOCK.get().defaultBlockState());
    }
}
