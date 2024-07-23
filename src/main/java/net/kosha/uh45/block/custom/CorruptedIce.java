package net.kosha.uh45.block.custom;

import net.kosha.uh45.damage_type.ModDamageTypes;
import net.kosha.uh45.entity.attribute.ModEntityAttributes;
import net.minecraft.block.BlockState;
import net.minecraft.block.TransparentBlock;
import net.minecraft.entity.Entity;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageSources;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.tick.TickPriority;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class CorruptedIce extends TransparentBlock {
    public CorruptedIce(Settings settings) {
        super(settings);
    }

    private Map<LivingEntity, Long> lastAppliedTimes = new HashMap<>();

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        super.onSteppedOn(world, pos, state, entity);
        if(entity instanceof LivingEntity livingEntity) {
            long currentTime = world.getTime();
            long lastAppliedTime = lastAppliedTimes.getOrDefault(livingEntity, 0L);

            livingEntity.setFrozenTicks(livingEntity.getFrozenTicks() + 5); // Increase frozen ticks, 20 ticks = 1 second

            if (currentTime - lastAppliedTime >= 15) { // 20 ticks = 1 second
                effectApplier(livingEntity, world);
                lastAppliedTimes.put(livingEntity, currentTime);
            }
        }
    }

    private void effectApplier(LivingEntity livingEntity, World world){
        ModDamageTypes.DamageWithCorruption(livingEntity, world, 3.0f);
    }
}
