package me.ducky.projectg.functions;

import me.ducky.projectg.catalog.catalogs.GunCatalog;
import me.ducky.projectg.catalog.enums.GunClass;
import me.ducky.projectg.catalog.items.GunItem;
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

    public void equipGun(Player player, GunItem gun) {
        ItemStack item = new ItemStack(Material.valueOf(gun.getGunId()));
        ItemMeta itemMeta = item.getItemMeta();

        itemMeta.setDisplayName(gun.getDisplayName());
        List<String> lore = new ArrayList<>();
        lore.add(gun.getDisplayRarity());
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);

        int gunIndex = 0;
        int ammoIndex = 9 * 3;

        if (gun.getGunClass() == GunClass.SECONDARY) {
            gunIndex += 1;
            ammoIndex += 1;
        }

        player.getInventory().setItem(gunIndex, item);

        if (gun.getAmmoAmout() > 64) {
            int ammoStacksAmount = gun.getAmmoAmout() / 64;

            for (int i = 0; i < ammoStacksAmount; i++) {

                ItemStack ammo = new ItemStack(Material.valueOf(gun.getAmmoId()), 64);
                player.getInventory().addItem(ammo);

            }

        } else {

            ItemStack ammo = new ItemStack(Material.valueOf(gun.getAmmoId()), gun.getAmmoAmout());
            player.getInventory().setItem(ammoIndex, ammo);

        }

        if (gun.getGunClass() == GunClass.SECONDARY) {
            lastSecondaryGun = Material.valueOf(gun.getGunId());
            lastSecondaryAmmo = Material.valueOf(gun.getAmmoId());
        } else {
            lastGun = Material.valueOf(gun.getGunId());
            lastAmmo = Material.valueOf(gun.getAmmoId());
        }

    }

    public void unequipGun(Player player, GunClass gunClass) {
        if (gunClass == GunClass.SECONDARY) {
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
        if (event.getCurrentItem() == null) return;
        ItemStack button = event.getCurrentItem();
        String buttonName = button.getItemMeta().getDisplayName();

        if (buttonName.equals(ChatColor.translateAlternateColorCodes('&', "&a&lEquip"))) {
            int buttonSlot = event.getSlot();
            ItemStack item = event.getClickedInventory().getItem(buttonSlot - 9);
            GunItem gunData = null;

            for (GunItem gun : GunCatalog.LIST) {
                if (ChatColor.stripColor(gun.getDisplayName()).equals(item.getItemMeta().getDisplayName())) gunData = gun;
            }

            assert gunData != null;
            if (gunData.getGunClass() == GunClass.SECONDARY) {
                if (lastSecondaryGun != null) {
                    event.getClickedInventory().setItem(lastSecondaryButtonSlot, GetButtonUtility.getButton("equip"));
                    unequipGun(player, gunData.getGunClass());
                } else {
                    lastSecondaryButtonSlot = buttonSlot;
                    event.getClickedInventory().setItem(lastSecondaryButtonSlot, GetButtonUtility.getButton("equip"));
                }
                lastSecondaryButtonSlot = buttonSlot;
            } else {
                if (lastGun != null) {
                    event.getClickedInventory().setItem(lastButtonSlot, GetButtonUtility.getButton("equip"));
                    unequipGun(player, gunData.getGunClass());
                } else {
                    lastButtonSlot = buttonSlot;
                    event.getClickedInventory().setItem(lastButtonSlot, GetButtonUtility.getButton("equip"));
                }

                lastButtonSlot = buttonSlot;
            }

            equipGun(player, gunData);
            player.sendMessage(item.getItemMeta().getDisplayName() + ChatColor.GREEN + " was equipped");
            event.getClickedInventory().setItem(buttonSlot, GetButtonUtility.getButton("unequip"));


            event.setCancelled(true);

        } else if (buttonName.equals(ChatColor.translateAlternateColorCodes('&', "&c&lUnequip"))) {
            int buttonSlot = event.getSlot();
            ItemStack item = event.getClickedInventory().getItem(buttonSlot - 9);
            GunItem gunData = null;

            for (GunItem gun : GunCatalog.LIST) {
                if (ChatColor.stripColor(gun.getDisplayName()).equals(item.getItemMeta().getDisplayName())) gunData = gun;
            }

            assert gunData != null;
            unequipGun(player, gunData.getGunClass());
            player.sendMessage(item.getItemMeta().getDisplayName() + ChatColor.RED + " was unequipped");
            event.getClickedInventory().setItem(buttonSlot, GetButtonUtility.getButton("equip"));

            event.setCancelled(true);
        }

    }

}
