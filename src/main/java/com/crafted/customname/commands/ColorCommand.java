package com.crafted.customname.commands;

import com.crafted.customname.util.ChatColors;
import com.crafted.customname.util.PrefixBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ColorCommand extends AbstractPermissionCommand {
    private final Component invalidColorMessage = Component
            .text("Invalid color! Please use a valid color.")
            .color(NamedTextColor.RED);

    private final PrefixBuilder builder;

    public ColorCommand() {
        super("cm.prefix.color");
        builder = new PrefixBuilder();
    }
    @Override
    public boolean execute(Player player, @NotNull String[] args) {
        if (args.length < 1) return false;
        String color = args[0];

        if (!ChatColors.validColor(color)) {
            player.sendMessage(invalidColorMessage);
            return false;
        }

        builder.setColor(player, color);
        return true;
    }
}
