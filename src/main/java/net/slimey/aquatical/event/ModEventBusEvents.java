package net.slimey.aquatical.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.loading.FMLLoader;
import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.ModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimey.aquatical.entity.client.SardineRenderer;
import net.slimey.aquatical.entity.client.ThreshersharkRenderer;
import net.slimey.aquatical.entity.custom.SardineEntity;
import net.slimey.aquatical.entity.custom.ThreshersharkEntity;


@Mod.EventBusSubscriber(modid = Aquatical.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.THRESHER_SHARK.get(), ThreshersharkEntity.setAttributes());
        event.put(ModEntityTypes.SARDINE.get(), SardineEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        EntityRenderers.register(ModEntityTypes.THRESHER_SHARK.get(), ThreshersharkRenderer::new);
        EntityRenderers.register(ModEntityTypes.SARDINE.get(), SardineRenderer::new);
    }
}
