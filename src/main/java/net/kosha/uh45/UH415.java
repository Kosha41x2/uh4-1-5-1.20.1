package net.kosha.uh45;

import net.fabricmc.api.ModInitializer;

import net.kosha.uh45.block.ModBlocks;
import net.kosha.uh45.effect.ModEffects;
import net.kosha.uh45.entity.attribute.ModEntityAttributes;
import net.kosha.uh45.item.ModItemGroups;
import net.kosha.uh45.item.ModItems;
import net.kosha.uh45.potion.ModPotions;
import net.kosha.uh45.sound.ModSounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UH415 implements ModInitializer {
	public static final String MOD_ID = "uh4-5";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModEntityAttributes.registerModEntityAttributes();

		ModEffects.registerEffects();
		ModPotions.registerModPotions();
		ModSounds.registerSounds();
	}
}