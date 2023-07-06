package com.crafted.customname.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.entity.Cow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class EntityDeathEventListener implements Listener {
    Random rand = new Random();

    private final Component cowDeathMessage = Component
            .text("A moment of silence please... a cow was just killed.")
            .color(NamedTextColor.AQUA);

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        float cow_pitch_randomiser = rand.nextFloat();
        if (event.getEntity() instanceof Cow) {
            event.setShouldPlayDeathSound(false);
            event.getEntity().getWorld().getPlayers().forEach(
                    player ->  {
                        player.sendMessage(cowDeathMessage);
                        player.playSound(player.getLocation(), "minecraft:entity.cow.death", 1, 0.5f + cow_pitch_randomiser);
                    }
            );
        }
    }

}
