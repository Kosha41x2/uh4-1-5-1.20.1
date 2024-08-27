package net.kosha.uh45.entity.client;

import net.kosha.uh45.UH415;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModModelLayers {
    public static final EntityModelLayer SLUG =
            new EntityModelLayer(new Identifier(UH415.MOD_ID,"slug"), "main");
    public static final EntityModelLayer AMALGAM =
            new EntityModelLayer(new Identifier(UH415.MOD_ID,"amalgam"), "main");
    public static final EntityModelLayer GLITCHTENITE_GOLEM =
            new EntityModelLayer(new Identifier(UH415.MOD_ID,"glitchtenite_golem"), "main");
}
