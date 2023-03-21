package me.jartype.EconomyPlus.listeners;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.Random;

public class MobKills implements Listener {
    @EventHandler
    public void onKillMob(EntityDeathEvent e) {

        LivingEntity entity = e.getEntity();

        if(entity.getType() == EntityType.ENDERMAN) {
            Player player = entity.getKiller();

            if (player != null) {
                // check if drop should occur
                Random rand = new Random();
                int dropChance = rand.nextInt(100);
                if (dropChance < 5) { // 10% chance to drop
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lRARE DROP &f&l-> &d&lCrystal &b&l(5%)"));

                    // Create a new ItemStack representing one Nether Quartz
                    ItemStack netherQuartz = new ItemStack(Material.QUARTZ, 1);

                    // Create a new ItemMeta object for the item
                    ItemMeta meta = netherQuartz.getItemMeta();

                    // Check if the ItemMeta object is not null
                    if (meta != null) {
                        // Set the item's display name
                        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lCrystal"));


                        // Set the item's lore
                        meta.setLore(Arrays.asList(
                                ChatColor.translateAlternateColorCodes('&', "&f&Drop from Endermans &b&l(5%)"),
                                "",
                                "",
                                ChatColor.translateAlternateColorCodes('&', "&7You can use this in /crystals"),
                                ChatColor.translateAlternateColorCodes('&', "&7Right click to redeem it")
                        ));

                        // Apply the ItemMeta to the item
                        netherQuartz.setItemMeta(meta);
                    }

                    // Get the player's inventory
                    Inventory inventory = player.getInventory();

                    // Add the item to the player's inventory
                    inventory.addItem(netherQuartz);
                }
            }
        }
    }
}
