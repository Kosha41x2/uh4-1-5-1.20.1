package net.kosha.uh45.entity.ai;

import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.custom.AmalgamEntity;
import net.kosha.uh45.entity.custom.SlugEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.util.Hand;

public class AmalgamAttackGoal extends MeleeAttackGoal {

    private final AmalgamEntity entity;
    private int attackDelay = 12;
    private int ticksUntilNextAttack = 12;
    private boolean shouldCountTillNextAttack = true;

    public AmalgamAttackGoal(PathAwareEntity mob, double speed, boolean pauseWhenMobIdle) {
        super(mob, speed, pauseWhenMobIdle);
        entity = ((AmalgamEntity) mob);
    }

    @Override
    public void start(){
        super.start();
        attackDelay = 12;
        ticksUntilNextAttack = 12;
    }

    @Override
    protected void attack(LivingEntity pEnemy, double squaredDistance){
        if (isEnemyWithinAttackDistance(pEnemy)){
            shouldCountTillNextAttack = true;

            if(isTimeToStartAttackAnimation()){
                entity.setAttacking(true);
            }
            if(isTimeToAttack()){
                this.mob.getLookControl().lookAt(pEnemy.getX(), pEnemy.getY(), pEnemy.getZ());
                performAttack(pEnemy);
            }
        } else {
            resetAttackCooldown();
            shouldCountTillNextAttack = false;
            entity.setAttacking(false);
            entity.attackAnimationTimeout = 0;
        }
    }

    private boolean isEnemyWithinAttackDistance(LivingEntity pEnemy){
        return this.entity.distanceTo(pEnemy) <= 2f; //TODO
    }

    protected void resetAttackCooldown() { this.ticksUntilNextAttack = this.getTickCount(attackDelay * 2); }

    protected boolean isTimeToStartAttackAnimation() { return this.ticksUntilNextAttack <= attackDelay; }

    protected boolean isTimeToAttack() {return this.ticksUntilNextAttack <= 0; }

    protected void performAttack(LivingEntity pEnemy){
        this.resetAttackCooldown();
        this.mob.swingHand(Hand.MAIN_HAND);
        this.mob.tryAttack(pEnemy);
    }

    @Override
    public void tick(){
        super.tick();
        if(shouldCountTillNextAttack) {
            this.ticksUntilNextAttack = Math.max(this.ticksUntilNextAttack - 1, 0);
        }
    }

    @Override
    public void stop(){
        entity.setAttacking(false);
        super.stop();
    }
}