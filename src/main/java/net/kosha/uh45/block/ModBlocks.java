package net.kosha.uh45.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.kosha.uh45.UH415;
import net.kosha.uh45.block.custom.BuggedGrassBlock;
import net.kosha.uh45.block.custom.CorruptedIce;
import net.kosha.uh45.block.custom.CorruptionBlock;
import net.kosha.uh45.effect.ModEffects;
import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block BUGGED_GRASS_BLOCK = registerBlock("bugged_grass_block",
            new BuggedGrassBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).mapColor(MapColor.LAPIS_BLUE)));

    public static final Block BUGGED_DIRT = registerBlock("bugged_dirt",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT).mapColor(MapColor.GRAY)));

    public static final Block BUGGED_COBBLESTONE = registerBlock("bugged_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).mapColor(MapColor.CYAN).strength(1.4f, 4.0f)));

    public static final Block BUGGED_COBBLESTONE_STAIRS = registerBlock("bugged_cobblestone_stairs",
            new StairsBlock(ModBlocks.BUGGED_COBBLESTONE.getDefaultState(),FabricBlockSettings.copyOf(ModBlocks.BUGGED_COBBLESTONE)));
    public static final Block BUGGED_COBBLESTONE_SLAB = registerBlock("bugged_cobblestone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.BUGGED_COBBLESTONE)));

    public static final Block BUGGED_COBBLESTONE_BUTTON = registerBlock("bugged_cobblestone_button",
            new ButtonBlock(FabricBlockSettings.copyOf(ModBlocks.BUGGED_COBBLESTONE), BlockSetType.STONE, 10, false));
    public static final Block BUGGED_COBBLESTONE_PRESSURE_PLATE = registerBlock("bugged_cobblestone_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING ,FabricBlockSettings.copyOf(ModBlocks.BUGGED_COBBLESTONE), BlockSetType.STONE));

    public static final Block BUGGED_COBBLESTONE_WALL = registerBlock("bugged_cobblestone_wall",
            new WallBlock(FabricBlockSettings.copyOf(ModBlocks.BUGGED_COBBLESTONE)));


    public static final Block BUGGED_STONE = registerBlock("bugged_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.GRAY).strength(1.1f, 4.0f)));

    public static final Block BUGGED_STONE_STAIRS = registerBlock("bugged_stone_stairs",
            new StairsBlock(ModBlocks.BUGGED_STONE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.BUGGED_STONE)));

    public static final Block BUGGED_STONE_SLAB = registerBlock("bugged_stone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.BUGGED_STONE)));

    public static final Block BUGGED_STONE_BUTTON = registerBlock("bugged_stone_button",
            new ButtonBlock(FabricBlockSettings.copyOf(ModBlocks.BUGGED_STONE), BlockSetType.STONE, 10, false));

    public static final Block BUGGED_STONE_PRESSURE_PLATE = registerBlock("bugged_stone_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(ModBlocks.BUGGED_STONE), BlockSetType.STONE));

    public static final Block BUGGED_STONE_WALL = registerBlock("bugged_stone_wall",
            new WallBlock(FabricBlockSettings.copyOf(ModBlocks.BUGGED_STONE)));

    public static final Block CRIMSON_COBBLESTONE = registerBlock("crimson_cobblestone",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE).mapColor(MapColor.DARK_RED).strength(2.0f, 14.0f)));

    public static final Block CRIMSON_COBBLESTONE_STAIRS = registerBlock("crimson_cobblestone_stairs",
            new StairsBlock(ModBlocks.CRIMSON_COBBLESTONE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CRIMSON_COBBLESTONE)));

    public static final Block CRIMSON_COBBLESTONE_SLAB = registerBlock("crimson_cobblestone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.CRIMSON_COBBLESTONE)));

    public static final Block CRIMSON_COBBLESTONE_BUTTON = registerBlock("crimson_cobblestone_button",
            new ButtonBlock(FabricBlockSettings.copyOf(ModBlocks.CRIMSON_COBBLESTONE), BlockSetType.STONE, 20, false));

    public static final Block CRIMSON_COBBLESTONE_PRESSURE_PLATE = registerBlock("crimson_cobblestone_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.copyOf(ModBlocks.CRIMSON_COBBLESTONE), BlockSetType.STONE));

    public static final Block CRIMSON_COBBLESTONE_WALL = registerBlock("crimson_cobblestone_wall",
            new WallBlock(FabricBlockSettings.copyOf(ModBlocks.CRIMSON_COBBLESTONE)));

    public static final Block CRIMSON_STONE = registerBlock("crimson_stone",
            new Block(FabricBlockSettings.copyOf(Blocks.STONE).mapColor(MapColor.DARK_RED).strength(1.5f, 14.0f)));

    public static final Block CRIMSON_STONE_STAIRS = registerBlock("crimson_stone_stairs",
            new StairsBlock(ModBlocks.CRIMSON_STONE.getDefaultState(), FabricBlockSettings.copyOf(ModBlocks.CRIMSON_STONE)));

    public static final Block CRIMSON_STONE_SLAB = registerBlock("crimson_stone_slab",
            new SlabBlock(FabricBlockSettings.copyOf(ModBlocks.CRIMSON_STONE)));

    public static final Block CRIMSON_STONE_BUTTON = registerBlock("crimson_stone_button",
            new ButtonBlock(FabricBlockSettings.copyOf(ModBlocks.CRIMSON_STONE), BlockSetType.STONE, 20, false));

    public static final Block CRIMSON_STONE_PRESSURE_PLATE = registerBlock("crimson_stone_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.MOBS, FabricBlockSettings.copyOf(ModBlocks.CRIMSON_STONE), BlockSetType.STONE));

    public static final Block CRIMSON_STONE_WALL = registerBlock("crimson_stone_wall",
            new WallBlock(FabricBlockSettings.copyOf(ModBlocks.CRIMSON_STONE)));

    public static final Block CRIMSON_LAPIS_ORE = registerBlock("crimson_lapis_ore",
            new ExperienceDroppingBlock(AbstractBlock.Settings.create().mapColor(MapColor.DARK_RED).instrument(Instrument.BASEDRUM).requiresTool().strength(3.0f, 14.0f), UniformIntProvider.create(3, 5)));

    public static final Block BUGGED_LAPIS_ORE = registerBlock("bugged_lapis_ore",
            new ExperienceDroppingBlock(AbstractBlock.Settings.create().mapColor(MapColor.CYAN).instrument(Instrument.BASEDRUM).requiresTool().strength(2.5f, 3.0f), UniformIntProvider.create(1, 5)));

    public static final Block CRIMSON_IRON_ORE = registerBlock("crimson_iron_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).mapColor(MapColor.DARK_RED).strength(4.5f, 14.0f)));

    public static final Block BUGGED_IRON_ORE = registerBlock("bugged_iron_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).mapColor(MapColor.DARK_RED).strength(4.0f, 3.0f)));

    public static final Block CRIMSON_COAL_ORE = registerBlock("crimson_coal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).mapColor(MapColor.DARK_RED).strength(3.0f, 14.0f)));

    public static final Block BUGGED_COAL_ORE = registerBlock("bugged_coal_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.COAL_ORE).mapColor(MapColor.DARK_RED).strength(2.5f, 3.0f)));

    public static final Block CRIMSON_GLITCHTENITE_ORE = registerBlock("crimson_glitchtenite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).mapColor(MapColor.DARK_RED).strength(5.0f, 14.0f)));

    public static final Block BUGGED_GLITCHTENITE_ORE = registerBlock("bugged_glitchtenite_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.IRON_ORE).mapColor(MapColor.DARK_RED).strength(4.5f, 3.0f)));

    public static final Block RAW_GLITCHTENITE_BLOCK = registerBlock("raw_glitchtenite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.RAW_IRON_BLOCK).mapColor(MapColor.LAPIS_BLUE)));

    public static final Block GLITCHTENITE_BLOCK = registerBlock("glitchtenite_block",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).mapColor(MapColor.LAPIS_BLUE)));

    public static final Block CORRUPTION_BLOCK = registerBlock("corruption_block",
            new CorruptionBlock(FabricBlockSettings.copyOf(Blocks.WARPED_WART_BLOCK).mapColor(MapColor.BLACK).strength(3.5f)
                    .luminance((state) -> state.get(CorruptionBlock.ACTIVATED) > 0 ? 2 : 0)));

    public static final Block CORRUPTED_ICE = registerBlock("corrupted_ice",
            new CorruptedIce(FabricBlockSettings.copyOf(Blocks.BLUE_ICE).strength(3.0F)));

    public static final Block HEART_FLOWER = registerBlock("heart_flower",
            new FlowerBlock(StatusEffects.ABSORPTION, 10,
                    FabricBlockSettings.copyOf(Blocks.RED_TULIP).nonOpaque().noCollision()));

    public static final Block POTTED_HEART_FLOWER = Registry.register(Registries.BLOCK, new Identifier(UH415.MOD_ID, "potted_heart_flower"),
            new FlowerPotBlock(HEART_FLOWER ,FabricBlockSettings.copyOf(Blocks.POTTED_RED_TULIP).nonOpaque()));

    public static final Block STRANGE_BUSH = registerBlock("strange_bush",
            new FlowerBlock(ModEffects.CORRUPTION_RESISTANCE, 10,
                    FabricBlockSettings.copyOf(Blocks.BLUE_ORCHID).nonOpaque().noCollision()));

    public static final Block POTTED_STRANGE_BUSH = Registry.register(Registries.BLOCK, new Identifier(UH415.MOD_ID, "potted_strange_bush"),
            new FlowerPotBlock(STRANGE_BUSH ,FabricBlockSettings.copyOf(Blocks.POTTED_BLUE_ORCHID).nonOpaque()));


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
