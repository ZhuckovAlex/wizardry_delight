package net.sanberdir.wizardrydelight.common.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import net.sanberdir.wizardrydelight.common.particle.custom.RobinStarsParticles;
import net.sanberdir.wizardrydelight.common.particle.custom.RobinStarsParticlesProjectile;


@Mod.EventBusSubscriber(modid = WizardryDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {

        @SubscribeEvent
        public static void registerParticleFactories(final RegisterParticleProvidersEvent event) {
            Minecraft.getInstance().particleEngine.register(ModParticles.ROBIN_STAR_PARTICLES.get(),
                    RobinStarsParticles.Provider::new);

            Minecraft.getInstance().particleEngine.register(ModParticles.ROBIN_STAR_PARTICLES_PROJECTILE.get(),
                    RobinStarsParticlesProjectile.Provider::new);


        }
    }

}
