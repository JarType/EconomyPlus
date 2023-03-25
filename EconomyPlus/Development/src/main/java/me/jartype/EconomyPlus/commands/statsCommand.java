package me.jartype.EconomyPlus.commands;

import jdk.jshell.execution.Util;
import me.jartype.EconomyPlus.EconomyPlusMain;
import me.jartype.EconomyPlus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.jartype.EconomyPlus.managers.CurrencyManager;

import java.io.File;
import java.util.ArrayList;


public class statsCommand implements CommandExecutor {


    private final EconomyPlusMain plugin;

    public statsCommand(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("stats").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


        CurrencyManager manager = new CurrencyManager(plugin);


        if (sender instanceof Player) {


            File configFile = new File(plugin.getDataFolder(), "config.yml");
            FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

            Player player = (Player) sender;
            String playerName = player.getName();
            String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
            int strengthLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.strength")) {
                strengthLevel = config.getInt("players." + formattedPlayerName + ".effects.strength");
            }
            int defenceLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.defence")) {
                defenceLevel = config.getInt("players." + formattedPlayerName + ".effects.defence");
            }
            int healthLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.health")) {
                healthLevel = config.getInt("players." + formattedPlayerName + ".effects.health");
            }
            int speedLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.speed")) {
                speedLevel = config.getInt("players." + formattedPlayerName + ".effects.speed");
            }
            int regenerationLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.regeneration")) {

                regenerationLevel = config.getInt("players." + formattedPlayerName + ".effects.regeneration");
            }
            int jumpLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.jump")) {
                jumpLevel = config.getInt("players." + formattedPlayerName + ".effects.jump");
            }
            int miningLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.mining")) {
                miningLevel = config.getInt("players." + formattedPlayerName + ".effects.mining");
            }
            int saturationLevel = 0;
            if (config.contains("players." + formattedPlayerName + ".effects.saturation")) {
                saturationLevel = config.getInt("players." + formattedPlayerName + ".effects.saturation");
            }








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
            if (strengthLevel != 10) {
                strength_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lStrength " + strengthLevel));
            } else {
                strength_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&4&lStrength MAXED"));
            }
            ArrayList<String> strength_lore = new ArrayList<>();
            strength_lore.add(Utils.chat("&fU can upgrade your damage."));
            strength_lore.add("");
            if (strengthLevel != 10) {
                strength_lore.add(Utils.chat("&eCost: " + strengthLevel * 10));
            } else {
                strength_lore.add(Utils.chat("&dMaxed "));
            }
            strength_meta.setLore(strength_lore);
            strength.setItemMeta(strength_meta);


            ItemMeta defence_meta = defence.getItemMeta();
            if (defenceLevel != 10) {
                defence_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lDefence " + defenceLevel));
            } else {
                defence_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lDefence &4&lMAXED"));
            }
            ArrayList<String> defence_lore = new ArrayList<>();
            defence_lore.add(Utils.chat("&fU can upgrade your defence."));
            defence_lore.add("");
            if (defenceLevel != 10) {
                defence_lore.add(Utils.chat("&eCost: " + defenceLevel * 10));
            } else {
                defence_lore.add(Utils.chat("&dMaxed"));
            }
            defence_meta.setLore(defence_lore);
            defence.setItemMeta(defence_meta);

            ItemMeta health_meta = health.getItemMeta();
            if (healthLevel != 10) {
                health_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lHealth " + healthLevel));
            } else {
                health_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lHealth &4&lMAXED"));
            }
            ArrayList<String> health_lore = new ArrayList<>();
            health_lore.add(Utils.chat ("&fU can get more health."));
            health_lore.add("");
            if (healthLevel != 10) {
                health_lore.add(Utils.chat("&eCost: " + healthLevel * 10));
            } else {
                health_lore.add(Utils.chat("&dMaxed"));
            }
            health_meta.setLore(health_lore);
            health.setItemMeta(health_meta);

            ItemMeta speed_meta = speed.getItemMeta();
            if (speedLevel != 10) {
                speed_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lSpeed " + speedLevel));
            } else {
                speed_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lSpeed &4&lMAXED"));
            }
            ArrayList<String> speed_lore = new ArrayList<>();
            speed_lore.add(Utils.chat ("&fU can be faster."));
            speed_lore.add("");
            if (speedLevel != 10) {
                speed_lore.add(Utils.chat("&eCost: " + speedLevel * 10));
            } else {
                speed_lore.add(Utils.chat("&dMAXED"));
            }
            speed_meta.setLore(speed_lore);
            speed.setItemMeta(speed_meta);

            ItemMeta regeneration_meta = regeneration.getItemMeta();
            if (regenerationLevel != 10) {
                regeneration_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lRegeneration " + regenerationLevel));
            } else {
                regeneration_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lRegeneration &4&lMAXED"));
            }
            ArrayList<String> regeneration_lore = new ArrayList<>();
            regeneration_lore.add(Utils.chat("&fYour health can regenerate faster."));
            regeneration_lore.add("");
            if (regenerationLevel !=10) {
                regeneration_lore.add(Utils.chat("&eCost: " + regenerationLevel * 10));
            } else {
                regeneration_lore.add(Utils.chat("&dMaxed"));
            }
            regeneration_meta.setLore(regeneration_lore);
            regeneration.setItemMeta(regeneration_meta);


            ItemMeta jump_meta = jump.getItemMeta();
            if (jumpLevel != 5) {
                jump_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lJump " + jumpLevel));
            } else {
                jump_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lJump &4&lMAXED"));
            }
            ArrayList<String> jump_lore = new ArrayList<>();
            jump_lore.add(Utils.chat("&fYou can jump higher."));
            jump_lore.add("");
            if (jumpLevel != 5) {
                jump_lore.add(Utils.chat("&eCost: " + jumpLevel * 10));
            } else {
                jump_lore.add(Utils.chat("&dMaxed"));
            }
            jump_meta.setLore(jump_lore);
            jump.setItemMeta(jump_meta);


            ItemMeta mining_meta = mining.getItemMeta();
            Integer miningPrice = miningLevel * 10;
            if (miningLevel != 10) {
                mining_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lMining Speed " + miningLevel));
            } else {
                mining_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lMining Speed &4&lMAXED"));
            }
            ArrayList<String> mining_lore = new ArrayList<>();
            mining_lore.add(ChatColor.translateAlternateColorCodes('&', "&fYour can mine blocks faster."));
            mining_lore.add("");
            if (miningLevel != 10) {
                mining_lore.add(ChatColor.translateAlternateColorCodes('&', "&eCost: " + miningPrice));
            } else {
                mining_lore.add(ChatColor.translateAlternateColorCodes('&', "&dMaxed"));
            }
            mining_meta.setLore(mining_lore);
            mining.setItemMeta(mining_meta);


            ItemMeta saturation_meta = saturation.getItemMeta();
            if (saturationLevel != 1) {
                saturation_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lSaturation " + saturationLevel));
            } else {
                saturation_meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lSaturation &4&lMAXED"));
            }
            ArrayList<String> saturation_lore = new ArrayList<>();
            saturation_lore.add(Utils.chat("&fYou dont need food."));
            saturation_lore.add("");
            if (saturationLevel != 1) {
                saturation_lore.add(Utils.chat("&eCost: 10"));
            } else {
                saturation_lore.add(Utils.chat("&dMaxed"));
            }
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
