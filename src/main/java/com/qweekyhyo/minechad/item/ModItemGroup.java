package com.qweekyhyo.minechad.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

import javax.annotation.Nonnull;

public class ModItemGroup {
    public static final ItemGroup MINECHAD_GROUP = new ItemGroup("MinechadModTab") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.WHIP.get());
        }
    };
}
