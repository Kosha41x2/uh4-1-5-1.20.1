package net.kosha.uh45.potion;

import net.kosha.uh45.UH415;
import net.kosha.uh45.effect.ModEffects;
import net.kosha.uh45.item.ModItems;
import net.kosha.uh45.mixin.BrewingRecipeRegistryMixin;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static Potion CORRUPTION_RESISTANCE_POTION = registerPotion("corruption_resistance_potion",
            new StatusEffectInstance(ModEffects.CORRUPTION_RESISTANCE, 3600, 0));

    public static Potion LONG_CORRUPTION_RESISTANCE_POTION = registerPotion("long_corruption_resistance_potion",
            new StatusEffectInstance(ModEffects.CORRUPTION_RESISTANCE, 9600, 0));

    public static Potion STRONG_CORRUPTION_RESISTANCE_POTION = registerPotion("strong_corruption_resistance_potion",
            new StatusEffectInstance(ModEffects.CORRUPTION_RESISTANCE, 3600, 1));

    public static Potion registerPotion(String name, StatusEffectInstance ... effects){
        return Registry.register(Registries.POTION, new Identifier(UH415.MOD_ID, name),
                new Potion(effects));
    }
    public static void registerModPotions(){
        UH415.LOGGER.info("Registering Mod Potions for " + UH415.MOD_ID);
        registerPotionRecipes();
    }
    private static void registerPotionRecipes(){
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, ModItems.POISONOUS_BERRY,
                ModPotions.CORRUPTION_RESISTANCE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.CORRUPTION_RESISTANCE_POTION, Items.REDSTONE,
                ModPotions.LONG_CORRUPTION_RESISTANCE_POTION);
        BrewingRecipeRegistryMixin.invokeRegisterPotionRecipe(ModPotions.CORRUPTION_RESISTANCE_POTION, Items.GLOWSTONE_DUST,
                ModPotions.STRONG_CORRUPTION_RESISTANCE_POTION);
    }
}
