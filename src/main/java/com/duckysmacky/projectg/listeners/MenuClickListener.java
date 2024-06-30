package com.duckysmacky.projectg.listeners;

import com.duckysmacky.projectg.functions.KitEquipFunction;
import com.duckysmacky.projectg.menu.ItemCatalog;
import com.duckysmacky.projectg.util.GetMenuUtility;
import com.duckysmacky.projectg.util.LocationsMenuUtility;
import com.duckysmacky.projectg.util.MapSettingsUtility;
import com.duckysmacky.projectg.util.TeamsMenuUtility;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class MenuClickListener implements Listener {

    @EventHandler
    public void onMenuClick(InventoryClickEvent event) {
        String menuName = event.getView().getTitle();
        ItemStack item = event.getCurrentItem();
        String itemName = item.getItemMeta().getDisplayName();

        if (menuName.equalsIgnoreCase("Menu")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lEquipment"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "equipment"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lTeleports"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "teleports"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lSettings"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "settings"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equalsIgnoreCase("Equipment")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lKits"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "kits"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lGuns"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "guns"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lGadgets"))) {

                player.openInventory(ItemCatalog.selectGadgetMenu(player));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "menu"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equalsIgnoreCase("Kits")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lAssault Class"))) {

                player.openInventory(ItemCatalog.selectKitMenu(player, "assault", "Assault Class"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&e&lSkirmisher Class"))) {

                player.openInventory(ItemCatalog.selectKitMenu(player, "skirmisher", "Skirmisher Class"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&6&lAssassin Class"))) {

                player.openInventory(ItemCatalog.selectKitMenu(player, "assassin", "Assassin Class"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lRandom Kit"))) {

                KitEquipFunction.equipKit(player, "random");

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&9&lSentinel Class"))) {

                player.openInventory(ItemCatalog.selectKitMenu(player, "sentinel", "Sentinel Class"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "equipment"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equalsIgnoreCase("Guns")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lAssault Rifles"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "assault_rifle", "Assault Rifles"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lBattle Rifles"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "battle_rifle", "Battle Rifles"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lDMRs"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "dmr", "DMRs"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lLMGs"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "lmg", "LMGs"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lSMGs"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "smg", "SMGs"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lShotguns"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "shotgun", "Shotguns"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lSniper Rifles"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "sniper_rifle", "Sniper Rifles"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lSecondaries"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "secondary", "Secondaries"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lSpecials"))) {

                player.openInventory(ItemCatalog.selectGunMenu(player, "special", "Specials"));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "equipment"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        }  else if (menuName.equals(ChatColor.stripColor("Assault Class")) || menuName.equals(ChatColor.stripColor("Skirmisher Class")) || menuName.equals(ChatColor.stripColor("Assassin Class")) || menuName.equals(ChatColor.stripColor("Sentinel Class")) || menuName.equals(ChatColor.stripColor("Support Class"))) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "kits"));

            } else {

                KitEquipFunction.equipKit(player, event.getCurrentItem().getItemMeta().getDisplayName());

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equals(ChatColor.stripColor("Assault Rifles")) || menuName.equals(ChatColor.stripColor("Battle Rifles")) || menuName.equals(ChatColor.stripColor("DMRs")) || menuName.equals(ChatColor.stripColor("LMGs")) || menuName.equals(ChatColor.stripColor("SMGs")) || menuName.equals(ChatColor.stripColor("Shotguns")) || menuName.equals(ChatColor.stripColor("Sniper Rifles")) || menuName.equals(ChatColor.stripColor("Secondaries")) || menuName.equals(ChatColor.stripColor("Specials"))) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "guns"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equalsIgnoreCase("Teleports")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lNewport City"))) {

                LocationsMenuUtility.checkForWorld(player, "Newport");

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lRadiant City"))) {

                LocationsMenuUtility.checkForWorld(player, "Radiant");

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lShmar City"))) {

                LocationsMenuUtility.checkForWorld(player, "Shmar");

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lAudia City"))) {

                LocationsMenuUtility.checkForWorld(player, "Audia");

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lCity 17"))) {

                LocationsMenuUtility.checkForWorld(player, "City 17");

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "menu"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equalsIgnoreCase("Settings")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lMap Settings"))) {

                player.openInventory(MapSettingsUtility.getMapSettingsMenu(player));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&f&lTeams"))) {

                player.openInventory(TeamsMenuUtility.getTeamsMenu(player));

            } else if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "menu"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equalsIgnoreCase("Map Settings")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "settings"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        } else if (menuName.equalsIgnoreCase("Teams")) {
            Player player = (Player) event.getWhoClicked();

            if (itemName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {

                player.openInventory(GetMenuUtility.getMenu(player, "settings"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);
        }
    }
}
