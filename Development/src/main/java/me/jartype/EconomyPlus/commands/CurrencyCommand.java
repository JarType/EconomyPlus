package me.jartype.EconomyPlus.commands;

import me.jartype.EconomyPlus.EconomyPlusMain;
import me.jartype.EconomyPlus.managers.CurrencyManager;
import me.jartype.EconomyPlus.utils.Utils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CurrencyCommand implements CommandExecutor {
     public EconomyPlusMain plugin;

     public CurrencyCommand(EconomyPlusMain plugin) {
         this.plugin = plugin;

         plugin.getCommand("crystal").setExecutor(this);
     }

     @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

         if (sender.hasPermission("currencymanager.use")) {
             if (args.length == 0) {
                 sender.sendMessage(Utils.chat("&e/crystal <add:remove:set:bal> <player> <amount>"));
                 return true;
             } else if (args.length == 1) {
                 if (args[0].equalsIgnoreCase("add")){
                     sender.sendMessage(Utils.chat("&e/crystal add <player> <amount>"));
                 } else if (args[0].equalsIgnoreCase("remove")){
                     sender.sendMessage(Utils.chat("&e/crystal remove <player> <amount>"));
                 } else if (args[0].equalsIgnoreCase("set")){
                     sender.sendMessage(Utils.chat("&e/crystal set <player> <amount>"));
                 } else if (args[0].equalsIgnoreCase("bal")){
                     sender.sendMessage(Utils.chat("&e/crystal bal <player>"));
                 } else {
                     sender.sendMessage(Utils.chat("&e/crystal <add:remove:set:bal> <player> <amount>"));
                 }
             } else if (args.length == 2) {
                 CurrencyManager manager = new CurrencyManager(plugin);
                 @SuppressWarnings("deprecation")
                 OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);

                 if (p != null || p.hasPlayedBefore()) {
                     if (args[0].equalsIgnoreCase("bal")){
                       sender.sendMessage(Utils.chat("&b&l" + p.getName() + " has &f&l" + manager.getPlayerCurrency(p) + " &d&lCrystal's"));
                       return true;
                     } else {
                         sender.sendMessage(Utils.chat("&e/crystal <add:remove:set:bal> " + p.getName() + " <amount>"));
                     }
                 } else {
                     sender.sendMessage(Utils.chat("&eCouldnt find" + args[1]));
                 }
             } else if (args.length == 3){
                 OfflinePlayer p = Bukkit.getOfflinePlayer(args[1]);
                 int amount = Integer.parseInt(args[2]);
                 CurrencyManager manager = new CurrencyManager(plugin);
                 if (args[0].equalsIgnoreCase("add")){
                     if (p != null || p.hasPlayedBefore()) {
                         manager.addCurrencyToPlayer(p, amount);
                         if (manager.getPlayerCurrency(p) < 0) {
                             manager.setPlayerCurrency(p, 0);
                         }
                         sender.sendMessage(Utils.chat("&a&lYou added &f&l" + args[2] + " &d&lCrystal's" + "&a&l to " + p.getName()));
                     } else {
                         sender.sendMessage(Utils.chat("&eCouldnt find " + args[1]));
                     }
                 } else if (args[0].equalsIgnoreCase("remove")){
                     if (p != null || p.hasPlayedBefore()) {
                         manager.removeCurrencyFromPlayer(p, amount);
                         if (manager.getPlayerCurrency(p) < 0) {
                             manager.setPlayerCurrency(p, 0);
                         }
                         sender.sendMessage(Utils.chat("&c&lYou removed &f&l" + args[2] + "&d&lCrystal's &c&l from " + p.getName()));
                     } else {
                         sender.sendMessage(Utils.chat("&eCouldnt find " + args[1]));
                     }
                 } else if (args[0].equalsIgnoreCase("set")){
                     if (p != null || p.hasPlayedBefore()) {
                         manager.setPlayerCurrency(p, amount);
                         if (manager.getPlayerCurrency(p) < 0) {
                             manager.setPlayerCurrency(p, 0);
                         }
                         sender.sendMessage(Utils.chat("&b&lYou set " + p.getName() + "'s &d&lCrystal's &b&lto &f&l" + args[2]));
                     } else {
                         sender.sendMessage(Utils.chat("&eCouldnt find " + args[1]));
                     }

                 } else {
                     sender.sendMessage(Utils.chat("&e/crystal <add:remove:set:bal> <player> <amount>"));
                 }
                 // run the code
             } else if (args.length > 3) {
                 sender.sendMessage(Utils.chat("&e/crystal <add:remove:set:bal> <player> <amount>"));
             }
         } else {
             sender.sendMessage(Utils.chat("&cYou dont have permission to execute this command"));
         }
         return false;
     }
}
