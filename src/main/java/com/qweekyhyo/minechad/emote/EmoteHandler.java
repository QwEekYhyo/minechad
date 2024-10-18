package com.qweekyhyo.minechad.emote;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Pose;
import net.minecraft.util.math.vector.Vector3d;

public class EmoteHandler {
    public static void playWavingEmote(PlayerEntity player) {
        player.setPose(Pose.STANDING);
        player.setDeltaMovement(Vector3d.ZERO);

        player.yBodyRot = 45.0F;
        player.yHeadRot = 45.0F;
    }

    public static void stopEmote(PlayerEntity player) {
        player.setPose(Pose.STANDING);
    }
}