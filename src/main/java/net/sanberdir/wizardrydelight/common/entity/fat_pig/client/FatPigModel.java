package net.sanberdir.wizardrydelight.common.entity.fat_pig.client;

import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.fat_pig.custom.FatPig;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FatPigModel extends AnimatedGeoModel<FatPig> {
    @Override
    public ResourceLocation getModelResource(FatPig object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/fat_pig.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FatPig object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/fat_pig/fat_pig.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FatPig animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/fat_pig.animation.json");
    }
}
