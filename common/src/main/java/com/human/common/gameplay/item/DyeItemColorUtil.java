package com.human.common.gameplay.item;

import net.minecraft.core.component.DataComponents;
import net.minecraft.util.FastColor;
import net.minecraft.world.item.DyeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.DyedItemColor;

import java.util.List;

public class DyeItemColorUtil {

    public static ItemStack applyDyesForced(ItemStack stack, List<DyeItem> dyes) {
        var itemStack = stack.copyWithCount(1);

        var i = 0;
        var j = 0;
        var k = 0;
        var l = 0;
        var m = 0;

        var dyedItemColor = itemStack.get(DataComponents.DYED_COLOR);

        if (dyedItemColor != null) {
            var n = FastColor.ARGB32.red(dyedItemColor.rgb());
            var o = FastColor.ARGB32.green(dyedItemColor.rgb());
            var p = FastColor.ARGB32.blue(dyedItemColor.rgb());
            l += Math.max(n, Math.max(o, p));
            i += n;
            j += o;
            k += p;
            ++m;
        }

        for (var dyeItem : dyes) {
            var p = dyeItem.getDyeColor().getTextureDiffuseColor();
            var q = FastColor.ARGB32.red(p);
            var r = FastColor.ARGB32.green(p);
            var s = FastColor.ARGB32.blue(p);
            l += Math.max(q, Math.max(r, s));
            i += q;
            j += r;
            k += s;
            ++m;
        }

        var n = i / m;
        var o = j / m;
        var p = k / m;
        var f = (float) l / (float) m;
        var g = (float) Math.max(n, Math.max(o, p));
        n = (int) ((float) n * f / g);
        o = (int) ((float) o * f / g);
        p = (int) ((float) p * f / g);
        var s = FastColor.ARGB32.color(0, n, o, p);
        var bl = dyedItemColor == null || dyedItemColor.showInTooltip();
        itemStack.set(DataComponents.DYED_COLOR, new DyedItemColor(s, bl));

        return itemStack;
    }
}
