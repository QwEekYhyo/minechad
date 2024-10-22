package com.qweekyhyo.minechad.client.renderer.entity;

import com.qweekyhyo.minechad.MineChad;
import com.qweekyhyo.minechad.client.renderer.entity.model.SerfModel;
import com.qweekyhyo.minechad.entity.serf.SerfEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import javax.annotation.Nonnull;

public class SerfRenderer extends MobRenderer<SerfEntity, SerfModel<SerfEntity>> {
    private static final ResourceLocation SERF_LOCATION = new ResourceLocation(MineChad.MODID, "textures/entity/serf.png");

    public SerfRenderer(EntityRendererManager rendererManagerIn) {
        super(rendererManagerIn, new SerfModel<>(), 0.5F);
    }

    @Override
    @Nonnull
    public ResourceLocation getTextureLocation(@Nonnull SerfEntity entity) {
        return SERF_LOCATION;
    }
}