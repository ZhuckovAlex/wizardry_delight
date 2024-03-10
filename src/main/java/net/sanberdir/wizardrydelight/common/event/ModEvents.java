package net.sanberdir.wizardrydelight.common.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.ModEntityTypesWD;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken2;
import net.sanberdir.wizardrydelight.common.entity.fat_pig.custom.FatPig;
import net.sanberdir.wizardrydelight.common.entity.gold_sheep.custom.GoldSheep;
import net.sanberdir.wizardrydelight.common.entity.gold_sheep.custom.GoldSheep2;
import net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = WizardryDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypesWD.FAT_PIG.get(), FatPig.setAttributes());
            event.put(ModEntityTypesWD.WOOL_COW.get(), WoolCow.setAttributes());
            event.put(ModEntityTypesWD.WOOL_COW2.get(), WoolCow.setAttributes());
            event.put(ModEntityTypesWD.GOLD_SHEEP.get(), GoldSheep.setAttributes());
            event.put(ModEntityTypesWD.GOLD_SHEEP2.get(), GoldSheep2.setAttributes());
            event.put(ModEntityTypesWD.FEATHER_CHICKEN.get(), FeatherChicken.setAttributes());
            event.put(ModEntityTypesWD.FEATHER_CHICKEN2.get(), FeatherChicken2.setAttributes());
        }

    }
}
