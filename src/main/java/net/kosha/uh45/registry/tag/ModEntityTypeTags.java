package net.kosha.uh45.registry.tag;

import net.kosha.uh45.UH415;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;


public class ModEntityTypeTags {
    public static final TagKey<EntityType<?>> GLITCHES = ModEntityTypeTags.of("glitches");


    private static TagKey<EntityType<?>> of(String id) {
        return TagKey.of(RegistryKeys.ENTITY_TYPE, new Identifier(id));
    }
    public static void registerModItems(){
        UH415.LOGGER.info("Registering Mod Entity Tags for " + UH415.MOD_ID);
    }
}
