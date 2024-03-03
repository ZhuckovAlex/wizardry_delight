package net.sanberdir.wizardrydelight.common.entity;


import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)

public class ModMobRenderer {
    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.STAR_BALL.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.EGG_MOTTLED.get(), ThrownItemRenderer::new);
    }

}