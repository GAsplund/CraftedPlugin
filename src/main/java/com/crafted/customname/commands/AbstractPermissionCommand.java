package com.crafted.customname.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

import static org.bukkit.Bukkit.getServer;

public abstract class AbstractPermissionCommand implements CommandExecutor {
    private final Component noPermissionMessage = Component
            .text("You do not have permission to use this command!")
            .color(NamedTextColor.RED);

    private final String node;
    private final Permission perm;

    public AbstractPermissionCommand(String node) {
        this.perm = Objects.requireNonNull(getServer().getServicesManager().getRegistration(Permission.class)).getProvider();
        this.node = node;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            return true;
        }

        if (!perm.has(player, node)) {
            sender.sendMessage(noPermissionMessage);
            return true;
        }

        return execute(player, args);
    }

    protected abstract boolean execute(Player player, @NotNull String[] args);
}
