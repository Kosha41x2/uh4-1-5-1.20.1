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
import net.minecraft.recipe.book.RecipeCategory;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {

    private static final List<ItemConvertible> TO_GET_GLITHCTENITE_INGOT = List.of(ModItems.RAW_GLITCHTENITE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, TO_GET_GLITHCTENITE_INGOT, RecipeCategory.MISC, ModItems.GLITCHTENITE_INGOT, 0.7f, 200, "glitchtenite");
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
    }
}
