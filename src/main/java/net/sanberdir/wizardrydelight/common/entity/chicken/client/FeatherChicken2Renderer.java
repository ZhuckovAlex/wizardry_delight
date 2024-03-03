package net.sanberdir.wizardrydelight.common.entity.chicken.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.sanberdir.wizardrydelight.WizardryDelight;
import net.sanberdir.wizardrydelight.common.entity.chicken.custom.FeatherChicken2;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class FeatherChicken2Renderer extends GeoEntityRenderer<FeatherChicken2> {
    public FeatherChicken2Renderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FeatherChicken2Model());
        this.shadowRadius = 0.3f;
    }

    @Override
    public ResourceLocation getTextureLocation(FeatherChicken2 instance) {
        return new ResourceLocation(WizardryDelight.MOD_ID, "textures/entity/feather_chicken/feather_chicken2.png");
    }

    @Override
    public RenderType getRenderType(FeatherChicken2 animatable, float partialTicks, PoseStack stack,
                                    @Nullable MultiBufferSource renderTypeBuffer,
                                    @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        if (animatable.isBaby()){
            stack.scale(0.4f, 0.4f, 0.4f);
        }
        else {
            stack.scale(1f, 1f, 1f);
        }
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
