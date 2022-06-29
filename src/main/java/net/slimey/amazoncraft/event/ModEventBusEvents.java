package net.slimey.amazoncraft.event;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.entity.ModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimey.amazoncraft.entity.client.renderers.CapybaraRenderer;
import net.slimey.amazoncraft.entity.client.renderers.DwarfCaimanRenderer;
import net.slimey.amazoncraft.entity.client.renderers.PayaraRenderer;
import net.slimey.amazoncraft.entity.custom.CapybaraEntity;
import net.slimey.amazoncraft.entity.custom.DwarfcaimanEntity;
import net.slimey.amazoncraft.entity.custom.PayaraEntity;


@Mod.EventBusSubscriber(modid = Amazoncraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.CAPYBARA.get(), CapybaraEntity.setAttributes());
        event.put(ModEntityTypes.DWARF_CAIMAN.get(), DwarfcaimanEntity.setAttributes());
        event.put(ModEntityTypes.PAYARA.get(), PayaraEntity.setAttributes());
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        EntityRenderers.register(ModEntityTypes.CAPYBARA.get(), CapybaraRenderer::new);
        EntityRenderers.register(ModEntityTypes.DWARF_CAIMAN.get(), DwarfCaimanRenderer::new);
        EntityRenderers.register(ModEntityTypes.PAYARA.get(), PayaraRenderer::new);
    }
}
