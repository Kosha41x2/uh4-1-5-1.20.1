package net.kosha.uh45.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kosha.uh45.UH415;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_GLITCHTENITE = registerItem("raw_glitchtenite", new Item(new FabricItemSettings()));
    public static final Item GLITCHTENITE_INGOT = registerItem("glitchtenite_ingot", new Item(new FabricItemSettings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(UH415.MOD_ID, name), item);
    }

    public static void registerModItems(){
        UH415.LOGGER.info("Registering Mod Items for " + UH415.MOD_ID);
    }
}
