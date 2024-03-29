package net.sanberdir.wizardrydelight.client;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.blocks.customBlocks.FlameLeavesApple;
import net.sanberdir.wizardrydelight.common.blocks.customBlocks.FlameLeavesNoapple;

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
