package net.slimey.aquatical.item;

import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties RAW_SARDINE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).fast().build();
    public static final FoodProperties COOKED_SARDINE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).fast().build();
}
