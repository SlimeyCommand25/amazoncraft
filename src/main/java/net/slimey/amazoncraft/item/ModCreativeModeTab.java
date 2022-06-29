package net.slimey.amazoncraft.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_AQUATICAL = new CreativeModeTab("amazoncrafttab") {

        @Override
        public ItemStack makeIcon() {return new ItemStack(ModItems.RAW_SARDINE.get());
        }
    };
}
