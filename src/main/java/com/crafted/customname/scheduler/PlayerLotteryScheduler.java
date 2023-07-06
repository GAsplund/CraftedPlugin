package com.crafted.customname.scheduler;

import com.crafted.customname.TitlePlugin;
import com.crafted.customname.util.PlayerLottery;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.util.Objects;

public final class PlayerLotteryScheduler {

    private static final long lotteryTime = 72000L;

    public static void onEnable() {

        Plugin plugin = TitlePlugin.getPlugin(TitlePlugin.class);

        BukkitScheduler scheduler = plugin.getServer().getScheduler();
        scheduler.scheduleSyncRepeatingTask(
                plugin,
                () -> PlayerLottery.doLottery(Objects.requireNonNull(plugin.getServer().getWorld("2023_SURVIVAL"))),
                0L,
                lotteryTime
        );

        //20L is twenty ticks,
        //twenty ticks is 1 second
        //1 hr would be: 20 * 60 * 60
        // 20 ticks, 60 seconds, 60 minutes
        // =
    }


}
