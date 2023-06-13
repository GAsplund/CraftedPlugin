package com.crafted.customname.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PortCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player player) {
            player.sendMessage("§2Wooosh! You have been teleported to port!");
            player.performCommand("mv tp 2023_PORT");
            player.sendMessage("§b** If you need some informations, follow the road without any wools.");
            return true;
        }

        return false;
    }

}
