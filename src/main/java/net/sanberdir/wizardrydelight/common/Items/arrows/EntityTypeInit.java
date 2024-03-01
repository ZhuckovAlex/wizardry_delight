package net.sanberdir.wizardrydelight.common.Items.arrows;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;

public class EntityTypeInit {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WizardryDelight.MOD_ID);

    public static final RegistryObject<EntityType<FlameArrow>> FLAME_ARROW = ENTITY_TYPES.register("flame_arrow",
            () -> EntityType.Builder.<FlameArrow>of(FlameArrow::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F).clientTrackingRange(4).updateInterval(20).setCustomClientFactory(FlameArrow::new)
                    .build(new ResourceLocation(WizardryDelight.MOD_ID, "flame_arrow").toString()));
}
