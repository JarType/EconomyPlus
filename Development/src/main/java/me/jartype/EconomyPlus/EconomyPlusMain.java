package me.jartype.EconomyPlus;

import me.jartype.EconomyPlus.commands.*;
import me.jartype.EconomyPlus.events.ClickEvent;
import me.jartype.EconomyPlus.events.CrystalClick;
import me.jartype.EconomyPlus.listeners.JoinLeaveMessages;
import me.jartype.EconomyPlus.listeners.MobKills;
import me.jartype.EconomyPlus.managers.CurrencyManager;

import me.jartype.EconomyPlus.utils.Scoreboard;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class EconomyPlusMain extends JavaPlugin implements Listener {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        new Scoreboard(this);

        try {
            File file = new File(getDataFolder(), "config.yml");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            File file = new File(getDataFolder(), "data.yml");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        CurrencyManager currencyManager = new CurrencyManager(this);
        try {
            File CurrencyFile = new File(getDataFolder(), "currency.dat");
            if (!CurrencyFile.exists()) {
                CurrencyFile.createNewFile();
            }
            currencyManager.loadCurrencyFile();
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        registerManagers();
        registerCommands();
        registerListeners();

        getServer().getPluginManager().registerEvents(new MobKills(), this);
        getServer().getPluginManager().registerEvents(new JoinLeaveMessages(), this);
        getServer().getPluginManager().registerEvents(new CrystalClick(), this);

        getCommand("crystals").setExecutor(new GUICommand());
        getServer().getPluginManager().registerEvents(new ClickEvent(this), this);
        getCommand("stats").setExecutor(new statsCommand());

        //config.yml
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Načtení konfigurace
        this.config = getConfig();
        getServer().getPluginManager().registerEvents(this, this);




    }









    @Override
    public void onDisable() {
        CurrencyManager currencyManager = new CurrencyManager(this);
        try {
            currencyManager.saveCurrencyFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Uložení konfigurace
        saveConfig();
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        ConfigurationSection players = config.getConfigurationSection("players");
        if (players == null) {
            players = config.createSection("players");
        }

        String playerName = event.getPlayer().getName();
        if (!players.contains(playerName)) {
            players.set(playerName, true);
            // Vytvoření základu pro "effects"
            ConfigurationSection effects = players.createSection(playerName + ".effects");
            effects.set("strength", 0);
            effects.set("defence", 0);
            effects.set("health", 0);
            effects.set("speed", 0);
            effects.set("regeneration", 0);
            effects.set("jump", 0);
            effects.set("mining", 0);
            effects.set("saturation", 0);

            saveConfig();
        }
    }

    public void updatePlayerStrength(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int strengthLevel = config.getInt("players." + formattedPlayerName + ".effects.strength");
        config.set("players." + formattedPlayerName + ".effects.strength", strengthLevel + 1);
        saveConfig();
    }


    public void updatePlayerDefence(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int defenceLevel = config.getInt("players." + formattedPlayerName + ".effects.defence");
        config.set("players." + formattedPlayerName + ".effects.defence", defenceLevel + 1);
        saveConfig();
    }







    public void registerManagers() {
        new CurrencyManager(this);
    }

    public void registerCommands() {
        new Message(this);
        new CurrencyCommand(this);
        new SetWarpCommand(this);
        new WarpCommand(this);
        new DelWarpCommand(this);
        new FlyCommand(this);
    }

    public void registerListeners() {

    }

}
