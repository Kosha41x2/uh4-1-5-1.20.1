package net.kosha.uh45.helping_classes;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.kosha.uh45.block.ModBlocks;

public class FuelRegisterer {

    public static void RegisterFuels(){
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_DEAD_LOG, 700);
        FuelRegistry.INSTANCE.add(ModBlocks.DEAD_LOG, 700);
        FuelRegistry.INSTANCE.add(ModBlocks.DEAD_WOOD, 700);
        FuelRegistry.INSTANCE.add(ModBlocks.STRIPPED_DEAD_WOOD, 700);
        FuelRegistry.INSTANCE.add(ModBlocks.DEAD_PLANKS, 350);
    }
}
