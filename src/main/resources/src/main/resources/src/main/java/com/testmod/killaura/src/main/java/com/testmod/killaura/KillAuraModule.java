package com.testmod.killaura;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.Hand;

public class KillAuraModule {

    public static boolean killauraEnabled = false;
    public static boolean reachEnabled = false;

    public KillAuraModule() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null || client.world == null) return;

            float reach = reachEnabled ? 6.0f : 3.0f;

            if (killauraEnabled) {
                for (Entity entity : client.world.getEntities()) {
                    if (entity instanceof PlayerEntity target
                        && target != client.player
                        && client.player.distanceTo(target) <= reach) {

                        client.player.swingHand(Hand.MAIN_HAND);
                        client.interactionManager.attackEntity(client.player, target);
                        break;
                    }
                }
            }
        });
    }
}
