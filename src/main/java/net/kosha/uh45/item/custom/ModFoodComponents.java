package net.kosha.uh45.item.custom;

import net.kosha.uh45.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CORRUPTED_GRAPE = new FoodComponent.Builder().hunger(2).saturationModifier(1.8f).statusEffect((new StatusEffectInstance(ModEffects.CORRUPTION_RESISTANCE, 300, 0)) , 1f).build();
    public static final FoodComponent POISONOUS_BERRY = new FoodComponent.Builder().hunger(2).saturationModifier(1.8f).statusEffect((new StatusEffectInstance(StatusEffects.POISON, 300, 9)) , 1f).build();

}
