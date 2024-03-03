package net.sanberdir.wizardrydelight.common.entity.chicken.client;

import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FeatherChickenModel extends AnimatedGeoModel<FeatherChicken> {
    @Override
    public ResourceLocation getModelResource(FeatherChicken object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/feather_chicken.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FeatherChicken object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/feather_chicken/feather_chicken.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FeatherChicken animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/feather_chicken.animation.json");
    }
}
