package com.crafted.customname.commands;

import com.crafted.customname.util.ChatColors;
import com.crafted.customname.util.PrefixBuilder;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class TitleCommand extends AbstractPermissionCommand {
    private final Component tooLongMessage = Component
            .text("Your title is too long! Please set a title shorter than 13 characters.")
            .color(NamedTextColor.RED);

    private final PrefixBuilder builder;

    public TitleCommand() {
        super("cm.prefix.title");
        builder = new PrefixBuilder();
    }
    @Override
    public boolean execute(Player player, @NotNull String[] args) {
        if (args.length < 1) return false;
        String prefix = args[0];

        String rawPrefix = ChatColors.stripColor(prefix);
        if (rawPrefix.length() > 13) {
            player.sendMessage(tooLongMessage);
            return false;
        }

        builder.setTitle(player, prefix);
        return true;
    }
}
