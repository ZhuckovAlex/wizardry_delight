package net.sanberdir.wizardrydelight.common.entity.type_blocks_item;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.sanberdir.wizardrydelight.common.entity.boat.ModBoatEntity;
import net.sanberdir.wizardrydelight.common.entity.chest_boat.ModChestBoatEntity;


public class EntityTypeInitializer {
    // Регистрация лодок, сигн - табличек
    public static EntityType<Entity> BOAT_ENTITY_TYPE = EntityType.Builder.of(ModBoatEntity::new, MobCategory.MISC).setCustomClientFactory(ModBoatEntity::new).sized(1.375f, 0.5625f).clientTrackingRange(10).build("mod_boat_entity");
    public static EntityType<Entity> CHEST_BOAT_ENTITY_TYPE = EntityType.Builder.of(ModChestBoatEntity::new, MobCategory.MISC).setCustomClientFactory(ModChestBoatEntity::new).sized(1.375f, 0.5625f).clientTrackingRange(10).build("mod_chest_boat_entity");
}
