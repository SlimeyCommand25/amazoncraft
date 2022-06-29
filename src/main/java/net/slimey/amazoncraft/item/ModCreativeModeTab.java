package net.slimey.amazoncraft.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_AMAZONCRAFT = new CreativeModeTab("amazoncrafttab") {

        @Override
        public ItemStack makeIcon() {return new ItemStack(Items.JUNGLE_LOG);
        }
    };
}
