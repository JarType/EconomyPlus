package me.jartype.EconomyPlus.commands;

import me.jartype.EconomyPlus.EconomyPlusMain;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetWarpCommand implements CommandExecutor {
    private final EconomyPlusMain plugin;

    public SetWarpCommand(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("setwarp").setExecutor(this);
    }



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(sender instanceof Player p) {

            Location location = p.getLocation();

        if (args.length == 0) {

            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/setwarp <name>"));

        } else if (args.length == 1) {

                plugin.getConfig().set("warps."+args[0], location);
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aSet warp "+args[0]));

        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/setwarp <name>"));
        }



        }
        return true;
    }
}
