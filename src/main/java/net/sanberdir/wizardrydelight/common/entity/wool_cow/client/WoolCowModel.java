package net.sanberdir.wizardrydelight.common.entity.wool_cow.client;

import net.minecraft.resources.ResourceLocation;

import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WoolCowModel extends AnimatedGeoModel<WoolCow> {
    @Override
    public ResourceLocation getModelResource(WoolCow object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/wool_cow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WoolCow object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/wool_cow/wool_cow.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WoolCow animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/wool_cow.animation.json");
    }
}
