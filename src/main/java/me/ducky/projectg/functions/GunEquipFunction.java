package me.ducky.projectg.functions;

import me.ducky.projectg.menu.ItemCatalog;
import me.ducky.projectg.util.GetButtonUtility;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GunEquipFunction implements Listener {
    private Material lastGun = null;
    private Material lastAmmo = null;
    private Material lastSecondaryGun = null;
    private Material lastSecondaryAmmo = null;
    private int lastButtonSlot = 0;
    private int lastSecondaryButtonSlot = 0;

    public GunEquipFunction() {}

    public void equipGun(Player player, String gunName, String gunType, String gunId, String ammoId, int ammoAmount, String gunRarity) {
        ItemStack gun = new ItemStack(Material.valueOf(gunId));
        ItemMeta gunMeta = gun.getItemMeta();
        int gunIndex = 0;
        int ammoIndex = 9 * 3;

        if (gunRarity.equals("common")) {
            gunMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + gunName);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "COMMON WEAPON");
            gunMeta.setLore(lore);
            gun.setItemMeta(gunMeta);
        } else if (gunRarity.equals("uncommon")) {
            gunMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + gunName);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.AQUA + "" + ChatColor.BOLD + "UNCOMMON WEAPON");
            gunMeta.setLore(lore);
            gun.setItemMeta(gunMeta);
        } else if (gunRarity.equals("rare")) {
            gunMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + gunName);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE WEAPON");
            gunMeta.setLore(lore);
            gun.setItemMeta(gunMeta);
        }
        else if (gunRarity.equals("epic")) {
            gunMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + gunName);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "EPIC WEAPON");
            gunMeta.setLore(lore);
            gun.setItemMeta(gunMeta);
        }
        else if (gunRarity.equals("legendary")) {
            gunMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + gunName);
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY WEAPON");
            gunMeta.setLore(lore);
            gun.setItemMeta(gunMeta);
        }

        if (gunType.equals("secondary")) {
            gunIndex += 1;
            ammoIndex += 1;
        }

        player.getInventory().setItem(gunIndex, gun);

        if (ammoAmount > 64) {
            int ammoStacksAmount = ammoAmount / 64;

            for (int i = 0; i < ammoStacksAmount; i++) {

                ItemStack ammo = new ItemStack(Material.valueOf(ammoId), 64);
                player.getInventory().addItem(ammo);

            }

        } else {

            ItemStack ammo = new ItemStack(Material.valueOf(ammoId), ammoAmount);
            player.getInventory().setItem(ammoIndex, ammo);

        }

        if (gunType.equals("secondary")) {
            lastSecondaryGun = Material.valueOf(gunId);
            lastSecondaryAmmo = Material.valueOf(ammoId);
        } else {
            lastGun = Material.valueOf(gunId);
            lastAmmo = Material.valueOf(ammoId);
        }

    }

    public void unequipGun(Player player, String gunType) {
        if (gunType.equals("secondary")) {
            player.getInventory().remove(lastSecondaryGun);
            while (player.getInventory().contains(lastSecondaryAmmo)) {
                player.getInventory().remove(lastSecondaryAmmo);
            }
        } else {
            player.getInventory().remove(lastGun);
            while (player.getInventory().contains(lastAmmo)) {
                player.getInventory().remove(lastAmmo);
            }
        }
    }

    @EventHandler
    public void onEquipButtonClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        ItemStack button = event.getCurrentItem();
        String buttonName = button.getItemMeta().getDisplayName();

        if (buttonName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lEquip"))) {
            int buttonSlot = event.getSlot();
            ItemStack item = event.getClickedInventory().getItem(buttonSlot - 9);
            String[] itemData = ItemCatalog.getCatalogItem("gun", ChatColor.stripColor(item.getItemMeta().getDisplayName()));

            assert itemData != null;
            if (itemData[1].equals("secondary")) {
                if (lastSecondaryGun != null) {
                    event.getClickedInventory().setItem(lastSecondaryButtonSlot, GetButtonUtility.getButton("equip"));
                    unequipGun(player, itemData[1]);
                } else {
                    lastSecondaryButtonSlot = buttonSlot;
                    event.getClickedInventory().setItem(lastSecondaryButtonSlot, GetButtonUtility.getButton("equip"));
                }
                lastSecondaryButtonSlot = buttonSlot;
            } else {
                if (lastGun != null) {
                    event.getClickedInventory().setItem(lastButtonSlot, GetButtonUtility.getButton("equip"));
                    unequipGun(player, itemData[1]);
                } else {
                    lastButtonSlot = buttonSlot;
                    event.getClickedInventory().setItem(lastButtonSlot, GetButtonUtility.getButton("equip"));
                }

                lastButtonSlot = buttonSlot;
            }

            equipGun(player, itemData[0], itemData[1], itemData[2], itemData[3], Integer.parseInt(itemData[4]), itemData[5]);
            player.sendMessage(item.getItemMeta().getDisplayName() + ChatColor.GREEN + " was equipped");
            event.getClickedInventory().setItem(buttonSlot, GetButtonUtility.getButton("unequip"));


            event.setCancelled(true);

        } else if (buttonName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lUnequip"))) {
            int buttonSlot = event.getSlot();
            ItemStack item = event.getClickedInventory().getItem(buttonSlot - 9);
            String[] itemData = ItemCatalog.getCatalogItem("gun", ChatColor.stripColor(item.getItemMeta().getDisplayName()));

            assert itemData != null;
            unequipGun(player, itemData[1]);
            player.sendMessage(item.getItemMeta().getDisplayName() + ChatColor.RED + " was unequipped");
            event.getClickedInventory().setItem(buttonSlot, GetButtonUtility.getButton("equip"));

            event.setCancelled(true);
        }

    }

}
