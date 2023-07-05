package com.crafted.customname.util;

import com.crafted.customname.scheduler.PlayerLotteryScheduler;
import it.unimi.dsi.fastutil.bytes.AbstractByte2FloatSortedMap;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import java.util.Random;

public class PlayerLottery {

    private static final Component lotteryMessage = Component
            .text("The Survival hourly lottery has occurred! One diamond was the prize! Congratulations to the winner!")
            .color(NamedTextColor.AQUA);

    private static final Component nooneMessage = Component
            .text("The Survival hourly lottery would occur, but no-one was in the Survival world! :(")
            .color(NamedTextColor.AQUA);

    private static final Component dropMessage = Component
            .text("Your inventory was full, so the item was dropped in front of you instead!")
            .color(NamedTextColor.RED);

    public static void doLottery(World world) {
        Random rand = new Random();
        float pitch_randomiser = rand.nextFloat();
        //0.0 and 1.0

        //get amount of players in survival world
        //get list of players in survival world
        //random integer between number of players in survival world
        //correspond each integer to player
        //give diamond to one of those names

        if (world.getPlayers().size() < 1) {
            for (Player player : world.getPlayers()) {
                Bukkit.broadcast(nooneMessage);
            }
            return;
        }
        
        Player winner = world.getPlayers().get(rand.nextInt(world.getPlayers().size()-1));

        for (Player player : world.getPlayers()) {
            if (player == winner) {
                winner.sendMessage(lotteryMessage);
                winner.playSound(winner.getLocation(), "minecraft:entity.player.levelup", 1, 0.5f + pitch_randomiser);

                if (winner.getInventory().addItem(new ItemStack(Material.DIAMOND, 1)).isEmpty()) {
                    world.dropItem(winner.getLocation(), new ItemStack(Material.DIAMOND, 1));
                    winner.sendMessage(dropMessage);
                }
            } else {
                player.sendMessage(lotteryMessage);
            }
        }

    }

}
