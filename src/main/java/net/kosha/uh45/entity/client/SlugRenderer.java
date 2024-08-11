package net.kosha.uh45.entity.client;

import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.custom.SlugEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class SlugRenderer extends MobEntityRenderer<SlugEntity, SlugModel<SlugEntity>> {
    private static final Identifier TEXTURE = new Identifier(UH415.MOD_ID, "textures/entity/slug.png");



    public SlugRenderer(EntityRendererFactory.Context context) {
        super(context, new SlugModel<>(context.getPart(ModModelLayers.SLUG)), 0.4f);
    }

    @Override
    public Identifier getTexture(SlugEntity entity) {
        return TEXTURE;
    }

    @Override
    public void render(SlugEntity mobEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        float scale = (float) mobEntity.getSlugSize() / mobEntity.getSlugInitailSize();
        matrixStack.scale(scale, scale, scale);

        super.render(mobEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
