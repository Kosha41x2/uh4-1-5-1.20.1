package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.item.ModItems;
import net.kosha.uh45.item.custom.CrossbowLikeItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_GLITCHTENITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLITCHTENITE_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GLITCHTENITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_GLITCHTENITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GLITCHTENITE_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLITCHTENITE_HOE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLITCHTENITE_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLITCHTENITE_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.GLITCHTENITE_SHOVEL, Models.HANDHELD);

    }
}
