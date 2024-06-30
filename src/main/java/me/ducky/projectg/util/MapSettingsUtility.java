package com.duckysmacky.projectg.util;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static org.bukkit.Bukkit.getServer;


public class MapSettingsUtility implements Listener {

    @EventHandler
    public static void teamsFunction(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory menu = event.getClickedInventory();
        String buttonName = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName());
        World world = Bukkit.getServer().getWorld(player.getWorld().getName());

        if (event.getInventory().getTitle().equalsIgnoreCase("Map Settings")) {

            if (buttonName.equals("Clear Yourself")) {

                player.getInventory().clear();
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lAll items removed"));

            }
            else if (buttonName.equals("Spectator Mode")) {

                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lGamemode switched to spectator"));

            }
            else if (buttonName.equals("Kill Yourself")) {

                player.setHealth(0);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lWell... you killed yourself"));

            }
            else if (buttonName.equals("Clear Floor Loot")) {

                String command = "kill @e[type=item]";
                getServer().dispatchCommand(getServer().getConsoleSender(), command);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&a&lFloor items cleared"));

            } else if (buttonName.equals("On") || buttonName.equals("Off")) {
                int buttonSlot = event.getSlot();
                buttonName = ChatColor.stripColor(menu.getItem(event.getSlot() - 9).getItemMeta().getDisplayName());

                if (buttonName.equals("Fire Spread")) {

                    if (world.getGameRuleValue("doFireTick").equals("false")) {

                        world.setGameRuleValue("doFireTick", "true");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("on"));

                    } else if (world.getGameRuleValue("doFireTick").equals("true")) {

                        world.setGameRuleValue("doFireTick", "false");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("off"));

                    }

                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + buttonName + " &a&lwas set to &f&l" + world.getGameRuleValue("doFireTick")));

                } else if (buttonName.equals("Block Drops")) {

                    if (world.getGameRuleValue("doTileDrops").equals("false")) {

                        world.setGameRuleValue("doTileDrops", "true");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("on"));

                    } else if (world.getGameRuleValue("doTileDrops").equals("true")) {

                        world.setGameRuleValue("doTileDrops", "false");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("off"));

                    }

                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + buttonName + " &a&lwas set to &f&l" + world.getGameRuleValue("doTileDrops")));

                } else if (buttonName.equals("Weather Cycle")) {

                    if (world.getGameRuleValue("doWeatherCycle").equals("false")) {

                        world.setGameRuleValue("doWeatherCycle", "true");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("on"));

                    } else if (world.getGameRuleValue("doWeatherCycle").equals("true")) {

                        world.setGameRuleValue("doWeatherCycle", "false");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("off"));

                    }

                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + buttonName + " &a&lwas set to &f&l" + world.getGameRuleValue("doWeatherCycle")));

                } else if (buttonName.equals("Daylight Cycle")) {

                    if (world.getGameRuleValue("doDaylightCycle").equals("false")) {

                        world.setGameRuleValue("doDaylightCycle", "true");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("on"));

                    } else if (world.getGameRuleValue("doDaylightCycle").equals("true")) {

                        world.setGameRuleValue("doDaylightCycle", "false");
                        menu.setItem(buttonSlot, GetButtonUtility.getButton("off"));

                    }

                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&f&l" + buttonName + " &a&lwas set to &f&l" + world.getGameRuleValue("doDaylightCycle")));

                }
            }
        }

    }

    public static Inventory getMapSettingsMenu(Player player) {
        Inventory menu = Bukkit.createInventory(player, 9 * 6, "Map Settings");
        World world = Bukkit.getServer().getWorld(player.getWorld().getName());

        ItemStack clear = new ItemStack(Material.BUCKET);
        ItemMeta clearMeta = clear.getItemMeta();
        clearMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lClear Yourself"));
        clear.setItemMeta(clearMeta);
        menu.setItem(3 + 9, clear);

        ItemStack spectator = new ItemStack(Material.EYE_OF_ENDER);
        ItemMeta spectatorMeta = spectator.getItemMeta();
        spectatorMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSpectator Mode"));
        spectator.setItemMeta(spectatorMeta);
        menu.setItem(4 + 9, spectator);

        ItemStack kill = new ItemStack(Material.SKULL_ITEM);
        ItemMeta killMeta = kill.getItemMeta();
        killMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lKill Yourself"));
        kill.setItemMeta(killMeta);
        menu.setItem(5 + 9, kill);

        ItemStack fireTick = new ItemStack(Material.LAVA_BUCKET);
        ItemMeta fireTickMeta = fireTick.getItemMeta();
        fireTickMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lFire Spread"));
        fireTick.setItemMeta(fireTickMeta);
        menu.setItem(2 + 9 * 3, fireTick);
        if (world.getGameRuleValue("doFireTick").equals("true")) {
            menu.setItem(2 + 9 * 4, GetButtonUtility.getButton("on"));
        } else if (world.getGameRuleValue("doFireTick").equals("false")) {
            menu.setItem(2 + 9 * 4, GetButtonUtility.getButton("off"));
        }

        ItemStack tileDrops = new ItemStack(Material.COBBLESTONE);
        ItemMeta tileDropsMeta = tileDrops.getItemMeta();
        tileDropsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lBlock Drops"));
        tileDrops.setItemMeta(tileDropsMeta);
        menu.setItem(3 + 9 * 3, tileDrops);
        if (world.getGameRuleValue("doTileDrops").equals("true")) {
            menu.setItem(3 + 9 * 4, GetButtonUtility.getButton("on"));
        } else if (world.getGameRuleValue("doTileDrops").equals("false")) {
            menu.setItem(3 + 9 * 4, GetButtonUtility.getButton("off"));
        }

        ItemStack floorLoot = new ItemStack(Material.FEATHER);
        ItemMeta floorLootMeta = floorLoot.getItemMeta();
        floorLootMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lClear Floor Loot"));
        floorLoot.setItemMeta(floorLootMeta);
        menu.setItem(4 + 9 * 3, floorLoot);

        ItemStack weatherCycle = new ItemStack(Material.WATER_BUCKET);
        ItemMeta weatherCycleMeta = weatherCycle.getItemMeta();
        weatherCycleMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lWeather Cycle"));
        weatherCycle.setItemMeta(weatherCycleMeta);
        menu.setItem(5 + 9 * 3, weatherCycle);
        if (world.getGameRuleValue("doWeatherCycle").equals("true")) {
            menu.setItem(5 + 9 * 4, GetButtonUtility.getButton("on"));
        } else if (world.getGameRuleValue("doWeatherCycle").equals("false")) {
            menu.setItem(5 + 9 * 4, GetButtonUtility.getButton("off"));
        }

        ItemStack dayCycle = new ItemStack(Material.WATCH);
        ItemMeta dayCycleMeta = dayCycle.getItemMeta();
        dayCycleMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lDaylight Cycle"));
        dayCycle.setItemMeta(dayCycleMeta);
        menu.setItem(6 + 9 * 3, dayCycle);
        if (world.getGameRuleValue("doDaylightCycle").equals("true")) {
            menu.setItem(6 + 9 * 4, GetButtonUtility.getButton("on"));
        } else if (world.getGameRuleValue("doDaylightCycle").equals("false")) {
            menu.setItem(6 + 9 * 4, GetButtonUtility.getButton("off"));
        }




        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
        backButton.setItemMeta(backButtonMeta);
        menu.setItem(4 + 9 * 5, backButton);

        return menu;

    }

}
