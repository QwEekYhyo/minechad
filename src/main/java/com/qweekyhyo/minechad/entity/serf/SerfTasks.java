package com.qweekyhyo.minechad.entity.serf;

import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;

public class SerfTasks {
    protected static void pickUpItem(SerfEntity entity, ItemEntity item) {
        entity.getNavigation().stop();
        if (item.getItem().getItem() == Items.COOKED_CHICKEN) {
            ItemStack itemStack = item.getItem();
            entity.take(item, itemStack.getCount());
            item.remove();
            entity.addToInventory(itemStack);
        }
    }

    protected static boolean wantsToPickUp(SerfEntity entity, ItemStack itemStack) {
        // Maybe add more logic later
        return itemStack.getItem() == Items.COOKED_CHICKEN && entity.canAddToInventory(itemStack);
    }
}