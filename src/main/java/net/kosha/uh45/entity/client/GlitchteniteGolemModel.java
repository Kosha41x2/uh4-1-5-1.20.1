// Made with Blockbench 4.10.4
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports

package net.kosha.uh45.entity.client;

import net.kosha.uh45.entity.custom.GlitchteniteGolemEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class GlitchteniteGolemModel<T extends GlitchteniteGolemEntity> extends SinglePartEntityModel<T> {
	private final ModelPart glitchtenite_golem;
	private final ModelPart body;
	private final ModelPart left_fin;
	private final ModelPart left_leg;
	private final ModelPart right_leg;
	private final ModelPart left_arm;
	private final ModelPart right_arm;
	private final ModelPart head;
	private final ModelPart nose;
	private final ModelPart left_horn;
	private final ModelPart right_horn;
	public GlitchteniteGolemModel(ModelPart root) {
		this.glitchtenite_golem = root.getChild("glitchtenite_golem");
		this.body = glitchtenite_golem.getChild("body");
		this.left_fin = body.getChild("left_fin");
		this.left_leg = glitchtenite_golem.getChild("left_leg");
		this.right_leg = glitchtenite_golem.getChild("right_leg");
		this.left_arm = glitchtenite_golem.getChild("left_arm");
		this.right_arm = glitchtenite_golem.getChild("right_arm");
		this.head = glitchtenite_golem.getChild("head");
		this.nose = head.getChild("nose");
		this.left_horn = head.getChild("left_horn");
		this.right_horn = head.getChild("right_horn");
	}
	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData glitchtenite_golem = modelPartData.addChild("glitchtenite_golem", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData body = glitchtenite_golem.addChild("body", ModelPartBuilder.create().uv(0, 40).cuboid(-9.0F, -2.0F, -6.0F, 18.0F, 12.0F, 11.0F, new Dilation(0.0F))
		.uv(0, 70).cuboid(-4.5F, 10.0F, -3.0F, 9.0F, 5.0F, 6.0F, new Dilation(0.5F)), ModelTransform.pivot(0.0F, -31.0F, 0.0F));

		ModelPartData left_fin = body.addChild("left_fin", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 2.0F, 4.5F));

		ModelPartData cube_r1 = left_fin.addChild("cube_r1", ModelPartBuilder.create().uv(84, -12).cuboid(0.0F, -14.0F, -4.0F, 0.0F, 14.0F, 12.0F, new Dilation(0.0F)), ModelTransform.of(-5.0F, 0.0F, 0.0F, -1.5708F, 0.0436F, 0.0F));

		ModelPartData left_leg = glitchtenite_golem.addChild("left_leg", ModelPartBuilder.create().uv(60, 0).cuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -13.0F, 0.0F));

		ModelPartData right_leg = glitchtenite_golem.addChild("right_leg", ModelPartBuilder.create().uv(37, 0).cuboid(-3.5F, -3.0F, -3.0F, 6.0F, 16.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(-4.0F, -13.0F, 0.0F));

		ModelPartData left_arm = glitchtenite_golem.addChild("left_arm", ModelPartBuilder.create().uv(60, 58).cuboid(9.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -31.0F, 0.0F));

		ModelPartData right_arm = glitchtenite_golem.addChild("right_arm", ModelPartBuilder.create().uv(60, 21).cuboid(-13.0F, -2.5F, -3.0F, 4.0F, 30.0F, 6.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -31.0F, 0.0F));

		ModelPartData head = glitchtenite_golem.addChild("head", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -7.0F, 0.0F, 8.0F, 10.0F, 8.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -36.0F, -7.5F));

		ModelPartData nose = head.addChild("nose", ModelPartBuilder.create().uv(24, 0).cuboid(-1.0F, 0.0F, -2.0F, 2.0F, 4.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 2.0F, 0.0F, -1.5708F, 0.0F, 0.0F));

		ModelPartData left_horn = head.addChild("left_horn", ModelPartBuilder.create().uv(0, 29).cuboid(-6.0607F, -14.0607F, 3.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 2).cuboid(-8.0F, -10.0F, 4.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F))
		.uv(2, 2).cuboid(-8.0F, -13.0F, 4.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData cube_r2 = left_horn.addChild("cube_r2", ModelPartBuilder.create().uv(0, 3).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-4.0F, -7.0F, 4.0F, 0.0F, 0.0F, -0.7854F));

		ModelPartData right_horn = head.addChild("right_horn", ModelPartBuilder.create().uv(0, 29).cuboid(-3.0F, -8.0F, -1.0F, 2.0F, 7.0F, 2.0F, new Dilation(0.0F))
		.uv(2, 26).mirrored().cuboid(-5.0F, -7.0F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false)
		.uv(2, 24).mirrored().cuboid(-5.0F, -4.0F, 0.0F, 2.0F, 2.0F, 0.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.of(2.9393F, -6.0607F, 4.0F, 0.0F, 3.1416F, 0.0F));

		ModelPartData cube_r3 = right_horn.addChild("cube_r3", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-0.9393F, -0.9393F, 0.0F, 0.0F, 0.0F, -0.7854F));
		return TexturedModelData.of(modelData, 128, 128);
	}
	@Override
	public void setAngles(GlitchteniteGolemEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		glitchtenite_golem.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return glitchtenite_golem;
	}
}