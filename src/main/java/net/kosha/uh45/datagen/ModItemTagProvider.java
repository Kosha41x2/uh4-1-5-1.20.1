package net.kosha.uh45.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.item.ModItems;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.GLITCHTENITE_HELMET, ModItems.GLITCHTENITE_HELMET, ModItems.GLITCHTENITE_BOOTS, ModItems.GLITCHTENITE_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.MUSIC_DISCS)
                .add(ModItems.UH4_OST_MAIN_THEME_MUSIC_DISK)
                .add(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER)
                .add(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER_PHASE_2);
        getOrCreateTagBuilder(ItemTags.STONE_TOOL_MATERIALS)
                .add(ModBlocks.CRIMSON_STONE.getLootTableId())
                .add(ModBlocks.BUGGED_COBBLESTONE.getLootTableId())
                .add(ModBlocks.CRIMSON_COBBLESTONE.getLootTableId())
                .add(ModBlocks.BUGGED_STONE.getLootTableId());
    }
}
