package com.qweekyhyo.minechad.item;

import com.qweekyhyo.minechad.MineChad;
import com.qweekyhyo.minechad.block.ModBlocks;
import com.qweekyhyo.minechad.entity.ModEntities;
import com.qweekyhyo.minechad.item.tool.Whip;
import net.minecraft.item.BlockNamedItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MineChad.MODID);

    public static final RegistryObject<Item> WHIP = ITEMS.register("whip",
            () -> new Whip(new Item.Properties()
                    .tab(ModItemGroup.MINECHAD_GROUP)
                    .durability(250)
            )
    );

    public static final RegistryObject<Item> COTTON_SEEDS = ITEMS.register(
            "cotton_seeds",
            () -> new BlockNamedItem(
                    ModBlocks.COTTON_CROP_BLOCK.get(),
                    new Item.Properties().tab(ModItemGroup.MINECHAD_GROUP)
            )
    );

    public static final RegistryObject<Item> COTTON = ITEMS.register(
            "cotton",
            () -> new Item(new Item.Properties()
                    .tab(ModItemGroup.MINECHAD_GROUP)
            )
    );

    public static final RegistryObject<Item> SERF_SPAWN_EGG = ITEMS.register(
            "serf_spawn_egg",
            () -> new ForgeSpawnEggItem(
                    ModEntities.SERF,
                    0x241511,
                    0xF4BA74,
                    new Item.Properties().tab(ModItemGroup.MINECHAD_GROUP)
            )
    );


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
