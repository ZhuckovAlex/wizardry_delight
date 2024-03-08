package net.sanberdir.wizardrydelight.common.entity.gold_sheep.client;

import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.gold_sheep.custom.GoldSheep2;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class GoldSheep2Model extends AnimatedGeoModel<GoldSheep2> {
    @Override
    public ResourceLocation getModelResource(GoldSheep2 object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/gold_sheep2.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoldSheep2 object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/gold_sheep/gold_sheep2.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoldSheep2 animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/gold_sheep.animation.json");
    }
}
