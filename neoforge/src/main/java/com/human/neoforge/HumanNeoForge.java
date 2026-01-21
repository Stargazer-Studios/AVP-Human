package com.human.neoforge;

import com.human.Human;
import com.human.neoforge.data.loot.modifier.BastionTreasureLootModifier;
import com.human.neoforge.data.loot.modifier.EarlyGameLootModifier;
import com.human.neoforge.data.loot.modifier.EndGameLootModifier;
import com.human.neoforge.data.loot.modifier.MidGameLootModifier;
import com.human.neoforge.data.loot.modifier.NetherBridgeLootModifier;
import com.human.neoforge.data.loot.modifier.VillageLootModifier;
import com.mojang.serialization.MapCodec;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.function.Supplier;

@Mod(Human.MOD_ID)
public class HumanNeoForge {

    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> GLOBAL_LOOT_MODIFIER_SERIALIZERS =
        DeferredRegister.create(NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Human.MOD_ID);

    public static final Supplier<MapCodec<VillageLootModifier>> VILLAGE_LOOT_MODIFIER =
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(VillageLootModifier.NAME, () -> VillageLootModifier.CODEC);

    public static final Supplier<MapCodec<EarlyGameLootModifier>> EARLY_GAME_LOOT_MODIFIER =
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(EarlyGameLootModifier.NAME, () -> EarlyGameLootModifier.CODEC);

    public static final Supplier<MapCodec<MidGameLootModifier>> MID_GAME_LOOT_MODIFIER =
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(MidGameLootModifier.NAME, () -> MidGameLootModifier.CODEC);

    public static final Supplier<MapCodec<EndGameLootModifier>> END_GAME_LOOT_MODIFIER =
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(EndGameLootModifier.NAME, () -> EndGameLootModifier.CODEC);

    public static final Supplier<MapCodec<BastionTreasureLootModifier>> BASTION_TREASURE_LOOT_MODIFIER =
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(BastionTreasureLootModifier.NAME, () -> BastionTreasureLootModifier.CODEC);

    public static final Supplier<MapCodec<NetherBridgeLootModifier>> NETHER_BRIDGE_LOOT_MODIFIER =
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(NetherBridgeLootModifier.NAME, () -> NetherBridgeLootModifier.CODEC);

    public HumanNeoForge(IEventBus modBus) {
        GLOBAL_LOOT_MODIFIER_SERIALIZERS.register(modBus);

        Human.initialize();
    }
}
