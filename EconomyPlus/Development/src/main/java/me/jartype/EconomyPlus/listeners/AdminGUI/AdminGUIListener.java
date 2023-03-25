package me.jartype.EconomyPlus.listeners.AdminGUI;

import me.jartype.EconomyPlus.EconomyPlusMain;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.sql.Time;
import java.util.ArrayList;

public class AdminGUIListener implements Listener {

    private final EconomyPlusMain plugin;

    public AdminGUIListener(EconomyPlusMain plugin) {
        this.plugin = plugin;
    }


    String reason;
    Integer duration;

    @EventHandler
    public void onMenuClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();


        try {
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lPlayer List"))) {

                if (e.getCurrentItem().getType() == Material.PLAYER_HEAD) {
                    Player whoToBan = p.getServer().getPlayerExact(ChatColor.stripColor(e.getCurrentItem().getItemMeta().getDisplayName()));


                    if (whoToBan == null) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cThis player is offline"));
                        e.setCancelled(true);
                    } else {

                        Inventory Options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lOptions"));

                        int exp = (int) whoToBan.getExp();
                        int hp = (int) whoToBan.getHealth();


                        // empty
                        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                        ItemMeta emptyMeta = air.getItemMeta();

                        emptyMeta.setDisplayName(ChatColor.BLACK + ".");
                        air.setItemMeta(emptyMeta);
                        // empty

// item 1
                        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                        ItemMeta playerHeadmeta = playerHead.getItemMeta();

                        playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan.getDisplayName()));
                        ArrayList<String> playerHeadlore = new ArrayList<>();
                        playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp));
                        playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp);
                        playerHeadmeta.setLore(playerHeadlore);
                        playerHead.setItemMeta(playerHeadmeta);
                        // item 1

                        // item 2
                        ItemStack ban = new ItemStack(Material.BARRIER, 1);
                        ItemMeta banMeta = ban.getItemMeta();

                        banMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBan"));
                        ban.setItemMeta(banMeta);
                        // item 2

                        // item 3
                        ItemStack kick = new ItemStack(Material.WOODEN_AXE, 1);
                        ItemMeta kickMeta = kick.getItemMeta();

                        kickMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lKick"));
                        kick.setItemMeta(kickMeta);
                        // item 3

                        // item 4
                        ItemStack mute = new ItemStack(Material.LIGHT_GRAY_CONCRETE, 1);
                        ItemMeta muteMeta = mute.getItemMeta();

                        muteMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lMute"));
                        mute.setItemMeta(muteMeta);
                        // item 4

                        // back button
                        ItemStack back = new ItemStack(Material.STONE_BUTTON, 1);
                        ItemMeta backMeta = back.getItemMeta();

                        backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                        back.setItemMeta(backMeta);
                        // back button


                        ItemStack[] menu_items = {
                                playerHead, air, air, air, air, air, air, air, air,
                                air, air, air, ban, kick, mute, air, air, air,
                                back, air, air, air, air, air, air, air, air,};
                        Options.setContents(menu_items);
                        e.setCancelled(true);
                        p.openInventory(Options);
                    }

                } else {
                    e.setCancelled(true);
                }

            }


            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lOptions"))) {


                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&7&lMute"))) {
                    //Mute
                    p.sendMessage(ChatColor.RED + "This command doesnt currently work.");
                    e.setCancelled(true);

                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&c&lKick"))) {
                    //kick
                    Inventory Kick_options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lKick menu"));

                    //item 1
                    String name2 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                    Player whoToBan2 = Bukkit.getPlayerExact(name2);
                    int exp2 = (int) whoToBan2.getExp();
                    int hp2 = (int) whoToBan2.getHealth();
                    ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                    ItemMeta playerHeadmeta = playerHead.getItemMeta();

                    playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan2.getDisplayName()));
                    ArrayList<String> playerHeadlore = new ArrayList<>();
                    playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp2));
                    playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp2);
                    playerHeadmeta.setLore(playerHeadlore);
                    playerHead.setItemMeta(playerHeadmeta);
                    //item 1

                    //item 2
                    ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                    ItemMeta airMeta = air.getItemMeta();

                    airMeta.setDisplayName(ChatColor.BLACK + ".");
                    air.setItemMeta(airMeta);
                    //item 2

                    //item 3
                    ItemStack paper = new ItemStack(Material.PAPER, 1);
                    ItemMeta paperMeta = paper.getItemMeta();

                    paperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lReason"));
                    paper.setItemMeta(paperMeta);
                    //item 3

                    //item 4
                    ItemStack back = new ItemStack(Material.STONE_BUTTON);
                    ItemMeta backMeta = back.getItemMeta();

                    backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                    back.setItemMeta(backMeta);
                    //item 4

                    ItemStack[] menu_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, air, air, paper, air, air, air, air,
                            back, air, air, air, air, air, air, air, air,};
                    Kick_options.setContents(menu_items);
                    p.openInventory(Kick_options);

                    e.setCancelled(true);
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&c&lBan"))) {
                    //ban

                    Inventory Ban_options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lBan menu"));

                    //item 1
                    String name6 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                    Player whoToBan6 = Bukkit.getPlayerExact(name6);
                    int exp6 = (int) whoToBan6.getExp();
                    int hp6 = (int) whoToBan6.getHealth();
                    ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                    ItemMeta playerHeadmeta = playerHead.getItemMeta();

                    playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan6.getDisplayName()));
                    ArrayList<String> playerHeadlore = new ArrayList<>();
                    playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp6));
                    playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp6);
                    playerHeadmeta.setLore(playerHeadlore);
                    playerHead.setItemMeta(playerHeadmeta);
                    //item 1

                    //item 2
                    ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                    ItemMeta airMeta = air.getItemMeta();

                    airMeta.setDisplayName(ChatColor.BLACK + ".");
                    air.setItemMeta(airMeta);
                    //item 2

                    //item 3
                    ItemStack paper = new ItemStack(Material.PAPER, 1);
                    ItemMeta paperMeta = paper.getItemMeta();

                    paperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lReason"));
                    paper.setItemMeta(paperMeta);
                    //item 3

                    //item 4
                    ItemStack clock = new ItemStack(Material.CLOCK);
                    ItemMeta clockMeta = clock.getItemMeta();

                    clockMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lDuration"));
                    clock.setItemMeta(clockMeta);
                    //item 4

                    //item 5
                    ItemStack back = new ItemStack(Material.STONE_BUTTON);
                    ItemMeta backMeta = back.getItemMeta();

                    backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                    back.setItemMeta(backMeta);
                    //item 5

                    ItemStack[] menu_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, air, paper, air, clock, air, air, air,
                            back, air, air, air, air, air, air, air, air,};
                    Ban_options.setContents(menu_items);
                    p.openInventory(Ban_options);
                    e.setCancelled(true);
                }

                if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&7&lBack"))) {
                    plugin.openMainAdminGUI(p);
                    e.setCancelled(true);
                } else {
                    e.setCancelled(true);
                }
            }














        /*
        B
        A
        N
         */

            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lBan menu"))) {
                switch (e.getCurrentItem().getType()) {
                    case STONE_BUTTON:


                        Inventory Options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lOptions"));


                        // empty
                        ItemStack air1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                        ItemMeta empty1Meta = air1.getItemMeta();

                        empty1Meta.setDisplayName(ChatColor.BLACK + ".");
                        air1.setItemMeta(empty1Meta);
                        // empty

                        // item 1
                        String name8 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                        Player whoToBan8 = Bukkit.getPlayerExact(name8);
                        int exp8 = (int) whoToBan8.getExp();
                        int hp8 = (int) whoToBan8.getHealth();
                        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                        ItemMeta playerHeadmeta = playerHead.getItemMeta();

                        playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan8.getDisplayName()));
                        ArrayList<String> playerHeadlore = new ArrayList<>();
                        playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp8));
                        playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp8);
                        playerHeadmeta.setLore(playerHeadlore);
                        playerHead.setItemMeta(playerHeadmeta);
                        // item 1

                        // item 2
                        ItemStack ban = new ItemStack(Material.BARRIER, 1);
                        ItemMeta banMeta = ban.getItemMeta();

                        banMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBan"));
                        ban.setItemMeta(banMeta);
                        // item 2

                        // item 3
                        ItemStack kick = new ItemStack(Material.WOODEN_AXE, 1);
                        ItemMeta kickMeta = kick.getItemMeta();

                        kickMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lKick"));
                        kick.setItemMeta(kickMeta);
                        // item 3

                        // item 4
                        ItemStack mute = new ItemStack(Material.LIGHT_GRAY_CONCRETE, 1);
                        ItemMeta muteMeta = mute.getItemMeta();

                        muteMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lMute"));
                        mute.setItemMeta(muteMeta);
                        // item 4

                        // back button
                        ItemStack back1 = new ItemStack(Material.STONE_BUTTON, 1);
                        ItemMeta back1Meta = back1.getItemMeta();

                        back1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                        back1.setItemMeta(back1Meta);
                        // back button


                        ItemStack[] menu_items = {
                                playerHead, air1, air1, air1, air1, air1, air1, air1, air1,
                                air1, air1, air1, ban, kick, mute, air1, air1, air1,
                                back1, air1, air1, air1, air1, air1, air1, air1, air1,};
                        Options.setContents(menu_items);
                        e.setCancelled(true);
                        p.openInventory(Options);
                        e.setCancelled(true);
                        break;
                    case PAPER:
                        Inventory banReasonMenu = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lBan reasons"));

                        //item 1
                        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                        ItemMeta airMeta = air.getItemMeta();

                        airMeta.setDisplayName(ChatColor.BLACK + ".");
                        air.setItemMeta(airMeta);
                        //item 1

                        //item 2
                        String name1 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                        Player whoToBan1 = Bukkit.getPlayerExact(name1);
                        int exp1 = (int) whoToBan1.getExp();
                        int hp1 = (int) whoToBan1.getHealth();
                        ItemStack playerHead8 = new ItemStack(Material.PLAYER_HEAD, 1);
                        ItemMeta playerHeadmeta8 = playerHead8.getItemMeta();

                        playerHeadmeta8.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan1.getDisplayName()));
                        ArrayList<String> playerHeadlore8 = new ArrayList<>();
                        playerHeadlore8.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp1));
                        playerHeadlore8.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp1);
                        playerHeadmeta8.setLore(playerHeadlore8);
                        playerHead8.setItemMeta(playerHeadmeta8);
                        //item 2

                        //item 3
                        ItemStack rule1 = new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER);
                        ItemMeta rule1Meta = rule1.getItemMeta();

                        rule1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lAnnoying"));
                        rule1.setItemMeta(rule1Meta);
                        //item 3

                        //item 4
                        ItemStack rule2 = new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER);
                        ItemMeta rule2Meta = rule1.getItemMeta();

                        rule2Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lSpamming"));
                        rule2.setItemMeta(rule2Meta);
                        //item 4

                        //item 5
                        ItemStack rule3 = new ItemStack(Material.BLUE_CONCRETE_POWDER);
                        ItemMeta rule3Meta = rule3.getItemMeta();

                        rule3Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lSwearing"));
                        rule3.setItemMeta(rule3Meta);
                        //item 5

                        //item 6
                        ItemStack rule4 = new ItemStack(Material.LIME_CONCRETE_POWDER);
                        ItemMeta rule4Meta = rule4.getItemMeta();

                        rule4Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lCharacter spam"));
                        rule4.setItemMeta(rule4Meta);
                        //item 6

                        //item 7
                        ItemStack rule5 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
                        ItemMeta rule5Meta = rule5.getItemMeta();

                        rule5Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&lDisrespecting a-team"));
                        rule5.setItemMeta(rule5Meta);
                        //item 7

                        //item 8
                        ItemStack rule6 = new ItemStack(Material.PINK_CONCRETE_POWDER);
                        ItemMeta rule6Meta = rule6.getItemMeta();

                        rule6Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lBug abusing"));
                        rule6.setItemMeta(rule6Meta);
                        //item 8

                        //item 9
                        ItemStack rule7 = new ItemStack(Material.MAGENTA_CONCRETE_POWDER);
                        ItemMeta rule7Meta = rule7.getItemMeta();

                        rule7Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lBreaking rules"));
                        rule7.setItemMeta(rule7Meta);
                        //item 9

                        //item 10
                        ItemStack rule8 = new ItemStack(Material.RED_CONCRETE_POWDER);
                        ItemMeta rule8Meta = rule8.getItemMeta();

                        rule8Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lDuping"));
                        rule8.setItemMeta(rule8Meta);
                        //item 10

                        //item 11
                        ItemStack rule9 = new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER);
                        ItemMeta rule9Meta = rule9.getItemMeta();

                        rule9Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lAnnoying"));
                        rule9.setItemMeta(rule9Meta);
                        //item 11

                        //item 12
                        ItemStack back = new ItemStack(Material.STONE_BUTTON);
                        ItemMeta backMeta = back.getItemMeta();

                        backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                        back.setItemMeta(backMeta);
                        //item 12

                        ItemStack[] menu_items1 = {
                                playerHead8, air, air, rule1, rule2, rule3, air, air, air,
                                air, air, air, rule4, rule5, rule6, air, air, air,
                                back, air, air, rule7, rule8, rule9, air, air, air,};
                        banReasonMenu.setContents(menu_items1);


                        p.openInventory(banReasonMenu);
                        e.setCancelled(true);
                        break;
                    case CLOCK:
                        Inventory Time = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lTime"));

                        //item 1
                        ItemStack air3 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                        ItemMeta airMeta3 = air3.getItemMeta();

                        airMeta3.setDisplayName(ChatColor.BLACK + ".");
                        air3.setItemMeta(airMeta3);
                        //item 1

                        //item 2
                        String name7 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                        Player whoToBan7 = Bukkit.getPlayerExact(name7);
                        int exp7 = (int) whoToBan7.getExp();
                        int hp7 = (int) whoToBan7.getHealth();
                        ItemStack playerHead7 = new ItemStack(Material.PLAYER_HEAD, 1);
                        ItemMeta playerHeadmeta7 = playerHead7.getItemMeta();

                        playerHeadmeta7.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan7.getDisplayName()));
                        ArrayList<String> playerHeadlore7 = new ArrayList<>();
                        playerHeadlore7.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp7));
                        playerHeadlore7.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp7);
                        playerHeadmeta7.setLore(playerHeadlore7);
                        playerHead7.setItemMeta(playerHeadmeta7);
                        //item 2

                        //item 3
                        ItemStack back5 = new ItemStack(Material.STONE_BUTTON);
                        ItemMeta backmeta5 = back5.getItemMeta();

                        backmeta5.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                        back5.setItemMeta(backmeta5);
                        //item 3



                        ItemStack duration1 = new ItemStack(Material.WHITE_CONCRETE);
                        ItemStack duration2 = new ItemStack(Material.LIME_CONCRETE);
                        ItemStack duration3 = new ItemStack(Material.LIGHT_BLUE_CONCRETE);
                        ItemStack duration4 = new ItemStack(Material.CYAN_CONCRETE);
                        ItemStack duration5 = new ItemStack(Material.ORANGE_CONCRETE);
                        ItemStack duration6 = new ItemStack(Material.PURPLE_CONCRETE);
                        ItemStack duration7 = new ItemStack(Material.BLUE_CONCRETE);
                        ItemStack duration8 = new ItemStack(Material.GRAY_CONCRETE);
                        ItemStack duration9 = new ItemStack(Material.BLACK_CONCRETE);

                        ItemMeta durationMeta1 = duration1.getItemMeta();
                        ItemMeta durationMeta2 = duration2.getItemMeta();
                        ItemMeta durationMeta3 = duration3.getItemMeta();
                        ItemMeta durationMeta4 = duration4.getItemMeta();
                        ItemMeta durationMeta5 = duration5.getItemMeta();
                        ItemMeta durationMeta6 = duration6.getItemMeta();
                        ItemMeta durationMeta7 = duration7.getItemMeta();
                        ItemMeta durationMeta8 = duration8.getItemMeta();
                        ItemMeta durationMeta9 = duration9.getItemMeta();

                        durationMeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l30min"));
                        durationMeta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l1h"));
                        durationMeta3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&l6h"));
                        durationMeta4.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&l1d"));
                        durationMeta5.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&l3d"));
                        durationMeta6.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&l7d"));
                        durationMeta7.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&l1m"));
                        durationMeta8.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&l3m"));
                        durationMeta9.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&0&lpermanent"));

                        duration1.setItemMeta(durationMeta1);
                        duration2.setItemMeta(durationMeta2);
                        duration3.setItemMeta(durationMeta3);
                        duration4.setItemMeta(durationMeta4);
                        duration5.setItemMeta(durationMeta5);
                        duration6.setItemMeta(durationMeta6);
                        duration7.setItemMeta(durationMeta7);
                        duration8.setItemMeta(durationMeta8);
                        duration9.setItemMeta(durationMeta9);


                         ItemStack[] menu_items2 = {
                                 playerHead7, air3, air3, duration1 , duration2, duration3, air3, air3, air3,
                                 air3, air3, air3, duration4, duration5, duration6, air3, air3, air3,
                                 back5, air3, air3, duration7, duration8, duration9, air3, air3, air3,};
                         Time.setContents(menu_items2);
                         e.setCancelled(true);
                         p.openInventory(Time);
                        break;
                    default:
                        e.setCancelled(true);
                        break;
                }
            }
        /*
        B
        A
        N
         */






            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lTime"))) {
                Inventory updatedTime = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lReason"));
                Inventory Ban_options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lBan menu"));


                //item 1
                String name2 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                Player whoToBan2 = Bukkit.getPlayerExact(name2);
                int exp2 = (int) whoToBan2.getExp();
                int hp2 = (int) whoToBan2.getHealth();
                ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta playerHeadmeta = playerHead.getItemMeta();

                playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan2.getDisplayName()));
                ArrayList<String> playerHeadlore = new ArrayList<>();
                playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp2));
                playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp2);
                playerHeadmeta.setLore(playerHeadlore);
                playerHead.setItemMeta(playerHeadmeta);
                //item 1

                //item 2
                ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                ItemMeta airMeta = air.getItemMeta();

                airMeta.setDisplayName(ChatColor.BLACK + ".");
                air.setItemMeta(airMeta);
                //item 2


                //item 3
                ItemStack paper = new ItemStack(Material.PAPER, 1);
                ItemMeta paperMeta = paper.getItemMeta();

                paperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lReason"));
                paper.setItemMeta(paperMeta);
                //item 3

                //updated paper
                ItemStack updatedClock = new ItemStack(Material.CLOCK, 1);
                ItemMeta updatedClockMeta = updatedClock.getItemMeta();

                updatedClockMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lDuration"));

                //updated paper


                //item 4
                ItemStack clock = new ItemStack(Material.CLOCK);
                ItemMeta clockMeta = clock.getItemMeta();

                clockMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lDuration"));
                clock.setItemMeta(clockMeta);
                //item 4

                //item 5
                ItemStack back = new ItemStack(Material.STONE_BUTTON);
                ItemMeta backMeta = back.getItemMeta();

                backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                back.setItemMeta(backMeta);
                //item 5



                ItemStack[] menu_items1 = {
                        playerHead, air, air, air, air, air, air, air, air,
                        air, air, air, paper, air, clock, air, air, air,
                        back, air, air, air, air, air, air, air, air,};
                Ban_options.setContents(menu_items1);




                switch (e.getCurrentItem().getType()){
                    case WHITE_CONCRETE :
                    updatedClockMeta.setDisplayName("30min");
                    e.setCancelled(true);
                        break;
                    case LIME_CONCRETE :
                        updatedClockMeta.setDisplayName("1h");
                        e.setCancelled(true);
                        break;
                    case LIGHT_BLUE_CONCRETE :
                        updatedClockMeta.setDisplayName("6h");
                        e.setCancelled(true);
                        break;
                    case CYAN_CONCRETE :
                        updatedClockMeta.setDisplayName("1d");
                        e.setCancelled(true);
                        break;
                    case ORANGE_CONCRETE :
                        updatedClockMeta.setDisplayName("3d");
                        e.setCancelled(true);
                        break;
                    case PURPLE_CONCRETE :
                        updatedClockMeta.setDisplayName("7d");
                        e.setCancelled(true);
                        break;
                    case BLUE_CONCRETE :
                        updatedClockMeta.setDisplayName("1m");
                        e.setCancelled(true);
                        break;
                    case GRAY_CONCRETE :
                        updatedClockMeta.setDisplayName("3m");
                        e.setCancelled(true);
                        break;
                    case BLACK_CONCRETE :
                        updatedClockMeta.setDisplayName("permanent");
                        e.setCancelled(true);
                        break;
                    case STONE_BUTTON:

                        p.openInventory(Ban_options);
                        e.setCancelled(true);
                        break;
                    default:
                        e.setCancelled(true);
                        break;
                }

                if (e.getCurrentItem().getType() == Material.STONE_BUTTON){
                    return;
                } else {
                    updatedClock.setItemMeta(updatedClockMeta);
                    ItemStack[] menu_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, air, paper, air, updatedClock, air, air, air,
                            back, air, air, air, air, air, air, air, air,};
                    updatedTime.setContents(menu_items);


                    p.openInventory(updatedTime);

                }

            }

























        /*
        K
        I
        C
        K
         */
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lKick menu"))) {
                switch (e.getCurrentItem().getType()) {
                    case STONE_BUTTON:
                        Inventory Options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lOptions"));


                        // empty
                        ItemStack air1 = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                        ItemMeta empty1Meta = air1.getItemMeta();

                        empty1Meta.setDisplayName(ChatColor.BLACK + ".");
                        air1.setItemMeta(empty1Meta);
                        // empty

                        // item 1
                        String name8 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                        Player whoToBan8 = Bukkit.getPlayerExact(name8);
                        int exp8 = (int) whoToBan8.getExp();
                        int hp8 = (int) whoToBan8.getHealth();
                        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                        ItemMeta playerHeadmeta = playerHead.getItemMeta();

                        playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan8.getDisplayName()));
                        ArrayList<String> playerHeadlore = new ArrayList<>();
                        playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp8));
                        playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp8);
                        playerHeadmeta.setLore(playerHeadlore);
                        playerHead.setItemMeta(playerHeadmeta);
                        // item 1

                        // item 2
                        ItemStack ban = new ItemStack(Material.BARRIER, 1);
                        ItemMeta banMeta = ban.getItemMeta();

                        banMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBan"));
                        ban.setItemMeta(banMeta);
                        // item 2

                        // item 3
                        ItemStack kick = new ItemStack(Material.WOODEN_AXE, 1);
                        ItemMeta kickMeta = kick.getItemMeta();

                        kickMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lKick"));
                        kick.setItemMeta(kickMeta);
                        // item 3

                        // item 4
                        ItemStack mute = new ItemStack(Material.LIGHT_GRAY_CONCRETE, 1);
                        ItemMeta muteMeta = mute.getItemMeta();

                        muteMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lMute"));
                        mute.setItemMeta(muteMeta);
                        // item 4

                        // back button
                        ItemStack back1 = new ItemStack(Material.STONE_BUTTON, 1);
                        ItemMeta back1Meta = back1.getItemMeta();

                        back1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                        back1.setItemMeta(back1Meta);
                        // back button


                        ItemStack[] menu_items = {
                                playerHead, air1, air1, air1, air1, air1, air1, air1, air1,
                                air1, air1, air1, ban, kick, mute, air1, air1, air1,
                                back1, air1, air1, air1, air1, air1, air1, air1, air1,};
                        Options.setContents(menu_items);
                        e.setCancelled(true);
                        p.openInventory(Options);
                        break;
                    case PAPER:
                        Inventory kickReasonMenu = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lKick reasons"));

                        //item 1
                        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                        ItemMeta airMeta = air.getItemMeta();

                        airMeta.setDisplayName(ChatColor.BLACK + ".");
                        air.setItemMeta(airMeta);
                        //item 1

                        //item 2
                        String name9 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                        Player whoToBan9 = Bukkit.getPlayerExact(name9);
                        int exp9 = (int) whoToBan9.getExp();
                        int hp9 = (int) whoToBan9.getHealth();
                        ItemStack playerHead9 = new ItemStack(Material.PLAYER_HEAD, 1);
                        ItemMeta playerHeadmeta9 = playerHead9.getItemMeta();

                        playerHeadmeta9.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan9.getDisplayName()));
                        ArrayList<String> playerHeadlore9 = new ArrayList<>();
                        playerHeadlore9.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp9));
                        playerHeadlore9.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp9);
                        playerHeadmeta9.setLore(playerHeadlore9);
                        playerHead9.setItemMeta(playerHeadmeta9);
                        //item 2

                        //item 3
                        ItemStack rule1 = new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER);
                        ItemMeta rule1Meta = rule1.getItemMeta();

                        rule1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lAnnoying"));
                        rule1.setItemMeta(rule1Meta);
                        //item 3

                        //item 4
                        ItemStack rule2 = new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER);
                        ItemMeta rule2Meta = rule1.getItemMeta();

                        rule2Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lSpamming"));
                        rule2.setItemMeta(rule2Meta);
                        //item 4

                        //item 5
                        ItemStack rule3 = new ItemStack(Material.BLUE_CONCRETE_POWDER);
                        ItemMeta rule3Meta = rule3.getItemMeta();

                        rule3Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lSwearing"));
                        rule3.setItemMeta(rule3Meta);
                        //item 5

                        //item 6
                        ItemStack rule4 = new ItemStack(Material.LIME_CONCRETE_POWDER);
                        ItemMeta rule4Meta = rule4.getItemMeta();

                        rule4Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lCharacter spam"));
                        rule4.setItemMeta(rule4Meta);
                        //item 6

                        //item 7
                        ItemStack rule5 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
                        ItemMeta rule5Meta = rule5.getItemMeta();

                        rule5Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&lDisrespecting a-team"));
                        rule5.setItemMeta(rule5Meta);
                        //item 7

                        //item 8
                        ItemStack rule6 = new ItemStack(Material.PINK_CONCRETE_POWDER);
                        ItemMeta rule6Meta = rule6.getItemMeta();

                        rule6Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lBug abusing"));
                        rule6.setItemMeta(rule6Meta);
                        //item 8

                        //item 9
                        ItemStack rule7 = new ItemStack(Material.MAGENTA_CONCRETE_POWDER);
                        ItemMeta rule7Meta = rule7.getItemMeta();

                        rule7Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lBreaking rules"));
                        rule7.setItemMeta(rule7Meta);
                        //item 9

                        //item 10
                        ItemStack rule8 = new ItemStack(Material.RED_CONCRETE_POWDER);
                        ItemMeta rule8Meta = rule8.getItemMeta();

                        rule8Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lDuping"));
                        rule8.setItemMeta(rule8Meta);
                        //item 10

                        //item 11
                        ItemStack rule9 = new ItemStack(Material.BLACK_CONCRETE_POWDER);
                        ItemMeta rule9Meta = rule9.getItemMeta();

                        rule9Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&0&lCheating"));
                        rule9.setItemMeta(rule9Meta);
                        //item 11

                        //item 12
                        ItemStack back = new ItemStack(Material.STONE_BUTTON);
                        ItemMeta backMeta = back.getItemMeta();

                        backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                        back.setItemMeta(backMeta);
                        //item 12

                        ItemStack[] menu_items3 = {
                                playerHead9, air, air, rule1, rule2, rule3, air, air, air,
                                air, air, air, rule4, rule5, rule6, air, air, air,
                                back, air, air, rule7, rule8, rule9, air, air, air,};
                        kickReasonMenu.setContents(menu_items3);


                        p.openInventory(kickReasonMenu);
                        e.setCancelled(true);
                        break;
                    default:
                        e.setCancelled(true);
                        break;
                }
            }
        /*
        K
        I
        C
        K
         */










        /*
        B
        A
        N
        */
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lBan reasons"))) {
                Inventory Ban_options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lBan menu"));
                Inventory Duration = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lDuration"));


                //item 1
                String name2 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                Player whoToBan2 = Bukkit.getPlayerExact(name2);
                int exp2 = (int) whoToBan2.getExp();
                int hp2 = (int) whoToBan2.getHealth();
                ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta playerHeadmeta = playerHead.getItemMeta();

                playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan2.getDisplayName()));
                ArrayList<String> playerHeadlore = new ArrayList<>();
                playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp2));
                playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp2);
                playerHeadmeta.setLore(playerHeadlore);
                playerHead.setItemMeta(playerHeadmeta);
                //item 1

                //item 2
                ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                ItemMeta airMeta = air.getItemMeta();

                airMeta.setDisplayName(ChatColor.BLACK + ".");
                air.setItemMeta(airMeta);
                //item 2


                //item 3
                ItemStack paper = new ItemStack(Material.PAPER, 1);
                ItemMeta paperMeta = paper.getItemMeta();

                paperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lReason"));
                paper.setItemMeta(paperMeta);
                //item 3

                //updated paper
                ItemStack updatedPaper = new ItemStack(Material.PAPER, 1);
                ItemMeta updatedPaperMeta = paper.getItemMeta();

                updatedPaperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lReason"));

                //updated paper


                //item 4
                ItemStack clock = new ItemStack(Material.CLOCK);
                ItemMeta clockMeta = clock.getItemMeta();

                clockMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lDuration"));
                clock.setItemMeta(clockMeta);
                //item 4

                //item 5
                ItemStack back = new ItemStack(Material.STONE_BUTTON);
                ItemMeta backMeta = back.getItemMeta();

                backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                back.setItemMeta(backMeta);
                //item 5

                ItemStack[] menu_items = {
                        playerHead, air, air, air, air, air, air, air, air,
                        air, air, air, paper, air, clock, air, air, air,
                        back, air, air, air, air, air, air, air, air,};
                Ban_options.setContents(menu_items);



                switch (e.getCurrentItem().getType()) {
                    case LIGHT_GRAY_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Annoying");
                        e.setCancelled(true);
                        break;
                    case LIGHT_BLUE_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Spamming");
                        e.setCancelled(true);
                        break;
                    case BLUE_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Swearing");
                        e.setCancelled(true);
                        break;
                    case LIME_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Character spamming");
                        e.setCancelled(true);
                        break;
                    case GREEN_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Disrespecting a-team");
                        e.setCancelled(true);
                        break;
                    case PINK_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Bug abusing");
                        e.setCancelled(true);
                        break;
                    case MAGENTA_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Breaking rules");
                        e.setCancelled(true);
                        break;
                    case RED_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Duping");
                        e.setCancelled(true);
                        break;
                    case BLACK_CONCRETE_POWDER:
                        updatedPaperMeta.setDisplayName("Cheating");
                        e.setCancelled(true);
                        break;
                    case STONE_BUTTON:

                        p.openInventory(Ban_options);
                        e.setCancelled(true);
                    default:
                        e.setCancelled(true);
                        break;
                }
                if (e.getCurrentItem().getType() == Material.STONE_BUTTON){
                    return;
                } else {
                    updatedPaper.setItemMeta(updatedPaperMeta);

                    ItemStack[] updatedMenu_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, air, updatedPaper, air, clock, air, air, air,
                            back, air, air, air, air, air, air, air, air,};
                    Duration.setContents(updatedMenu_items);
                    p.openInventory(Duration);
                }
            }
        /*
        B
        A
        N
        */









        /*
        K
        I
        C
        K
         */
            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lKick reasons"))) {

                switch (e.getCurrentItem().getType()) {
                    case LIGHT_GRAY_CONCRETE_POWDER:
                        reason = "Annoying";
                        e.setCancelled(true);
                        break;
                    case LIGHT_BLUE_CONCRETE_POWDER:
                        reason = "Spamming";
                        e.setCancelled(true);
                        break;
                    case BLUE_CONCRETE_POWDER:
                        reason = "Swearing";
                        e.setCancelled(true);
                        break;
                    case LIME_CONCRETE_POWDER:
                        reason = "Character spam";
                        e.setCancelled(true);
                        break;
                    case GREEN_CONCRETE_POWDER:
                        reason = "Disrespecting a-team";
                        e.setCancelled(true);
                        break;
                    case PINK_CONCRETE_POWDER:
                        reason = "Bug abusing";
                        e.setCancelled(true);
                        break;
                    case MAGENTA_CONCRETE_POWDER:
                        reason = "Breaking rules";
                        e.setCancelled(true);
                        break;
                    case RED_CONCRETE_POWDER:
                        reason = "Duping";
                        e.setCancelled(true);
                        break;
                    case BLACK_CONCRETE_POWDER:
                        reason = "Cheating";
                        e.setCancelled(true);
                        break;
                    case STONE_BUTTON:
                        Inventory kick_options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lKick menu"));

                        //item 1
                        String name2 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                        Player whoToBan2 = Bukkit.getPlayerExact(name2);
                        int exp2 = (int) whoToBan2.getExp();
                        int hp2 = (int) whoToBan2.getHealth();
                        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                        ItemMeta playerHeadmeta = playerHead.getItemMeta();

                        playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan2.getDisplayName()));
                        ArrayList<String> playerHeadlore = new ArrayList<>();
                        playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp2));
                        playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp2);
                        playerHeadmeta.setLore(playerHeadlore);
                        playerHead.setItemMeta(playerHeadmeta);
                        //item 1

                        //item 2
                        ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                        ItemMeta airMeta = air.getItemMeta();

                        airMeta.setDisplayName(ChatColor.BLACK + ".");
                        air.setItemMeta(airMeta);
                        //item 2

                        //item 3
                        ItemStack paper = new ItemStack(Material.PAPER, 1);
                        ItemMeta paperMeta = paper.getItemMeta();

                        paperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lReason"));
                        paper.setItemMeta(paperMeta);
                        //item 3

                        //item 4
                        ItemStack clock = new ItemStack(Material.CLOCK);
                        ItemMeta clockMeta = clock.getItemMeta();

                        clockMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lDuration"));
                        clock.setItemMeta(clockMeta);
                        //item 4

                        //item 5
                        ItemStack back = new ItemStack(Material.STONE_BUTTON);
                        ItemMeta backMeta = back.getItemMeta();

                        backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                        back.setItemMeta(backMeta);
                        //item 5

                        ItemStack[] menu_items = {
                                playerHead, air, air, air, air, air, air, air, air,
                                air, air, air, air, paper, air, air, air, air,
                                back, air, air, air, air, air, air, air, air,};
                        kick_options.setContents(menu_items);
                        p.openInventory(kick_options);
                        e.setCancelled(true);
                    default:
                        e.setCancelled(true);
                        break;




                }
                if (e.getCurrentItem().getType() == Material.STONE_BUTTON){
                    return;
                } else {
                    String nameOfTarget = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                    Player target = Bukkit.getPlayerExact(nameOfTarget);

                    target.kickPlayer(ChatColor.translateAlternateColorCodes('&', "" +
                                    "&a&lEconomy&f&lPlus&3&l ▶ &7&lyou have been kicked\n"+
                            "\n"+
                                    "&f&lReason&3&l ▶ &7&l" + reason + "\n"+"\n"+"\n"+"\n"+
                                    "&a&lDiscord&3&l ▶ &7https://discord.gg/QcVg5HGy"
                            )


                    );
                }
            }

        /*
        K
        I
        C
        K
        */

        /*
        B
        A
        N
        */






            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lReason"))){
                Inventory Ban_options = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lBan menu"));
                Inventory banReasonMenu = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lBan reason"));
                Inventory Time = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lTime"));

                //item 1
                String name2 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                Player whoToBan2 = Bukkit.getPlayerExact(name2);
                int exp2 = (int) whoToBan2.getExp();
                int hp2 = (int) whoToBan2.getHealth();
                ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta playerHeadmeta = playerHead.getItemMeta();

                playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan2.getDisplayName()));
                ArrayList<String> playerHeadlore = new ArrayList<>();
                playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp2));
                playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp2);
                playerHeadmeta.setLore(playerHeadlore);
                playerHead.setItemMeta(playerHeadmeta);
                //item 1

                //item 2
                ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                ItemMeta airMeta = air.getItemMeta();

                airMeta.setDisplayName(ChatColor.BLACK + ".");
                air.setItemMeta(airMeta);
                //item 2


                //item 3
                ItemStack paper = new ItemStack(Material.PAPER, 1);
                ItemMeta paperMeta = paper.getItemMeta();

                paperMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lReason"));
                paper.setItemMeta(paperMeta);
                //item 3


                //item 4
                ItemStack clock = new ItemStack(Material.CLOCK);
                ItemMeta clockMeta = clock.getItemMeta();

                clockMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lDuration"));
                clock.setItemMeta(clockMeta);
                //item 4

                //item 5
                ItemStack back = new ItemStack(Material.STONE_BUTTON);
                ItemMeta backMeta = back.getItemMeta();

                backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                back.setItemMeta(backMeta);
                //item 5

                //item 3
                ItemStack rule1 = new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER);
                ItemMeta rule1Meta = rule1.getItemMeta();

                rule1Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lAnnoying"));
                rule1.setItemMeta(rule1Meta);
                //item 3

                //item 4
                ItemStack rule2 = new ItemStack(Material.LIGHT_BLUE_CONCRETE_POWDER);
                ItemMeta rule2Meta = rule1.getItemMeta();

                rule2Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&lSpamming"));
                rule2.setItemMeta(rule2Meta);
                //item 4

                //item 5
                ItemStack rule3 = new ItemStack(Material.BLUE_CONCRETE_POWDER);
                ItemMeta rule3Meta = rule3.getItemMeta();

                rule3Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&lSwearing"));
                rule3.setItemMeta(rule3Meta);
                //item 5

                //item 6
                ItemStack rule4 = new ItemStack(Material.LIME_CONCRETE_POWDER);
                ItemMeta rule4Meta = rule4.getItemMeta();

                rule4Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lCharacter spam"));
                rule4.setItemMeta(rule4Meta);
                //item 6

                //item 7
                ItemStack rule5 = new ItemStack(Material.GREEN_CONCRETE_POWDER);
                ItemMeta rule5Meta = rule5.getItemMeta();

                rule5Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&2&lDisrespecting a-team"));
                rule5.setItemMeta(rule5Meta);
                //item 7

                //item 8
                ItemStack rule6 = new ItemStack(Material.PINK_CONCRETE_POWDER);
                ItemMeta rule6Meta = rule6.getItemMeta();

                rule6Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&d&lBug abusing"));
                rule6.setItemMeta(rule6Meta);
                //item 8

                //item 9
                ItemStack rule7 = new ItemStack(Material.MAGENTA_CONCRETE_POWDER);
                ItemMeta rule7Meta = rule7.getItemMeta();

                rule7Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&lBreaking rules"));
                rule7.setItemMeta(rule7Meta);
                //item 9

                //item 10
                ItemStack rule8 = new ItemStack(Material.RED_CONCRETE_POWDER);
                ItemMeta rule8Meta = rule8.getItemMeta();

                rule8Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lDuping"));
                rule8.setItemMeta(rule8Meta);
                //item 10

                //item 11
                ItemStack rule9 = new ItemStack(Material.LIGHT_GRAY_CONCRETE_POWDER);
                ItemMeta rule9Meta = rule9.getItemMeta();

                rule9Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lAnnoying"));
                rule9.setItemMeta(rule9Meta);
                //item 11

                //item12
                ItemStack updatedClock = new ItemStack(Material.CLOCK);
                ItemMeta updatedClockMeta = updatedClock.getItemMeta();

                updatedClockMeta.setDisplayName(e.getView().getItem(14).getItemMeta().getDisplayName());
                updatedClock.setItemMeta(updatedClockMeta);
                //item12

                ItemStack duration1 = new ItemStack(Material.WHITE_CONCRETE);
                ItemStack duration2 = new ItemStack(Material.LIME_CONCRETE);
                ItemStack duration3 = new ItemStack(Material.LIGHT_BLUE_CONCRETE);
                ItemStack duration4 = new ItemStack(Material.CYAN_CONCRETE);
                ItemStack duration5 = new ItemStack(Material.ORANGE_CONCRETE);
                ItemStack duration6 = new ItemStack(Material.PURPLE_CONCRETE);
                ItemStack duration7 = new ItemStack(Material.BLUE_CONCRETE);
                ItemStack duration8 = new ItemStack(Material.GRAY_CONCRETE);
                ItemStack duration9 = new ItemStack(Material.BLACK_CONCRETE);

                ItemMeta durationMeta1 = duration1.getItemMeta();
                ItemMeta durationMeta2 = duration2.getItemMeta();
                ItemMeta durationMeta3 = duration3.getItemMeta();
                ItemMeta durationMeta4 = duration4.getItemMeta();
                ItemMeta durationMeta5 = duration5.getItemMeta();
                ItemMeta durationMeta6 = duration6.getItemMeta();
                ItemMeta durationMeta7 = duration7.getItemMeta();
                ItemMeta durationMeta8 = duration8.getItemMeta();
                ItemMeta durationMeta9 = duration9.getItemMeta();

                durationMeta1.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&l30min"));
                durationMeta2.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l1h"));
                durationMeta3.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&b&l6h"));
                durationMeta4.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&3&l1d"));
                durationMeta5.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&l3d"));
                durationMeta6.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&5&l7d"));
                durationMeta7.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&l1m"));
                durationMeta8.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&l3m"));
                durationMeta9.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&0&lpermanent"));

                duration1.setItemMeta(durationMeta1);
                duration2.setItemMeta(durationMeta2);
                duration3.setItemMeta(durationMeta3);
                duration4.setItemMeta(durationMeta4);
                duration5.setItemMeta(durationMeta5);
                duration6.setItemMeta(durationMeta6);
                duration7.setItemMeta(durationMeta7);
                duration8.setItemMeta(durationMeta8);
                duration9.setItemMeta(durationMeta9);


                ItemStack[] menu_items2 = {
                        playerHead, air, air, duration1 , duration2, duration3, air, air, air,
                        air, air, air, duration4, duration5, duration6, air, air, air,
                        back, air, air, duration7, duration8, duration9, air, air, air,};
                Time.setContents(menu_items2);


                ItemStack[] menu_items1 = {
                        playerHead, air, air, rule1, rule2, rule3, air, air, air,
                        air, air, air, rule4, rule5, rule6, air, air, updatedClock,
                        back, air, air, rule7, rule8, rule9, air, air, air,};
                banReasonMenu.setContents(menu_items1);

                ItemStack[] menu_items = {
                        playerHead, air, air, air, air, air, air, air, air,
                        air, air, air, paper, air, clock, air, air, air,
                        back, air, air, air, air, air, air, air, air,};
                Ban_options.setContents(menu_items);


                switch (e.getCurrentItem().getType()){
                    case PAPER:
                        p.openInventory(banReasonMenu);

                        e.setCancelled(true);
                        break;
                    case CLOCK:

                        p.openInventory(Time);

                        e.setCancelled(true);
                        break;
                    case STONE_BUTTON:
                        p.openInventory(Ban_options);
                        e.setCancelled(true);
                        break;
                    default:
                        e.setCancelled(true);
                        break;
                }
            }






            if (e.getView().getTitle().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&a&lBan reason"))){

                Inventory confirmban1 = Bukkit.createInventory(p, 27, ChatColor.translateAlternateColorCodes('&', "&a&lConfirm &f&lreason/duration"));

                //item 1
                String name2 = ChatColor.stripColor(e.getView().getItem(0).getItemMeta().getDisplayName());
                Player whoToBan2 = Bukkit.getPlayerExact(name2);
                int exp2 = (int) whoToBan2.getExp();
                int hp2 = (int) whoToBan2.getHealth();
                ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD, 1);
                ItemMeta playerHeadmeta = playerHead.getItemMeta();

                playerHeadmeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&l&f" + whoToBan2.getDisplayName()));
                ArrayList<String> playerHeadlore = new ArrayList<>();
                playerHeadlore.add(ChatColor.translateAlternateColorCodes('&', "&6Health: &c&l" + hp2));
                playerHeadlore.add(ChatColor.GOLD + "Exp: " + ChatColor.AQUA + "" + ChatColor.BOLD + exp2);
                playerHeadmeta.setLore(playerHeadlore);
                playerHead.setItemMeta(playerHeadmeta);
                //item 1

                //item 2
                ItemStack air = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
                ItemMeta airMeta = air.getItemMeta();

                airMeta.setDisplayName(ChatColor.BLACK + ".");
                air.setItemMeta(airMeta);
                //item 2

                //time
                ItemStack timer = new ItemStack(Material.CLOCK);
                ItemMeta timerMeta = timer.getItemMeta();

                timerMeta.setDisplayName(e.getView().getItem(17).getItemMeta().getDisplayName());
                timer.setItemMeta(timerMeta);
                //time

                //item 5
                ItemStack back = new ItemStack(Material.STONE_BUTTON);
                ItemMeta backMeta = back.getItemMeta();

                backMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7&lBack"));
                back.setItemMeta(backMeta);
                //item 5

                //reason
                ItemStack reasonToBan = new ItemStack(Material.PAPER);
                ItemMeta reasonTobanMeta = reasonToBan.getItemMeta();
                //reason

                ItemStack confirm = new ItemStack(Material.LIME_CONCRETE);
                ItemStack cancel = new ItemStack(Material.RED_CONCRETE);

                ItemMeta confirmMeta = confirm.getItemMeta();
                ItemMeta cancelMeta = cancel.getItemMeta();

                confirmMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lConfirm"));
                cancelMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lCancel"));

                confirm.setItemMeta(confirmMeta);
                cancel.setItemMeta(cancelMeta);

                switch (e.getCurrentItem().getType()){
                    case LIGHT_GRAY_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Annoying");

                        e.setCancelled(true);
                        break;
                    case LIGHT_BLUE_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Spamming");

                        e.setCancelled(true);
                        break;
                    case BLUE_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Swearing");

                        e.setCancelled(true);
                        break;
                    case LIME_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Character spam");

                        e.setCancelled(true);
                        break;
                    case GREEN_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Disrespecting a-team");

                        e.setCancelled(true);
                        break;
                    case PINK_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Bug abusing");

                        e.setCancelled(true);
                        break;
                    case MAGENTA_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Breaking rules");

                        e.setCancelled(true);
                        break;
                    case RED_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Duping");

                        e.setCancelled(true);
                        break;
                    case BLACK_CONCRETE_POWDER:
                        reasonTobanMeta.setDisplayName("Cheating");

                        e.setCancelled(true);
                        break;
                    case STONE_BUTTON:


                        e.setCancelled(true);
                    default:
                        e.setCancelled(true);
                        break;
                }

                if (e.getCurrentItem().getType() == Material.LIGHT_GRAY_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);
                } else if (e.getCurrentItem().getType() == Material.LIGHT_BLUE_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else if (e.getCurrentItem().getType() == Material.BLUE_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else if (e.getCurrentItem().getType() == Material.LIME_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else if (e.getCurrentItem().getType() == Material.GREEN_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else if (e.getCurrentItem().getType() == Material.PINK_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else if (e.getCurrentItem().getType() == Material.MAGENTA_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else if (e.getCurrentItem().getType() == Material.RED_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else if (e.getCurrentItem().getType() == Material.BLACK_CONCRETE_POWDER){
                    reasonToBan.setItemMeta(reasonTobanMeta);
                    ItemStack[] reasontoban_items = {
                            playerHead, air, air, air, air, air, air, air, air,
                            air, air, confirm, air, timer, reasonToBan, air, cancel, air,
                            back, air, air, air, air, air, air, air, air,};
                    confirmban1.setContents(reasontoban_items);

                    p.openInventory(confirmban1);

                } else {
                    return;
                }




            }












        /*
        B
        A
        N
        */



















        } catch (NullPointerException exception) {
        }
    }
}

