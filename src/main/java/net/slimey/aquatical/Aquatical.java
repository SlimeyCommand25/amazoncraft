package net.slimey.aquatical;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.slimey.aquatical.block.ModBlocks;
import net.slimey.aquatical.entity.ModEntityTypes;
import net.slimey.aquatical.entity.client.renderers.SardineRenderer;
import net.slimey.aquatical.entity.client.renderers.ThreshersharkRenderer;
import net.slimey.aquatical.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Aquatical.MOD_ID)
public class Aquatical {
    public static final String MOD_ID = "aquatical";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    //Add a comment
    public Aquatical() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModEntityTypes.register(eventBus);

        GeckoLib.initialize();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.SARDINE.get(), SardineRenderer::new);
        EntityRenderers.register(ModEntityTypes.THRESHER_SHARK.get(), ThreshersharkRenderer::new);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

}
