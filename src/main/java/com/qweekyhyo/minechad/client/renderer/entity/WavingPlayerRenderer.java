package com.qweekyhyo.minechad.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.PlayerRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.entity.model.PlayerModel;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.StringTextComponent;

public class WavingPlayerRenderer extends LayerRenderer<AbstractClientPlayerEntity, PlayerModel<AbstractClientPlayerEntity>> {
    public WavingPlayerRenderer(PlayerRenderer playerRenderer) {
        super(playerRenderer);
    }

    @Override
    public void render(MatrixStack matrixStack, IRenderTypeBuffer buffer, int packedLight, AbstractClientPlayerEntity player, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (player.getPersistentData().getBoolean("is_waving")) {
            float waveAngle = MathHelper.sin(ageInTicks * 0.5F) * 30.0F;

            this.getParentModel().rightArm.xRot = (float) Math.toRadians(-waveAngle);
            this.getParentModel().rightArm.zRot = (float) Math.toRadians(10.0F);
            player.sendMessage(new StringTextComponent("xRot: " + this.getParentModel().rightArm.xRot), player.getUUID());
            player.sendMessage(new StringTextComponent("zRot: " + this.getParentModel().rightArm.zRot), player.getUUID());
        } else {
            this.getParentModel().rightArm.xRot = 0.0F;
            this.getParentModel().rightArm.zRot = 0.0F;
        }
    }
}