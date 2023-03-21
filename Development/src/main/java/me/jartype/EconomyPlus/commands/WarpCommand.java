package me.jartype.EconomyPlus.commands;

import me.jartype.EconomyPlus.EconomyPlusMain;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WarpCommand implements CommandExecutor {

    private final EconomyPlusMain plugin;

    public WarpCommand(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("warp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p) {

            if(args.length == 0) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/warp <name>"));
            } else if (args.length == 1) {

                Location location = plugin.getConfig().getLocation("warps."+args[0]);

                if(location == null) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis warp doesn't exist"));
                } else {
                    p.teleport(location);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou warped to "+args[0]));
                }

            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/warp <name>"));
            }

        }

        return true;
    }
}
