package net.slimey.aquatical.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimey.aquatical.Aquatical;
import net.slimey.aquatical.entity.custom.PayaraEntity;
import net.slimey.aquatical.entity.custom.SardineEntity;
import net.slimey.aquatical.entity.custom.ThreshersharkEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Aquatical.MOD_ID);

    public static final RegistryObject<EntityType<ThreshersharkEntity>> THRESHER_SHARK =
            ENTITY_TYPES.register("thresher_shark",
                    () -> EntityType.Builder.of(ThreshersharkEntity::new, MobCategory.CREATURE)
                            .sized(1.1f, 0.75f)
                            .build(new ResourceLocation(Aquatical.MOD_ID, "thresher_shark").toString()));

    public static final RegistryObject<EntityType<SardineEntity>> SARDINE =
            ENTITY_TYPES.register("sardine",
                    () -> EntityType.Builder.of(SardineEntity::new, MobCategory.CREATURE)
                            .sized(0.5f, 0.4f)
                            .build(new ResourceLocation(Aquatical.MOD_ID, "sardine").toString()));
    public static final RegistryObject<EntityType<PayaraEntity>> PAYARA =
            ENTITY_TYPES.register("payara",
                    () -> EntityType.Builder.of(PayaraEntity::new, MobCategory.CREATURE)
                            .sized(0.6f, 0.6f)
                            .build(new ResourceLocation(Aquatical.MOD_ID, "payara").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}