package net.kosha.uh45.block;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;

public class FlammableBlocksRegisterer {
    public static void RegisterFlammableBlocks(){
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_LOG, 10, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DEAD_WOOD, 10, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_DEAD_LOG, 10, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_WOOD, 10, 5);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_LEAVES, 30, 60);
        FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.DEAD_PLANKS, 10, 20);
    }
}
