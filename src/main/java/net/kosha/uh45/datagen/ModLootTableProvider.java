package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.item.ModItems;
import net.kosha.uh45.util.ModTags;
import net.minecraft.item.Items;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.GLITCHTENITE_BLOCK);
        addDrop(ModBlocks.RAW_GLITCHTENITE_BLOCK);
        addDrop(ModBlocks.CORRUPTION_BLOCK);
        addDrop(ModBlocks.BUGGED_DIRT);
        addDrop(ModBlocks.BUGGED_COBBLESTONE);
        addDrop(ModBlocks.CRIMSON_COBBLESTONE);
        addDropWithSilkTouch(ModBlocks.CORRUPTED_ICE);

        addDrop(ModBlocks.CRIMSON_COAL_ORE, oreDrops(ModBlocks.CRIMSON_COAL_ORE ,Items.COAL));
        addDrop(ModBlocks.CRIMSON_IRON_ORE, oreDrops(ModBlocks.CRIMSON_IRON_ORE ,Items.RAW_IRON));
        addDrop(ModBlocks.CRIMSON_GLITCHTENITE_ORE, oreDrops(ModBlocks.CRIMSON_GLITCHTENITE_ORE ,ModItems.RAW_GLITCHTENITE));
        addDrop(ModBlocks.BUGGED_COAL_ORE, oreDrops(ModBlocks.BUGGED_COAL_ORE ,Items.COAL));
        addDrop(ModBlocks.BUGGED_IRON_ORE, oreDrops(ModBlocks.BUGGED_IRON_ORE ,Items.RAW_IRON));
        addDrop(ModBlocks.BUGGED_GLITCHTENITE_ORE, oreDrops(ModBlocks.BUGGED_GLITCHTENITE_ORE ,ModItems.RAW_GLITCHTENITE));

        addDrop(ModBlocks.STRANGE_BUSH);
        addDrop(ModBlocks.HEART_FLOWER);
        addPottedPlantDrops(ModBlocks.POTTED_STRANGE_BUSH);
        addPottedPlantDrops(ModBlocks.POTTED_HEART_FLOWER);

        addDrop(ModBlocks.BUGGED_COBBLESTONE_BUTTON);
        addDrop(ModBlocks.BUGGED_COBBLESTONE_SLAB, slabDrops(ModBlocks.BUGGED_COBBLESTONE_SLAB));
        addDrop(ModBlocks.BUGGED_COBBLESTONE_STAIRS);
        addDrop(ModBlocks.BUGGED_COBBLESTONE_PRESSURE_PLATE);
        addDrop(ModBlocks.BUGGED_COBBLESTONE_WALL);
        // Agregar drops de BUGGED_STONE
        addDrop(ModBlocks.BUGGED_STONE_BUTTON);
        addDrop(ModBlocks.BUGGED_STONE_SLAB, slabDrops(ModBlocks.BUGGED_STONE_SLAB));
        addDrop(ModBlocks.BUGGED_STONE_STAIRS);
        addDrop(ModBlocks.BUGGED_STONE_PRESSURE_PLATE);
        addDrop(ModBlocks.BUGGED_STONE_WALL);

// Agregar drops de CRIMSON_COBBLESTONE
        addDrop(ModBlocks.CRIMSON_COBBLESTONE_BUTTON);
        addDrop(ModBlocks.CRIMSON_COBBLESTONE_SLAB, slabDrops(ModBlocks.CRIMSON_COBBLESTONE_SLAB));
        addDrop(ModBlocks.CRIMSON_COBBLESTONE_STAIRS);
        addDrop(ModBlocks.CRIMSON_COBBLESTONE_PRESSURE_PLATE);
        addDrop(ModBlocks.CRIMSON_COBBLESTONE_WALL);

// Agregar drops de CRIMSON_STONE
        addDrop(ModBlocks.CRIMSON_STONE_BUTTON);
        addDrop(ModBlocks.CRIMSON_STONE_SLAB, slabDrops(ModBlocks.CRIMSON_STONE_SLAB));
        addDrop(ModBlocks.CRIMSON_STONE_STAIRS);
        addDrop(ModBlocks.CRIMSON_STONE_PRESSURE_PLATE);
        addDrop(ModBlocks.CRIMSON_STONE_WALL);

    }
}
