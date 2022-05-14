package net.slimey.aquatical.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.slimey.aquatical.Aquatical;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.slimey.aquatical.entity.ModEntityTypes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Aquatical.MOD_ID);

    public static final RegistryObject<Item> GOLD_COIN = ITEMS.register("gold_coin",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_AQUATICAL)));


    public static final RegistryObject<Item> RAW_SARDINE = ITEMS.register("raw_sardine",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_AQUATICAL).food(ModFoods.RAW_SARDINE)));

    public static final RegistryObject<Item> COOKED_SARDINE = ITEMS.register("cooked_sardine",
            ()->new Item(new Item.Properties().tab(ModCreativeModeTab.TAB_AQUATICAL).food(ModFoods.COOKED_SARDINE)));


    public static final RegistryObject<Item> DIVING_HELMET = ITEMS.register("diving_helmet",
            ()-> new ArmorItem(ModArmorMaterials.DIVING, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_AQUATICAL)));


    public static final RegistryObject<Item> THRESHER_SHARK_SPAWN_EGG = ITEMS.register("thresher_shark_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.THRESHER_SHARK,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_AQUATICAL)));
    public static final RegistryObject<Item> SARDINE_SPAWN_EGG = ITEMS.register("sardine_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.THRESHER_SHARK,0x948e8d, 0x3b3635,
                    new Item.Properties().tab(ModCreativeModeTab.TAB_AQUATICAL)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
