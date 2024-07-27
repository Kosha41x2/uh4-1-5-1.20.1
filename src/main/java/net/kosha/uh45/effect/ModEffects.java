package net.kosha.uh45.effect;

import net.kosha.uh45.UH415;
import net.kosha.uh45.effect.custom.CorruptionResistanceEffect;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static StatusEffect CORRUPTION_RESISTANCE = registerStatusEffect("corruption_resistance", StatusEffectCategory.BENEFICIAL, 3215610);;

    private static StatusEffect registerStatusEffect(String name, StatusEffectCategory statusEffectCategory, int color){
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(UH415.MOD_ID, name),
                new CorruptionResistanceEffect(statusEffectCategory, color));
    }

    public static void registerEffects(){
        UH415.LOGGER.info("Registering Mod Effect for " + UH415.MOD_ID);
    }
}
