package net.slimey.amazoncraft.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.entity.ModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimey.amazoncraft.entity.client.renderers.PayaraRenderer;
import net.slimey.amazoncraft.entity.client.renderers.SardineRenderer;
import net.slimey.amazoncraft.entity.client.renderers.ThreshersharkRenderer;
import net.slimey.amazoncraft.entity.custom.PayaraEntity;
import net.slimey.amazoncraft.entity.custom.SardineEntity;
import net.slimey.amazoncraft.entity.custom.ThreshersharkEntity;


@Mod.EventBusSubscriber(modid = Amazoncraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.THRESHER_SHARK.get(), ThreshersharkEntity.setAttributes());
        event.put(ModEntityTypes.SARDINE.get(), SardineEntity.setAttributes());
        event.put(ModEntityTypes.PAYARA.get(), PayaraEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        EntityRenderers.register(ModEntityTypes.THRESHER_SHARK.get(), ThreshersharkRenderer::new);
        EntityRenderers.register(ModEntityTypes.SARDINE.get(), SardineRenderer::new);
        EntityRenderers.register(ModEntityTypes.PAYARA.get(), PayaraRenderer::new);
    }
}
