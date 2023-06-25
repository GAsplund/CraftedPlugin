package com.crafted.customname.commands;

import com.crafted.customname.util.PrefixBuilder;
import net.kyori.adventure.text.Component;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PrefixResetCommand extends AbstractPermissionCommand {
    private final Component prefixResetMessage = Component
            .text("Your title and color have been reset.");

    private final PrefixBuilder builder;

    public PrefixResetCommand() {
        super("cm.prefix.reset");
        builder = new PrefixBuilder();
    }

    @Override
    public boolean execute(Player player, @NotNull String[] args) {
        builder.removePrefix(player);
        player.sendMessage(prefixResetMessage);
        return true;
    }
}
