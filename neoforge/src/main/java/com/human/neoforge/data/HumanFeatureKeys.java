package com.human.neoforge.data;

import com.human.Human;
import net.minecraft.resources.ResourceKey;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import org.jetbrains.annotations.NotNull;

public class HumanFeatureKeys {

    public static final ResourceKey<BiomeModifier> ADD_LEAD_SWAMP = create("add_lead_swamp");

    public static final ResourceKey<BiomeModifier> ADD_AUTUNITE_GEODE = create("add_autunite_geode");

    public static final ResourceKey<BiomeModifier> ADD_BAUXITE_MIDDLE = create("add_bauxite_middle");

    public static final ResourceKey<BiomeModifier> ADD_BAUXITE_UPPER = create("add_bauxite_upper");

    public static final ResourceKey<BiomeModifier> ADD_GALENA = create("add_galena");

    public static final ResourceKey<BiomeModifier> ADD_LITHIUM = create("add_lithium");

    public static final ResourceKey<BiomeModifier> ADD_MONAZITE = create("add_monazite");

    public static final ResourceKey<BiomeModifier> ADD_SILICON_GRAVEL = create("add_silicon_gravel");

    public static final ResourceKey<BiomeModifier> ADD_TITANIUM_LOWER = create("add_titanium_lower");

    public static final ResourceKey<BiomeModifier> ADD_LITHIUM_DESERT = create("add_lithium_desert");

    public static final ResourceKey<BiomeModifier> ADD_MONAZITE_JUNGLE = create("add_monazite_jungle");

    public static final ResourceKey<BiomeModifier> ADD_ZINC = create("add_zinc");

    public static final ResourceKey<BiomeModifier> ADD_ZINC_DRIPSTONE_CAVES = create("add_zinc_dripstone_caves");

    private static @NotNull ResourceKey<BiomeModifier> create(String path) {
        return Human.MOD.resources().createKey(NeoForgeRegistries.Keys.BIOME_MODIFIERS, path);
    }
}
