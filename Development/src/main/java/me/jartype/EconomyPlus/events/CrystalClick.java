package me.jartype.EconomyPlus.events;


import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import me.jartype.EconomyPlus.EconomyPlusMain;
import me.jartype.EconomyPlus.managers.CurrencyManager;
import org.bukkit.ChatColor;

public class CrystalClick implements Listener {


    public EconomyPlusMain plugin;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        ItemStack item = event.getItem();
        CurrencyManager manager = new CurrencyManager(plugin);
        int amountClicked = event.getItem().getAmount();

        if (item != null && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&d&lCrystal"))) {
                // The item has the correct display name
                // Add your code here
                manager.addCurrencyToPlayer(player, amountClicked);
                player.getInventory().removeItem(item);

                if (amountClicked == 1) {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou redeemed "+"&f&l" + amountClicked + " &d&lCrystal"));
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lYou redeemed "+"&f&l" + amountClicked + " &d&lCrystal's"));
                }

            }
        }
    }};
