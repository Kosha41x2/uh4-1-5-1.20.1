package net.kosha.uh45;

import net.fabricmc.api.ModInitializer;

import net.kosha.uh45.item.ModItemGroups;
import net.kosha.uh45.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UH415 implements ModInitializer {
	public static final String MOD_ID = "uh4-5";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
	}
}