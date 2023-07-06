package com.crafted.customname.commands;

import com.crafted.customname.TitlePlugin;
import com.crafted.customname.util.PlayerLottery;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class LotteryCommand extends AbstractPermissionCommand {

    public LotteryCommand() {
        super("cm.lottery");
    }
    @Override
    public boolean execute(Player player, @NotNull String[] args) {
        Plugin plugin = TitlePlugin.getPlugin(TitlePlugin.class);
        PlayerLottery.doLottery(Objects.requireNonNull(plugin.getServer().getWorld("2023_SURVIVAL")));
        return true;
    }
}
