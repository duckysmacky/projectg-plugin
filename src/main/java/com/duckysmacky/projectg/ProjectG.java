package com.duckysmacky.projectg;

import com.duckysmacky.projectg.functions.GadgetEquipFunction;
import com.duckysmacky.projectg.functions.GunEquipFunction;
import com.duckysmacky.projectg.listeners.MenuClickListener;
import com.duckysmacky.projectg.menu.*;
import com.duckysmacky.projectg.util.LocationsMenuUtility;
import com.duckysmacky.projectg.util.MapSettingsUtility;
import com.duckysmacky.projectg.util.TeamsMenuUtility;
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
