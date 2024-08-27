package net.kosha.uh45.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.kosha.uh45.UH415;
import net.kosha.uh45.entity.custom.AmalgamEntity;
import net.kosha.uh45.entity.custom.GlitchteniteGolemEntity;
import net.kosha.uh45.entity.custom.SlugEntity;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;


public class ModEntities {
    public static final EntityType<SlugEntity> SLUG = Registry.register(Registries.ENTITY_TYPE, new Identifier(UH415.MOD_ID, "slug"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, SlugEntity::new).dimensions(EntityDimensions.fixed(0.8f,0.35f)).build());

    public static final EntityType<AmalgamEntity> AMALGAM = Registry.register(Registries.ENTITY_TYPE, new Identifier(UH415.MOD_ID, "amalgam"),
            FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, AmalgamEntity::new).dimensions(EntityDimensions.fixed(1.3f,2.4f)).build());

    public static final EntityType<GlitchteniteGolemEntity> GLITCHTENITE_GOLEM = Registry.register(Registries.ENTITY_TYPE, new Identifier(UH415.MOD_ID, "glitchtenite_golem"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, GlitchteniteGolemEntity::new).dimensions(EntityDimensions.fixed(1.5f,3f)).build());


    public static void registerModEntities() {
        UH415.LOGGER.info("Registering Entities for " + UH415.MOD_ID);
    }
}
