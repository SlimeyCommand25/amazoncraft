package net.slimey.aquatical.event;

import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.ModEntityTypes;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimey.aquatical.entity.custom.ThreshersharkEntity;

import javax.annotation.Nonnull;

@Mod.EventBusSubscriber(modid = Aquatical.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

       @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.THRESHER_SHARK.get(), ThreshersharkEntity.setAttributes());
    }
}
