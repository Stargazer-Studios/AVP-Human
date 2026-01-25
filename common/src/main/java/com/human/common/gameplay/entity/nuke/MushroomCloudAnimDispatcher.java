package com.human.common.gameplay.entity.nuke;

import com.blib.azurelib.common.animation.dispatch.command.AzCommand;
import com.blib.azurelib.common.animation.play_behavior.AzPlayBehaviors;

public class MushroomCloudAnimDispatcher {

    private static final AzCommand EXPLODE_COMMAND = AzCommand.create(
        "base_controller",
        "animation.explode",
        AzPlayBehaviors.HOLD_ON_LAST_FRAME
    );

    private MushroomCloudEntity mushroomCloudEntity;

    public MushroomCloudAnimDispatcher(MushroomCloudEntity mushroomCloudEntity) {
        this.mushroomCloudEntity = mushroomCloudEntity;
    }

    public void explode() {
        EXPLODE_COMMAND.sendForEntity(mushroomCloudEntity);
    }
}
