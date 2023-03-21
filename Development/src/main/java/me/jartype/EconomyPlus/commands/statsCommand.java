package me.jartype.EconomyPlus.commands;

import com.google.common.base.MoreObjects;
import me.jartype.EconomyPlus.EconomyPlusMain;
import me.jartype.EconomyPlus.utils.Utils;
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
import me.jartype.EconomyPlus.managers.CurrencyManager;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;


public class statsCommand implements CommandExecutor {


    public EconomyPlusMain plugin;


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        CurrencyManager manager = new CurrencyManager(plugin);


        if (sender instanceof Player) {
            Player player = (Player) sender;

            Inventory gui = Bukkit.createInventory(player, 45, ChatColor.LIGHT_PURPLE + "Stats Upgrades");


            ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
            ItemStack strength = new ItemStack(Material.DIAMOND_SWORD);
            ItemStack defence = new ItemStack(Material.IRON_CHESTPLATE);
            ItemStack health = new ItemStack(Material.GOLDEN_APPLE);
            ItemStack speed = new ItemStack(Material.FEATHER);
            ItemStack regeneration = new ItemStack(Material.POTION);
            ItemStack jump = new ItemStack(Material.LEATHER_BOOTS);
            ItemStack mining = new ItemStack(Material.GOLDEN_PICKAXE);
            ItemStack saturation = new ItemStack(Material.GOLDEN_CARROT);
            ItemStack back = new ItemStack(Material.BARRIER);
            ItemStack balance = new ItemStack(Material.QUARTZ);



            ItemMeta air_meta = air.getItemMeta();
            air_meta.setDisplayName(ChatColor.BLACK + "Nothing");
            ArrayList<String> air_lore = new ArrayList<>();
            air_lore.add(ChatColor.WHITE + "");
            air_meta.setLore(air_lore);
            air.setItemMeta(air_meta);

            ItemMeta strength_meta = strength.getItemMeta();
            strength_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lStrength"));
            ArrayList<String> strength_lore = new ArrayList<>();
            strength_lore.add(ChatColor.WHITE + "U can upgrade your damage. (10)");
            strength_meta.setLore(strength_lore);
            strength.setItemMeta(strength_meta);


            ItemMeta defence_meta = defence.getItemMeta();
            defence_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lDefence"));
            ArrayList<String> defence_lore = new ArrayList<>();
            defence_lore.add(ChatColor.WHITE + "U can upgrade your defence.");
            defence_meta.setLore(defence_lore);
            defence.setItemMeta(defence_meta);

            ItemMeta health_meta = health.getItemMeta();
            health_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&cHealth"));
            ArrayList<String> health_lore = new ArrayList<>();
            health_lore.add(ChatColor.WHITE + "U can get more health.");
            health_meta.setLore(health_lore);
            health.setItemMeta(health_meta);

            ItemMeta speed_meta = speed.getItemMeta();
            speed_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lSpeed"));
            ArrayList<String> speed_lore = new ArrayList<>();
            speed_lore.add(ChatColor.WHITE + "U can be faster.");
            speed_meta.setLore(speed_lore);
            speed.setItemMeta(speed_meta);

            ItemMeta regeneration_meta = regeneration.getItemMeta();
            regeneration_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lRegeneration"));
            ArrayList<String> regeneration_lore = new ArrayList<>();
            regeneration_lore.add(ChatColor.WHITE + "Your health can regenerate faster.");
            regeneration_meta.setLore(regeneration_lore);
            regeneration.setItemMeta(regeneration_meta);


            ItemMeta jump_meta = jump.getItemMeta();
            jump_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lJump"));
            ArrayList<String> jump_lore = new ArrayList<>();
            jump_lore.add(ChatColor.WHITE + "Your can jump higher.");
            jump_meta.setLore(jump_lore);
            jump.setItemMeta(jump_meta);


            ItemMeta mining_meta = mining.getItemMeta();
            mining_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lMining Speed"));
            ArrayList<String> mining_lore = new ArrayList<>();
            mining_lore.add(ChatColor.WHITE + "Your can mine blocks faster.");
            mining_meta.setLore(mining_lore);
            mining.setItemMeta(mining_meta);


            ItemMeta saturation_meta = saturation.getItemMeta();
            saturation_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lSaturation"));
            ArrayList<String> saturation_lore = new ArrayList<>();
            saturation_lore.add(ChatColor.WHITE + "You dont need food.");
            saturation_meta.setLore(saturation_lore);
            saturation.setItemMeta(saturation_meta);




            ItemMeta back_meta = back.getItemMeta();
            back_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lBack to Menu"));
            ArrayList<String> back_lore = new ArrayList<>();
            back_lore.add(ChatColor.WHITE + "");
            back_meta.setLore(back_lore);
            back.setItemMeta(back_meta);


            ItemMeta balance_meta = balance.getItemMeta();
            balance_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lCrystals"));
            ArrayList<String> balance_lore = new ArrayList<>();
            balance_lore.add(Utils.chat("&f&l" + manager.getPlayerCurrency(player)));
            balance_meta.setLore(balance_lore);
            balance.setItemMeta(balance_meta);







            ItemStack[] menu_items = {
                    air, air, air, air, air, air, air, air, air,
                    air, air, air, strength, defence, health, air, air, air,
                    air, air, speed, regeneration, jump, mining, saturation, air, air,
                    air, air, air, air, air, air, air, air, air,
                    air, air, air, air, back, air, air, air, balance};
            gui.setContents(menu_items);
            player.openInventory(gui);
        }




        return true;
    }
}
