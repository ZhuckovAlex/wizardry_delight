package net.sanberdir.wizardrydelight.common.armor.entity.custom.armor;
import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.customItem.HatArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class HatModel extends AnimatedGeoModel<HatArmorItem> {
    @Override
    public ResourceLocation getModelResource(HatArmorItem object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/hat_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HatArmorItem object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/models/armor/hat_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HatArmorItem animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/armor_animation.json");
    }
}
