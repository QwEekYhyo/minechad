package com.qweekyhyo.minechad.init;

import com.qweekyhyo.minechad.MineChad;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.glfw.GLFW;

@OnlyIn(Dist.CLIENT)
public class KeybindsInit {
    public static KeyBinding WAVE_EMOTE_KEY;

    public static void registerAllKeys() {
        WAVE_EMOTE_KEY = registerKey("wave_emote_key", GLFW.GLFW_KEY_J, "key.categories.misc");
    }

    private static KeyBinding registerKey(String name, int keyCode, String category) {
        final KeyBinding key = new KeyBinding(
                "key." + MineChad.MODID + "." + name,
                keyCode,
                category
        );
        ClientRegistry.registerKeyBinding(key);
        return key;
    }
}
