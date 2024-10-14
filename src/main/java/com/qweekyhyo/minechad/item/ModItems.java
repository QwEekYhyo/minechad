package com.qweekyhyo.minechad.item;

import com.qweekyhyo.minechad.MineChad;
import com.qweekyhyo.minechad.item.tool.Whip;
import net.minecraft.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MineChad.MODID);

    public static final RegistryObject<Item> WHIP = ITEMS.register("whip",
            () -> new Whip(new Item.Properties().durability(250)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
