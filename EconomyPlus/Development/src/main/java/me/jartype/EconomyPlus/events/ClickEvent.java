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
            String playerName = player.getName();
            String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
            switch (e.getCurrentItem().getType()) {
                case DIAMOND_SWORD:

                    int strengthLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.strength")) {
                        strengthLevel = config.getInt("players." + formattedPlayerName + ".effects.strength");
                    }



                    if (strengthLevel < 10) {
                    e.setCancelled(true);
                    if (manager.getPlayerCurrency(player) >= strengthLevel * 10) {
                        manager.removeCurrencyFromPlayer(player, strengthLevel * 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your strength"));




                        if (config.contains("players." + formattedPlayerName + ".effects.strength")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000 * 999999, strengthLevel, false, false));
                        }





                        // update strength level in config
                        if (config.contains("players." + formattedPlayerName + ".effects.strength")) {
                            strengthLevel = config.getInt("players." + formattedPlayerName + ".effects.strength");
                        }
                        config.set("players." + formattedPlayerName + ".effects.strength", strengthLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerStrength(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }


                    break;

                case BARRIER:
                    e.setCancelled(true);
                    player.closeInventory();
                    player.performCommand("crystals");
                    break;




                case IRON_CHESTPLATE:


                    int defenceLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.defence")) {
                        defenceLevel = config.getInt("players." + formattedPlayerName + ".effects.defence");
                    }



                    if (defenceLevel < 10) {
                    e.setCancelled(true);
                    if (manager.getPlayerCurrency(player) >= defenceLevel * 10) {
                        manager.removeCurrencyFromPlayer(player,defenceLevel * 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your defence"));




                        if (config.contains("players." + formattedPlayerName + ".effects.defence")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000 * 999999, defenceLevel, false, false));
                        }



                        // update defence level in config
                        if (config.contains("players." + formattedPlayerName + ".effects.defence")) {
                            defenceLevel = config.getInt("players." + formattedPlayerName + ".effects.defence");
                        }
                        config.set("players." + formattedPlayerName + ".effects.defence", defenceLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerDefence(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }

                    break;





                case BLACK_STAINED_GLASS_PANE:
                    e.setCancelled(true);
                    break;


                case GOLDEN_APPLE:

                    int healthLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.health")) {
                        healthLevel = config.getInt("players." + formattedPlayerName + ".effects.health");
                    }



                    if (healthLevel < 10) {
                    e.setCancelled(true);
                    if (manager.getPlayerCurrency(player) >= healthLevel * 10) {
                        manager.removeCurrencyFromPlayer(player, healthLevel * 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your health"));



                        if (config.contains("players." + formattedPlayerName + ".effects.health")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000 * 999999, healthLevel, false, false));
                        }



                        // update defence level in config
                        if (config.contains("players." + formattedPlayerName + ".effects.health")) {
                            healthLevel = config.getInt("players." + formattedPlayerName + ".effects.health");
                        }
                        config.set("players." + formattedPlayerName + ".effects.health", healthLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerHealth(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }

                    break;


                case FEATHER:

                    int speedLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.speed")) {
                        speedLevel = config.getInt("players." + formattedPlayerName + ".effects.speed");
                    }



                    if (speedLevel < 10) {
                    e.setCancelled(true);
                    if (manager.getPlayerCurrency(player) >= speedLevel * 10) {
                        manager.removeCurrencyFromPlayer(player, speedLevel * 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your speed"));



                        if (config.contains("players." + formattedPlayerName + ".effects.speed")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000 * 999999, speedLevel, false, false));
                        }



                        // update defence level in config
                        if (config.contains("players." + formattedPlayerName + ".effects.speed")) {
                            speedLevel = config.getInt("players." + formattedPlayerName + ".effects.speed");
                        }
                        config.set("players." + formattedPlayerName + ".effects.speed", speedLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerSpeed(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }

                    break;


                case POTION:

                    int regenerationLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.regeneration")) {

                        regenerationLevel = config.getInt("players." + formattedPlayerName + ".effects.regeneration");
                    }


                    e.setCancelled(true);


                    if (regenerationLevel < 10) {
                    if (manager.getPlayerCurrency(player) >= regenerationLevel * 10) {
                        manager.removeCurrencyFromPlayer(player, regenerationLevel * 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your regeneration."));


                        if (config.contains("players." + formattedPlayerName + ".effects.regeneration")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000 * 999999, regenerationLevel, false, false));
                        }



                        // update defence level in config
                        if (config.contains("players." + formattedPlayerName + ".effects.regeneration")) {
                            regenerationLevel = config.getInt("players." + formattedPlayerName + ".effects.regeneration");
                        }
                        config.set("players." + formattedPlayerName + ".effects.regeneration", regenerationLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerRegeneration(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }

                    break;


                case LEATHER_BOOTS:
                    e.setCancelled(true);

                    int jumpLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.jump")) {
                        jumpLevel = config.getInt("players." + formattedPlayerName + ".effects.jump");
                    }


                    if (jumpLevel < 5) {
                    if (manager.getPlayerCurrency(player) >= jumpLevel * 10) {
                        manager.removeCurrencyFromPlayer(player, jumpLevel * 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your jump."));


                        if (config.contains("players." + formattedPlayerName + ".effects.jump")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000 * 999999, jumpLevel, false, false));
                        }



                        // update defence level in config
                        config.set("players." + formattedPlayerName + ".effects.jump", jumpLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerJump(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }

                    break;


                case GOLDEN_PICKAXE:
                    e.setCancelled(true);

                    int miningLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.mining")) {
                        miningLevel = config.getInt("players." + formattedPlayerName + ".effects.mining");
                    }


                    if (miningLevel < 10) {
                    if (manager.getPlayerCurrency(player) >= miningLevel * 10) {
                        manager.removeCurrencyFromPlayer(player, miningLevel * 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your mining."));


                        if (config.contains("players." + formattedPlayerName + ".effects.mining")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1000 * 999999, miningLevel, false, false));
                        }



                        // update defence level in config
                        config.set("players." + formattedPlayerName + ".effects.mining", miningLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerMining(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }

                    break;


                case GOLDEN_CARROT:
                    e.setCancelled(true);

                    int saturationLevel = 0;
                    if (config.contains("players." + formattedPlayerName + ".effects.saturation")) {
                        saturationLevel = config.getInt("players." + formattedPlayerName + ".effects.saturation");
                    }


                    if (saturationLevel < 1) {
                    if (manager.getPlayerCurrency(player) >= 10) {
                        manager.removeCurrencyFromPlayer(player, 10);
                        player.sendMessage(Utils.chat("&a&lYou upgraded your saturation."));


                        if (config.contains("players." + formattedPlayerName + ".effects.saturation")) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1000 * 999999, saturationLevel, false, false));
                        }



                        // update defence level in config
                        config.set("players." + formattedPlayerName + ".effects.saturation", saturationLevel + 1);
                        player.closeInventory();
                        player.performCommand("stats");
                        plugin.updatePlayerSaturation(player);
                        plugin.saveConfig();
                        try {
                            config.save(configFile);
                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    } else {
                        player.sendMessage(Utils.chat("&c&lYou don't have enough crystals."));
                    }} else {
                        player.sendMessage(Utils.chat("&cYou have maxed this stat."));
                        e.setCancelled(true);
                    }

                    break;


                case QUARTZ:
                    e.setCancelled(true);
            }
        }
    }
}
