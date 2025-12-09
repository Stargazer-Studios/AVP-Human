package com.human.neoforge.data;

import com.human.Human;
import com.human.neoforge.data.impl.NeoForgeHumanBiomeModifiers;
import com.human.neoforge.data.impl.NeoForgeHumanCompostableDataMappings;
import com.human.neoforge.data.impl.NeoForgeHumanFurnaceFuelDataMappings;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.data.DataProvider;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;

@EventBusSubscriber(modid = Human.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class HumanNeoForgeDatagen {

    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var packOutput = generator.getPackOutput();
        var lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new NeoForgeHumanCompostableDataMappings(packOutput, lookupProvider));
        generator.addProvider(event.includeServer(), new NeoForgeHumanFurnaceFuelDataMappings(packOutput, lookupProvider));

        DataProvider.Factory<DatapackBuiltinEntriesProvider> datapackBuiltinEntriesProviderFactory =
            $1 -> createDatapackBuiltInEntriesProvider(event);

        generator.addProvider(event.includeServer(), datapackBuiltinEntriesProviderFactory);
    }

    private static DatapackBuiltinEntriesProvider createDatapackBuiltInEntriesProvider(GatherDataEvent event) {
        var packOutput = event.getGenerator().getPackOutput();
        var datapackEntriesBuilder = new RegistrySetBuilder()
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, NeoForgeHumanBiomeModifiers::bootstrapBiomeModifiers);

        return new DatapackBuiltinEntriesProvider(packOutput, event.getLookupProvider(), datapackEntriesBuilder, Set.of(Human.MOD_ID));
    }

    private HumanNeoForgeDatagen() {
        throw new UnsupportedOperationException();
    }
}
