package com.human.common.gameplay.component;

import com.blib.api.common.codec.v1.BLibCodecs;
import com.just.codec.stream.RecordStreamCodec;
import com.just.codec.stream.StreamCodec;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.item.ItemStack;

public record ArmorCaseContainerContents(
    ItemStack head,
    ItemStack chest,
    ItemStack legs,
    ItemStack feet
) {

    public static final ArmorCaseContainerContents EMPTY = new ArmorCaseContainerContents(
        ItemStack.EMPTY,
        ItemStack.EMPTY,
        ItemStack.EMPTY,
        ItemStack.EMPTY
    );

    public static final Codec<ArmorCaseContainerContents> CODEC = RecordCodecBuilder.create(
        instance -> instance.group(
            ItemStack.OPTIONAL_CODEC.fieldOf("head").forGetter(ArmorCaseContainerContents::head),
            ItemStack.OPTIONAL_CODEC.fieldOf("chest").forGetter(ArmorCaseContainerContents::chest),
            ItemStack.OPTIONAL_CODEC.fieldOf("legs").forGetter(ArmorCaseContainerContents::legs),
            ItemStack.OPTIONAL_CODEC.fieldOf("feet").forGetter(ArmorCaseContainerContents::feet)
        )
            .apply(instance, ArmorCaseContainerContents::new)
    );

    public static final StreamCodec<ArmorCaseContainerContents> STREAM_CODEC = RecordStreamCodec.of(
        BLibCodecs.Stream.ITEM_STACK,
        ArmorCaseContainerContents::head,
        BLibCodecs.Stream.ITEM_STACK,
        ArmorCaseContainerContents::chest,
        BLibCodecs.Stream.ITEM_STACK,
        ArmorCaseContainerContents::legs,
        BLibCodecs.Stream.ITEM_STACK,
        ArmorCaseContainerContents::feet,
        ArmorCaseContainerContents::new
    );

    public boolean isEmpty() {
        return head.isEmpty() && chest.isEmpty() && legs.isEmpty() && feet.isEmpty();
    }

    public boolean isFull() {
        return !head.isEmpty() && !chest.isEmpty() && !legs.isEmpty() && !feet.isEmpty();
    }
}
