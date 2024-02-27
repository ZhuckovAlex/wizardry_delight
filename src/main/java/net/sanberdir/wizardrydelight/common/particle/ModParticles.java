package net.sanberdir.wizardrydelight.common.particle;

import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;

public class ModParticles {
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, WizardryDelight.MOD_ID);

    public static final RegistryObject<SimpleParticleType> ROBIN_STAR_PARTICLES =
            PARTICLE_TYPES.register("robin_star_particles", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> ROBIN_STAR_PARTICLES_PROJECTILE =
            PARTICLE_TYPES.register("robin_star_particles_projectile", () -> new SimpleParticleType(true));
    public static final RegistryObject<SimpleParticleType> STOMBLE_ROSE =
            PARTICLE_TYPES.register("stomble_rose", () -> new SimpleParticleType(true));

    public static void register(IEventBus eventBus) {
        PARTICLE_TYPES.register(eventBus);
    }
}
