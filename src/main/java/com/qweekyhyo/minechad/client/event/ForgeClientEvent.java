package com.qweekyhyo.minechad.client.event;

import com.qweekyhyo.minechad.MineChad;
import com.qweekyhyo.minechad.init.KeybindsInit;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MineChad.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class ForgeClientEvent {
    @SubscribeEvent
    public static void clientTick(TickEvent.ClientTickEvent event) {
        PlayerEntity player = Minecraft.getInstance().player;
        if (player == null) return;
        player.getPersistentData().putBoolean("is_waving", KeybindsInit.WAVE_EMOTE_KEY.isDown());
    }
}