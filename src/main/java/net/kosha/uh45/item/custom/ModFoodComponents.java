package net.kosha.uh45.item.custom;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent CORRUPTED_GRAPE = new FoodComponent.Builder().hunger(2).saturationModifier(1.8f).statusEffect((new StatusEffectInstance(StatusEffects.ABSORPTION, 300, 0)) , 1f).build();
}
