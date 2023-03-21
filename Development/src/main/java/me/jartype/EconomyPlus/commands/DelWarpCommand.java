package me.jartype.EconomyPlus.commands;

import me.jartype.EconomyPlus.EconomyPlusMain;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DelWarpCommand implements CommandExecutor {
    private final EconomyPlusMain plugin;

    public DelWarpCommand(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("delwarp").setExecutor(this);
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p) {

            if (args.length == 0) {

                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/delwarp <name>"));

            } else if (args.length == 1) {

                plugin.getConfig().set("warps."+args[0], null);
                plugin.saveDefaultConfig();
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lDeleted warp "+args[0]));

            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/delwarp <name>"));
            }



        }
        return true;
    }
}
