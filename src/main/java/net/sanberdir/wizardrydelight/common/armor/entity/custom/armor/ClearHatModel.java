package net.sanberdir.wizardrydelight.common.armor.entity.custom.armor;
import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.Items.customItem.ClearHatArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ClearHatModel extends AnimatedGeoModel<ClearHatArmorItem> {
    @Override
    public ResourceLocation getModelResource(ClearHatArmorItem object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "geo/clear_hat_armor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(ClearHatArmorItem object) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/models/armor/clear_hat_armor_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(ClearHatArmorItem animatable) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "animations/armor_animation.json");
    }
}
