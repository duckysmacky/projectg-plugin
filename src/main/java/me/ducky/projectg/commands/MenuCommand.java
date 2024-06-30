package me.ducky.projectg.commands;

import me.ducky.projectg.catalog.enums.Menu;
import me.ducky.projectg.util.MenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MenuCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 && sender instanceof Player) {
            Player player = (Player) sender;
            player.openInventory(MenuUtility.getMenu(player, Menu.MENU));
            return true;
        } else if (args.length == 1) {
            Player player = Bukkit.getPlayer(args[0]);
            player.openInventory(MenuUtility.getMenu(player, Menu.MENU));
            return true;
        } else return false;
    }
}
