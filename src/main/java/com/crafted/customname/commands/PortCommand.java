package com.crafted.customname.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PortCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            Location loc = new Location(Bukkit.getWorld("2023_PORT"), 205.5, 64, 318.5, 0, 0);
            player.sendMessage("§2Wooosh! You have been teleported to port!");
            player.teleport(loc);
            player.sendMessage("§b** If you need some informations, follow the road without any wools.");
            return true;
        }

        return false;
    }

}
