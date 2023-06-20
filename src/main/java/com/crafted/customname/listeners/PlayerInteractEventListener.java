package com.crafted.customname.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerInteractEventListener implements Listener {

    // Hardcoded locations, but we don't need a config for this.
    Map<Location, Location> buttons = new HashMap<>() {{
        put(new Location(Bukkit.getWorld("2023_PORT"), 163, 65, 319),
                new Location(Bukkit.getWorld("2023_CREATIVE"), 0.5, -2, 0.5));
        put(new Location(Bukkit.getWorld("2023_PORT"), 204, 65, 276),
                new Location(Bukkit.getWorld("2023_SURVIVAL"), 275.5, 65, -89.5));
        put(new Location(Bukkit.getWorld("2023_PORT"), 247, 65, 317),
                new Location(Bukkit.getWorld("2023_QUESTIONS"), 0.5, -60, 0.5));
    }};

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block clicked = event.getClickedBlock();

            // event.getClickedBlock() can return nothing, i.e. 'null'.
            // Just in-case we'll check to make sure.
            if (clicked != null) {
                if (clicked.getType() == Material.STONE_BUTTON) {
                    Location loc = buttons.get(clicked.getLocation());
                    if(loc != null) event.getPlayer().teleport(loc);
                    event.setCancelled(true);
                }
            }
        }
    }

}
