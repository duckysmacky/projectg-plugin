package me.ducky.projectg.catalog.items;

import me.ducky.projectg.catalog.enums.KitClass;
import me.ducky.projectg.catalog.enums.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class KitItem implements RarityItem {
    private String displayItem;
    private String id;
    private KitClass kitClass;
    private Rarity rarity;
    private String description;

    public KitItem(String displayItem, String id, KitClass kitClass, Rarity rarity, String description) {
        this.displayItem = displayItem;
        this.id = id;
        this.kitClass = kitClass;
        this.rarity = rarity;
        this.description = description;
    }

    @Override
    public String getDisplayRarity() {
        ChatColor accentColor;
        String rarityTitle;
        switch (this.rarity) {
            case UNCOMMON:
                accentColor = ChatColor.BLUE;
                rarityTitle = "ADVANCED";
                break;
            case RARE:
                accentColor = ChatColor.LIGHT_PURPLE;
                rarityTitle = "COMPLEX";
                break;
            case EPIC:
                accentColor = ChatColor.DARK_PURPLE;
                rarityTitle = "PROFESSIONAL";
                break;
            case LEGENDARY:
                accentColor = ChatColor.DARK_RED;
                rarityTitle = "ELITE";
                break;
            default:
                accentColor = ChatColor.WHITE;
                rarityTitle = "BASIC";
                break;
        }

        String displayRarity = String.format(
            "%s%s%s KIT",
            accentColor,
            ChatColor.BOLD,
            rarityTitle
        );

        return displayRarity;
    }

    public ItemStack getDisplayItem() {
        return new ItemStack(Material.valueOf(this.displayItem));
    }

    public String getDisplayName() {
        String name = id.substring(0, 1).toUpperCase() + id.substring(1);
        String displayName = String.format(
            "%s%s%s Kit",
            ChatColor.WHITE,
            ChatColor.BOLD,
            name
        );

        return displayName;
    }

    public String getId() {
        return id;
    }

    public KitClass getKitClass() {
        return kitClass;
    }

    public String getDescription() {
        return ChatColor.translateAlternateColorCodes('&', this.description);
    }
}
