package net.sanberdir.wizardrydelight.common.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken2;
import net.sanberdir.wizardrydelight.common.entity.fat_pig.custom.FatPig;
import net.sanberdir.wizardrydelight.common.entity.gold_sheep.custom.GoldSheep;
import net.sanberdir.wizardrydelight.common.entity.gold_sheep.custom.GoldSheep2;
import net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow;
import net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow2;

public class ModEntityTypesWD {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WizardryDelight.MOD_ID);
    public static final RegistryObject<EntityType<FatPig>> FAT_PIG =
            ENTITY_TYPES.register("fat_pig",
                    () -> EntityType.Builder.of(FatPig::new, MobCategory.AMBIENT)
                            .sized(1.2f, 1.4f)
                            .build(new ResourceLocation(WizardryDelight.MOD_ID, "fat_pig").toString()));
    public static final RegistryObject<EntityType<GoldSheep>> GOLD_SHEEP =
            ENTITY_TYPES.register("gold_sheep",
                    () -> EntityType.Builder.of(GoldSheep::new, MobCategory.AMBIENT)
                            .sized(1.2f, 1.4f)
                            .build(new ResourceLocation(WizardryDelight.MOD_ID, "gold_sheep").toString()));
    public static final RegistryObject<EntityType<GoldSheep2>> GOLD_SHEEP2 =
            ENTITY_TYPES.register("gold_sheep2",
                    () -> EntityType.Builder.of(GoldSheep2::new, MobCategory.AMBIENT)
                            .sized(1.2f, 1.4f)
                            .build(new ResourceLocation(WizardryDelight.MOD_ID, "gold_sheep2").toString()));
    public static final RegistryObject<EntityType<WoolCow>> WOOL_COW =
            ENTITY_TYPES.register("wool_cow",
                    () -> EntityType.Builder.of(WoolCow::new, MobCategory.AMBIENT)
                            .sized(1.2f, 1.4f)
                            .build(new ResourceLocation(WizardryDelight.MOD_ID, "wool_cow").toString()));

    public static final RegistryObject<EntityType<WoolCow2>> WOOL_COW2 =
            ENTITY_TYPES.register("wool_cow2",
                    () -> EntityType.Builder.of(WoolCow2::new, MobCategory.AMBIENT)
                            .sized(1.2f, 1.4f)
                            .build(new ResourceLocation(WizardryDelight.MOD_ID, "wool_cow2").toString()));

    public static final RegistryObject<EntityType<FeatherChicken>> FEATHER_CHICKEN =
            ENTITY_TYPES.register("feather_chicken",
                    () -> EntityType.Builder.of(FeatherChicken::new, MobCategory.AMBIENT)
                            .sized(0.8f, 0.8f)
                            .build(new ResourceLocation(WizardryDelight.MOD_ID, "feather_chicken").toString()));
    public static final RegistryObject<EntityType<FeatherChicken2>> FEATHER_CHICKEN2 =
            ENTITY_TYPES.register("feather_chicken2",
                    () -> EntityType.Builder.of(FeatherChicken2::new, MobCategory.AMBIENT)
                            .sized(0.4f, 0.4f)
                            .build(new ResourceLocation(WizardryDelight.MOD_ID, "feather_chicken2").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
