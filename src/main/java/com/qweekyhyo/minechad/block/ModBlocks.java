package com.qweekyhyo.minechad.block;

import com.qweekyhyo.minechad.MineChad;
import com.qweekyhyo.minechad.block.crop.CottonCropBlock;
import net.minecraft.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, MineChad.MODID);

    public static final RegistryObject<Block> COTTON_CROP_BLOCK = BLOCKS.register(
            "cotton",
            CottonCropBlock::new
    );


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
