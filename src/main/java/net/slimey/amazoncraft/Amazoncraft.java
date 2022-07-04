package net.slimey.amazoncraft;

import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.slimey.amazoncraft.block.ModBlocks;
import net.slimey.amazoncraft.entity.ModEntityTypes;
import net.slimey.amazoncraft.entity.client.renderers.CapybaraRenderer;
import net.slimey.amazoncraft.entity.client.renderers.DwarfCaimanRenderer;
import net.slimey.amazoncraft.entity.client.renderers.PayaraRenderer;
import net.slimey.amazoncraft.item.ModItems;
import net.slimey.amazoncraft.sounds.ModSounds;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(Amazoncraft.MOD_ID)
public class Amazoncraft {
    public static final String MOD_ID = "amazoncraft";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    //Add a comment
    public Amazoncraft() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);
        ModSounds.register(eventBus);

        ModEntityTypes.register(eventBus);

        GeckoLib.initialize();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::clientSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    private void clientSetup(final FMLClientSetupEvent event) {
        EntityRenderers.register(ModEntityTypes.CAPYBARA.get(), CapybaraRenderer::new);
        EntityRenderers.register(ModEntityTypes.DWARF_CAIMAN.get(), DwarfCaimanRenderer::new);
        EntityRenderers.register(ModEntityTypes.PAYARA.get(), PayaraRenderer::new);

    }

    private void setup(final FMLCommonSetupEvent event) {
       SpawnPlacements.register(ModEntityTypes.CAPYBARA.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntityTypes.DWARF_CAIMAN.get(),
                SpawnPlacements.Type.ON_GROUND,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules);
        SpawnPlacements.register(ModEntityTypes.PAYARA.get(),
                SpawnPlacements.Type.IN_WATER,
                Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                WaterAnimal::checkSurfaceWaterAnimalSpawnRules);
    }

}
