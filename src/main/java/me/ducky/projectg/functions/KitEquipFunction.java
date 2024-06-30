package me.ducky.projectg.functions;

import me.ducky.projectg.catalog.catalogs.KitCatalog;
import me.ducky.projectg.catalog.items.KitItem;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public class KitEquipFunction{

    public static void equipKit(Player player, String kitName) {
        if (kitName.equals("random")) {
            KitItem kitData = null;
            for (KitItem kit : KitCatalog.LIST) {
                if (ChatColor.stripColor(kit.getDisplayName()).equals(kitName)) kitData = kit;
            }

            Random random = new Random();
            int randomKit = random.nextInt(KitCatalog.LIST.size()) + 1;

            String command = "csg_kit give " + KitCatalog.LIST.get(randomKit).getId() + " " + player.getDisplayName();
            getServer().dispatchCommand(getServer().getConsoleSender(), command);
            player.sendMessage(KitCatalog.LIST.get(randomKit).getDisplayName() + ChatColor.GREEN + " was equipped");
        } else {
            KitItem kitData = null;
            for (KitItem kit : KitCatalog.LIST) {
                if (ChatColor.stripColor(kit.getDisplayName()).equals(kitName)) kitData = kit;
            }

            String command = "csg_kit give " + kitData.getId() + " " + player.getDisplayName();
            getServer().dispatchCommand(getServer().getConsoleSender(), command);
            player.sendMessage(kitName + ChatColor.GREEN + " was equipped");

        }

    }

}
