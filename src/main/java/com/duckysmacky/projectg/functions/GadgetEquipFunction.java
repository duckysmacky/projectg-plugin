package com.duckysmacky.projectg.functions;

import com.duckysmacky.projectg.util.GetMenuUtility;
import com.duckysmacky.projectg.menu.ItemCatalog;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GadgetEquipFunction implements Listener {

    private Material lastGadget = null;

    public void equipGadget(Player player, String gadgetName, String gadgetId, int amount, String gadgetRarity) {
        ItemStack gadget = new ItemStack(Material.valueOf(gadgetId), amount);
        ItemMeta gadgetMeta = gadget.getItemMeta();
        int gadgetIndex = 4;

        switch (gadgetRarity) {
            case "common": {
                gadgetMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + gadgetName);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "COMMON GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
                break;
            }
            case "uncommon": {
                gadgetMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + gadgetName);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.AQUA + "" + ChatColor.BOLD + "UNCOMMON GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
                break;
            }
            case "rare": {
                gadgetMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + gadgetName);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
                break;
            }
            case "epic": {
                gadgetMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + gadgetName);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "EPIC GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
                break;
            }
            case "legendary": {
                gadgetMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + gadgetName);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
                break;
            }
        }

        player.getInventory().setItem(gadgetIndex, gadget);

        lastGadget = Material.valueOf(gadgetId);

    }

    public void unequipGadget(Player player) {

        if (lastGadget != null) {
            while (player.getInventory().contains(lastGadget)) {
                player.getInventory().remove(lastGadget);
            }
        }

    }

    @EventHandler
    public void onGadgetClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String gadgetName = event.getCurrentItem().getItemMeta().getDisplayName();

        if (event.getView().getTitle().equals("Gadgets")) {

            if (!gadgetName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {
                ItemStack gadget = event.getCurrentItem();
                String[] gadgetData = ItemCatalog.getCatalogItem("gadget", ChatColor.stripColor(gadgetName));

                unequipGadget(player);
                equipGadget(player, gadgetData[0], gadgetData[1], Integer.parseInt(gadgetData[2]), gadgetData[3]);
                player.sendMessage(gadget.getItemMeta().getDisplayName() + ChatColor.GREEN + " was equipped");

            } else {

                player.openInventory(GetMenuUtility.getMenu(player, "equipment"));

            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);

        }


    }

}
