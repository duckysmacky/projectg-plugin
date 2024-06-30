package me.ducky.projectg.util;

import me.ducky.projectg.menu.ItemCatalog;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static org.bukkit.Bukkit.getServer;

public class LocationsMenuUtility implements Listener {

    @EventHandler
    public static void teleportsFunction(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory menu = event.getClickedInventory();
        String buttonName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

        if (menu.getName().equals("Newport") || menu.getName().equals("Radiant") || menu.getName().equals("Shmar") || menu.getName().equals("Audia") || menu.getName().equals("City 17")) {

            if (buttonName.equals("Back")) {

                player.openInventory(GetMenuUtility.getMenu(player, "teleports"));

            } else {

                String[][] teleportsCatalog = ItemCatalog.getCatalog("teleports");

                assert teleportsCatalog != null;
                for (String[] teleportsData : teleportsCatalog) {

                    if (teleportsData[0].equals(menu.getName())) {

                        if (teleportsData[1].equals(buttonName)) {

                            player.setGameMode(GameMode.SPECTATOR);
                            String command = "tp " + player.getDisplayName() + " " + teleportsData[2] + " " + teleportsData[3] + " " + teleportsData[4];
                            getServer().dispatchCommand(getServer().getConsoleSender(), command);
//                            Location location = new Location(Bukkit.getWorld(menu.getName()), Double.parseDouble(teleportsData[2]), Double.parseDouble(teleportsData[3]), Double.parseDouble(teleportsData[4]));
//                            player.teleport(location);
                            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
                            event.setCancelled(true);

                        }
                    }
                }
            }
        }
    }

    public static void checkForWorld(Player player, String mapName) {

//        if (player.getWorld().getName().equals(mapName)) {
//
//            ItemCatalog.selectLocationsMenu(player, mapName);
//
//        } else {
//
//            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&lThis is not your current map, please select your current map!"));
//
//        }

        player.openInventory(ItemCatalog.selectLocationsMenu(player, mapName));

    }
}
