package net.sanberdir.wizardrydelight.common.armor.entity.custom.armor;

import net.sanberdir.wizardrydelight.common.Items.customItem.ClearHatArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class ClearHatArmorRenderer extends GeoArmorRenderer<ClearHatArmorItem> {
    public ClearHatArmorRenderer() {
        super(new ClearHatModel());

        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorLeftLeg";
        this.leftLegBone = "armorRightLeg";
        this.rightBootBone = "armorLeftBoot";
        this.leftBootBone = "armorRightBoot";
    }
}
