package net.kosha.uh45.block.custom;

import net.kosha.uh45.UH415;
import net.kosha.uh45.damage_type.ModDamageTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;


import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;

import net.minecraft.util.math.Box;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CorruptionBlock extends Block {
    public CorruptionBlock(Settings settings) {
        super(settings);
    }

    private Map <LivingEntity, Long> lastAppliedTimes = new HashMap<>();
    public static final BooleanProperty ACTIVATED = BooleanProperty.of("activated");

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(ACTIVATED);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(ACTIVATED)) {
            boolean Stepping = isEntityOnBlock(world, pos);
            if(!Stepping){
                world.setBlockState(pos, state.with(ACTIVATED,false));
            }
        }
    }


    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(!world.isClient && entity instanceof LivingEntity livingEntity){
            long currentTime = world.getTime();
            long lastAppliedTime = lastAppliedTimes.getOrDefault(livingEntity, 0L);
            world.setBlockState(pos, state.with(ACTIVATED,true));
            if (currentTime - lastAppliedTime >= 15) { // 20 ticks = 1 second
                EffectApplier(livingEntity, world);
                lastAppliedTimes.put(livingEntity, currentTime);
            }
        }
        else{
            super.onSteppedOn(world, pos, state, entity);
        }
    }

    private void EffectApplier(LivingEntity livingEntity, World world){
        int inSlowness = 0;
        try {
            inSlowness = livingEntity.getStatusEffect(StatusEffects.SLOWNESS).getDuration();
        }
        catch (Exception e){
            inSlowness = 1;
        }
        int inWeakness = 0;
        try {
            inWeakness = livingEntity.getStatusEffect(StatusEffects.WEAKNESS).getDuration();
        }
        catch (Exception e){
            inWeakness = 1;
        }
        if(inSlowness > 1800) {
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, inSlowness + 20 , 3));
            livingEntity.damage(ModDamageTypes.of(world, ModDamageTypes.CORRUPTION_DAMAGE) , 2.0f);
        }
        else if (inSlowness > 600){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, inSlowness + 120 , 1));
            livingEntity.damage(ModDamageTypes.of(world, ModDamageTypes.CORRUPTION_DAMAGE) , 1.0f);
        }
        else{
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, inSlowness + 60 , 0));
        }
        if (inWeakness > 1200){
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, inWeakness * 2 + 20 , 1));
        }
        else{
            livingEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, inWeakness * 2 + 20 , 0));
        }
    }

    private boolean isEntityOnBlock(World world, BlockPos pos) {
        Box box = new Box(pos).expand(0.0, 0.5, 0.0); // A small expansion to check the entities' feet level
        List<Entity> entities = world.getOtherEntities(null, box, entity -> entity instanceof LivingEntity);
        return !entities.isEmpty();
    }
}
