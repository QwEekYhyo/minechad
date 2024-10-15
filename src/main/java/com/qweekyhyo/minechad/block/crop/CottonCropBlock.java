package com.qweekyhyo.minechad.block.crop;

import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;

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
}