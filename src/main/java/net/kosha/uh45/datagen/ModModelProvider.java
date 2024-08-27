package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.item.ModItems;
import net.kosha.uh45.item.custom.CrossbowLikeItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_GLITCHTENITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GLITCHTENITE_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CORRUPTED_ICE);

        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.HEART_FLOWER, ModBlocks.POTTED_HEART_FLOWER, BlockStateModelGenerator.TintType.NOT_TINTED);
        blockStateModelGenerator.registerFlowerPotPlant(ModBlocks.STRANGE_BUSH, ModBlocks.POTTED_STRANGE_BUSH, BlockStateModelGenerator.TintType.NOT_TINTED);
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
        itemModelGenerator.register(ModItems.CORRUPTED_GRAPE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POISONOUS_BERRY, Models.GENERATED);
        itemModelGenerator.register(ModItems.UH4_OST_MAIN_THEME_MUSIC_DISK, Models.GENERATED);
        itemModelGenerator.register(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER, Models.GENERATED);
        itemModelGenerator.register(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER_PHASE_2, Models.GENERATED);
        itemModelGenerator.register(ModItems.SLUG_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.AMALGAM_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GLITCHTENITE_GOLEM_SPAWN_EGG,
                new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));


        itemModelGenerator.registerArmor((ArmorItem) ModItems.GLITCHTENITE_HELMET);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GLITCHTENITE_CHESTPLATE);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GLITCHTENITE_LEGGINGS);
        itemModelGenerator.registerArmor((ArmorItem) ModItems.GLITCHTENITE_BOOTS);
    }
}
