package me.ducky.projectg.catalog.items;

import me.ducky.projectg.catalog.enums.Menu;
import org.bukkit.ChatColor;

public class MenuItem {
    private Menu menu;
    private String name;

    public MenuItem(Menu menu) {
        this.menu = menu;
        this.name = getName();
    }

    public Menu getMenu() {
        return menu;
    }

    public String getButtonName() {
        return ChatColor.translateAlternateColorCodes('&', "&f&l" + name);
    }

    public String getName() {
        switch (menu) {
            case EQUIPMENT: return "Equipment";
            case LOCATIONS: return "Locations";
            case SETTINGS: return "Settings";
            case KITS: return "Kits";
            case GUNS: return "Guns";
            case GADGETS: return "Gadgets";
            case CITY_NEWPORT: return "Newport City";
            case CITY_RADIANT: return "Radiant City";
            case CITY_SHMAR: return "Shmar City";
            case CITY_AUDIA: return "Audia City";
            case CITY_CITY_17: return "City 17";
            case MAP_SETTINGS: return "Map Settings";
            case TEAMS: return "Teams";
            default: return "Menu";
        }
    }

    public MenuItem getPreviousMenu() {
        switch (menu) {
            case EQUIPMENT: case LOCATIONS: case SETTINGS: return new MenuItem(Menu.MENU);
            case KITS: case GUNS: case GADGETS: return new MenuItem(Menu.EQUIPMENT);
            case CITY_NEWPORT: case CITY_RADIANT: case CITY_SHMAR: case CITY_AUDIA: case CITY_CITY_17: return new MenuItem(Menu.LOCATIONS);
            case MAP_SETTINGS: case TEAMS: return new MenuItem(Menu.SETTINGS);
            default: return new MenuItem(Menu.EXIT);
        }
    }
}
