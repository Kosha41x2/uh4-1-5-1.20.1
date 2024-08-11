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
                        entries.add(ModBlocks.CORRUPTION_BLOCK);
                        entries.add(ModBlocks.CORRUPTED_ICE);

                        entries.add(ModItems.GLITCHTENITE_SWORD);
                        entries.add(ModItems.GLITCHTENITE_AXE);
                        entries.add(ModItems.GLITCHTENITE_PICKAXE);
                        entries.add(ModItems.GLITCHTENITE_SHOVEL);
                        entries.add(ModItems.GLITCHTENITE_HOE);
                        entries.add(ModItems.GLITCHED_CROSSBOW);

                        entries.add(ModItems.GLITCHTENITE_HELMET);
                        entries.add(ModItems.GLITCHTENITE_CHESTPLATE);
                        entries.add(ModItems.GLITCHTENITE_LEGGINGS);
                        entries.add(ModItems.GLITCHTENITE_BOOTS);


                        entries.add(ModItems.CORRUPTED_GRAPE);
                        entries.add(ModItems.POISONOUS_BERRY);
                        entries.add(ModBlocks.STRANGE_BUSH);
                        entries.add(ModBlocks.HEART_FLOWER);

                        entries.add(ModItems.UH4_OST_MAIN_THEME_MUSIC_DISK);
                        entries.add(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER);
                        entries.add(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER_PHASE_2);

                        entries.add(ModItems.SLUG_SPAWN_EGG);


                    }).build());

    public static void registerItemGroups(){
        UH415.LOGGER.info("Registering Item Groups for " + UH415.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItemGroups::addItemsToTabIngredients);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(ModItemGroups::addBlocksToTabBlocks);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(ModItemGroups::addItemsToTabCombat);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItemGroups::addItemsToTabTools);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItemGroups::addItemsToTabFoodAndDrink);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModItemGroups::addItemsToTabNatural);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register(ModItemGroups::addItemsToTabSpawnEggs);


    }

    //Already existing groups

    //Add these to the building blocks group
    private static void addBlocksToTabBlocks(FabricItemGroupEntries entries){
        entries.add(ModBlocks.RAW_GLITCHTENITE_BLOCK);
        entries.add(ModBlocks.GLITCHTENITE_BLOCK);
        entries.add(ModBlocks.CORRUPTION_BLOCK);
        entries.add(ModBlocks.CORRUPTED_ICE);
    }
    //Add these to the ingredients group
    private static void addItemsToTabIngredients(FabricItemGroupEntries entries){
        entries.add(ModItems.RAW_GLITCHTENITE);
        entries.add(ModItems.GLITCHTENITE_INGOT);
    }

    private static void addItemsToTabCombat(FabricItemGroupEntries entries){
        entries.add(ModItems.GLITCHTENITE_SWORD);
        entries.add(ModItems.GLITCHTENITE_AXE);
        entries.add(ModItems.GLITCHED_CROSSBOW);

        entries.add(ModItems.GLITCHTENITE_HELMET);
        entries.add(ModItems.GLITCHTENITE_CHESTPLATE);
        entries.add(ModItems.GLITCHTENITE_LEGGINGS);
        entries.add(ModItems.GLITCHTENITE_BOOTS);
    }


    private static void addItemsToTabTools(FabricItemGroupEntries entries){
        entries.add(ModItems.GLITCHTENITE_PICKAXE);
        entries.add(ModItems.GLITCHTENITE_AXE);
        entries.add(ModItems.GLITCHTENITE_SHOVEL);
        entries.add(ModItems.GLITCHTENITE_HOE);

        entries.add(ModItems.UH4_OST_MAIN_THEME_MUSIC_DISK);
        entries.add(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER);
        entries.add(ModItems.UH4_OST_BATTLE_THE_GATEKEEPER_PHASE_2);
    }

    private static void addItemsToTabFoodAndDrink(FabricItemGroupEntries entries){
        entries.add(ModItems.CORRUPTED_GRAPE);
        entries.add(ModItems.POISONOUS_BERRY);
    }

    private static void addItemsToTabNatural(FabricItemGroupEntries entries){
        entries.add(ModBlocks.HEART_FLOWER);
        entries.add(ModBlocks.STRANGE_BUSH);
    }

    private static void addItemsToTabSpawnEggs(FabricItemGroupEntries entries){
        entries.add(ModItems.SLUG_SPAWN_EGG);
    }
}
