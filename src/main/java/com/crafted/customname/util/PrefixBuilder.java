package com.crafted.customname.util;

import com.crafted.customname.models.UserPrefix;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * A class to build prefixes for players
 */
public class PrefixBuilder {

    private final Chat chat;

    public PrefixBuilder() {
        chat = Objects.requireNonNull(Bukkit.getServer().getServicesManager().getRegistration(Chat.class)).getProvider();
    }

    public UserPrefix getPrefix(Player player) {
        return UserPrefix.deserialize(chat.getPlayerInfoString(player, "prefix_serialized", "\n&r"));
    }

    /**
     * Sets the title prefix of a player
     * @param player The player to set the prefix for
     * @param title The title to be set
     */
    public void setTitle(Player player, String title) {
        UserPrefix prefix = getPrefix(player);
        prefix.setTitle(title);
        setPrefix(player, prefix);
    }

    /**
     * Sets the color of a player name
     * @param player The player to set the color for
     * @param color The color to be set
     */
    public void setColor(Player player, String color) {
        UserPrefix prefix = getPrefix(player);
        prefix.setColor(color);
        setPrefix(player, prefix);
    }

    /**
     * Removes both the title and color from a player
     * @param player The player to remove the prefix from
     */
    public void removePrefix(Player player) {
        setPrefix(player, new UserPrefix("", "&r"));
    }

    /**
     * Applies the prefix to a player from stored data to LuckPerms
     * @param player The player to apply the prefix to
     */
    public void setPrefix(Player player, UserPrefix prefix) {
        chat.setPlayerPrefix(null, player, prefix.toString());
        chat.setPlayerInfoString(player, "prefix_serialized", prefix.serialize());
    }
}
