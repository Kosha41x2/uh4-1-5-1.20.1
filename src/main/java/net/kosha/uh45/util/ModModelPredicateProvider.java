package net.kosha.uh45.util;

import net.kosha.uh45.item.ModItems;
import net.kosha.uh45.item.custom.CrossbowLikeItem;
import net.minecraft.client.item.ModelPredicateProviderRegistry;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class ModModelPredicateProvider {
    public static void registerModModels(){
        ModelPredicateProviderRegistry.register(ModItems.GLITCHED_CROSSBOW, new Identifier("pull"), (stack, world, entity, seed) -> {
            if (entity == null) {
                return 0.0f;
            }
            if (CrossbowLikeItem.isCharged(stack)) {
                return 0.0f;
            }
            return (float)(stack.getMaxUseTime() - entity.getItemUseTimeLeft()) / (float)CrossbowLikeItem.getPullTime(stack);
        });
        ModelPredicateProviderRegistry.register(ModItems.GLITCHED_CROSSBOW, new Identifier("pulling"), (stack, world, entity, seed) -> entity != null && entity.isUsingItem() && entity.getActiveItem() == stack && !CrossbowLikeItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(ModItems.GLITCHED_CROSSBOW, new Identifier("charged"), (stack, world, entity, seed) -> CrossbowLikeItem.isCharged(stack) ? 1.0f : 0.0f);
        ModelPredicateProviderRegistry.register(ModItems.GLITCHED_CROSSBOW, new Identifier("firework"), (stack, world, entity, seed) -> CrossbowLikeItem.isCharged(stack) && CrossbowLikeItem.hasProjectile(stack, Items.FIREWORK_ROCKET) ? 1.0f : 0.0f);
    }
}
