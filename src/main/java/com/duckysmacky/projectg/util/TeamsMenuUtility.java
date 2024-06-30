package com.duckysmacky.projectg.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

import static org.bukkit.Bukkit.getServer;

public class TeamsMenuUtility implements Listener {

    @EventHandler
    public static void teamsFunction(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        String buttonName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());

        if (event.getInventory().getTitle().equalsIgnoreCase("Teams")) {

            if (buttonName.equals("Quick Setup")) {

                String command = "scoreboard objectives add Deaths deathCount";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard objectives setdisplay sidebar Deaths";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams add ffa";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams add blue";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams add red";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams add yellow";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams add green";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams option ffa nametagVisibility never";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams option blue nametagVisibility hideForOtherTeams";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams option red nametagVisibility hideForOtherTeams";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams option yellow nametagVisibility hideForOtherTeams";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                command = "scoreboard teams option green nametagVisibility hideForOtherTeams";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lTeam setup complete"));

            } else if (buttonName.equals("FFA")) {

                String command = "scoreboard teams join ffa @a";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a&lGamemode switched to FFA"));

            } else if (buttonName.equals("Join Blue Team")) {

                String command = "scoreboard teams join blue " + player.getDisplayName();
                getServer().dispatchCommand(getServer().getConsoleSender(), command);

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + player.getDisplayName() + " &a&ljoined the &9&lBlue &a&lteam!"));

            } else if (buttonName.equals("Join Red Team")) {

                String command = "scoreboard teams join red " + player.getDisplayName();
                getServer().dispatchCommand(getServer().getConsoleSender(), command);

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + player.getDisplayName() + " &a&ljoined the &c&lRed &a&lteam!"));

            } else if (buttonName.equals("Join Yellow Team")) {

                String command = "scoreboard teams join yellow " + player.getDisplayName();
                getServer().dispatchCommand(getServer().getConsoleSender(), command);

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + player.getDisplayName() + " &a&ljoined the &e&lYellow &a&lteam!"));

            } else if (buttonName.equals("Join Green Team")) {

                String command = "scoreboard teams join green " + player.getDisplayName();
                getServer().dispatchCommand(getServer().getConsoleSender(), command);

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + player.getDisplayName() + " &a&ljoined the &a&lGreen &a&lteam!"));

            } else if (buttonName.equals("Reset Deaths")) {

                String command = "scoreboard players set @a Deaths 0";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&a&lDeaths were reset"));

            }
            //        } else if (buttonName.equals("Off")) {
            //            int buttonSlot = event.getSlot() - 9;
            //            buttonName = ChatColor.stripColor(event.getInventory().getItem(buttonSlot).getItemMeta().getDisplayName());
            //
            //            if (buttonName.equals("Show Enemy Name Tags")) {
            //
            //                String command = "scoreboard teams option ffa nametagVisibility always";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option blue nametagVisibility always";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option red nametagVisibility always";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option yellow nametagVisibility always";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option green nametagVisibility always";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //
            //                event.getClickedInventory().setItem(event.getSlot(), GetButtonUtility.getButton("on"));
            //
            //            } else if (buttonName.equals("Friendly Fire")) {
            //
            //                String command = "scoreboard teams option ffa friendlyfire true";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option blue friendlyfire true";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option red friendlyfire true";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option yellow friendlyfire true";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option green friendlyfire true";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //
            //                event.getClickedInventory().setItem(event.getSlot(), GetButtonUtility.getButton("on"));
            //
            //            }
            //
            //        } else if (buttonName.equals("On")) {
            //            int buttonSlot = event.getSlot() - 9;
            //            buttonName = ChatColor.stripColor(event.getInventory().getItem(buttonSlot).getItemMeta().getDisplayName());
            //
            //            if (buttonName.equals("Show Enemy Name Tags")) {
            //
            //                String command = "scoreboard teams option ffa nametagVisibility hideForOtherTeams";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option blue nametagVisibility hideForOtherTeams";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option red nametagVisibility hideForOtherTeams";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option yellow nametagVisibility hideForOtherTeams";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option green nametagVisibility hideForOtherTeams";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //
            //                event.getClickedInventory().setItem(event.getSlot(), GetButtonUtility.getButton("off"));
            //
            //            } else if (buttonName.equals("Friendly Fire")) {
            //
            //                String command = "scoreboard teams option ffa friendlyfire false";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option blue friendlyfire false";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option red friendlyfire false";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option yellow friendlyfire false";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //                command = "scoreboard teams option green friendlyfire false";
            //                getServer().dispatchCommand(getServer().getConsoleSender(), command);
            //
            //                event.getClickedInventory().setItem(event.getSlot(), GetButtonUtility.getButton("off"));
            //
            //            }
            //
            //        }
        }

    }

    public static Inventory getTeamsMenu(Player player) {
        Inventory menu = Bukkit.createInventory(player, 9 * 3, "Teams");

        ItemStack setup = new ItemStack(Material.REDSTONE_TORCH_ON);
        ItemMeta setupMeta = setup.getItemMeta();
        setupMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lQuick Setup"));
        List<String> setupLore = new ArrayList<>();
        setupLore.add(ChatColor.translateAlternateColorCodes('&', "&fCreate teams and add scoreboard with deaths"));
        setupMeta.setLore(setupLore);
        setup.setItemMeta(setupMeta);
        menu.setItem(9, setup);

        ItemStack ffa = new ItemStack(Material.SLIME_BALL);
        ItemMeta ffaMeta = ffa.getItemMeta();
        ffaMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lFFA"));
        ffa.setItemMeta(ffaMeta);
        menu.setItem(2 + 9, ffa);

        ItemStack teamBlue = new ItemStack(Material.INK_SACK, 1, (short)6);
        ItemMeta teamBlueMeta = teamBlue.getItemMeta();
        teamBlueMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lJoin &9&lBlue &a&lTeam"));
        teamBlue.setItemMeta(teamBlueMeta);
        menu.setItem(3 + 9, teamBlue);

        ItemStack redTeam = new ItemStack(Material.INK_SACK, 1, (short)1);
        ItemMeta redTeamMeta = redTeam.getItemMeta();
        redTeamMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lJoin &c&lRed &a&lTeam"));
        redTeam.setItemMeta(redTeamMeta);
        menu.setItem(4 + 9, redTeam);

        ItemStack yellowTeam = new ItemStack(Material.INK_SACK, 1, (short)11);
        ItemMeta yellowTeamMeta = yellowTeam.getItemMeta();
        yellowTeamMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lJoin &e&lYellow &a&lTeam"));
        yellowTeam.setItemMeta(yellowTeamMeta);
        menu.setItem(5 + 9, yellowTeam);

        ItemStack greenTeam = new ItemStack(Material.INK_SACK, 1, (short)2);
        ItemMeta greenTeamMeta = greenTeam.getItemMeta();
        greenTeamMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lJoin &a&lGreen &a&lTeam"));
        greenTeam.setItemMeta(greenTeamMeta);
        menu.setItem(6 + 9, greenTeam);

//        ItemStack nametags = new ItemStack(Material.NAME_TAG);
//        ItemMeta nametagsMeta = nametags.getItemMeta();
//        nametagsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lShow Enemy Name Tags"));
//        List<String> nametagsLore = new ArrayList<>();
//        nametagsLore.add(ChatColor.translateAlternateColorCodes('&', "&fToggle name tag visibility between enemy teams"));
//        nametagsMeta.setLore(nametagsLore);
//        nametags.setItemMeta(nametagsMeta);
//        menu.setItem(1 + 9 * 3, nametags);
//        menu.setItem(1 + 9 * 4, GetButtonUtility.getButton("off"));

//        ItemStack friendlyFire = new ItemStack(Material.IRON_SWORD);
//        ItemMeta friendlyFireMeta = friendlyFire.getItemMeta();
//        friendlyFireMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lFriendly Fire"));
//        List<String> friendlyFireLore = new ArrayList<>();
//        friendlyFireLore.add(ChatColor.translateAlternateColorCodes('&', "&fToggle friendly fire between allies"));
//        friendlyFireMeta.setLore(friendlyFireLore);
//        friendlyFire.setItemMeta(friendlyFireMeta);
//        menu.setItem(2 + 9 * 3, friendlyFire);
//        menu.setItem(2 + 9 * 4, GetButtonUtility.getButton("off"));

        ItemStack resetDeaths = new ItemStack(Material.TOTEM);
        ItemMeta resetDeathsMeta = resetDeaths.getItemMeta();
        resetDeathsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lReset Deaths"));
        resetDeaths.setItemMeta(resetDeathsMeta);
        menu.setItem(8 + 9, resetDeaths);




        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
        backButton.setItemMeta(backButtonMeta);
        menu.setItem(4 + 9 * 2, backButton);

        return menu;

    }

}
