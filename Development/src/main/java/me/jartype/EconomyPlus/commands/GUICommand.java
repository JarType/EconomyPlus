package me.jartype.EconomyPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class GUICommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(player, 9, ChatColor.LIGHT_PURPLE + "Crystal Shop");


            ItemStack air1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemStack stats = new ItemStack(Material.DIAMOND_SWORD);
            ItemStack comming1 = new ItemStack(Material.BARRIER);
            ItemStack comming2 = new ItemStack(Material.BARRIER);




            ItemMeta air1_meta = air1.getItemMeta();
            air1_meta.setDisplayName(ChatColor.BLACK + "Nothing");
            ArrayList<String> air1_lore = new ArrayList<>();
            air1_lore.add(ChatColor.WHITE + "");
            air1_meta.setLore(air1_lore);
            air1.setItemMeta(air1_meta);


            
            ItemMeta stats_meta = stats.getItemMeta();
            stats_meta.setDisplayName(ChatColor.RED + "Stats");
            ArrayList<String> stats_lore = new ArrayList<>();
            stats_lore.add(ChatColor.WHITE + "U can upgrade your stats here.");
            stats_meta.setLore(stats_lore);
            stats.setItemMeta(stats_meta);


            ItemMeta comming1_meta = comming1.getItemMeta();
            comming1_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lComming Soon"));
            ArrayList<String> comming1_lore = new ArrayList<>();
            comming1_lore.add(ChatColor.RED + "Let him cook!");
            comming1_meta.setLore(comming1_lore);
            comming1.setItemMeta(comming1_meta);

            ItemMeta comming2_meta = comming2.getItemMeta();
            comming2_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lComming Soon"));
            ArrayList<String> comming2_lore = new ArrayList<>();
            comming2_lore.add(ChatColor.RED + "Let him cook!");
            comming2_meta.setLore(comming2_lore);
            comming2.setItemMeta(comming2_meta);







            ItemStack[] menu_items = {air1, air1, air1, stats, comming1, comming2, air1, air1, air1};
            gui.setContents(menu_items);
            player.openInventory(gui);
        }




        return true;
    }
}
