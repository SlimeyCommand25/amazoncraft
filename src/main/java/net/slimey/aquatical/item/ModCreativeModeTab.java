package net.slimey.aquatical.item;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab TAB_AQUATICAL = new CreativeModeTab("aquaticaltab") {

        @Override
        public ItemStack makeIcon() {return new ItemStack(ModItems.RAW_SARDINE.get());
        }
    };
}
