package net.sanberdir.wizardrydelight.common.entity.boat;

import net.minecraft.world.entity.EntityType;
import net.minecraftforge.registries.ObjectHolder;
import net.sanberdir.wizardrydelight.common.entity.chest_boat.ModChestBoatEntity;

import static net.sanberdir.wizardrydelight.WizardryDelight.MOD_ID;


public class ModEntityData {
    @ObjectHolder(registryName = "minecraft:entity_type", value = MOD_ID + ":mod_boat_entity")
    public static EntityType<ModBoatEntity> MOD_BOAT_DATA;

    @ObjectHolder(registryName = "minecraft:entity_type", value = MOD_ID + ":mod_chest_boat_entity")
    public static EntityType<ModChestBoatEntity> MOD_CHEST_BOAT_DATA;
}
