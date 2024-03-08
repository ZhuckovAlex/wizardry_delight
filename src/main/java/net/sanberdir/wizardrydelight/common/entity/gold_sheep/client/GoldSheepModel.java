package net.sanberdir.wizardrydelight.common.entity.gold_sheep.client;

import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.gold_sheep.custom.GoldSheep;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldSheepModel extends AnimatedGeoModel<GoldSheep> {
    @Override
    public ResourceLocation getModelResource(GoldSheep object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/gold_sheep.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldSheep object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/gold_sheep/gold_sheep.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldSheep animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/gold_sheep.animation.json");
    }
}
