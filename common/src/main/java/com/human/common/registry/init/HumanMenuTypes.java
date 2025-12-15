package com.human.common.registry.init;

import com.blib.common.registry.BLibHolder;
import com.blib.common.registry.BLibRegistry;
import com.human.Human;
import com.human.common.gameplay.menu.IndustrialFurnaceMenu;
import com.human.common.gameplay.menu.armor_case.ArmorCaseMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;

public class HumanMenuTypes {

    private static final BLibRegistry<MenuType<?>> REGISTRY = Human.MOD.registries().create(BuiltInRegistries.MENU);

    public static final BLibHolder<MenuType<ArmorCaseMenu>> ARMOR_CASE = register("armor_case", ArmorCaseMenu::new);

    public static final BLibHolder<MenuType<IndustrialFurnaceMenu>> INDUSTRIAL_FURNACE_MENU = register(
        "industrial_furnace_menu",
        IndustrialFurnaceMenu::new
    );

    public static <T extends AbstractContainerMenu> BLibHolder<MenuType<T>> register(String id, MenuType.MenuSupplier<T> supplier) {
        return REGISTRY.createHolder(id, () -> new MenuType<>(supplier, FeatureFlagSet.of()));
    }

    public static void initialize() {
        REGISTRY.registerAll();
    }
}
