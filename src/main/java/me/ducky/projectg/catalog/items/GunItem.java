package me.ducky.projectg.catalog.items;

import me.ducky.projectg.catalog.enums.GunClass;
import me.ducky.projectg.catalog.enums.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GunItem implements RarityItem {
    private String name;
    private GunClass gunClass;
    private String gunId;
    private String ammoId;
    private int ammoAmout;
    private Rarity rarity;

    public GunItem(String name, GunClass gunClass, String gunId, String ammoId, int ammoAmout, Rarity rarity) {
        this.name = name;
        this.gunClass = gunClass;
        this.gunId = gunId;
        this.ammoId = ammoId;
        this.ammoAmout = ammoAmout;
        this.rarity = rarity;
    }

    @Override
    public String getDisplayRarity() {
        ChatColor accentColor;
        String rarityTitle;
        switch (this.rarity) {
            case UNCOMMON:
                accentColor = ChatColor.GRAY;
                rarityTitle = "UNCOMMON";
                break;
            case RARE:
                accentColor = ChatColor.AQUA;
                rarityTitle = "RARE";
                break;
            case EPIC:
                accentColor = ChatColor.BLUE;
                rarityTitle = "EPIC";
                break;
            case LEGENDARY:
                accentColor = ChatColor.DARK_PURPLE;
                rarityTitle = "LEGENDARY";
                break;
            default:
                accentColor = ChatColor.GOLD;
                rarityTitle = "COMMON";
                break;
        }

        String displayRarity = String.format(
            "%s%s%s WEAPON",
            accentColor,
            ChatColor.BOLD,
            rarityTitle
        );

        return displayRarity;
    }

    public ItemStack getDisplayItem() {
        return new ItemStack(Material.valueOf(this.gunId));
    }

    public String getDisplayName() {
        ChatColor accentColor;
        switch (this.rarity) {
            case UNCOMMON: accentColor = ChatColor.GRAY; break;
            case RARE: accentColor = ChatColor.AQUA; break;
            case EPIC: accentColor = ChatColor.BLUE; break;
            case LEGENDARY: accentColor = ChatColor.DARK_PURPLE; break;
            default: accentColor = ChatColor.GOLD; break;
        }

        String displayName = String.format(
            "%s%s%s",
            accentColor,
            ChatColor.BOLD,
            name
        );

        return displayName;
    }

    public GunClass getGunClass() {
        return this.gunClass;
    }

    public String getGunId() {
        return gunId;
    }

    public String getAmmoId() {
        return ammoId;
    }

    public int getAmmoAmout() {
        return ammoAmout;
    }
}
