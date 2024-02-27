package net.sanberdir.wizardrydelight.client;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.blocks.customBlocks.FlameLeavesApple;
import net.sanberdir.wizardrydelight.common.blocks.customBlocks.FlameLeavesNoapple;
import net.sanberdir.wizardrydelight.common.particle.ModParticles;
import net.sanberdir.wizardrydelight.common.particle.custom.StombleRoseParticles;

@Mod.EventBusSubscriber(modid = WizardryDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientBusEvents {

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientSideHandler {
        @SubscribeEvent
        public static void blockColorLoad(RegisterColorHandlersEvent.Block event) {
            FlameLeavesApple.blockColorLoad(event);
            FlameLeavesNoapple.blockColorLoad(event);

        }

    }

}
