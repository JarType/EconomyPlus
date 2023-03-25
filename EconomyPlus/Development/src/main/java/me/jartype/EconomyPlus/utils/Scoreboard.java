package me.jartype.EconomyPlus.utils;

import fr.mrmicky.fastboard.FastBoard;
import me.jartype.EconomyPlus.EconomyPlusMain;
import me.jartype.EconomyPlus.managers.CurrencyManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Scoreboard implements Listener {
    private final Map<UUID, FastBoard> boards = new HashMap<>();
    private final Map<UUID, String> playerNames = new HashMap<>();

    public Scoreboard(EconomyPlusMain plugin) {
        CurrencyManager manager = new CurrencyManager(plugin);
        Bukkit.getPluginManager().registerEvents(this, plugin);

        plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, () -> {
            for (Map.Entry<UUID, FastBoard> entry : boards.entrySet()) {
                UUID playerId = entry.getKey();
                FastBoard board = entry.getValue();
                String playerName = playerNames.get(playerId);
                if (playerName == null) {
                    // Player name not found, skip this board
                    continue;
                }
                updateBoard(board,
                        "",
                        "&b&lOnline:",
                        "&f&l" + Bukkit.getOnlinePlayers().size(),
                        "",
                        "&d&lCrystals:",
                        "&f&l" + manager.getPlayerCurrency(Bukkit.getPlayer(playerId)));
            }
        }, 0L, 10L);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FastBoard board = new FastBoard(player);

        String title = "&a&lEconomy&f&lPlus";
        board.updateTitle(ChatColor.translateAlternateColorCodes('&', title));

        boards.put(player.getUniqueId(), board);
        playerNames.put(player.getUniqueId(), player.getName());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        UUID playerId = player.getUniqueId();
        FastBoard board = boards.remove(playerId);
        playerNames.remove(playerId);

        if (board != null) {
            board.delete();
        }
    }

    private void updateBoard(FastBoard board, String ... lines) {
        for (int a = 0; a < lines.length; ++a) {
            lines[a] = ChatColor.translateAlternateColorCodes('&', lines[a]);
        }

        board.updateLines(lines);
    }
}

