package net.slimey.amazoncraft.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimey.amazoncraft.Amazoncraft;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENT =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Amazoncraft.MOD_ID);


    public static final RegistryObject<SoundEvent> CAPYBARA_SQUEAK =
            registerSoundEvent("capybara_squeak");
    public static final RegistryObject<SoundEvent> CAPYBARA_CHIRP=
            registerSoundEvent("capybara_chirp");
    public static final RegistryObject<SoundEvent> CAPYBARA_DEATH=
            registerSoundEvent("capybara_death");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUND_EVENT.register(name,()-> new SoundEvent(new ResourceLocation(Amazoncraft.MOD_ID, name)));
    }

    public static void register(IEventBus eventbus){
    SOUND_EVENT.register(eventbus);
    }
}
