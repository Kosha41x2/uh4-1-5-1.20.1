package net.kosha.uh45.entity.client;

import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.custom.AmalgamEntity;
import net.kosha.uh45.entity.custom.SlugEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class AmalgamRenderer extends MobEntityRenderer<AmalgamEntity, AmalgamModel<AmalgamEntity>> {

    private static final Identifier TEXTURE = new Identifier(UH415.MOD_ID, "textures/entity/amalgam.png");

    public AmalgamRenderer(EntityRendererFactory.Context context) {
        super(context, new AmalgamModel<>(context.getPart(ModModelLayers.AMALGAM)), 0.48f);
    }

    @Override
    public Identifier getTexture(AmalgamEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(AmalgamEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        matrixStack.scale(2.5f, 2.5f, 2.5f);
        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
