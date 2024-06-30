package me.ducky.projectg.menu;

import me.ducky.projectg.util.GetMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {

            if (sender instanceof Player) {
                Player player = (Player) sender;

                player.openInventory(GetMenuUtility.getMenu(player, "menu"));

            }

        } else if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);

            player.openInventory(GetMenuUtility.getMenu(player, "menu"));

        } else {

            return false;

        }

        return true;
    }
}
