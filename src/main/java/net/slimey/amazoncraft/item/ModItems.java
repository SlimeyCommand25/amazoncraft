package net.slimey.amazoncraft.item;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.slimey.amazoncraft.Amazoncraft;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimey.amazoncraft.entity.ModEntityTypes;

import java.util.function.Supplier;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Amazoncraft.MOD_ID);

    public static final RegistryObject<Item> CAPYBARA_SPAWN_EGG = ITEMS.register("capybara_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CAPYBARA,0x76503d, 0x2f2018,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_AMAZONCRAFT)));


    public static final RegistryObject<Item> DWARF_CAIMAN_SPAWN_EGG = ITEMS.register("dwarf_caiman_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.DWARF_CAIMAN,0x9c897b, 0x4a3e35,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_AMAZONCRAFT)));

    public static final RegistryObject<Item> PAYARA_SPAWN_EGG = ITEMS.register("payara_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.PAYARA,0x72736b, 0x474746,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_AMAZONCRAFT)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
