package com.qweekyhyo.minechad.block.crop;

import com.qweekyhyo.minechad.item.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.IItemProvider;

import javax.annotation.Nonnull;

public class CottonCropBlock extends CropsBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_5;

    public CottonCropBlock() {
        super(AbstractBlock.Properties.of(Material.PLANT)
                .noCollission()
                .randomTicks()
                .instabreak()
                .sound(Blocks.WHEAT.defaultBlockState().getSoundType())
        );
        this.registerDefaultState(this.getStateDefinition().any().setValue(AGE, 0));
    }

    @Override
    @Nonnull
    public IntegerProperty getAgeProperty() {
        return CottonCropBlock.AGE;
    }

    @Override
    public int getMaxAge() {
        return 5;
    }

    @Override
    protected void createBlockStateDefinition(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(AGE);
    }

    @Override
    @Nonnull
    protected IItemProvider getBaseSeedId() {
        return ModItems.COTTON_SEEDS.get();
    }
}