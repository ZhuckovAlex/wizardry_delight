package net.sanberdir.wizardrydelight.common.entity.chief_cat.client;

import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.chief_cat.custom.ChiefCat;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ChiefCatModel extends AnimatedGeoModel<ChiefCat> {
    @Override
    public ResourceLocation getModelResource(ChiefCat object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/chief_cat.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ChiefCat object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/chief_cat/chief_cat.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ChiefCat animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/chief_cat.animation.json");
    }
}
