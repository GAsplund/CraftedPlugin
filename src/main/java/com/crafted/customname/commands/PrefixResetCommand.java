package com.crafted.customname.commands;

import com.crafted.customname.util.PrefixBuilder;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.Objects;

public class PrefixResetCommand implements CommandExecutor {
    private final PrefixBuilder builder;
    private final Permission perms;

    public PrefixResetCommand() {
        builder = new PrefixBuilder();
        perms = Objects.requireNonNull(Bukkit.getServer().getServicesManager().getRegistration(Permission.class)).getProvider();
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)) {
            return true;
        }

        builder.removePrefix(player);
        return true;
    }
}
