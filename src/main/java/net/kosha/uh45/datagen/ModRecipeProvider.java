package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> TO_GET_GLITHCTENITE_INGOT = List.of(ModItems.RAW_GLITCHTENITE);
    private static final List<ItemConvertible> TO_GET_BUGGED_STONE = List.of(ModBlocks.BUGGED_COBBLESTONE);
    private static final List<ItemConvertible> TO_GET_CRIMSON_STONE = List.of(ModBlocks.CRIMSON_COBBLESTONE);

    private static final List<ItemConvertible> TO_GET_RAW_GLITCHTENITE = List.of(ModBlocks.CRIMSON_GLITCHTENITE_ORE, ModBlocks.BUGGED_GLITCHTENITE_ORE);
    private static final List<ItemConvertible> TO_GET_RAW_IRON = List.of(ModBlocks.CRIMSON_IRON_ORE, ModBlocks.BUGGED_IRON_ORE);
    private static final List<ItemConvertible> TO_GET_COAL = List.of(ModBlocks.CRIMSON_COAL_ORE, ModBlocks.BUGGED_COAL_ORE);
    private static final List<ItemConvertible> TO_GET_LAPIS = List.of(ModBlocks.CRIMSON_LAPIS_ORE, ModBlocks.BUGGED_LAPIS_ORE);




    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, TO_GET_GLITHCTENITE_INGOT, RecipeCategory.MISC, ModItems.GLITCHTENITE_INGOT, 0.7f, 200, "glitchtenite");
        offerSmelting(exporter, TO_GET_BUGGED_STONE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUGGED_STONE, 0.7f, 200, "stone");
        offerSmelting(exporter, TO_GET_CRIMSON_STONE, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_STONE, 0.7f, 200, "stone");

        offerSmelting(exporter, TO_GET_RAW_GLITCHTENITE, RecipeCategory.MISC, ModItems.RAW_GLITCHTENITE, 1.4f, 200, "ores");
        offerSmelting(exporter, TO_GET_RAW_IRON, RecipeCategory.MISC, Items.RAW_IRON, 0.7f, 200, "ores");
        offerSmelting(exporter, TO_GET_COAL, RecipeCategory.MISC, Items.COAL, 0.7f, 200, "ores");
        offerSmelting(exporter, TO_GET_LAPIS, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.7f, 200, "ores");

        offerBlasting(exporter, TO_GET_RAW_GLITCHTENITE, RecipeCategory.MISC, ModItems.RAW_GLITCHTENITE, 1.4f, 100, "ores");
        offerBlasting(exporter, TO_GET_RAW_IRON, RecipeCategory.MISC, Items.RAW_IRON, 0.7f, 100, "ores");
        offerBlasting(exporter, TO_GET_COAL, RecipeCategory.MISC, Items.COAL, 0.7f, 100, "ores");
        offerBlasting(exporter, TO_GET_LAPIS, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.7f, 100, "ores");



        offerBlasting(exporter, TO_GET_GLITHCTENITE_INGOT, RecipeCategory.MISC, ModItems.GLITCHTENITE_INGOT, 0.7f, 100, "glitchtenite");
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.GLITCHTENITE_INGOT, RecipeCategory.DECORATIONS, ModBlocks.GLITCHTENITE_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.RAW_GLITCHTENITE, RecipeCategory.DECORATIONS, ModBlocks.RAW_GLITCHTENITE_BLOCK);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS ,ModItems.GLITCHTENITE_PICKAXE)
                .pattern("###")
                .pattern(" / ")
                .pattern(" / ")
                .input('#', ModItems.GLITCHTENITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.GLITCHTENITE_INGOT), conditionsFromItem(ModItems.GLITCHTENITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS ,ModItems.GLITCHTENITE_AXE)
                .pattern(" ##")
                .pattern(" /#")
                .pattern(" / ")
                .input('#', ModItems.GLITCHTENITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.GLITCHTENITE_INGOT), conditionsFromItem(ModItems.GLITCHTENITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS ,ModItems.GLITCHTENITE_HOE)
                .pattern(" ##")
                .pattern(" / ")
                .pattern(" / ")
                .input('#', ModItems.GLITCHTENITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.GLITCHTENITE_INGOT), conditionsFromItem(ModItems.GLITCHTENITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS ,ModItems.GLITCHTENITE_SHOVEL)
                .pattern(" # ")
                .pattern(" / ")
                .pattern(" / ")
                .input('#', ModItems.GLITCHTENITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.GLITCHTENITE_INGOT), conditionsFromItem(ModItems.GLITCHTENITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS ,ModItems.GLITCHTENITE_SWORD)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" / ")
                .input('#', ModItems.GLITCHTENITE_INGOT)
                .input('/', Items.STICK)
                .criterion(hasItem(ModItems.GLITCHTENITE_INGOT), conditionsFromItem(ModItems.GLITCHTENITE_INGOT))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS ,ModItems.GLITCHED_CROSSBOW)
                .pattern("##%")
                .pattern(" /#")
                .pattern("# #")
                .input('#', ModItems.GLITCHTENITE_INGOT)
                .input('/', Items.STRING)
                .input('%', ModBlocks.GLITCHTENITE_BLOCK)
                .criterion(hasItem(ModItems.GLITCHTENITE_INGOT), conditionsFromItem(ModItems.GLITCHTENITE_INGOT))
                .offerTo(exporter);
        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUPTION_BLOCK)
                .input(Blocks.DIRT)
                .input(ModItems.RAW_GLITCHTENITE)
                .criterion("corruption_block", FabricRecipeProvider.conditionsFromItem(ModBlocks.CORRUPTION_BLOCK))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CORRUPTED_ICE)
                .input(Blocks.BLUE_ICE)
                .input(ModItems.RAW_GLITCHTENITE)
                .criterion("corrupted_ice", FabricRecipeProvider.conditionsFromItem(ModBlocks.CORRUPTED_ICE))
                .offerTo(exporter);
        offerSingleOutputShapelessRecipe(exporter, Items.RED_DYE, ModBlocks.HEART_FLOWER, "flower_dyes");
        offerSingleOutputShapelessRecipe(exporter, Items.CYAN_DYE, ModBlocks.STRANGE_BUSH, "flower_dyes");

        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUGGED_COBBLESTONE_SLAB, ModBlocks.BUGGED_COBBLESTONE);
        offerPressurePlateRecipe(exporter, ModBlocks.BUGGED_COBBLESTONE_PRESSURE_PLATE, ModBlocks.BUGGED_COBBLESTONE);
        createStairsRecipe( ModBlocks.BUGGED_COBBLESTONE_STAIRS, Ingredient.ofItems(ModBlocks.BUGGED_COBBLESTONE))
                .criterion("bugged_cobblestone", FabricRecipeProvider.conditionsFromItem(ModBlocks.BUGGED_COBBLESTONE))
                .offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUGGED_COBBLESTONE_WALL, ModBlocks.BUGGED_COBBLESTONE);
        offerShapelessRecipe(exporter, ModBlocks.BUGGED_COBBLESTONE_BUTTON, ModBlocks.BUGGED_COBBLESTONE, null, 1);

        // Ofrecer recetas de BUGGED_STONE
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUGGED_STONE_SLAB, ModBlocks.BUGGED_STONE);
        offerPressurePlateRecipe(exporter, ModBlocks.BUGGED_STONE_PRESSURE_PLATE, ModBlocks.BUGGED_STONE);
        createStairsRecipe(ModBlocks.BUGGED_STONE_STAIRS, Ingredient.ofItems(ModBlocks.BUGGED_STONE))
                .criterion("bugged_stone", FabricRecipeProvider.conditionsFromItem(ModBlocks.BUGGED_STONE))
                .offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BUGGED_STONE_WALL, ModBlocks.BUGGED_STONE);
        offerShapelessRecipe(exporter, ModBlocks.BUGGED_STONE_BUTTON, ModBlocks.BUGGED_STONE, null, 1);

        // Ofrecer recetas de CRIMSON_COBBLESTONE
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_COBBLESTONE_SLAB, ModBlocks.CRIMSON_COBBLESTONE);
        offerPressurePlateRecipe(exporter, ModBlocks.CRIMSON_COBBLESTONE_PRESSURE_PLATE, ModBlocks.CRIMSON_COBBLESTONE);
        createStairsRecipe(ModBlocks.CRIMSON_COBBLESTONE_STAIRS, Ingredient.ofItems(ModBlocks.CRIMSON_COBBLESTONE))
                .criterion("crimson_cobblestone", FabricRecipeProvider.conditionsFromItem(ModBlocks.CRIMSON_COBBLESTONE))
                .offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_COBBLESTONE_WALL, ModBlocks.CRIMSON_COBBLESTONE);
        offerShapelessRecipe(exporter, ModBlocks.CRIMSON_COBBLESTONE_BUTTON, ModBlocks.CRIMSON_COBBLESTONE, null, 1);

        // Ofrecer recetas de CRIMSON_STONE
        offerSlabRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_STONE_SLAB, ModBlocks.CRIMSON_STONE);
        offerPressurePlateRecipe(exporter, ModBlocks.CRIMSON_STONE_PRESSURE_PLATE, ModBlocks.CRIMSON_STONE);
        createStairsRecipe(ModBlocks.CRIMSON_STONE_STAIRS, Ingredient.ofItems(ModBlocks.CRIMSON_STONE))
                .criterion("crimson_stone", FabricRecipeProvider.conditionsFromItem(ModBlocks.CRIMSON_STONE))
                .offerTo(exporter);
        offerWallRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_STONE_WALL, ModBlocks.CRIMSON_STONE);
        offerShapelessRecipe(exporter, ModBlocks.CRIMSON_STONE_BUTTON, ModBlocks.CRIMSON_STONE, null, 1);
    }
}
