package me.jartype.EconomyPlus.commands;

import org.bukkit.Bukkit;
import me.jartype.EconomyPlus.EconomyPlusMain;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

public class adminGUICommand implements CommandExecutor {

    private final EconomyPlusMain plugin;

    public adminGUICommand(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("admingui").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p) {
            if (p.hasPermission("EconomyPlus.adminGUI")) {

             plugin.openMainAdminGUI(p);


            } else {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou dont have permissions for this command"));
            }

        }



        return true;

    }
}
