package net.slimey.amazoncraft.world;

import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.world.gen.ModEntityGeneration;

@Mod.EventBusSubscriber(modid = Amazoncraft.MOD_ID)
public class ModWorldEvents {
    @SubscribeEvent
    public static void biomeLoadingEvent(final BiomeLoadingEvent event) {

        ModEntityGeneration.onEntitySpawn(event);
    }
}
