package net.kosha.uh45.damage_type;

import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.attribute.ModEntityAttributes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class ModDamageTypes {

    public static final RegistryKey<DamageType> CORRUPTION_DAMAGE = RegistryKey.of(RegistryKeys.DAMAGE_TYPE, new Identifier(UH415.MOD_ID, "corruption_damage"));

    private static DamageSource of(World world, RegistryKey<DamageType> key) {
        return new DamageSource(world.getRegistryManager().get(RegistryKeys.DAMAGE_TYPE).entryOf(key));
    }

    public static void DamageWithCorruption(Entity entity, World world, float damageAmount){
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.damage(ModDamageTypes.of(world, ModDamageTypes.CORRUPTION_DAMAGE), damageAmount * (1 - (float) livingEntity.getAttributeValue(ModEntityAttributes.GENERIC_CORRUPTION_RESISTANCE) / ModEntityAttributes.maxCorruptionResistance));
        }
        else{
            entity.damage(ModDamageTypes.of(world, ModDamageTypes.CORRUPTION_DAMAGE), damageAmount);
        }
    }
}