package net.kosha.uh45.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kosha.uh45.UH415;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RAW_GLITCHTENITE_BLOCK = registerBlock("raw_glitchtenite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_GOLD_BLOCK).mapColor(MapColor.LAPIS_BLUE)));

    public static final Block GLITCHTENITE_BLOCK = registerBlock("glitchtenite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GOLD_BLOCK).mapColor(MapColor.LAPIS_BLUE)));


    private static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(UH415.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block){
        return Registry.register(Registries.ITEM, new Identifier(UH415.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks(){
        UH415.LOGGER.info("Registering ModBlocks for " + UH415.MOD_ID);
    }
}
