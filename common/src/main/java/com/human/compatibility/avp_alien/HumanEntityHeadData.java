package com.human.compatibility.avp_alien;

import com.alien.client.render.entity.head.EntityHeadData;
import net.minecraft.world.phys.Vec3;

public class HumanEntityHeadData {

    private static final double MULTIPLIER = 1 / 16.0;

    public static final EntityHeadData MARINE = adjust(vec3(8, 8, 8), vec3(-4, 24, -4), vec3(0, 24, 0));

    private static EntityHeadData adjust(Vec3 size, Vec3 position, Vec3 pivot) {
        var adjustedSize = size.multiply(MULTIPLIER, MULTIPLIER, MULTIPLIER);
        var adjustedPosition = position.multiply(MULTIPLIER, MULTIPLIER, MULTIPLIER);
        var adjustedPivot = pivot.multiply(MULTIPLIER, MULTIPLIER, MULTIPLIER);

        return new EntityHeadData(adjustedSize, adjustedPosition, adjustedPivot);
    }

    private static Vec3 vec3(double x, double y, double z) {
        return new Vec3(x, y, z);
    }
}
