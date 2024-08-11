package net.kosha.uh45.entity.client;

import net.kosha.uh45.entity.animation.ModAnimations;
import net.kosha.uh45.entity.custom.SlugEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class SlugModel<T extends SlugEntity> extends SinglePartEntityModel<T> {
	private final ModelPart slug;
	private final ModelPart body;
	private final ModelPart head;
	private final ModelPart left_antenna;
	private final ModelPart right_antenna;
	private final ModelPart tail;
	private final ModelPart tail_2;

	public SlugModel(ModelPart root) {
		this.slug = root.getChild("slug");
		this.body = slug.getChild("body");
		this.head = body.getChild("head");
		this.left_antenna = head.getChild("left_antenna");
		this.right_antenna = head.getChild("right_antenna");
		this.tail = body.getChild("tail");
		this.tail_2 = tail.getChild("tail_2");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData root = modelData.getRoot();
		ModelPartData slug = root.addChild("slug", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = slug.addChild("body", ModelPartBuilder.create()
				.uv(0, 0).cuboid(-2.0F, -2.0F, -3.0F, 4.0F, 2.0F, 4.0F)
				.uv(10, 7).cuboid(-1.0F, -3.0F, -3.0F, 2.0F, 1.0F, 4.0F), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		body.addChild("cube_r1", ModelPartBuilder.create().uv(12, 2).cuboid(-2.2464F, 0.3536F, -1.9F, 1.0F, 1.0F, 4.0F), ModelTransform.of(-0.3536F, -3.8536F, -1.0F, 0.0F, 0.0F, -0.7854F));
		body.addChild("cube_r2", ModelPartBuilder.create().uv(8, 13).cuboid(-2.2464F, 0.3536F, -1.9F, 1.0F, 1.0F, 4.0F), ModelTransform.of(1.6464F, -3.8536F, -1.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(18, 0).cuboid(-1.0F, -1.0F, -2.0F, 2.0F, 2.0F, 2.0F), ModelTransform.pivot(0.0F, -1.0F, -3.0F));

		head.addChild("left_antenna", ModelPartBuilder.create().uv(2, 22).mirrored().cuboid(-0.1138F, -2.5372F, 0.0219F, 1.0F, 4.0F, 1.0F).mirrored(false), ModelTransform.of(-1.0F, -1.0F, -1.0F, 0.1309F, -0.0436F, -0.48F));
		head.addChild("right_antenna", ModelPartBuilder.create().uv(2, 22).cuboid(-0.8862F, -2.5372F, 0.0219F, 1.0F, 4.0F, 1.0F), ModelTransform.of(1.0F, -1.0F, -1.0F, 0.1309F, -0.0436F, 0.48F));

		ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(0, 6).cuboid(-2.0F, 0.0F, 0.0F, 4.0F, 2.0F, 3.0F), ModelTransform.pivot(0.0F, -2.0F, 1.0F));
		tail.addChild("cube_r3", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -0.8695F, -0.9914F, 2.0F, 1.0F, 4.0F), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.1309F, 0.0F, 0.0F));
		tail.addChild("tail_2", ModelPartBuilder.create().uv(15, 15).cuboid(-1.0F, 0.0F, 0.0F, 2.0F, 2.0F, 3.0F), ModelTransform.pivot(0.0F, 0.0F, 3.0F));

		return TexturedModelData.of(modelData, 32, 32);
	}

	@Override
	public void setAngles(SlugEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(netHeadYaw, headPitch);
		this.animateMovement(ModAnimations.WALK, limbSwing, limbSwingAmount, 10f, 15f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.IDLE, ageInTicks, 1f);
		this.updateAnimation(entity.attackAnimationState, ModAnimations.ATTACK, ageInTicks, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch){
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		slug.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return slug;
	}
}