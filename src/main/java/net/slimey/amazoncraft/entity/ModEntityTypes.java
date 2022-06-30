package net.slimey.amazoncraft.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimey.amazoncraft.Amazoncraft;
import net.slimey.amazoncraft.entity.custom.CapybaraEntity;
import net.slimey.amazoncraft.entity.custom.DwarfcaimanEntity;
import net.slimey.amazoncraft.entity.custom.PayaraEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, Amazoncraft.MOD_ID);

    public static final RegistryObject<EntityType<CapybaraEntity>> CAPYBARA =
            ENTITY_TYPES.register("capybara",
                    () -> EntityType.Builder.of(CapybaraEntity::new, MobCategory.CREATURE)
                            .sized(1.0f, 1.0f)
                            .build(new ResourceLocation(Amazoncraft.MOD_ID, "capybara").toString()));

    public static final RegistryObject<EntityType<DwarfcaimanEntity>> DWARF_CAIMAN =
            ENTITY_TYPES.register("dwarf_caiman",
                    () -> EntityType.Builder.of(DwarfcaimanEntity::new, MobCategory.CREATURE)
                            .sized(0.6f, 0.6f)
                            .build(new ResourceLocation(Amazoncraft.MOD_ID, "dwarf_caiman").toString()));

    public static final RegistryObject<EntityType<PayaraEntity>> PAYARA =
            ENTITY_TYPES.register("payara",
                    () -> EntityType.Builder.of(PayaraEntity::new, MobCategory.CREATURE)
                            .sized(0.6f, 0.6f)
                            .build(new ResourceLocation(Amazoncraft.MOD_ID, "payara").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}