package net.kosha.uh45.effect.custom;

import net.kosha.uh45.entity.attribute.ModEntityAttributes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.AttributeContainer;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

import java.util.UUID;

public class CorruptionResistanceEffect extends StatusEffect {
    public CorruptionResistanceEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    EntityAttributeModifier boost = null;
    UUID CORRUPTION_RESISTANCE_MODIFIER_ID = UUID.randomUUID();

    @Override
    public void onApplied(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        if(!entity.getWorld().isClient){

            boost = new EntityAttributeModifier(CORRUPTION_RESISTANCE_MODIFIER_ID,"corruption_resistance_boost", (amplifier + 1) * 2, EntityAttributeModifier.Operation.ADDITION);
            if (entity.getAttributes().hasAttribute(ModEntityAttributes.GENERIC_CORRUPTION_RESISTANCE)) {
                entity.getAttributeInstance(ModEntityAttributes.GENERIC_CORRUPTION_RESISTANCE).addTemporaryModifier(boost);
            }
        }
        super.onApplied(entity, attributes, amplifier);
    }

    @Override
    public void onRemoved(LivingEntity entity, AttributeContainer attributes, int amplifier) {
        super.onRemoved(entity, attributes, amplifier);
        if (!entity.getWorld().isClient) {
            if (entity.getAttributes().hasAttribute(ModEntityAttributes.GENERIC_CORRUPTION_RESISTANCE)) {
                if (boost != null){
                    entity.getAttributeInstance(ModEntityAttributes.GENERIC_CORRUPTION_RESISTANCE)
                            .removeModifier(CORRUPTION_RESISTANCE_MODIFIER_ID);
                }
            }
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }
}
