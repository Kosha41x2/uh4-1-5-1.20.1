package net.kosha.uh45;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.entity.client.ModModelLayers;
import net.kosha.uh45.entity.client.SlugModel;
import net.kosha.uh45.entity.client.SlugRenderer;
import net.kosha.uh45.entity.custom.ModEntities;
import net.kosha.uh45.util.ModModelPredicateProvider;
import net.minecraft.client.render.RenderLayer;


public class UH415Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModModels();
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEART_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_HEART_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.STRANGE_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_STRANGE_BUSH, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.SLUG, SlugRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.SLUG, SlugModel::getTexturedModelData);
    }
}
