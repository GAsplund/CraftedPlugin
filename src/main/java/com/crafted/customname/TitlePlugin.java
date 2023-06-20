package com.crafted.customname;

import com.crafted.customname.commands.*;
import com.crafted.customname.listeners.ChatColorListener;
import com.crafted.customname.listeners.ChatListener;
import com.crafted.customname.listeners.EntityDeathEventListener;
import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;
import net.milkbowl.vault.permission.Permission;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.ServicePriority;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.Plugin;

import java.util.Objects;
import java.util.logging.Logger;

public class TitlePlugin extends JavaPlugin {

    private static final Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onDisable() {
        log.info(String.format("[%s] Disabled Version %s", getName(), getPluginMeta().getVersion()));
    }

    @Override
    public void onEnable() {
        saveDefaultConfig();
        if (!checkVaultIntegration())
        {
            log.severe(String.format("[%s] - Vault dependency not found, disabling plugin!", getServer().getName()));
        }
        // Register events
        //getServer().getPluginManager().registerEvents(new ChatListener(), this);
        getServer().getPluginManager().registerEvents(new EntityDeathEventListener(), this);
        getServer().getPluginManager().registerEvents(new ChatColorListener(), this);

        // Register commands
        Objects.requireNonNull(this.getCommand("resetprefix")).setExecutor(new PrefixResetCommand());
        Objects.requireNonNull(this.getCommand("title")).setExecutor(new TitleCommand());
        Objects.requireNonNull(this.getCommand("color")).setExecutor(new ColorCommand());
        Objects.requireNonNull(this.getCommand("bed")).setExecutor(new BedCommand());
        Objects.requireNonNull(this.getCommand("port")).setExecutor(new PortCommand());
        Objects.requireNonNull(this.getCommand("spawn")).setExecutor(new SpawnCommand());
    }

    private boolean checkVaultIntegration() {
        if (getServer().getPluginManager().isPluginEnabled("Vault")) {
            final RegisteredServiceProvider<Chat> chatRsp = getServer().getServicesManager().getRegistration(Chat.class);
            final RegisteredServiceProvider<Permission> permRsp = getServer().getServicesManager().getRegistration(Permission.class);
            if (chatRsp != null && permRsp != null) {
                return true;
            }
        }
        return false;
    }
}