package com.human.common.gameplay.entity.living.human.marine.ai.place_torch;

import com.blib.common.gameplay.model.inventory.BLibInventory;
import com.human.common.gameplay.entity.living.human.marine.Marine;
import com.just.core.functional.option.Option;
import com.just.goap.StateKey;
import com.just.goap.sensor.Compose;
import com.just.goap.sensor.Sensor;
import com.just.goap.sensor.Sensors;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LightLayer;

public class TorchSensors {

    private static final int MAX_TORCHES_TO_COLLECT = 64;

    private static final int DARK_LIGHT_LEVEL_THRESHOLD = 7;

    private static final int MAX_WALL_SEARCH_DISTANCE = 3;

    public static final Sensor.Mono<Marine, Option<ItemEntity>> NEAREST_TORCH_IN_WORLD = Sensors.lazyCompose(
        StateKey.sensed("nearest_torch_in_world"),
        (marine, worldState) -> {
            var itemEntities = marine.getEntitySenseCache().getByItem(Items.TORCH);

            ItemEntity nearestTorch = null;
            double nearestDistance = Double.MAX_VALUE;

            for (var itemEntity : itemEntities) {
                var distance = marine.distanceToSqr(itemEntity);

                if (distance < nearestDistance) {
                    nearestDistance = distance;
                    nearestTorch = itemEntity;
                }
            }

            return Option.ofNullable(nearestTorch);
        }
    );

    public static final Sensor.Mono<Marine, Boolean> HAS_TORCH_IN_WORLD = Sensors.compose(
        NEAREST_TORCH_IN_WORLD.key(),
        StateKey.sensed("has_torch_in_world"),
        (marine, torchOption) -> torchOption.isSome()
    );

    public static final Compose<Marine, Option<ItemEntity>, Boolean> IS_NEAREST_TORCH_IN_RANGE = Sensors.compose(
        NEAREST_TORCH_IN_WORLD.key(),
        StateKey.sensed("is_nearest_torch_in_range"),
        (marine, torchOption) -> torchOption.isSomeAnd(torch -> marine.distanceToSqr(torch) < 4)
    );

    public static final Sensor.Mono<Marine, Integer> TORCH_COUNT_IN_INVENTORY = Sensors.lazyCompose(
        StateKey.sensed("torch_count_in_inventory"),
        (marine, worldState) -> {
            var inventory = marine.getInventory();
            return inventory.selectEntries(Items.TORCH)
                .stream()
                .mapToInt(BLibInventory.Entry::getItemCount)
                .sum();
        }
    );

    public static final Sensor.Mono<Marine, Boolean> HAS_TORCH_IN_INVENTORY = Sensors.compose(
        TORCH_COUNT_IN_INVENTORY.key(),
        StateKey.sensed("has_torch_in_inventory"),
        (marine, count) -> count > 0
    );

    public static final Sensor.Mono<Marine, Boolean> HAS_TORCH_EQUIPPED = Sensors.lazyCompose(
        StateKey.sensed("has_torch_equipped"),
        (marine, worldState) -> marine.getMainHandItem().is(Items.TORCH) || marine.getOffhandItem().is(Items.TORCH)
    );

    public static final Sensor.Mono<Marine, Boolean> SHOULD_COLLECT_MORE_TORCHES = Sensors.lazyCompose(
        StateKey.sensed("should_collect_more_torches"),
        (marine, worldState) -> {
            var torchCount = worldState.getOrDefault(TORCH_COUNT_IN_INVENTORY.key(), 0);
            var hasTorchInWorld = worldState.getOrDefault(HAS_TORCH_IN_WORLD.key(), false);

            return hasTorchInWorld && torchCount < MAX_TORCHES_TO_COLLECT;
        }
    );

    public static final Sensor.Mono<Marine, Boolean> IS_IN_DARK_AREA = Sensors.lazyCompose(
        StateKey.sensed("is_in_dark_area"),
        (marine, worldState) -> {
            var level = marine.level();
            var pos = marine.blockPosition();
            var blockLight = level.getBrightness(LightLayer.BLOCK, pos);

            return blockLight <= DARK_LIGHT_LEVEL_THRESHOLD;
        }
    );

    public static final Sensor.Mono<Marine, Boolean> CAN_PLACE_TORCH_AT_FEET = Sensors.lazyCompose(
        StateKey.sensed("can_place_torch_at_feet"),
        (marine, worldState) -> {
            var level = marine.level();
            var feetPos = marine.blockPosition();
            var belowPos = feetPos.below();

            // Can't place if in fluid.
            if (marine.isInWater() || marine.isInLava()) {
                return false;
            }

            var feetState = level.getBlockState(feetPos);
            var belowState = level.getBlockState(belowPos);

            // The block at feet must be replaceable (air or similar).
            if (!feetState.canBeReplaced()) {
                return false;
            }

            // The block below must be solid to support a torch.
            return belowState.isFaceSturdy(level, belowPos, Direction.UP);
        }
    );

    /**
     * Finds a valid wall position to place a wall torch within 3 blocks in any cardinal direction. Returns the position
     * where the torch would be placed (the air block), not the wall itself.
     */
    public static final Sensor.Mono<Marine, Option<BlockPos>> TORCH_WALL_PLACEMENT_POS = Sensors.lazyCompose(
        StateKey.sensed("torch_wall_placement_pos"),
        (marine, worldState) -> {
            var level = marine.level();
            var marinePos = marine.blockPosition();

            // Check all 4 cardinal directions.
            for (var direction : Direction.Plane.HORIZONTAL) {
                // Search outward from the marine.
                for (int distance = 1; distance <= MAX_WALL_SEARCH_DISTANCE; distance++) {
                    var checkPos = marinePos.relative(direction, distance);
                    var wallPos = checkPos.relative(direction);
                    var checkState = level.getBlockState(checkPos);
                    var wallState = level.getBlockState(wallPos);

                    // The position must be air/replaceable and not in fluid.
                    if (!checkState.canBeReplaced() || checkState.getFluidState().isSource()) {
                        break;
                    }

                    // Check if the wall can support a wall torch.
                    if (wallState.isFaceSturdy(level, wallPos, direction.getOpposite())) {
                        return Option.some(checkPos);
                    }
                }
            }

            return Option.none();
        }
    );

    public static final Sensor.Mono<Marine, Boolean> CAN_PLACE_TORCH_ON_WALL = Sensors.compose(
        TORCH_WALL_PLACEMENT_POS.key(),
        StateKey.sensed("can_place_torch_on_wall"),
        (marine, posOption) -> posOption.isSome()
    );

    public static final Sensor.Mono<Marine, Boolean> SHOULD_PLACE_TORCH = Sensors.lazyCompose(
        StateKey.sensed("should_place_torch"),
        (marine, worldState) -> {
            var isInDarkArea = worldState.getOrDefault(IS_IN_DARK_AREA.key(), false);
            var hasTorch = worldState.getOrDefault(HAS_TORCH_IN_INVENTORY.key(), false)
                || worldState.getOrDefault(HAS_TORCH_EQUIPPED.key(), false);
            var canPlaceAtFeet = worldState.getOrDefault(CAN_PLACE_TORCH_AT_FEET.key(), false);
            var canPlaceOnWall = worldState.getOrDefault(CAN_PLACE_TORCH_ON_WALL.key(), false);

            return isInDarkArea && hasTorch && (canPlaceAtFeet || canPlaceOnWall);
        }
    );

    private TorchSensors() {
        throw new UnsupportedOperationException();
    }
}
