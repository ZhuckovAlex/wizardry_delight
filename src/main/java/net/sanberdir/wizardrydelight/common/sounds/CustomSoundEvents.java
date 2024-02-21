package net.sanberdir.wizardrydelight.common.sounds;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;

public class CustomSoundEvents {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WizardryDelight.MOD_ID);

    public static final RegistryObject<SoundEvent> NYAMNYAM =
            registerSoundEvent("nyamnyam");
    public static final RegistryObject<SoundEvent> ROBIN_STICK =
            registerSoundEvent("robin_stick");
    public static final RegistryObject<SoundEvent> NYAMNYAM_END =
            registerSoundEvent("nyamnyam_end");
    public static final RegistryObject<SoundEvent> WIZARDRY_DELIGHT_JAM =
            registerSoundEvent("wizardry_delight_jam");




    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(WizardryDelight.MOD_ID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}
