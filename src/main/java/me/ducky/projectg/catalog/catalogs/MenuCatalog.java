package me.ducky.projectg.catalog.catalogs;

import me.ducky.projectg.catalog.enums.Menu;
import me.ducky.projectg.catalog.items.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuCatalog {
    public static final List<MenuItem> LIST;

    static {
        LIST = new ArrayList<>();
        LIST.add(new MenuItem(Menu.MENU));
        LIST.add(new MenuItem(Menu.EQUIPMENT));
        LIST.add(new MenuItem(Menu.LOCATIONS));
        LIST.add(new MenuItem(Menu.SETTINGS));
        LIST.add(new MenuItem(Menu.KITS));
        LIST.add(new MenuItem(Menu.GUNS));
        LIST.add(new MenuItem(Menu.GADGETS));
        LIST.add(new MenuItem(Menu.CITY_NEWPORT));
        LIST.add(new MenuItem(Menu.CITY_RADIANT));
        LIST.add(new MenuItem(Menu.CITY_SHMAR));
        LIST.add(new MenuItem(Menu.CITY_AUDIA));
        LIST.add(new MenuItem(Menu.CITY_CITY_17));
        LIST.add(new MenuItem(Menu.MAP_SETTINGS));
        LIST.add(new MenuItem(Menu.TEAMS));
    }
}
