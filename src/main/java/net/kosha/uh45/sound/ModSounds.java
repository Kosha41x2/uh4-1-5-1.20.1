package net.kosha.uh45.sound;

import net.kosha.uh45.UH415;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {

    public static final SoundEvent UH4_OST_MAIN_THEME = registerSoundEvent("uh4_ost_main_theme");
    public static final SoundEvent UH4_OST_BATTLE_THE_GATEKEEPER = registerSoundEvent("uh4_ost_battle_the_gatekeeper");
    public static final SoundEvent UH4_OST_BATTLE_THE_GATEKEEPER_PHASE_2 = registerSoundEvent("uh4_ost_battle_the_gatekeeper_phase_2");



    private static SoundEvent registerSoundEvent(String name){
        Identifier id = new Identifier(UH415.MOD_ID, name);

        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerSounds(){
        UH415.LOGGER.info("Registering Sounds for" + UH415.MOD_ID);
    }
}
