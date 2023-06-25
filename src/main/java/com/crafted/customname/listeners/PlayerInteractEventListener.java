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
                new Location(Bukkit.getWorld("2023_CREATIVE"), 0.5, -2, 0.5)); // Creative
        put(new Location(Bukkit.getWorld("2023_PORT"), 204, 65, 276),
                new Location(Bukkit.getWorld("2023_SURVIVAL"), 275.5, 65, -89.5)); // Survival
        put(new Location(Bukkit.getWorld("2023_PORT"), 247, 65, 317),
                new Location(Bukkit.getWorld("2023_QUESTIONS"), -18.5, -50, 36.5)); // FAQ

        put(new Location(Bukkit.getWorld("2023_PORT"), 240, 65, 329),
                new Location(Bukkit.getWorld("OLD_SURVIVAL_1"), 92.5, 65, 447.5)); // Survival 3
        put(new Location(Bukkit.getWorld("2023_PORT"), 240, 64, 329),
                new Location(Bukkit.getWorld("OLD_SURVIVAL_3"), -2037.5, 65, 804.5)); // Survival 4
        put(new Location(Bukkit.getWorld("2023_PORT"), 239, 65, 329),
                new Location(Bukkit.getWorld("OLD_CREATIVE_SPAWN"), 601.5, 5, -690.5)); // Creative spawn
        put(new Location(Bukkit.getWorld("2023_PORT"), 239, 64, 329),
                new Location(Bukkit.getWorld("OLD_CREATIVE_RACKOBOI"), 602.5, 38, -1686.5)); // Creative rackoboi
        put(new Location(Bukkit.getWorld("2023_PORT"), 238, 65, 329),
                new Location(Bukkit.getWorld("OLD_MINIGAMES"), 348.5, 4, -53.5, -166, -11)); // Minigames
        put(new Location(Bukkit.getWorld("2023_PORT"), 237, 65, 329),
                new Location(Bukkit.getWorld("OLD_PORT_1_ANARCHY_CHUNK_ERRORS"), 205.5, 64, 318.5)); // Port 2011
        put(new Location(Bukkit.getWorld("2023_PORT"), 237, 64, 329),
                new Location(Bukkit.getWorld("OLD_PORT_3_MINIGAMES"), 205.5, 64, 318.5)); // Port 2012
        put(new Location(Bukkit.getWorld("2023_PORT"), 236, 65, 329),
                new Location(Bukkit.getWorld("OLD_CTF_2"), -1949.5, 138, 2119.5)); // CTF

        put(new Location(Bukkit.getWorld("2023_PORT"), 278, 21, 403),
                new Location(Bukkit.getWorld("wynncraft"), -882, 66, -1576, -90, 0)); // Wynncraft
        put(new Location(Bukkit.getWorld("2023_PORT"), 275, 21, 406),
                new Location(Bukkit.getWorld("wynncraft"), -882, 66, -1576, -90, 0)); // Wynncraft
        put(new Location(Bukkit.getWorld("2023_PORT"), 272, 21, 403),
                new Location(Bukkit.getWorld("wynncraft"), -882, 66, -1576, -90, 0)); // Wynncraft
        put(new Location(Bukkit.getWorld("2023_PORT"), 275, 21, 400),
                new Location(Bukkit.getWorld("wynncraft"), -882, 66, -1576, -90, 0)); // Wynncraft
    }};

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block clicked = event.getClickedBlock();

            // event.getClickedBlock() can return nothing, i.e. 'null'.
            // Just in-case we'll check to make sure.
            if (clicked != null) {
                if (clicked.getType() == Material.STONE_BUTTON || clicked.getType() == Material.OAK_BUTTON) {
                    Location loc = buttons.get(clicked.getLocation());
                    if(loc != null)  {
                        event.getPlayer().teleport(loc);
                        event.setCancelled(true);
                    }
                }
            }
        }
    }

}
