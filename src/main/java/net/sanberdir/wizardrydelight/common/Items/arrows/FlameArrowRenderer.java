package net.sanberdir.wizardrydelight.common.Items.arrows;

import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;

public class FlameArrowRenderer extends ArrowRenderer<FlameArrow> {
    public static final ResourceLocation FLAME_ARROW = new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/projectiles/flame_arrow.png");

    public FlameArrowRenderer(EntityRendererProvider.Context p_174399_) {
        super(p_174399_);
    }

    public ResourceLocation getTextureLocation(FlameArrow p_116001_) {
        return FLAME_ARROW;
    }
}