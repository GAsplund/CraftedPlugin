package com.crafted.customname.listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.ComponentLike;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerEvent;
import org.intellij.lang.annotations.RegExp;

import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class ChatListener implements Listener {
    @RegExp
    private final Pattern WORLD_COLOR_PATTERN = Pattern.compile("\\{WORLDCOLOR\\}(\\[.+\\])\\{WORLDCOLOREND\\}");
    public static ComponentLike WorldColorCallback(MatchResult results, TextComponent.Builder builder)
    {
        return Component.text()
                .content(results.group(1))
                .color(NamedTextColor.GOLD);
    }
    @EventHandler(priority=EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event) {
        // Disable EssentialsXChat event triggering and set up own plugin to render the message
        event.setCancelled(true);
        // Since Essential already did most of the formatting, the rest can be done by deserializing the previous format
        String format = event.getFormat();
        TextComponent comp = LegacyComponentSerializer.legacySection().deserialize(format);

        // TextReplacementConfig can be later used by TextComponent.replaceText(TextReplaceConfig)
        // It allows for consuming each component (either by root or children) and performing regex replacing on its contents
        // This feature is desired since we want to search for custom patterns inside the already "formatted" message, and reformatting it at will.
        TextReplacementConfig replacer = TextReplacementConfig.builder()
                        .match(WORLD_COLOR_PATTERN)
                        .replacement(ChatListener::WorldColorCallback).build();
        Component replacedComp = comp.replaceText(replacer);

        // TODO: Find more patterns using the method above (TextReplacementConfig) with custom callback like `WorldColorCallback`
        // TODO: Find %1$s and %2$s to replace with event.getPlayer().getDisplayName() and event.getMessage() respectively
        // TODO: End whole procedure with feeding everything to a MiniMessage builder (https://docs.advntr.dev/minimessage/api.html)
        // TODO: Check (https://docs.advntr.dev/minimessage/format.html#) to see why I want to add MiniMessage formatter :)
        // String.format(replacedComp, event.getPlayer().getDisplayName(), event.getMessage());
        Bukkit.getServer().sendMessage(replacedComp);
    }
}