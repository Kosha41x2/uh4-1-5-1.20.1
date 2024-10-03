package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kosha.uh45.block.ModBlocks;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.GLITCHTENITE_BLOCK)
                .add(ModBlocks.RAW_GLITCHTENITE_BLOCK)
                .add(ModBlocks.BUGGED_COBBLESTONE)
                .add(ModBlocks.CRIMSON_COBBLESTONE)
                .add(ModBlocks.BUGGED_STONE)
                .add(ModBlocks.CRIMSON_STONE)
                .add(ModBlocks.BUGGED_COAL_ORE)
                .add(ModBlocks.CRIMSON_COAL_ORE)
                .add(ModBlocks.BUGGED_GLITCHTENITE_ORE)
                .add(ModBlocks.CRIMSON_GLITCHTENITE_ORE)
                .add(ModBlocks.BUGGED_LAPIS_ORE)
                .add(ModBlocks.CRIMSON_LAPIS_ORE)
                .add(ModBlocks.CRIMSON_IRON_ORE)
                .add(ModBlocks.BUGGED_IRON_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.GLITCHTENITE_BLOCK)
                .add(ModBlocks.RAW_GLITCHTENITE_BLOCK)
                .add(ModBlocks.BUGGED_GLITCHTENITE_ORE)
                .add(ModBlocks.CRIMSON_GLITCHTENITE_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.BUGGED_LAPIS_ORE)
                .add(ModBlocks.CRIMSON_LAPIS_ORE)
                .add(ModBlocks.CRIMSON_IRON_ORE)
                .add(ModBlocks.BUGGED_IRON_ORE);

        getOrCreateTagBuilder(BlockTags.ICE)
                .add(ModBlocks.CORRUPTED_ICE);

        getOrCreateTagBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.CORRUPTION_BLOCK);

        getOrCreateTagBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.BUGGED_GRASS_BLOCK)
                .add(ModBlocks.BUGGED_DIRT);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.HEART_FLOWER)
                .add(ModBlocks.STRANGE_BUSH);

        getOrCreateTagBuilder(BlockTags.FLOWER_POTS)
                .add(ModBlocks.POTTED_HEART_FLOWER)
                .add(ModBlocks.POTTED_STRANGE_BUSH);

        getOrCreateTagBuilder(BlockTags.COAL_ORES)
                .add(ModBlocks.BUGGED_COAL_ORE)
                .add(ModBlocks.CRIMSON_COAL_ORE);

        getOrCreateTagBuilder(BlockTags.IRON_ORES)
                .add(ModBlocks.CRIMSON_IRON_ORE)
                .add(ModBlocks.BUGGED_IRON_ORE);

        getOrCreateTagBuilder(BlockTags.LAPIS_ORES)
                .add(ModBlocks.BUGGED_LAPIS_ORE)
                .add(ModBlocks.CRIMSON_LAPIS_ORE);

        getOrCreateTagBuilder(BlockTags.WALLS)
                .add(ModBlocks.BUGGED_COBBLESTONE_WALL)
                .add(ModBlocks.BUGGED_STONE_WALL)
                .add(ModBlocks.CRIMSON_COBBLESTONE_WALL)
                .add(ModBlocks.CRIMSON_STONE_WALL);

    }
}
