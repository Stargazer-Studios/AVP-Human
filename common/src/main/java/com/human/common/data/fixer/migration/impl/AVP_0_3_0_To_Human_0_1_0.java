package com.human.common.data.fixer.migration.impl;

import com.blib.api.common.data_fix.v1.BLibDataFixerRegistry;
import com.blib.api.common.data_fix.v1.BLibDataMigration;
import com.blib.api.common.mod.v1.model.Version;
import com.human.Human;
import com.human.common.gameplay.worldgen.structure.HumanMarineCampStructure;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class AVP_0_3_0_To_Human_0_1_0 implements BLibDataMigration {

    @Override
    public Version fromVersion() {
        return new Version(0, 3, 0);
    }

    @Override
    public Version toVersion() {
        return new Version(0, 1, 0);
    }

    @Override
    public void apply() {
        registerStructureDataFixes();
        registerStructureSetDataFixes();
        registerTemplatePoolDataFixes();
        BuiltInRegistries.REGISTRY.forEach(AVP_0_3_0_To_Human_0_1_0::registerMigrationsForRegistry);
    }

    private static void registerStructureDataFixes() {
        register(createResourceKeyEntry(Registries.STRUCTURE, HumanMarineCampStructure.NAME));
        register(createResourceKeyEntry(Registries.STRUCTURE, "mobile_lab"));
        register(createResourceKeyEntry(Registries.STRUCTURE, "outpost_comm_bottom"));
        register(createResourceKeyEntry(Registries.STRUCTURE, "outpost_munition"));
        register(createResourceKeyEntry(Registries.STRUCTURE, "outpost_supply_badland"));
        register(createResourceKeyEntry(Registries.STRUCTURE, "outpost_supply_desert"));
    }

    private static void registerStructureSetDataFixes() {
        register(createResourceKeyEntry(Registries.STRUCTURE_SET, HumanMarineCampStructure.NAME));
        register(createResourceKeyEntry(Registries.STRUCTURE_SET, "mobile_lab"));
        register(createResourceKeyEntry(Registries.STRUCTURE_SET, "outpost_comm_bottom"));
        register(createResourceKeyEntry(Registries.STRUCTURE_SET, "outpost_munition"));
        register(createResourceKeyEntry(Registries.STRUCTURE_SET, "outpost_supply_badland"));
        register(createResourceKeyEntry(Registries.STRUCTURE_SET, "outpost_supply_desert"));
    }

    private static void registerTemplatePoolDataFixes() {
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "marine"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, HumanMarineCampStructure.NAME));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "marine_summon"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "mobile_lab"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "outpost_comm_bottom"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "outpost_comm_top"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "outpost_munition"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "outpost_supply_badland"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "outpost_supply_desert"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "villager"));
        register(createResourceKeyEntry(Registries.TEMPLATE_POOL, "villager_summon"));
    }

    private static <T> BLibDataFixerRegistry.Entry.@NotNull Resource createResourceKeyEntry(
        ResourceKey<Registry<T>> registry,
        String path
    ) {
        return new BLibDataFixerRegistry.Entry.Resource(
            registry,
            createAvpResourceLocation(path),
            Human.MOD.resources().createLocation(path)
        );
    }

    private static void registerMigrationsForRegistry(Registry<?> registry) {
        Human.MOD.registries()
            .getAllHolders(registry)
            .forEach(
                holder -> register(
                    new BLibDataFixerRegistry.Entry.Direct(
                        registry,
                        createAvpResourceLocation(holder.getPath()),
                        holder.getResourceLocation()
                    )
                )
            );
    }

    private static ResourceLocation createAvpResourceLocation(String path) {
        return ResourceLocation.fromNamespaceAndPath("avp", path);
    }

    public static void register(BLibDataFixerRegistry.Entry entry) {
        BLibDataFixerRegistry.register(entry);
    }
}
