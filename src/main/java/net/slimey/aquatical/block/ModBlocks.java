package net.slimey.aquatical.block;

import net.minecraft.world.level.block.CoralBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MaterialColor;
import net.slimey.aquatical.Aquatical;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.slimey.aquatical.item.ModCreativeModeTab;
import net.slimey.aquatical.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Aquatical.MOD_ID);

    public static final RegistryObject<Block> BARREL_SPONGE = registryBlock("barrel_sponge",
            ()-> new Block(BlockBehaviour.Properties.of(Material.SPONGE)
                    .strength(0.6f, 0.2f).sound(SoundType.WET_GRASS)),ModCreativeModeTab.TAB_AQUATICAL);

    public static final RegistryObject<Block> DEAD_BARREL_SPONGE = registryBlock("dead_barrel_sponge",
            ()-> new Block(BlockBehaviour.Properties.of(Material.SPONGE, MaterialColor.COLOR_GRAY)
                    .strength(0.9f, 0.2f).sound(SoundType.CORAL_BLOCK)), ModCreativeModeTab.TAB_AQUATICAL);

    private static <T extends Block> RegistryObject<T> registryBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name,block);
        registryObjectItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registryObjectItem(String name, RegistryObject<T> block,
                                                                            CreativeModeTab tab){
    return ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(),
            new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
