package com.duckysmacky.projectg.functions;

import com.duckysmacky.projectg.menu.ItemCatalog;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public class KitEquipFunction{

    public static void equipKit(Player player, String kitName) {

        if (kitName.equals("random")) {
            String[][] kitCatalog = ItemCatalog.getCatalog("kit");
            Random random = new Random();
            int randomKit = random.nextInt(kitCatalog.length) + 1;


            String command = "csg_kit give " + kitCatalog[randomKit][2] + " " + player.getDisplayName();
            getServer().dispatchCommand(getServer().getConsoleSender(), command);
            player.sendMessage(kitCatalog[randomKit][0] + ChatColor.GREEN + " was equipped");

        } else {

            String[] kitData = ItemCatalog.getCatalogItem("kit", ChatColor.stripColor(kitName));

            String command = "csg_kit give " + kitData[2] + " " + player.getDisplayName();
            getServer().dispatchCommand(getServer().getConsoleSender(), command);
            player.sendMessage(kitName + ChatColor.GREEN + " was equipped");

        }

    }

}
