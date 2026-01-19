package com.human.common.gameplay.entity.living.human.ai.model;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.item.ItemEntity;

public sealed interface ItemTarget {

    Location location();

    record Equipped(
        EquipmentSlot equipmentSlot
    ) implements ItemTarget {

        @Override
        public Location location() {
            return Location.EQUIPPED;
        }
    }

    record Inventory(
        BLibInventory.Entry entry
    ) implements ItemTarget {

        @Override
        public Location location() {
            return Location.INVENTORY;
        }
    }

    record World(
        ItemEntity itemEntity
    ) implements ItemTarget {

        @Override
        public Location location() {
            return Location.WORLD;
        }
    }

    enum None implements ItemTarget {

        INSTANCE;

        @Override
        public Location location() {
            return Location.NONE;
        }

        @Override
        public String toString() {
            return "NONE";
        }
    }

    enum Location {
        EQUIPPED,
        INVENTORY,
        WORLD,
        NONE
    }
}
