package net.sanberdir.wizardrydelight.common.armor.entity.custom.armor;

import net.sanberdir.wizardrydelight.common.Items.customItem.HatArmorItem;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class HatArmorRenderer extends GeoArmorRenderer<HatArmorItem> {
    public HatArmorRenderer() {
        super(new HatModel());

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
