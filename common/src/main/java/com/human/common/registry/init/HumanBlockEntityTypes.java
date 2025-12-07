package com.human.common.registry.init;

import com.blib.BLibHolder;
import com.blib.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.block.entity.AmmoChestBlockEntity;
import com.human.common.gameplay.block.entity.IndustrialFurnaceBlockEntity;
import com.human.common.gameplay.block.entity.LeadChestBlockEntity;
import com.human.common.gameplay.block.entity.power.impl.BatteryBlockEntity;
import com.human.common.gameplay.block.entity.power.impl.DeskTerminalBlockEntity;
import com.human.common.gameplay.block.entity.power.impl.InfinitePowerGeneratorBlockEntity;
import com.human.common.gameplay.block.entity.power.impl.ResonatorBlockEntity;
import com.human.common.gameplay.block.entity.power.impl.SolarPanelBlockEntity;
import com.human.common.gameplay.block.entity.power.impl.ThermalGeneratorBlockEntity;
import com.human.common.gameplay.block.entity.power.impl.WindTurbineBlockEntity;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import java.util.function.Supplier;

public class HumanBlockEntityTypes {

    private static final BLibRegistry<BlockEntityType<?>> REGISTRY = Human.MOD.createRegistry(BuiltInRegistries.BLOCK_ENTITY_TYPE);

    public static final BLibHolder<BlockEntityType<IndustrialFurnaceBlockEntity>> INDUSTRIAL_FURNACE = create(
        "industrial_furnace",
        () -> BlockEntityType.Builder.of(IndustrialFurnaceBlockEntity::new, HumanBlocks.INDUSTRIAL_FURNACE.get())
    );

    public static final BLibHolder<BlockEntityType<InfinitePowerGeneratorBlockEntity>> INFINITE_POWER_GENERATOR = create(
        "infinite_power_generator",
        () -> BlockEntityType.Builder.of(InfinitePowerGeneratorBlockEntity::new, HumanBlocks.INFINITE_POWER_GENERATOR.get())
    );

    public static final BLibHolder<BlockEntityType<LeadChestBlockEntity>> LEAD_CHEST = create(
        "lead_chest",
        () -> BlockEntityType.Builder.of(LeadChestBlockEntity::new, HumanBlocks.LEAD_CHEST.get())
    );

    public static final BLibHolder<BlockEntityType<AmmoChestBlockEntity>> AMMO_CHEST = create(
        "ammo_chest",
        () -> BlockEntityType.Builder.of(AmmoChestBlockEntity::new, HumanBlocks.AMMO_CHEST.get())
    );

    public static final BLibHolder<BlockEntityType<BatteryBlockEntity>> BATTERY = create(
        "battery",
        () -> BlockEntityType.Builder.of(BatteryBlockEntity::new, HumanBlocks.BATTERY.get())
    );

    public static final BLibHolder<BlockEntityType<DeskTerminalBlockEntity>> DESK_TERMINAL = create(
        "desk_terminal",
        () -> BlockEntityType.Builder.of(DeskTerminalBlockEntity::new, HumanBlocks.DESK_TERMINAL_BLOCK.get())
    );

    public static final BLibHolder<BlockEntityType<ResonatorBlockEntity>> RESONATOR = create(
        "resonator",
        () -> BlockEntityType.Builder.of(ResonatorBlockEntity::new, HumanBlocks.RESONATOR_BLOCK.get())
    );

    public static final BLibHolder<BlockEntityType<SolarPanelBlockEntity>> SOLAR_PANEL = create(
        "solar_panel",
        () -> BlockEntityType.Builder.of(SolarPanelBlockEntity::new, HumanBlocks.SOLAR_PANEL.get())
    );

    public static final BLibHolder<BlockEntityType<ThermalGeneratorBlockEntity>> THERMAL_GENERATOR = create(
        "thermal_generator",
        () -> BlockEntityType.Builder.of(ThermalGeneratorBlockEntity::new, HumanBlocks.THERMAL_GENERATOR.get())
    );

    public static final BLibHolder<BlockEntityType<WindTurbineBlockEntity>> WIND_TURBINE = create(
        "wind_turbine",
        () -> BlockEntityType.Builder.of(WindTurbineBlockEntity::new, HumanBlocks.WIND_TURBINE.get())
    );

    private static <T extends BlockEntity> BLibHolder<BlockEntityType<T>> create(
        String path,
        Supplier<BlockEntityType.Builder<T>> builder
    ) {
        return REGISTRY.createHolder(path, () -> builder.get().build(null));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
