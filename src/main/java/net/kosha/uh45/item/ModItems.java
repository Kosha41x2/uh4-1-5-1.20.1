package net.kosha.uh45.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kosha.uh45.UH415;
import net.kosha.uh45.item.custom.GlitchedCrossbowItem;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item RAW_GLITCHTENITE = registerItem("raw_glitchtenite", new Item(new FabricItemSettings()));
    public static final Item GLITCHTENITE_INGOT = registerItem("glitchtenite_ingot", new Item(new FabricItemSettings()));
    public static final Item GLITCHTENITE_PICKAXE = registerItem("glitchtenite_pickaxe", new PickaxeItem(ModToolMaterial.GLITCHTENITE,1, realAttackSpeed(1.2f),new FabricItemSettings()));
    public static final Item GLITCHTENITE_AXE = registerItem("glitchtenite_axe", new AxeItem(ModToolMaterial.GLITCHTENITE,6, realAttackSpeed(0.9f),new FabricItemSettings()));
    public static final Item GLITCHTENITE_SHOVEL = registerItem("glitchtenite_shovel", new ShovelItem(ModToolMaterial.GLITCHTENITE,1, realAttackSpeed(1.0f),new FabricItemSettings()));
    public static final Item GLITCHTENITE_HOE = registerItem("glitchtenite_hoe", new HoeItem(ModToolMaterial.GLITCHTENITE,0, realAttackSpeed(1.0f),new FabricItemSettings()));
    public static final Item GLITCHTENITE_SWORD = registerItem("glitchtenite_sword", new SwordItem(ModToolMaterial.GLITCHTENITE,3, realAttackSpeed(1.6f),new FabricItemSettings()));
    public static final Item GLITCHED_CROSSBOW = registerItem("glitched_crossbow", (Item)new GlitchedCrossbowItem(new FabricItemSettings().maxCount(1).maxDamage(687)));


    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, new Identifier(UH415.MOD_ID, name), item);
    }

    public static void registerModItems(){
        UH415.LOGGER.info("Registering Mod Items for " + UH415.MOD_ID);
    }
    private static float realAttackSpeed(float attackSpeed){
        return attackSpeed - 4;
    }
}
