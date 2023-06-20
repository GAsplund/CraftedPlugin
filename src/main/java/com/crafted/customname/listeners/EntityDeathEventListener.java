package com.crafted.customname.listeners;

import org.bukkit.entity.Cow;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class EntityDeathEventListener implements Listener {

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Cow) {
            event.setShouldPlayDeathSound(false);
            event.getEntity().getWorld().getPlayers().forEach(
                    player ->  {
                        player.sendMessage("§bA moment of silence please... a cow was just killed.");
                        player.playSound(player.getLocation(), "minecraft:entity.cow.death", 1, 1);
                    }
            );
        }
    }

}
