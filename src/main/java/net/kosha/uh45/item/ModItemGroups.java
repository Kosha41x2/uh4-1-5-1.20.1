package net.kosha.uh45.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.kosha.uh45.UH415;
import net.kosha.uh45.block.ModBlocks;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup CORRUPTED = Registry.register(Registries.ITEM_GROUP,
            new Identifier(UH415.MOD_ID, "corrupted"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.corrupted"))
                    .icon(() -> new ItemStack(ModItems.GLITCHTENITE_INGOT)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_GLITCHTENITE);
                        entries.add(ModItems.GLITCHTENITE_INGOT);
                        entries.add(ModBlocks.RAW_GLITCHTENITE_BLOCK);
                        entries.add(ModBlocks.GLITCHTENITE_BLOCK);

                    }).build());

    public static void registerItemGroups(){
        UH415.LOGGER.info("Registering Item Groups for " + UH415.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroups::addItemsToTabIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItemGroups::addBlocksToTabBlocks);
    }

    //Already existing groups

    //Add these to the building blocks group
    private static void addBlocksToTabBlocks(FabricItemGroupEntries entries){
        entries.add(ModBlocks.RAW_GLITCHTENITE_BLOCK);
        entries.add(ModBlocks.GLITCHTENITE_BLOCK);
    }
    //Add these to the ingredients group
    private static void addItemsToTabIngredients(FabricItemGroupEntries entries){
        entries.add(ModItems.RAW_GLITCHTENITE);
        entries.add(ModItems.GLITCHTENITE_INGOT);
    }

}
