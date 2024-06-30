package me.ducky.projectg;

import me.ducky.projectg.functions.GadgetEquipFunction;
import me.ducky.projectg.functions.GunEquipFunction;
import me.ducky.projectg.listeners.MenuClickListener;
import me.ducky.projectg.util.LocationsMenuUtility;
import me.ducky.projectg.util.MapSettingsUtility;
import me.ducky.projectg.util.TeamsMenuUtility;
import me.ducky.projectg.menu.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class ProjectG extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("---------------- Project G Official Plugin is starting ----------------");

        getCommand("menu").setExecutor(new MenuCommand());

        getServer().getPluginManager().registerEvents(new MenuClickListener(), this);
        getServer().getPluginManager().registerEvents(new GunEquipFunction(), this);
        getServer().getPluginManager().registerEvents(new TeamsMenuUtility(), this);
        getServer().getPluginManager().registerEvents(new MapSettingsUtility(), this);
        getServer().getPluginManager().registerEvents(new LocationsMenuUtility(), this);
        getServer().getPluginManager().registerEvents(new GadgetEquipFunction(), this);

    }
}
