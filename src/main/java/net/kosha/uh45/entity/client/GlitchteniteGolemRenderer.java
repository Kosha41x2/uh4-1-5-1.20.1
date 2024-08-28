package net.kosha.uh45.entity.client;

import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.custom.GlitchteniteGolemEntity;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class GlitchteniteGolemRenderer extends MobEntityRenderer<GlitchteniteGolemEntity, GlitchteniteGolemModel<GlitchteniteGolemEntity>> {

    private static final Identifier TEXTURE = new Identifier(UH415.MOD_ID, "textures/entity/glitchtenite_golem.png");

    public GlitchteniteGolemRenderer(EntityRendererFactory.Context context) {
        super(context, new GlitchteniteGolemModel<>(context.getPart(ModModelLayers.GLITCHTENITE_GOLEM)), 0.7f);
    }

    @Override
    public Identifier getTexture(GlitchteniteGolemEntity entity) {
        return TEXTURE;
    }
}
