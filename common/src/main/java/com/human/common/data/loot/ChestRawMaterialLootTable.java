package com.human.common.data.loot;

import com.alien.common.registry.init.item.AlienItems;
import com.blib.common.data.loot.condition.item.BLibLootItemModLoadedCondition;
import com.human.common.registry.init.item.HumanItems;
import com.human.compatibility.avp_alien.AVPAlien;
import com.human.compatibility.avp_predator.AVPPredator;
import com.predator.common.registry.init.item.PredatorItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.function.Function;

public class ChestRawMaterialLootTable {

    public static final Function<HolderLookup.Provider, LootTable.Builder> LOOT_TABLE = provider -> LootTable.lootTable()
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.RAW_ZINC.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                        .setWeight(50)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(Items.COPPER_ORE)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                        .setWeight(50)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(Items.RAW_COPPER)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8)))
                        .setWeight(40)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.RAW_ZINC.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(4, 8)))
                        .setWeight(40)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.RAW_BRASS.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 6)))
                        .setWeight(25)
                )
        )
        .withPool(
            LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(HumanItems.RAW_MONAZITE.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(1, 6)))
                        .setWeight(5)
                )
        )
        .withPool(
            LootPool.lootPool()
                .when(BLibLootItemModLoadedCondition.isModLoaded(AVPAlien.MOD.id()))
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(AlienItems.ALIEN_MUSIC_DISC_1_FRAGMENT.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                        .setWeight(5)
                )
        )
        .withPool(
            LootPool.lootPool()
                .when(BLibLootItemModLoadedCondition.isModLoaded(AVPPredator.MOD.id()))
                .setRolls(ConstantValue.exactly(1))
                .add(
                    LootItem.lootTableItem(PredatorItems.PREDATOR_MUSIC_DISC_1_FRAGMENT.get())
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(2, 4)))
                        .setWeight(5)
                )
        );
}
