package net.kosha.uh45.entity.custom;

import net.kosha.uh45.effect.ModEffects;
import net.kosha.uh45.entity.ai.AmalgamAttackGoal;
import net.kosha.uh45.entity.ai.AmalgamPounceAtTargetGoal;
import net.kosha.uh45.entity.attribute.ModEntityAttributes;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class AmalgamEntity extends HostileEntity {

    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(AmalgamEntity.class, TrackedDataHandlerRegistry.BOOLEAN);
    private static final TrackedData<Boolean> CHASING = DataTracker.registerData(AmalgamEntity.class, TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;

    public final AnimationState chaseAnimationState = new AnimationState();
    public int chaseAnimationTimeout = 0;

    public AmalgamEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 5;
    }

    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0 && !attackAnimationState.isRunning() && !chaseAnimationState.isRunning()) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 18;
            attackAnimationState.start(this.age);
            idleAnimationState.stop();
        } else{
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
        }
        if(isChasing() && chaseAnimationTimeout <= 0){
            chaseAnimationTimeout = 23;
            this.chaseAnimationState.start(this.age);
            setChasing(false);
        } else{
            this.chaseAnimationTimeout--;
        }

        if(!isChasing() && chaseAnimationTimeout <= 0){
            this.chaseAnimationState.stop();
        }

        if(this.chaseAnimationState.isRunning()){
        }
    }

    @Override
    protected void updateLimbs(float posDelta) {
        float f = this.getPose() == EntityPose.STANDING ? Math.min(posDelta * 6.0f, 1.0f) : 0.0f;
        this.limbAnimator.updateLimbs(f, 0.2f);
    }

    @Override
    public void tick() {
        super.tick();
        if(this.getWorld().isClient()){
            setupAnimationStates();
        }
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new FleeEntityGoal<GlitchteniteGolemEntity>(this, GlitchteniteGolemEntity.class, 6.0f, 1.0, 1.2));
        this.goalSelector.add(2, new AmalgamPounceAtTargetGoal(this, 0.4f));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));
        this.targetSelector.add(3, new ActiveTargetGoal<IronGolemEntity>((MobEntity)this, IronGolemEntity.class, true));
        this.goalSelector.add(3, new AmalgamAttackGoal(this, 1D, true));
        this.goalSelector.add(4, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(6, new LookAroundGoal(this));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 0.8));
    }

    public static DefaultAttributeContainer.Builder createAmalgamAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 30)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25f)
                .add(ModEntityAttributes.GENERIC_CORRUPTION_RESISTANCE, 12)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4);
    }

    public boolean canHaveStatusEffect(StatusEffectInstance effect) {
        if (effect.getEffectType() == ModEffects.CORRUPTION_RESISTANCE) {
            return false;
        }
        return super.canHaveStatusEffect(effect);
    }

    @Override
    protected void initDataTracker() {
        super.initDataTracker();
        this.dataTracker.startTracking(ATTACKING, false);
        this.dataTracker.startTracking(CHASING, false);
    }

    public boolean isChasing(){
        return this.dataTracker.get(CHASING);
    }
    public void setChasing(boolean b){
        this.dataTracker.set(CHASING, b, true);
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 2.2f;
    }
}
