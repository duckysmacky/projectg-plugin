package me.ducky.projectg.util;

import me.ducky.projectg.catalog.catalogs.LocationCatalog;
import me.ducky.projectg.catalog.enums.Menu;
import me.ducky.projectg.catalog.items.LocationItem;
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

                player.openInventory(MenuUtility.getMenu(player, Menu.LOCATIONS));

            } else {
                for (LocationItem teleportsData : LocationCatalog.LIST) {
                    if (teleportsData.getCity().name().equals(menu.getName())) {
                        if (teleportsData.getDisplayName().equals(buttonName)) {

                            player.setGameMode(GameMode.SPECTATOR);
                            String command = "tp " + player.getDisplayName() + " " + teleportsData.getX() + " " + teleportsData.getY() + " " + teleportsData.getZ();
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
}
