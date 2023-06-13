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

    // Non-persistent for now
    private static final Map<Player, UserPrefix> prefixes = new HashMap<>();

    /**
     * Sets the title prefix of a player
     * @param player The player to set the prefix for
     * @param title The title to be set
     */
    public void setTitle(Player player, String title) {
        UserPrefix prefix;
        if (prefixes.containsKey(player)) {
            prefix = prefixes.get(player);
            prefix = new UserPrefix(title, prefix.color());
        } else {
            prefix = new UserPrefix(title, "&r");
        }
        prefixes.put(player, prefix);
        applyPrefix(player);
    }

    /**
     * Sets the color of a player name
     * @param player The player to set the color for
     * @param color The color to be set
     */
    public void setColor(Player player, String color) {
        UserPrefix prefix;
        if (prefixes.containsKey(player)) {
            prefix = prefixes.get(player);
            prefix = new UserPrefix(prefix.title(), color);
        } else {
            prefix = new UserPrefix("", color);
        }
        prefixes.put(player, prefix);
        applyPrefix(player);
    }

    /**
     * Removes both the title and color from a player
     * @param player The player to remove the prefix from
     */
    public void removePrefix(Player player) {
        prefixes.put(player, new UserPrefix());
        applyPrefix(player);
    }

    /**
     * Applies the prefix to a player from stored data to LuckPerms
     * @param player The player to apply the prefix to
     */
    public void applyPrefix(Player player) {
        UserPrefix prefix = prefixes.get(player);
        if (prefix == null) {
            prefix = new UserPrefix("", "&r");
        }
        chat.setPlayerPrefix(null, player, prefix.toString());
    }
}
