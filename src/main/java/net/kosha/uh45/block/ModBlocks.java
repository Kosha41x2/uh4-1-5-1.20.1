package net.kosha.uh45.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kosha.uh45.UH415;
import net.kosha.uh45.block.custom.CorruptedIce;
import net.kosha.uh45.block.custom.CorruptionBlock;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block RAW_GLITCHTENITE_BLOCK = registerBlock("raw_glitchtenite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.LAPIS_BLUE)));

    public static final Block GLITCHTENITE_BLOCK = registerBlock("glitchtenite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.LAPIS_BLUE)));

    public static final Block CORRUPTION_BLOCK = registerBlock("corruption_block",
            new CorruptionBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.BLACK).strength(3.5f)
                    .luminance((state) -> state.get(CorruptionBlock.ACTIVATED) > 0 ? 2 : 0)));

    public static final Block CORRUPTED_ICE = registerBlock("corrupted_ice",
            new CorruptedIce(FabricBlockSettings.copyOf(Blocks.BLUE_ICE).strength(3.0F)));


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
