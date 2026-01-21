package com.human.common.data.loot;

import com.human.mixin.MixinLootContext_Accessor;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

// TODO: Move this to Blib.
public class BLibLootModifier {

    public static BLibLootModifier.Builder builder() {
        return new Builder();
    }

    private final Set<ResourceKey<LootTable>> injectionTargets;

    private final List<LootPool.Builder> poolBuildersToAdd;

    private final LootTable lootTable;

    private BLibLootModifier(Set<ResourceKey<LootTable>> injectionTargets, List<LootPool.Builder> poolBuildersToAdd) {
        this.injectionTargets = Collections.unmodifiableSet(injectionTargets);
        this.poolBuildersToAdd = poolBuildersToAdd;

        var lootTable = LootTable.lootTable();

        poolBuildersToAdd.forEach(lootTable::withPool);

        this.lootTable = lootTable.build();
    }

    public boolean isValidTarget(ResourceKey<LootTable> target) {
        return injectionTargets.contains(target);
    }

    public Set<ResourceKey<LootTable>> getInjectionTargets() {
        return injectionTargets;
    }

    public LootTable getLootTable() {
        return lootTable;
    }

    public List<ItemStack> roll(ResourceLocation resourceLocation, LootContext lootContext) {
        return roll(ResourceKey.create(Registries.LOOT_TABLE, resourceLocation), lootContext);
    }

    public List<ItemStack> roll(ResourceKey<LootTable> key, LootContext lootContext) {
        if (injectionTargets.contains(key)) {
            return lootTable.getRandomItems(((MixinLootContext_Accessor) lootContext).getParams());
        }

        return List.of();
    }

    public void apply(ResourceKey<LootTable> key, LootTable.Builder builder) {
        if (injectionTargets.contains(key)) {
            poolBuildersToAdd.forEach(builder::withPool);
        }
    }

    public static class Builder {

        private final Set<ResourceKey<LootTable>> injectionTargets;

        private final List<LootPool.Builder> poolBuildersToAdd;

        private Builder() {
            this.injectionTargets = new HashSet<>();
            this.poolBuildersToAdd = new ArrayList<>();
        }

        public Builder addPool(Supplier<LootPool.Builder> builderSupplier) {
            return addPool(builderSupplier.get());
        }

        public Builder addPool(LootPool.Builder builder) {
            poolBuildersToAdd.add(builder);
            return this;
        }

        @SafeVarargs
        public final Builder addInjectionTargets(ResourceKey<LootTable>... injectionTargets) {
            Arrays.stream(injectionTargets)
                .forEach(this::addInjectionTarget);

            return this;
        }

        public Builder addInjectionTargets(Collection<ResourceKey<LootTable>> injectionTargets) {
            injectionTargets
                .forEach(this::addInjectionTarget);

            return this;
        }

        public Builder addInjectionTarget(ResourceKey<LootTable> injectionTarget) {
            injectionTargets.add(injectionTarget);
            return this;
        }

        public BLibLootModifier build() {
            return new BLibLootModifier(injectionTargets, poolBuildersToAdd);
        }
    }
}
