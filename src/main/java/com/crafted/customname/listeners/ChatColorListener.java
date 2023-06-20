package com.crafted.customname.listeners;

import com.crafted.customname.util.ChatColors;
import net.milkbowl.vault.chat.Chat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Objects;

public class ChatColorListener implements Listener {
    private final Chat chat;

    public ChatColorListener() {
        chat = Objects.requireNonNull(Bukkit.getServer().getServicesManager().getRegistration(Chat.class)).getProvider();
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String worldcolor = chat.getPlayerInfoString(null, player, "cm-worldcolor", "&r");
        if (!ChatColors.validColor(worldcolor)) worldcolor = "&r";

        String worldColorFormatted = ChatColor.translateAlternateColorCodes('&', worldcolor);
        String message = event.getFormat().replace("{WORLDCOLOR}", worldColorFormatted);

        event.setFormat(message);
    }
}
