package com.human.common.data.loot;

import com.human.common.registry.init.item.HumanItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.Function;

public class AmmoChestBulletsLootTable {

    public static final Function<HolderLookup.Provider, LootTable.Builder> LOOT_TABLE = provider -> LootTable.lootTable()
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.SMALL_BULLET.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 6)))
                        .setWeight(60)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.MEDIUM_BULLET.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 8)))
                        .setWeight(50)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.CASELESS_BULLET.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))
                        .setWeight(45)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.HEAVY_BULLET.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(3, 8)))
                        .setWeight(30)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.SHOTGUN_SHELL.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))
                        .setWeight(25)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.FUEL_TANK.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 3)))
                        .setWeight(15)
                )
        );
}
