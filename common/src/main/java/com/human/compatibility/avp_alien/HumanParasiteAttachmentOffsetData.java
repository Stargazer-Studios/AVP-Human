package com.human.compatibility.avp_alien;

import com.alien.client.render.entity.head.EntityHeadData;
import com.alien.client.render.entity.parasite.attachment.ParasiteHeadAttachmentOffsetData;
import net.minecraft.world.entity.Entity;

public class HumanParasiteAttachmentOffsetData {

    public static final ParasiteHeadAttachmentOffsetData MARINE = new ParasiteHeadAttachmentOffsetData(
        HumanParasiteAttachmentOffsetData::marineVerticalOffset,
        HumanParasiteAttachmentOffsetData::marineFaceOffset
    );

    private static double marineVerticalOffset(EntityHeadData data, Entity parasite) {
        return -data.size().y - (data.size().y / 4);
    }

    private static double marineFaceOffset(EntityHeadData data, Entity parasite) {
        return data.size().z - (data.size().z / 2);
    }

}
