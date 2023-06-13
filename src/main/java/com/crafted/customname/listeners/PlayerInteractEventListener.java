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
    Map<Location, String> buttons = new HashMap<>() {{
        put(new Location(Bukkit.getWorld("world"), 0, 0, 0), "mv tp %s P");
        put(new Location(Bukkit.getWorld("world"), 0, 0, 0), "mv tp %s C");
        put(new Location(Bukkit.getWorld("world"), 0, 0, 0), "mv tp %s S");
    }};

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block clicked = event.getClickedBlock();

            // event.getClickedBlock() can return nothing, i.e. 'null'.
            // Just in-case we'll check to make sure.
            if (clicked != null) {
                if (clicked.getType() == Material.STONE_BUTTON) {
                    ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
                    String command = String.format(buttons.get(clicked.getLocation()), event.getPlayer().getName());
                    if(command != null) Bukkit.dispatchCommand(console, command);
                }
            }
        }
    }

}
