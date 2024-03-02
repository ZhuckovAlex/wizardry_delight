package net.sanberdir.wizardrydelight.common.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;

public class ModEffectsWD {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, WizardryDelight.MOD_ID);

    public static final RegistryObject<MobEffect> FROSTBITTEN = MOB_EFFECTS.register("frostbitten",
            () -> new FrostbittenEffect(MobEffectCategory.HARMFUL, 0x38FFCB));
    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
