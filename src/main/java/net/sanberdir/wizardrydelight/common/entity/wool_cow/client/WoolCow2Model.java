package net.sanberdir.wizardrydelight.common.entity.wool_cow.client;

import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.wool_cow.custom.WoolCow2;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class WoolCow2Model extends AnimatedGeoModel<WoolCow2> {
    @Override
    public ResourceLocation getModelResource(WoolCow2 object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/wool_cow.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WoolCow2 object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/wool_cow/wool_cow2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WoolCow2 animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/wool_cow.animation.json");
    }
}
