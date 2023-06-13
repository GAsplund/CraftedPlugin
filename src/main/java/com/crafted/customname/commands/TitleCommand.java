package com.crafted.customname.commands;

import com.crafted.customname.util.ChatColors;
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

public class TitleCommand implements CommandExecutor {
    private final PrefixBuilder builder;
    private final Permission perms;

    public TitleCommand() {
        builder = new PrefixBuilder();
        perms = Objects.requireNonNull(Bukkit.getServer().getServicesManager().getRegistration(Permission.class)).getProvider();
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player player)) {
            return true;
        }

        if (args.length < 1) return false;
        String prefix = args[0];

        String rawPrefix = ChatColors.stripColor(prefix);
        if (rawPrefix.length() > 13) {
            player.sendMessage("§cYour title is too long! Please set a title shorter than 13 characters.");
            return false;
        }

        builder.setTitle(player, prefix);
        return true;
    }
}
