package me.jartype.EconomyPlus;

import me.jartype.EconomyPlus.commands.*;
import me.jartype.EconomyPlus.events.ClickEvent;
import me.jartype.EconomyPlus.events.CrystalClick;
import me.jartype.EconomyPlus.listeners.AdminGUI.AdminGUIListener;
import me.jartype.EconomyPlus.listeners.JoinLeaveMessages;
import me.jartype.EconomyPlus.listeners.MobKills;
import me.jartype.EconomyPlus.managers.CurrencyManager;

import java.util.Timer;
import java.util.TimerTask;
import me.jartype.EconomyPlus.utils.Scoreboard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

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
        getServer().getPluginManager().registerEvents(new AdminGUIListener(this), this);


        //stats
        getServer().getPluginManager().registerEvents(new ClickEvent(this), this);


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

        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000 * 999999, strengthLevel, false, false));
    }


    public void updatePlayerDefence(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int defenceLevel = config.getInt("players." + formattedPlayerName + ".effects.defence");
        config.set("players." + formattedPlayerName + ".effects.defence", defenceLevel + 1);
        saveConfig();

        player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000 * 999999, defenceLevel, false, false));
    }


    public void updatePlayerRegeneration(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int regenerationLevel = config.getInt("players." + formattedPlayerName + ".effects.regeneration");
        config.set("players." + formattedPlayerName + ".effects.regeneration", regenerationLevel + 1);
        saveConfig();

        player.removePotionEffect(PotionEffectType.REGENERATION);
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000 * 999999, regenerationLevel, false, false));

    }

    public void updatePlayerHealth(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int healthLevel = config.getInt("players." + formattedPlayerName + ".effects.health");
        config.set("players." + formattedPlayerName + ".effects.health", healthLevel + 1);
        saveConfig();

        player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000 * 999999, healthLevel, false, false));

    }

    public void updatePlayerSpeed(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int speedLevel = config.getInt("players." + formattedPlayerName + ".effects.speed");
        config.set("players." + formattedPlayerName + ".effects.speed", speedLevel + 1);
        saveConfig();

        player.removePotionEffect(PotionEffectType.SPEED);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000 * 999999, speedLevel, false, false));
    }

    public void updatePlayerJump(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int jumpLevel = config.getInt("players." + formattedPlayerName + ".effects.jump");
        config.set("players." + formattedPlayerName + ".effects.jump", jumpLevel + 1);
        saveConfig();

        player.removePotionEffect(PotionEffectType.JUMP);
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000 * 999999, jumpLevel, false, false));
    }

    public void updatePlayerMining(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int miningLevel = config.getInt("players." + formattedPlayerName + ".effects.mining");
        config.set("players." + formattedPlayerName + ".effects.mining", miningLevel + 1);
        saveConfig();

        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1000 * 999999, miningLevel, false, false));
    }

    public void updatePlayerSaturation(Player player) {
        String playerName = player.getName();
        String formattedPlayerName = playerName.replace("CraftPlayer{name=", "").replace("}", "");
        int saturationLevel = config.getInt("players." + formattedPlayerName + ".effects.saturation");
        config.set("players." + formattedPlayerName + ".effects.saturation", saturationLevel + 1);
        saveConfig();

        player.removePotionEffect(PotionEffectType.SATURATION);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1000 * 999999, saturationLevel, false, false));
    }


    //updaty effectu pouze

    public void updateEffectStrength(Player player) {

        String playerName = player.getName();

        int strengthLevel = config.getInt("players." + playerName + ".effects.strength");

        player.removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1000 * 999999, strengthLevel, false, false));

    }

    public void updateEffectDefence(Player player) {

        String playerName = player.getName();
        int defenceLevel = config.getInt("players." + playerName + ".effects.defence");


        player.removePotionEffect(PotionEffectType.DAMAGE_RESISTANCE);
        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000 * 999999, defenceLevel, false, false));
    }

    public void updateEffectHealth(Player player) {

        String playerName = player.getName();
        int healthLevel = config.getInt("players." + playerName + ".effects.health");

        player.removePotionEffect(PotionEffectType.HEALTH_BOOST);
        player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 1000 * 999999, healthLevel, false, false));



    }

    public void updateEffectSpeed(Player player) {

        String playerName = player.getName();
        int speedLevel = config.getInt("players." + playerName + ".effects.speed");

        player.removePotionEffect(PotionEffectType.SPEED);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 1000 * 999999, speedLevel, false, false));

    }

    public void updateEffectRegeneration(Player player) {

        String playerName = player.getName();
        int regenerationLevel = config.getInt("players." + playerName + ".effects.regeneration");

        player.removePotionEffect(PotionEffectType.REGENERATION);
        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1000 * 999999, regenerationLevel, false, false));


    }

    public void updateEffectJump(Player player) {

        String playerName = player.getName();
        int jumpLevel = config.getInt("players." + playerName + ".effects.jump");

        player.removePotionEffect(PotionEffectType.JUMP);
        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 1000 * 999999, jumpLevel, false, false));
    }

    public void updateEffectMining(Player player) {

        String playerName = player.getName();
        int miningLevel = config.getInt("players." + playerName + ".effects.mining");

        player.removePotionEffect(PotionEffectType.FAST_DIGGING);
        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 1000 * 999999, miningLevel, false, false));
    }

    public void updateEffectSaturation(Player player) {

        String playerName = player.getName();
        int saturationLevel = config.getInt("players." + playerName + ".effects.saturation");

        player.removePotionEffect(PotionEffectType.SATURATION);
        player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 1000 * 999999, saturationLevel, false, false));
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
        new adminGUICommand(this);
        new StatsConfiguration(this);
        new statsCommand(this);
        new CrystalsCommand(this);
    }

    public void registerListeners() {

     }

    public class PlayerEffectsUpdater {
        private Player player; // assuming you have a Player class

        public PlayerEffectsUpdater(Player player) {
            this.player = player;
            startEffectsUpdater();
        }

        private void startEffectsUpdater() {
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    updateEffects();
                }
            }, 0, 3000); // updates every 15 seconds
        }

        private void updateEffects() {
            updateEffectHealth(player);
            updateEffectDefence(player);
            updateEffectSpeed(player);
            updateEffectRegeneration(player);
            updateEffectJump(player);
            updateEffectMining(player);
            updateEffectSaturation(player);
        }}




























    //Veci s adminGUI
    public void openMainAdminGUI(Player p){
        ArrayList<Player> list = new ArrayList<>(p.getServer().getOnlinePlayers());
        Inventory adminGUI = Bukkit.createInventory(p, 45, ChatColor.translateAlternateColorCodes('&', "&a&lPlayer List"));

        for (int i = 0; i < list.size(); i++) {
            ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
            ItemMeta meta = playerHead.getItemMeta();

            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + list.get(i).getDisplayName()));
            ArrayList<String> lore = new ArrayList<>();
            lore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + list.get(i).getHealth()));
            lore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + list.get(i).getExp());
            meta.setLore(lore);
            playerHead.setItemMeta(meta);

            adminGUI.addItem(playerHead);
        }



        for (int members = list.size();members < 45; members++){
            ItemStack empty = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
            ItemMeta emptyMeta = empty.getItemMeta();

            emptyMeta.setDisplayName(ChatColor.BLACK+".");
            empty.setItemMeta(emptyMeta);

            adminGUI.setItem(members, empty);
        }
        p.openInventory(adminGUI);
    }





    //Veci s adminGUI

}
