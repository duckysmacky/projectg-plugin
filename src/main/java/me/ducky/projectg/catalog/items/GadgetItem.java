package me.ducky.projectg.catalog.items;

import me.ducky.projectg.catalog.enums.Rarity;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class GadgetItem implements RarityItem {
    private String name;
    private String id;
    private int amount;
    private Rarity rarity;

    public GadgetItem(String name, String id, int amount, Rarity rarity) {
        this.name = name;
        this.id = id;
        this.amount = amount;
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
            "%s%s%s GADGET",
            accentColor,
            ChatColor.BOLD,
            rarityTitle
        );

        return displayRarity;
    }

    public ItemStack getDisplayItem() {
        return new ItemStack(Material.valueOf(this.id));
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

    public String getId() {
        return id;
    }

    public int getAmount() {
        return amount;
    }
}
