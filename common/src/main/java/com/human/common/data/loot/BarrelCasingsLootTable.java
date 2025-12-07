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

public class BarrelCasingsLootTable {

    public static final Function<HolderLookup.Provider, LootTable.Builder> LOOT_TABLE = provider -> LootTable.lootTable()
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.BRASS_NUGGET.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))
                        .setWeight(20)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.STEEL_NUGGET.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8)))
                        .setWeight(35)
                )
        );
}
