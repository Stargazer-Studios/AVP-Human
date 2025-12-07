package com.human.common.registry.init;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.effect.RadiationStatusEffect;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class HumanMobEffects {

    private static final BLibRegistry<MobEffect> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.MOB_EFFECT);

    public static final BLibHolder<MobEffect> RADIATION = register("radiation", RadiationStatusEffect::new);

    private static BLibHolder<MobEffect> register(String path, Supplier<MobEffect> mobEffectSupplier) {
        return REGISTRY.createHolder(path, mobEffectSupplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
