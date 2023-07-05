
    package com.crafted.customname.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

    public class PlayerFirstTimeJoiningListener implements Listener {


        private final Component welcomeMessage = Component
                .text(" has joined for the first time! Welcome them to the server")
                .color(NamedTextColor.GREEN);

        @EventHandler
        public void onFirstJoin(PlayerJoinEvent event, Bukkit player) {

            OfflinePlayer offlinePlayer = Bukkit.getOfflinePlayer(player.getName());

            if(!offlinePlayer.hasPlayedBefore())
            {
                Bukkit.broadcastMessage(player.getName() + welcomeMessage);
            }
        }

    }
