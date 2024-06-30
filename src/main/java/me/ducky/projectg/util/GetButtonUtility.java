package com.duckysmacky.projectg.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GetButtonUtility {

    public static ItemStack getButton(String buttonType) {

        switch (buttonType) {
            case "equip": {
                ItemStack button = new ItemStack(Material.INK_SACK, 1, (short) 8);
                ItemMeta buttonMeta = button.getItemMeta();

                buttonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lEquip"));
                button.setItemMeta(buttonMeta);

                return button;
            }
            case "unequip": {
                ItemStack button = new ItemStack(Material.INK_SACK, 1, (short) 10);
                ItemMeta buttonMeta = button.getItemMeta();

                buttonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lUnequip"));
                button.setItemMeta(buttonMeta);

                return button;
            }
            case "variants": {
                ItemStack button = new ItemStack(Material.INK_SACK, 1, (short) 5);
                ItemMeta buttonMeta = button.getItemMeta();

                buttonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lShow Variants"));
                button.setItemMeta(buttonMeta);

                return button;
            }
            case "on": {
                ItemStack button = new ItemStack(Material.INK_SACK, 1, (short) 10);
                ItemMeta buttonMeta = button.getItemMeta();

                buttonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lOn"));
                button.setItemMeta(buttonMeta);

                return button;
            }
            case "off": {
                ItemStack button = new ItemStack(Material.INK_SACK, 1, (short) 8);
                ItemMeta buttonMeta = button.getItemMeta();

                buttonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lOff"));
                button.setItemMeta(buttonMeta);

                return button;
            }
            default: return null;
        }

    }

}
