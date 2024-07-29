package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kosha.uh45.block.ModBlocks;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GLITCHTENITE_BLOCK);
        addDrop(ModBlocks.RAW_GLITCHTENITE_BLOCK);
        addDrop(ModBlocks.CORRUPTION_BLOCK);
        addDropWithSilkTouch(ModBlocks.CORRUPTED_ICE);

        addDrop(ModBlocks.STRANGE_BUSH);
        addDrop(ModBlocks.HEART_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_STRANGE_BUSH);
        addPottedPlantDrops(ModBlocks.POTTED_HEART_FLOWER);
    }
}
