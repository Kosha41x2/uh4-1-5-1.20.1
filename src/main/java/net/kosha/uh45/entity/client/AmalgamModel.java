// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.kosha.uh45.entity.client;

import net.kosha.uh45.entity.animation.ModAmalgamAnimations;
import net.kosha.uh45.entity.custom.AmalgamEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;


public class AmalgamModel<T extends AmalgamEntity> extends SinglePartEntityModel<T> {
	private final ModelPart amalgam;
	private final ModelPart body;
	private final ModelPart right_front_leg;
	private final ModelPart right_front_leg_2;
	private final ModelPart right_back_leg;
	private final ModelPart right_back_leg_2;
	private final ModelPart back_leg;
	private final ModelPart back_leg_2;
	private final ModelPart up_body;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart right_arm_2;
	private final ModelPart left_arm2;
	private final ModelPart second_articulation;
	private final ModelPart claw_1;
	private final ModelPart claw_2;
	private final ModelPart head;
	private final ModelPart jaw;

	public AmalgamModel(ModelPart root) {
		this.amalgam = root.getChild("amalgam");
		this.body = amalgam.getChild("body");
		this.right_front_leg = body.getChild("right_front_leg");
		this.right_front_leg_2 = right_front_leg.getChild("right_front_leg_2");
		this.right_back_leg = body.getChild("right_back_leg");
		this.right_back_leg_2 = right_back_leg.getChild("right_back_leg_2");
		this.back_leg = body.getChild("back_leg");
		this.back_leg_2 = back_leg.getChild("back_leg_2");
		this.up_body = body.getChild("up_body");
		this.left_arm = up_body.getChild("left_arm");
		this.right_arm = up_body.getChild("right_arm");
		this.right_arm_2 = right_arm.getChild("right_arm_2");
		this.left_arm2 = up_body.getChild("left_arm2");
		this.second_articulation = left_arm2.getChild("second_articulation");
		this.claw_1 = second_articulation.getChild("claw_1");
		this.claw_2 = second_articulation.getChild("claw_2");
		this.head = up_body.getChild("head");
		this.jaw = head.getChild("jaw");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData amalgam = modelPartData.addChild("amalgam", ModelPartBuilder.create(), ModelTransform.of(0.0F, 24.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		ModelPartData body = amalgam.addChild("body", ModelPartBuilder.create().uv(16, 12).cuboid(-2.0F, -10.0F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_front_leg = body.addChild("right_front_leg", ModelPartBuilder.create().uv(8, 29).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -5.0F, -1.0F, -1.1889F, 0.5212F, 0.9874F));

		ModelPartData right_front_leg_2 = right_front_leg.addChild("right_front_leg_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

		ModelPartData cube_r1 = right_front_leg_2.addChild("cube_r1", ModelPartBuilder.create().uv(16, 21).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.031F, 0.5304F, -0.9263F));

		ModelPartData right_back_leg = body.addChild("right_back_leg", ModelPartBuilder.create().uv(0, 29).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, -5.0F, 1.0F, 1.0887F, 0.2902F, 2.4031F));

		ModelPartData right_back_leg_2 = right_back_leg.addChild("right_back_leg_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

		ModelPartData cube_r2 = right_back_leg_2.addChild("cube_r2", ModelPartBuilder.create().uv(8, 21).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 1.031F, 0.5304F, -0.9263F));

		ModelPartData back_leg = body.addChild("back_leg", ModelPartBuilder.create(), ModelTransform.of(1.0F, -5.0F, 0.0F, -3.1092F, -0.6483F, 1.3697F));

		ModelPartData cube_r3 = back_leg.addChild("cube_r3", ModelPartBuilder.create().uv(28, 9).cuboid(-1.0F, -5.0F, -1.0F, 2.0F, 5.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 5.0F, 0.0F, 0.0F, 0.0436F, 0.0F));

		ModelPartData back_leg_2 = back_leg.addChild("back_leg_2", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 5.0F, 0.0F));

		ModelPartData cube_r4 = back_leg_2.addChild("cube_r4", ModelPartBuilder.create().uv(0, 21).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 6.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.8436F, 0.5526F, -0.9729F));

		ModelPartData up_body = body.addChild("up_body", ModelPartBuilder.create().uv(0, 12).cuboid(-2.7321F, -5.2321F, -2.0F, 4.0F, 5.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, -10.299F, 0.0F, 0.0F, 0.0F, -0.5236F));

		ModelPartData left_arm = up_body.addChild("left_arm", ModelPartBuilder.create(), ModelTransform.pivot(-0.7321F, -1.2321F, 0.0F));

		ModelPartData right_arm = up_body.addChild("right_arm", ModelPartBuilder.create().uv(18, 4).cuboid(-0.3179F, -0.227F, -1.4833F, 1.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, -2.2321F, 2.0F, 0.088F, -0.5358F, -0.1847F));

		ModelPartData right_arm_2 = right_arm.addChild("right_arm_2", ModelPartBuilder.create(), ModelTransform.pivot(0.1557F, 0.3813F, 3.0393F));

		ModelPartData cube_r5 = right_arm_2.addChild("cube_r5", ModelPartBuilder.create().uv(25, 4).cuboid(0.5263F, -0.615F, -0.5979F, 1.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(-1.0F, 0.0F, 0.0F, 0.1425F, -0.7868F, -0.016F));

		ModelPartData left_arm2 = up_body.addChild("left_arm2", ModelPartBuilder.create().uv(18, 0).cuboid(-5.0F, -1.0F, -1.7F, 5.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-1.7321F, -2.2321F, -1.0F, 0.1372F, -1.0448F, -0.2468F));

		ModelPartData second_articulation = left_arm2.addChild("second_articulation", ModelPartBuilder.create().uv(24, 21).cuboid(-4.0F, -1.0F, -0.7F, 4.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 0.0F, -1.0F, 0.0F, 0.8727F, 0.0F));

		ModelPartData claw_1 = second_articulation.addChild("claw_1", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 0.0F, -1.0F));

		ModelPartData cube_r6 = claw_1.addChild("cube_r6", ModelPartBuilder.create().uv(24, 25).cuboid(-3.0F, -1.5F, -1.0F, 3.0F, 3.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.2618F, 0.0F));

		ModelPartData claw_2 = second_articulation.addChild("claw_2", ModelPartBuilder.create(), ModelTransform.pivot(-4.0F, 0.0F, 1.0F));

		ModelPartData cube_r7 = claw_2.addChild("cube_r7", ModelPartBuilder.create().uv(12, 12).cuboid(-2.0F, -1.0F, 0.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, -0.1309F, 0.0F));

		ModelPartData head = up_body.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-5.75F, -4.201F, -2.0F, 7.0F, 3.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.9163F));

		ModelPartData jaw = head.addChild("jaw", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -1.0F, 0.0F));

		ModelPartData cube_r8 = jaw.addChild("cube_r8", ModelPartBuilder.create().uv(0, 7).cuboid(-5.7054F, -0.1583F, -2.0F, 7.0F, 1.0F, 4.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6109F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(AmalgamEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.animateMovement(ModAmalgamAnimations.AMALGAM_WALK, limbSwing, limbSwingAmount, 4f, 5f);
		this.updateAnimation(entity.chaseAnimationState, ModAmalgamAnimations.AMALGAM_CHASE, ageInTicks, 1.5f);
		this.updateAnimation(entity.idleAnimationState, ModAmalgamAnimations.AMALGAM_IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAmalgamAnimations.AMALGAM_ATTACK, ageInTicks, 1f);

	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		amalgam.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return amalgam;
	}
}