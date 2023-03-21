package me.jartype.EconomyPlus.commands;

import me.jartype.EconomyPlus.EconomyPlusMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.*;

public class Message implements CommandExecutor {

    public EconomyPlusMain plugin;

    public Message(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("m").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player) {
            Player p = (Player) sender;

            if(args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/m <player> <message>"));
            }else if(args.length == 1) {
                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if(target == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis player is not online"));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c/m "+playerName+" <message>"));
                }
            } else {
                StringBuilder builder = new StringBuilder();

                String playerName = args[0];

                Player target = Bukkit.getServer().getPlayerExact(playerName);

                if (target == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis player is not online"));
                } else {

                    for (int i = 1; i < args.length; i++) {

                        builder.append(args[i]);
                        builder.append(" ");
                    }

                    String finalMessage = builder.toString();
                    finalMessage = finalMessage.stripTrailing();

                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dTo &6" + target.getDisplayName() + "&7: " + finalMessage));
                    target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&dFrom &6" + p.getDisplayName() + "&7: " + finalMessage));
                }
            }
        }



        return false;
    }
}
