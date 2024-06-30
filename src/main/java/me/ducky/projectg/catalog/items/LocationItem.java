package me.ducky.projectg.catalog.items;

import me.ducky.projectg.catalog.enums.City;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class LocationItem {
    private City city;
    private String name;
    private int x;
    private int y;
    private int z;

    public LocationItem(City city, String name, String x, String y, String z) {
        this.city = city;
        this.name = name;
        this.x = Integer.parseInt(x);
        this.y = Integer.parseInt(y);
        this.z = Integer.parseInt(z);
    }

    public City getCity() {
        return city;
    }

    public ItemStack getDisplayItem() {
        return new ItemStack(Material.ENDER_PEARL);
    }

    public String getDisplayName() {
        return ChatColor.translateAlternateColorCodes('&', "&a&l" + name);
    }

    public String getDisplayCoordinates() {
        return String.format(
            "%s%s %s %s",
            ChatColor.BOLD,
            x, y, z
        );
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }
}
