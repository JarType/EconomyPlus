package me.jartype.EconomyPlus.commands;

import me.jartype.EconomyPlus.EconomyPlusMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class FlyCommand implements CommandExecutor {

    private ArrayList<Player> list_of_flying_player = new ArrayList<>();

    private final EconomyPlusMain plugin;

    public FlyCommand(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("fly").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

    if(sender instanceof Player p) {
        if(p.hasPermission("EconomyPlus.fly")){
            if(args.length == 0) {
                if(list_of_flying_player.contains(p)){

                    p.setAllowFlight(false);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou can no longer fly."));
                    list_of_flying_player.remove(p);
                } else if(!list_of_flying_player.contains(p)) {

                    p.setAllowFlight(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aYou can now fly."));
                    list_of_flying_player.add(p);
                }
            } else if (args.length == 1){
                  Player target = Bukkit.getPlayer(args[0]);
                  if(p.hasPermission("EconomyPlus.flyothers")){
                      if(list_of_flying_player.contains(target)){

                          target.setAllowFlight(false);
                          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c"+target.getDisplayName()+" can no longer fly."));
                          target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c"+p.getDisplayName()+" took your perms to fly."));
                          list_of_flying_player.remove(target);
                      } else if(!list_of_flying_player.contains(target)) {

                          target.setAllowFlight(true);
                          p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a"+target.getDisplayName()+" can now fly."));
                          target.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a"+p.getDisplayName()+" gave you perms to fly."));
                          list_of_flying_player.add(target);
                      }


                  } else {
                      p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou dont have permissions for this"));
                  }
                   } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6/fly or /fly <player>"));
            }
        } else {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou dont have permission for this command"));
        }
    }

        return true;
    }
}
