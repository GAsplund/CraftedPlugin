package com.crafted.customname.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PortCommand implements CommandExecutor {

    private final Component portMessage = Component
            .text("Wooosh! You have been teleported to port!")
            .color(NamedTextColor.DARK_GREEN);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            Location loc = new Location(Bukkit.getWorld("2023_PORT"), 205.5, 64, 318.5, 180, 0);
            player.sendMessage(portMessage);
            player.teleport(loc);
            return true;
        }

        return false;
    }

}
