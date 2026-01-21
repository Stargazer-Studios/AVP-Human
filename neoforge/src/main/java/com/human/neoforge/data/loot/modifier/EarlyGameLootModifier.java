package com.human.neoforge.data.loot.modifier;

import com.human.common.data.loot.LootTableModifiers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class EarlyGameLootModifier extends LootModifier {

    public static final MapCodec<EarlyGameLootModifier> CODEC = RecordCodecBuilder.mapCodec(
        inst -> LootModifier.codecStart(inst).apply(inst, EarlyGameLootModifier::new)
    );

    public static final String NAME = "early_game_loot_modifier";

    public EarlyGameLootModifier() {
        this(new LootItemCondition[] {});
    }

    protected EarlyGameLootModifier(LootItemCondition[] conditionsIn) {
        super(conditionsIn);
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(
        @NotNull ObjectArrayList<ItemStack> objectArrayList,
        @NotNull LootContext lootContext
    ) {
        objectArrayList.addAll(LootTableModifiers.EARLY_GAME_LOOT_TABLE_MODIFIER.roll(lootContext.getQueriedLootTableId(), lootContext));
        return objectArrayList;
    }

    @Override
    public @NotNull MapCodec<? extends IGlobalLootModifier> codec() {
        return CODEC;
    }
}
