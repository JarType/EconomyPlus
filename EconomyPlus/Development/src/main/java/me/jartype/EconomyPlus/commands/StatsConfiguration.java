package me.jartype.EconomyPlus.commands;

import me.jartype.EconomyPlus.EconomyPlusMain;
import me.jartype.EconomyPlus.utils.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;


public class StatsConfiguration implements CommandExecutor {


    private final EconomyPlusMain plugin;

    public StatsConfiguration(EconomyPlusMain plugin) {
        this.plugin = plugin;

        plugin.getCommand("config").setExecutor(this);
    }

    private FileConfiguration config;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        config = plugin.getConfig();
        File configFile = new File(plugin.getDataFolder(), "config.yml");

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                sender.sendMessage(Utils.chat("&e/config &c<stats> <type> <amount>"));
                return true;
            } else if (args.length == 1) {
                if (args[0].equalsIgnoreCase("stats")) {
                    sender.sendMessage(Utils.chat("&e/config stats &c<type> <amount>"));
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("strength")) {
                    sender.sendMessage(Utils.chat("&e/config stats strength &c<amount>"));
                }
            } else if (args.length == 3) {
                if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("strength")) {
                    int amount = Integer.parseInt(args[2]);

                    String playerName = player.getName();

                    if (config.contains("players." + playerName + ".effects.strength")) {
                        config.set("players." + playerName + ".effects.strength", amount);

                        sender.sendMessage(Utils.chat("&a&l" + playerName + ", &b&lstrength was set to level " + amount));
                        plugin.updateEffectStrength(player);

                        try {
                            config.save(configFile);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cThis player does not exist!"));
                    }
                } else if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("defence")) {
                    int amount = Integer.parseInt(args[2]);

                    String playerName = player.getName();

                    if (config.contains("players." + playerName + ".effects.defence")) {
                        config.set("players." + playerName + ".effects.defence", amount);

                        sender.sendMessage(Utils.chat("&a&l" + playerName + ", &b&ldefence was set to level " + amount));
                        plugin.updateEffectDefence(player);

                        try {
                            config.save(configFile);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cThis player does not exist!"));
                    }
                } else if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("health")) {
                    int amount = Integer.parseInt(args[2]);

                    String playerName = player.getName();

                    if (config.contains("players." + playerName + ".effects.health")) {
                        config.set("players." + playerName + ".effects.health", amount);

                        sender.sendMessage(Utils.chat("&a&l" + playerName + ", &b&lhealth was set to level " + amount));
                        plugin.updateEffectHealth(player);

                        try {
                            config.save(configFile);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cThis player does not exist!"));
                    }
                } else if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("speed")) {
                    int amount = Integer.parseInt(args[2]);

                    String playerName = player.getName();

                    if (config.contains("players." + playerName + ".effects.speed")) {
                        config.set("players." + playerName + ".effects.speed", amount);

                        sender.sendMessage(Utils.chat("&a&l" + playerName + ", &b&lspeed was set to level " + amount));
                        plugin.updateEffectSpeed(player);

                        try {
                            config.save(configFile);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cThis player does not exist!"));
                    }
                } else if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("regeneration")) {
                    int amount = Integer.parseInt(args[2]);

                    String playerName = player.getName();

                    if (config.contains("players." + playerName + ".effects.regeneration")) {
                        config.set("players." + playerName + ".effects.regeneration", amount);

                        sender.sendMessage(Utils.chat("&a&l" + playerName + ", &b&lregeneration was set to level " + amount));
                        plugin.updateEffectRegeneration(player);

                        try {
                            config.save(configFile);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cThis player does not exist!"));
                    }
                } else if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("jump")) {
                    int amount = Integer.parseInt(args[2]);

                    String playerName = player.getName();

                    if (config.contains("players." + playerName + ".effects.jump")) {
                        config.set("players." + playerName + ".effects.jump", amount);

                        sender.sendMessage(Utils.chat("&a&l" + playerName + ", &b&ljump was set to level " + amount));
                        plugin.updateEffectJump(player);

                        try {
                            config.save(configFile);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cThis player does not exist!"));
                    }
                } else if (args[0].equalsIgnoreCase("stats") && args[1].equalsIgnoreCase("mining")) {
                    int amount = Integer.parseInt(args[2]);

                    String playerName = player.getName();

                    if (config.contains("players." + playerName + ".effects.mining")) {
                        config.set("players." + playerName + ".effects.mining", amount);

                        sender.sendMessage(Utils.chat("&a&l" + playerName + ", &b&lmining was set to level " + amount));
                        plugin.updateEffectMining(player);

                        try {
                            config.save(configFile);
                        } catch(IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(Utils.chat("&cThis player does not exist!"));
                    }
                }
                }
            }
        return true;
        }

    }

