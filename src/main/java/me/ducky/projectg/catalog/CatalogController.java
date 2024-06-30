package me.ducky.projectg.catalog;

import me.ducky.projectg.catalog.catalogs.GadgetCatalog;
import me.ducky.projectg.catalog.catalogs.GunCatalog;
import me.ducky.projectg.catalog.catalogs.KitCatalog;
import me.ducky.projectg.catalog.catalogs.LocationCatalog;
import me.ducky.projectg.catalog.enums.City;
import me.ducky.projectg.catalog.enums.GunClass;
import me.ducky.projectg.catalog.enums.KitClass;
import me.ducky.projectg.catalog.items.GadgetItem;
import me.ducky.projectg.catalog.items.GunItem;
import me.ducky.projectg.catalog.items.KitItem;
import me.ducky.projectg.catalog.items.LocationItem;
import me.ducky.projectg.util.GetButtonUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class CatalogController {

    public static Inventory getKitMenu(Player player, KitClass kitClass, String menuTitle) {
        Inventory menu = Bukkit.createInventory(player, 9 * 4, menuTitle);
        int itemSlot = 1;
        int itemRow = 1;

        for (KitItem kit : KitCatalog.LIST) {
            if (kit.getKitClass() != kitClass) continue;

            ItemStack item = kit.getDisplayItem();
            ItemMeta itemMeta = item.getItemMeta();

            itemMeta.setDisplayName(kit.getDisplayName());

            List<String> lore = new ArrayList<>();
            lore.add(kit.getDescription());
            lore.add(kit.getDisplayRarity());

            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);

            // Slot = Slot Num + 9 * Row
            menu.setItem(itemSlot + 9 * itemRow, item);

            itemSlot += 1;
            if (itemSlot == 8) {
                itemSlot = 1;
                itemRow += 1;
            }
        }

        menu.setItem(4 + 9 * 3, getBackButton());

        return menu;
    }

    public static Inventory getGunMenu(Player player, GunClass gunClass, String menuTitle) {
        Inventory menu = Bukkit.createInventory(player, 9 * 6, menuTitle);
        int itemSlot = 0;
        int itemRow = 0;

        for (GunItem gun : GunCatalog.LIST) {
            if (gun.getGunClass() != gunClass) continue;

            ItemStack item = gun.getDisplayItem();
            ItemMeta itemMeta = item.getItemMeta();

            itemMeta.setDisplayName(gun.getDisplayName());

            List<String> lore = new ArrayList<>();
            lore.add(gun.getDisplayRarity());

            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);

            // Slot = Slot Num + 9 * Row
            menu.setItem(itemSlot + 9 * itemRow, item);
            menu.setItem(itemSlot + 9 + 9 * itemRow, GetButtonUtility.getButton("equip"));

            itemSlot += 1;
            if (itemSlot == 9) {
                itemSlot = 0;
                itemRow += 2;
            }

            if (itemSlot == 4 && itemRow == 4) itemSlot += 1;
        }

        menu.setItem(4 + 9 * 5, getBackButton());

        return menu;
    }

    public static Inventory getGadgetMenu(Player player) {
        Inventory menu = Bukkit.createInventory(player, 9 * 6, "Gadgets");
        int itemSlot = 1;
        int itemRow = 1;

        for (GadgetItem gadget : GadgetCatalog.LIST) {
            ItemStack item = gadget.getDisplayItem();
            ItemMeta itemMeta = item.getItemMeta();

            itemMeta.setDisplayName(gadget.getDisplayName());

            List<String> lore = new ArrayList<>();
            lore.add(gadget.getDisplayRarity());

            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);

            // Slot = Slot Num + 9 * Row
            menu.setItem(itemSlot + 9 * itemRow, item);

            itemSlot += 1;
            if (itemSlot == 8) {
                itemSlot = 1;
                itemRow += 1;
            }
        }

        menu.setItem(4 + 9 * 5, getBackButton());

        return menu;
    }

    public static Inventory getLocationMenu(Player player, City city) {
        Inventory menu;
        int itemSlot = 1;
        int itemRow = 1;

        switch (city) {
            case NEWPORT: menu = Bukkit.createInventory(player, 9 * 4, "Newport City"); break;
            case RADIANT: menu = Bukkit.createInventory(player, 9 * 4, "Radiant City"); break;
            case SHMAR: menu = Bukkit.createInventory(player, 9 * 4, "Shmar City"); break;
            case AUDIA: menu = Bukkit.createInventory(player, 9 * 6, "Audia City"); break;
            case CITY_17: menu = Bukkit.createInventory(player, 9 * 6, "City 17"); break;
            default: menu = Bukkit.createInventory(player, 9 * 4, "Unknown City"); break;
        }

        for (LocationItem location : LocationCatalog.LIST) {
            if (location.getCity() != city) continue;

            ItemStack item = new ItemStack(Material.ENDER_PEARL);
            ItemMeta itemMeta = item.getItemMeta();

            itemMeta.setDisplayName(location.getDisplayName());

            List<String> lore = new ArrayList<>();
            lore.add(location.getDisplayCoordinates());

            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);

            // Slot = Slot Num + 9 * Row
            menu.setItem(itemSlot + 9 * itemRow, item);

            itemSlot += 1;
            if (itemSlot == 8) {
                itemSlot = 1;
                itemRow += 1;
            }
        }

        if (city == City.AUDIA || city == City.CITY_17)
            menu.setItem(4 + 9 * 5, getBackButton());
        else
            menu.setItem(4 + 9 * 3, getBackButton());

        return menu;
    }

    private static ItemStack getBackButton() {
        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
        backButton.setItemMeta(backButtonMeta);
        return backButton;
    }
}
