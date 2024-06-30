package me.ducky.projectg.functions;

import me.ducky.projectg.catalog.catalogs.GadgetCatalog;
import me.ducky.projectg.catalog.enums.Menu;
import me.ducky.projectg.catalog.items.GadgetItem;
import me.ducky.projectg.util.MenuUtility;
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
    private static final int GADGET_INDEX = 4;

    private Material lastGadget = null;

    public void equipGadget(Player player, GadgetItem gadget) {
        ItemStack item = new ItemStack(Material.valueOf(gadget.getId()), gadget.getAmount());
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(gadget.getDisplayName());
        List<String> lore = new ArrayList<>();
        lore.add(gadget.getDisplayRarity());
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);

        player.getInventory().setItem(GADGET_INDEX, item);
        lastGadget = Material.valueOf(gadget.getId());
    }

    public void unequipGadget(Player player) {
        if (lastGadget != null)
            while (player.getInventory().contains(lastGadget))
                player.getInventory().remove(lastGadget);
    }

    @EventHandler
    public void onGadgetClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String gadgetName = event.getCurrentItem().getItemMeta().getDisplayName();

        if (event.getView().getTitle().equals("Gadgets")) {
            if (!gadgetName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lBack"))) {
                ItemStack gadgetItem = event.getCurrentItem();

                for (GadgetItem gadget : GadgetCatalog.LIST) {
                    if (gadget.getDisplayName().equals(gadgetName)) {
                        unequipGadget(player);
                        equipGadget(player, gadget);
                        player.sendMessage(ChatColor.stripColor(gadget.getDisplayName()) + ChatColor.GREEN + " was equipped");
                    }
                }
            } else {
                player.openInventory(MenuUtility.getMenu(player, Menu.EQUIPMENT));
            }

            player.playSound(player.getLocation(), Sound.UI_BUTTON_CLICK, 1.0f, 1.0f);
            event.setCancelled(true);
        }
    }
}
