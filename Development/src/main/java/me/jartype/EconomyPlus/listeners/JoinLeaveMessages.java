package me.jartype.EconomyPlus.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinLeaveMessages implements Listener {
        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent e) {
            e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', "&a+ " + e.getPlayer().getName() + " &ajoined the server"));
        }
        @EventHandler
        public void onPlayerQuit(PlayerQuitEvent e) {
            e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', "&c- " + e.getPlayer().getName() + " &cleft the server"));
}}

