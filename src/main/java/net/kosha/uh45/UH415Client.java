package net.kosha.uh45;

import net.fabricmc.api.ClientModInitializer;
import net.kosha.uh45.util.ModModelPredicateProvider;

public class UH415Client implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModModelPredicateProvider.registerModModels();
    }
}
