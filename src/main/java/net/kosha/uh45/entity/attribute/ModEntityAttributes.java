package net.kosha.uh45.entity.attribute;

import net.kosha.uh45.UH415;
import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

public class ModEntityAttributes {
    public static final EntityAttribute GENERIC_CORRUPTION_RESISTANCE = register("generic.corruption_resistance", new ClampedEntityAttribute("attribute.name.generic.corruption_resistance", 0, 0.0, 12.0).setTracked(true));

    private static EntityAttribute register(String id, EntityAttribute attribute) {
        return Registry.register(Registries.ATTRIBUTE, id, attribute);
    }
    public static void registerModEntityAttributes(){
        UH415.LOGGER.info("Registering Mod Entity Attributes for " + UH415.MOD_ID);
    }
}
