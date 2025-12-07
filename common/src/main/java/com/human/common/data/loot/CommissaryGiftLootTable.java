package com.human.common.data.loot;

import com.human.common.registry.init.item.HumanItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.function.Function;

public class CommissaryGiftLootTable {

    public static final Function<HolderLookup.Provider, LootTable.Builder> LOOT_TABLE = provider -> LootTable.lootTable()
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.SMALL_BULLET.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .setWeight(2)
                )
                .add(
                    LootItem.lootTableItem(HumanItems.MEDIUM_BULLET.get())
                        .apply(SetItemCountFunction.setCount(ConstantValue.exactly(1)))
                        .setWeight(1)
                )
        );
}
