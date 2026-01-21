package com.human.common.registry.init;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.effect.RadiationStatusEffect;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

import java.util.function.Supplier;

public class HumanMobEffects {

    private static final BLibRegistry<MobEffect> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.MOB_EFFECT);

    private static final BLibHolder<MobEffect> RADIATION = create("radiation", RadiationStatusEffect::new);

    public static Holder<MobEffect> getRadiationHolder() {
        return RADIATION.getBackingHolder();
    }

    private static BLibHolder<MobEffect> create(String path, Supplier<MobEffect> mobEffectSupplier) {
        return REGISTRY.createHolder(path, mobEffectSupplier);
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
