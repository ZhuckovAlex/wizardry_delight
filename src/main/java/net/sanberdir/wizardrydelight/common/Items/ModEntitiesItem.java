package net.sanberdir.wizardrydelight.common.Items;

import net.minecraftforge.registries.ObjectHolder;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.customItem.AppleBoat;
import net.sanberdir.wizardrydelight.common.Items.customItem.AppleChestBoat;


public class ModEntitiesItem {
    @ObjectHolder(registryName = "minecraft:item", value = WizardryDelight.MOD_ID + ":apple_boat")
    public static AppleBoat APPLE_BOAT;
    @ObjectHolder(registryName = "minecraft:item", value = WizardryDelight.MOD_ID + ":apple_chest_boat")
    public static AppleChestBoat APPLE_CHEST_BOAT;
}
