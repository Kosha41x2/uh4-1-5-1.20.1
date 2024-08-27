package net.kosha.uh45.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.ModEntities;
import net.kosha.uh45.item.custom.GlitchedCrossbowItem;
import net.kosha.uh45.item.custom.GlitchteniteArmor;
import net.kosha.uh45.item.custom.ModFoodComponents;
import net.kosha.uh45.sound.ModSounds;
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
    public static final Item GLITCHTENITE_HELMET = registerItem("glitchtenite_helmet", new GlitchteniteArmor(ModArmorMaterials.GLITCHTENITE, ArmorItem.Type.HELMET, new FabricItemSettings(), 1));
    public static final Item GLITCHTENITE_CHESTPLATE = registerItem("glitchtenite_chestplate", new GlitchteniteArmor(ModArmorMaterials.GLITCHTENITE, ArmorItem.Type.CHESTPLATE, new FabricItemSettings(), 1));
    public static final Item GLITCHTENITE_LEGGINGS = registerItem("glitchtenite_leggings", new GlitchteniteArmor(ModArmorMaterials.GLITCHTENITE, ArmorItem.Type.LEGGINGS, new FabricItemSettings(), 1));
    public static final Item GLITCHTENITE_BOOTS = registerItem("glitchtenite_boots", new GlitchteniteArmor(ModArmorMaterials.GLITCHTENITE,ArmorItem.Type.BOOTS, new FabricItemSettings(), 1));
    public static final Item CORRUPTED_GRAPE = registerItem("corrupted_grape", new Item(new FabricItemSettings().food(ModFoodComponents.CORRUPTED_GRAPE)));
    public static final Item POISONOUS_BERRY = registerItem("poisonous_berry", new Item(new FabricItemSettings().food(ModFoodComponents.POISONOUS_BERRY)));
    public static final Item UH4_OST_MAIN_THEME_MUSIC_DISK = registerItem("main_theme_music_disk", new MusicDiscItem(7 , ModSounds.UH4_OST_MAIN_THEME ,new FabricItemSettings().maxCount(1), 101));
    public static final Item UH4_OST_BATTLE_THE_GATEKEEPER = registerItem("the_gatekeeper_music_disk", new MusicDiscItem(7 , ModSounds.UH4_OST_BATTLE_THE_GATEKEEPER ,new FabricItemSettings().maxCount(1), 108));
    public static final Item UH4_OST_BATTLE_THE_GATEKEEPER_PHASE_2 = registerItem("the_gatekeeper_phase_2_music_disk", new MusicDiscItem(7 , ModSounds.UH4_OST_BATTLE_THE_GATEKEEPER_PHASE_2 ,new FabricItemSettings().maxCount(1), 152));
    public static final Item SLUG_SPAWN_EGG = registerItem("slug_spawn_egg", new SpawnEggItem(ModEntities.SLUG, 61909, 16057301,new FabricItemSettings()));
    public static final Item AMALGAM_SPAWN_EGG = registerItem("amalgam_spawn_egg", new SpawnEggItem(ModEntities.AMALGAM, 16053237, 3336933,new FabricItemSettings()));
    public static final Item GLITCHTENITE_GOLEM_SPAWN_EGG = registerItem("glitchtenite_golem_spawn_egg", new SpawnEggItem(ModEntities.GLITCHTENITE_GOLEM, 2495736, 11539683,new FabricItemSettings()));




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
