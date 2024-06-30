package me.ducky.projectg.listeners;

import me.ducky.projectg.catalog.catalogs.MenuCatalog;
import me.ducky.projectg.catalog.enums.City;
import me.ducky.projectg.catalog.enums.GunClass;
import me.ducky.projectg.catalog.enums.KitClass;
import me.ducky.projectg.catalog.enums.Menu;
import me.ducky.projectg.catalog.items.MenuItem;
import me.ducky.projectg.functions.KitEquipFunction;
import me.ducky.projectg.catalog.CatalogController;
import me.ducky.projectg.util.MenuUtility;
import me.ducky.projectg.util.MapSettingsUtility;
import me.ducky.projectg.util.TeamsMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuClickListener implements Listener {
    private static final String BACK_BUTTON = ChatColor.translateAlternateColorCodes('&', "&c&lBack");

    public static String getButtonName(String name) {
        return ChatColor.translateAlternateColorCodes('&', "&f&l" + name);
    }

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        String currentMenuName = event.getView().getTitle().toLowerCase();
        MenuItem currentMenu = null;

        // Exclude all vanilla menus
        boolean vanillaMenu = true;
        for (MenuItem menu : MenuCatalog.LIST) {
            if (currentMenuName.equals(menu.getName())) {
                currentMenu = menu;
                vanillaMenu = false;
            }
        }
        if (vanillaMenu) return;

        Player player = (Player) event.getWhoClicked();
        ItemStack clickedItem = event.getCurrentItem();
        String clickedButtonName = clickedItem.getItemMeta().getDisplayName();

        switch (currentMenu.getMenu()) {
            case MENU:
                if (clickedButtonName.equals(getButtonName("Equipment")))
                    player.openInventory(MenuUtility.getMenu(player, Menu.EQUIPMENT));
                else if (clickedButtonName.equals(getButtonName("Locations")))
                    player.openInventory(MenuUtility.getMenu(player, Menu.LOCATIONS));
                else if (clickedButtonName.equals(getButtonName("Settings")))
                    player.openInventory(MenuUtility.getMenu(player, Menu.SETTINGS));
                break;
            case EQUIPMENT: {
                if (clickedButtonName.equals(getButtonName("Assault Class")))
                    player.openInventory(CatalogController.getKitMenu(player, KitClass.ASSAULT, "Assault Class"));
                else if (clickedButtonName.equals(getButtonName("Skirmisher Class")))
                    player.openInventory(CatalogController.getKitMenu(player, KitClass.SKIRMISHER, "Skirmisher Class"));
                else if (clickedButtonName.equals(getButtonName("Random Class")))
                    KitEquipFunction.equipKit(player, "random");
                else if (clickedButtonName.equals(getButtonName("Assassin Class")))
                    player.openInventory(CatalogController.getKitMenu(player, KitClass.SKIRMISHER, "Assassin Class"));
                else if (clickedButtonName.equals(getButtonName("Sentinel Class")))
                    player.openInventory(CatalogController.getKitMenu(player, KitClass.SKIRMISHER, "Sentinel Class"));
                break;
            }
            case LOCATIONS: {
                if (clickedButtonName.equals(getButtonName("Newport City"))) {
                    player.openInventory(CatalogController.getLocationMenu(player, City.NEWPORT));
                } else if (clickedButtonName.equals(getButtonName("Radiant City"))) {
                    player.openInventory(CatalogController.getLocationMenu(player, City.RADIANT));
                } else if (clickedButtonName.equals(getButtonName("Shmar City"))) {
                    player.openInventory(CatalogController.getLocationMenu(player, City.SHMAR));
                } else if (clickedButtonName.equals(getButtonName("Audia City"))) {
                    player.openInventory(CatalogController.getLocationMenu(player, City.AUDIA));
                } else if (clickedButtonName.equals(getButtonName("City 17"))) {
                    player.openInventory(CatalogController.getLocationMenu(player, City.CITY_17));
                }
                break;
            }
            case SETTINGS: {
                if (clickedButtonName.equals(getButtonName("Map Settings"))) {
                    player.openInventory(MapSettingsUtility.getMapSettingsMenu(player));
                } else if (clickedButtonName.equals(getButtonName("Teams"))) {
                    player.openInventory(TeamsMenuUtility.getTeamsMenu(player));
                }
                break;
            }
            case GUNS:
                if (clickedButtonName.equals(getButtonName("Assault Rifles")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.ASSAULT_RIFLE, "Assault Rifles"));
                else if (clickedButtonName.equals(getButtonName("Battle Rifles")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.BATTLE_RIFLE, "Battle Rifles"));
                else if (clickedButtonName.equals(getButtonName("DMRs")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.DMR, "DMRs"));
                else if (clickedButtonName.equals(getButtonName("LMGs")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.LMG, "LMGs"));
                else if (clickedButtonName.equals(getButtonName("SMGs")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.SMG, "SMGs"));
                else if (clickedButtonName.equals(getButtonName("Shotguns")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.SHOTGUN, "Shotguns"));
                else if (clickedButtonName.equals(getButtonName("Sniper Rifles")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.SNIPER_RIFLE, "Sniper Rifles"));
                else if (clickedButtonName.equals(getButtonName("Secondaries")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.SECONDARY, "Secondaries"));
                else if (clickedButtonName.equals(getButtonName("Specials")))
                    player.openInventory(CatalogController.getGunMenu(player, GunClass.SPECIAL, "Specials"));
                break;
        }

        if (currentMenuName.equals(ChatColor.stripColor("Assault Class"))
            || currentMenuName.equals(ChatColor.stripColor("Skirmisher Class"))
            || currentMenuName.equals(ChatColor.stripColor("Assassin Class"))
            || currentMenuName.equals(ChatColor.stripColor("Sentinel Class"))
            || currentMenuName.equals(ChatColor.stripColor("Support Class"))) {
            if (clickedButtonName.equals(BACK_BUTTON)) {
                player.openInventory(MenuUtility.getMenu(player, Menu.KITS));
            } else {
                KitEquipFunction.equipKit(player, event.getCurrentItem().getItemMeta().getDisplayName());
            }
        } else if (currentMenuName.equals(ChatColor.stripColor("Assault Rifles"))
            || currentMenuName.equals(ChatColor.stripColor("Battle Rifles"))
            || currentMenuName.equals(ChatColor.stripColor("DMRs"))
            || currentMenuName.equals(ChatColor.stripColor("LMGs"))
            || currentMenuName.equals(ChatColor.stripColor("SMGs"))
            || currentMenuName.equals(ChatColor.stripColor("Shotguns"))
            || currentMenuName.equals(ChatColor.stripColor("Sniper Rifles"))
            || currentMenuName.equals(ChatColor.stripColor("Secondaries"))
            || currentMenuName.equals(ChatColor.stripColor("Specials"))) {
            if (clickedButtonName.equals(BACK_BUTTON)) {
                player.openInventory(MenuUtility.getMenu(player, Menu.GUNS));
            }
        }

        if (clickedButtonName.equals(BACK_BUTTON)) player.openInventory(MenuUtility.getMenu(player, currentMenu.getPreviousMenu().getMenu()));

        player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
        event.setCancelled(true);
    }
}
