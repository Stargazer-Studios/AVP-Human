package com.human.common.registry.init;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import com.human.HumanResources;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

public class HumanSoundEvents {

    private static final BLibRegistry<SoundEvent> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.SOUND_EVENT);

    private static BLibHolder<SoundEvent> create(String path) {
        return REGISTRY.createHolder(path, () -> SoundEvent.createVariableRangeEvent(HumanResources.location(path)));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
