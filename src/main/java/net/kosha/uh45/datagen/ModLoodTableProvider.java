package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kosha.uh45.block.ModBlocks;

public class ModLoodTableProvider extends FabricBlockLootTableProvider {
    public ModLoodTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GLITCHTENITE_BLOCK);
        addDrop(ModBlocks.RAW_GLITCHTENITE_BLOCK);
    }
}
