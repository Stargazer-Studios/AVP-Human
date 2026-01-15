package com.human.common.gameplay.item.gun;

import com.human.common.gameplay.item.gun.animation.dispatcher.GunAnimationDispatcher;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

public record GunConfig(
    @Nullable Supplier<ItemLike> ammunitionItemSupplier,
    GunAnimationDispatcher animationDispatcher,
    int durability,
    List<FireModeConfig> fireModeConfigs,
    int maximumAmmunition,
    int reloadAmount,
    int reloadTimeInTicks
) {

    public @NotNull FireModeConfig getDefaultFireMode() {
        return fireModeConfigs.getFirst();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private final List<FireModeConfig> fireModeConfigs;

        private Supplier<ItemLike> ammunitionItemSupplier;

        private GunAnimationDispatcher animationDispatcher;

        private int durability;

        private int maximumAmmunition;

        private int reloadAmount;

        private int reloadTimeInTicks;

        private Builder() {
            this.animationDispatcher = GunAnimationDispatcher.DEFAULT;
            this.fireModeConfigs = new ArrayList<>();
            this.reloadAmount = 1;
        }

        public Builder withAmmunitionItemSupplier(Supplier<ItemLike> ammunitionItemSupplier) {
            this.ammunitionItemSupplier = ammunitionItemSupplier;
            return this;
        }

        public Builder withAnimationDispatcher(GunAnimationDispatcher animationDispatcher) {
            this.animationDispatcher = animationDispatcher;
            return this;
        }

        public Builder withDurability(int durability) {
            this.durability = durability;
            return this;
        }

        public Builder withFireMode(FireModeConfig fireModeConfig) {
            fireModeConfigs.add(fireModeConfig);
            return this;
        }

        public Builder withMaximumAmmunition(int defaultMaxAmmunition) {
            this.maximumAmmunition = defaultMaxAmmunition;
            return this;
        }

        // TODO: Reload data should probably be in an object.
        public Builder withReloadTimeInTicks(int reloadTimeInTicks) {
            this.reloadTimeInTicks = reloadTimeInTicks;
            return this;
        }

        // TODO: Reload data should probably be in an object.
        public Builder withReloadAmount(int reloadAmount) {
            this.reloadAmount = reloadAmount;
            return this;
        }

        public GunConfig build() {
            if (fireModeConfigs.isEmpty()) {
                throw new IllegalStateException("At least 1 fire mode for guns is required.");
            }

            return new GunConfig(
                ammunitionItemSupplier,
                animationDispatcher,
                durability,
                Collections.unmodifiableList(fireModeConfigs),
                maximumAmmunition,
                reloadAmount,
                reloadTimeInTicks
            );
        }
    }
}
