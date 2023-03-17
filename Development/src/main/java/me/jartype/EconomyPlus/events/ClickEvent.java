package me.jartype.EconomyPlus.events;

import me.jartype.EconomyPlus.EconomyPlusMain;
import me.jartype.EconomyPlus.managers.CurrencyManager;
import me.jartype.EconomyPlus.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import me.jartype.EconomyPlus.commands.statsCommand;

import java.io.File;
import java.io.IOException;

public class ClickEvent implements Listener {

    private final EconomyPlusMain plugin;

    public ClickEvent(EconomyPlusMain plugin) {
        this.plugin = plugin;
    }


    @EventHandler
    public void clickEvent(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Crystal Shop")) {
            switch (e.getCurrentItem().getType()) {
                case DIAMOND_SWORD:
                    player.closeInventory();
                    e.setCancelled(true);
                    player.performCommand("stats");
                    break;

                case BARRIER:
                case BLACK_STAINED_GLASS_PANE:
                    e.setCancelled(true);
                    break;
                // add more cases as needed
            }
        }





















        File configFile = new File(plugin.getDataFolder(), "config.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(configFile);

        CurrencyManager manager = new CurrencyManager(plugin);






        //STATS VYLEPSOVANI / CLICK EVENTY NA ITEMY +



        if (e.getView().getTitle().equalsIgnoreCase(ChatColor.LIGHT_PURPLE + "Stats Upgrades")) {
            switch (e.getCurrentItem().getType()) {
                case DIAMOND_SWORD:
                    e.setCancelled(true);
                    if (manager.getPlayerCurrency(player) >= 10) {
                        manager.removeCurrencyFromPlayer(player, 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your strength"));


                        String playerName = player.getName();
                        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
                        if (config.contains("players." + formattedPlayerName + ".effects.strength")) {
                            int strengthLevel = config.getInt("players." + formattedPlayerName + ".effects.strength");
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000 * 999999, strengthLevel, false));
                        }





                        // update strength level in config
                        int strengthLevel = 0;
                        if (config.contains("players." + formattedPlayerName + ".effects.strength")) {
                            strengthLevel = config.getInt("players." + formattedPlayerName + ".effects.strength");
                        }
                        config.set("players." + formattedPlayerName + ".effects.strength", strengthLevel + 1);
                        plugin.updatePlayerStrength(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }
                    break;

                case BARRIER:
                    e.setCancelled(true);
                    player.closeInventory();
                    player.performCommand("crystals");
                    break;




                case IRON_CHESTPLATE:
                    e.setCancelled(true);
                    if (manager.getPlayerCurrency(player) >= 10) {
                        manager.removeCurrencyFromPlayer(player, 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your defence"));


                        String playerName = player.getName();
                        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
                        if (config.contains("players." + formattedPlayerName + ".effects.defence")) {
                            int defenceLevel = config.getInt("players." + formattedPlayerName + ".effects.defence");
                            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000 * 999999, defenceLevel, false));
                        }



                        // update defence level in config
                        int defenceLevel = 0;
                        if (config.contains("players." + formattedPlayerName + ".effects.defence")) {
                            defenceLevel = config.getInt("players." + formattedPlayerName + ".effects.defence");
                        }
                        config.set("players." + formattedPlayerName + ".effects.defence", defenceLevel + 1);
                        plugin.updatePlayerDefence(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }
                    break;





                case BLACK_STAINED_GLASS_PANE:
                    e.setCancelled(true);
                    break;


                case GOLDEN_APPLE:
                    e.setCancelled(true);
                    break;


                case FEATHER:
                    e.setCancelled(true);
                    break;


                case POTION:
                    e.setCancelled(true);
                    break;


                case LEATHER_BOOTS:
                    e.setCancelled(true);
                    break;


                case GOLDEN_PICKAXE:
                    e.setCancelled(true);
                    break;


                case GOLDEN_CARROT:
                    e.setCancelled(true);
                    break;
            }
        }
    }
}
