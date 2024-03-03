package net.sanberdir.wizardrydelight.common.entity.chicken.client;

import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken2;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class FeatherChicken2Model extends AnimatedGeoModel<FeatherChicken2> {
    @Override
    public ResourceLocation getModelResource(FeatherChicken2 object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/feather_chicken.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FeatherChicken2 object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/feather_chicken/feather_chicken2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FeatherChicken2 animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/feather_chicken.animation.json");
    }
}
