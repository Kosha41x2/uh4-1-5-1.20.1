package net.kosha.uh45.entity.custom;

import net.kosha.uh45.effect.ModEffects;
import net.kosha.uh45.entity.ai.SlugAttackGoal;
import net.kosha.uh45.entity.attribute.ModEntityAttributes;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.ZombifiedPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class SlugEntity extends HostileEntity {

    private static final TrackedData<Integer> SIZE = DataTracker.registerData(SlugEntity.class, TrackedDataHandlerRegistry.INTEGER);
    private static final int MIN_SIZE_VALUE = 1;
    private static final int MAX_SIZE_VALUE = 100;
    private static final int INITIAL_SIZE_VALUE = 5;

    private static final TrackedData<Boolean> ATTACKING = DataTracker.registerData(SlugEntity.class ,TrackedDataHandlerRegistry.BOOLEAN);

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public final AnimationState attackAnimationState = new AnimationState();
    public int attackAnimationTimeout = 0;


    private void setupAnimationStates(){
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = this.random.nextInt(40) + 80;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }

        if(this.isAttacking() && attackAnimationTimeout <= 0){
            attackAnimationTimeout = 40;
            attackAnimationState.start(this.age);
        } else{
            --this.attackAnimationTimeout;
        }

        if(!this.isAttacking()){
            attackAnimationState.stop();
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




    public SlugEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 2;
        this.setPathfindingPenalty(PathNodeType.WATER, 0.0f);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(2, new LookAtEntityGoal(this, PlayerEntity.class, 8.0f));
        this.goalSelector.add(4, new LookAroundGoal(this));
        this.goalSelector.add(3, new WanderAroundFarGoal(this, 0.8));
        this.goalSelector.add(1, new SlugAttackGoal(this, 1D, true));
        this.targetSelector.add(1, new RevengeGoal(this));
        this.targetSelector.add(2, new ActiveTargetGoal<PlayerEntity>(this, PlayerEntity.class, true));

    }

    public static DefaultAttributeContainer.Builder createSlugAttributes(){
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, INITIAL_SIZE_VALUE + 5)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, INITIAL_SIZE_VALUE * 0.005f + 0.095f)
                .add(ModEntityAttributes.GENERIC_CORRUPTION_RESISTANCE, 12)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, Math.floor((double) INITIAL_SIZE_VALUE / 5) + 2);
    }

    public void setAttacking(boolean attacking){
        this.dataTracker.set(ATTACKING, attacking);
    }

    @Override
    public boolean isAttacking(){
        return this.dataTracker.get(ATTACKING);
    }

    @Override
    public boolean isPushedByFluids() {
        return false;
    }

    @Override
    public boolean canBreatheInWater() {
        return true;
    }

    @Override
    public EntityGroup getGroup() {
        return EntityGroup.ARTHROPOD;
    }

    @Override
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
        this.dataTracker.startTracking(SIZE, INITIAL_SIZE_VALUE);
    }

    @Override
    public void writeCustomDataToNbt(NbtCompound nbt) {
        super.writeCustomDataToNbt(nbt);
        nbt.putInt("Size", this.getSlugSize());
    }

    @Override
    public void readCustomDataFromNbt(NbtCompound nbt) {
        this.setSlugSize(nbt.getInt("Size"), false);
        super.readCustomDataFromNbt(nbt);
    }

    public int getSlugSize() {
        return this.dataTracker.get(SIZE);
    }

    public void setSlugSize(int size, boolean heal) {

        int lastMaxHealth = (int)this.getMaxHealth();
        int i = MathHelper.clamp(size, MIN_SIZE_VALUE, MAX_SIZE_VALUE);
        this.dataTracker.set(SIZE, i);
        this.refreshPosition();
        this.calculateDimensions();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue(i + 5);
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue(i * 0.005f + 0.095f);
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue(Math.floor((double) i / 5) + 2);
        if(heal){
            this.heal(this.getMaxHealth() - lastMaxHealth);
        }
    }


    public int getSlugInitailSize() {
        return INITIAL_SIZE_VALUE;
    }

    @Override
    protected float getActiveEyeHeight(EntityPose pose, EntityDimensions dimensions) {
        return 0.35f;
    }
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_SLIME_HURT;
    }
}
