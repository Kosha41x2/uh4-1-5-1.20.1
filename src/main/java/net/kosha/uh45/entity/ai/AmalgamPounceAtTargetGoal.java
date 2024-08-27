package net.kosha.uh45.entity.ai;

import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.custom.AmalgamEntity;
import net.kosha.uh45.entity.custom.SlugEntity;
import net.minecraft.entity.ai.goal.PounceAtTargetGoal;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.util.math.Vec3d;

public class AmalgamPounceAtTargetGoal extends PounceAtTargetGoal {

    private final AmalgamEntity entity;

    public AmalgamPounceAtTargetGoal(MobEntity mob, float velocity) {
        super(mob, velocity * 1.4f);
        this.entity = (AmalgamEntity) mob;
    }

    @Override
    public void start() {
        super.start();
        entity.setChasing(true);
    }
}
