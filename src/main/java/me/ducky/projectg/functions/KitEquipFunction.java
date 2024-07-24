package me.ducky.projectg.functions;

import me.ducky.projectg.menu.ItemCatalog;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Random;

import static org.bukkit.Bukkit.getServer;

public class  KitEquipFunction{

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
            String kitID = kitData[2];

            String command = "csg_kit give " + kitID + " " + player.getDisplayName();
            getServer().dispatchCommand(getServer().getConsoleSender(), command);

            GunEquipFunction gunEquipFunction = new GunEquipFunction();
            switch (kitID) {
                case "sniper": {
                    gunEquipFunction.equipGun(player, "NTW-20", "sniper_rifle", "MW_NTW_20", "MW_NTW20MAG", 3, "legendary");
                    break;
                }
                case "juggernaut": {
                    gunEquipFunction.equipGun(player, "M138 Minigun", "lmg", "MW_M134", "MW_M134MAG", 2, "legendary");
                    break;
                }
                case "chainsaw": {
                    gunEquipFunction.equipGun(player, "Chainsaw", "special", "MW_CHAINSAW", "MW_FUELCELL", 1, "legendary");
                    break;
                }
            }

            player.sendMessage(kitName + ChatColor.GREEN + " was equipped");
        }

    }

}
