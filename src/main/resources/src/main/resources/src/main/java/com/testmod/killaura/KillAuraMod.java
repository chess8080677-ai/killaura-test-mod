package com.testmod.killaura;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class KillAuraMod implements ClientModInitializer {

    public static KeyBinding openMenuKey;

    @Override
    public void onInitializeClient() {
        new KillAuraModule();

        openMenuKey = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "Open KillAura Menu",
            GLFW.GLFW_KEY_R,
            "KillAura Test Mod"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (openMenuKey.wasPressed()) {
                client.setScreen(new KillAuraMenuScreen());
            }
        });
    }
}
