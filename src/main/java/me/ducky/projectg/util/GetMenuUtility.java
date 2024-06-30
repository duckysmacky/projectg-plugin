package com.duckysmacky.projectg.util;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GetMenuUtility {

    public static Inventory getMenu(Player player, String menuType) {

        switch (menuType) {
            case "menu": {
                Inventory menu = Bukkit.createInventory(player, 9 * 3, "Menu");

                ItemStack pickaxe = new ItemStack(Material.IRON_PICKAXE);
                ItemMeta pickaxeMeta = pickaxe.getItemMeta();
                pickaxeMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lEquipment"));
                pickaxe.setItemMeta(pickaxeMeta);
                menu.setItem(1 + 9, pickaxe);

                ItemStack pearl = new ItemStack(Material.COMPASS);
                ItemMeta pearlMeta = pearl.getItemMeta();
                pearlMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lTeleports"));
                pearl.setItemMeta(pearlMeta);
                menu.setItem(4 + 9, pearl);

                ItemStack compass = new ItemStack(Material.REDSTONE_COMPARATOR);
                ItemMeta compassMeta = compass.getItemMeta();
                compassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lSettings"));
                compass.setItemMeta(compassMeta);
                menu.setItem(7 + 9, compass);

                return menu;

            }
            case "equipment": {
                Inventory menu = Bukkit.createInventory(player, 9 * 3, "Equipment");

                ItemStack kits = new ItemStack(Material.valueOf("MW_ASSAULT_BACKPACK"));
                ItemMeta kitsMeta = kits.getItemMeta();
                kitsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lKits"));
                List<String> kitsLore = new ArrayList<>();
                kitsLore.add(ChatColor.translateAlternateColorCodes('&', "&c&lWARNING: &bEquipping any kit clears inventory, recommended to equip a kit first"));
                kitsMeta.setLore(kitsLore);
                kits.setItemMeta(kitsMeta);
                menu.setItem(2 + 9, kits);

                ItemStack guns = new ItemStack(Material.valueOf("MW_M4A1"));
                ItemMeta gunsMeta = guns.getItemMeta();
                gunsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lGuns"));
                guns.setItemMeta(gunsMeta);
                menu.setItem(4 + 9, guns);

                ItemStack gadgets = new ItemStack(Material.valueOf("MW_TABLET"));
                ItemMeta gadgetsMeta = gadgets.getItemMeta();
                gadgetsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lGadgets"));
                List<String> gadgetsLore = new ArrayList<>();
                gadgetsLore.add(ChatColor.translateAlternateColorCodes('&', "&c&lCOMING SOON"));
                kitsMeta.setLore(gadgetsLore);
                gadgets.setItemMeta(gadgetsMeta);
                menu.setItem(6 + 9, gadgets);

                ItemStack backButton = new ItemStack(Material.BARRIER);
                ItemMeta backButtonMeta = backButton.getItemMeta();
                backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
                backButton.setItemMeta(backButtonMeta);
                menu.setItem(4 + 9 * 2, backButton);

                return menu;

            }
            case "kits": {
                Inventory menu = Bukkit.createInventory(player, 9 * 3, "Kits");

                ItemStack assaultClass = new ItemStack(Material.IRON_CHESTPLATE);
                ItemMeta assaultClassMeta = assaultClass.getItemMeta();
                assaultClassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lAssault Class"));
                List<String> assaultClassLore = new ArrayList<>();
                assaultClassLore.add(ChatColor.translateAlternateColorCodes('&', "&fUtility for better survivability and easier combat"));
                assaultClassMeta.setLore(assaultClassLore);
                assaultClass.setItemMeta(assaultClassMeta);
                menu.setItem(2 + 9, assaultClass);

                ItemStack skirmisherClass = new ItemStack(Material.EYE_OF_ENDER);
                ItemMeta skirmisherClassMeta = skirmisherClass.getItemMeta();
                skirmisherClassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&lSkirmisher Class"));
                List<String> skirmisherClasslore = new ArrayList<>();
                skirmisherClasslore.add(ChatColor.translateAlternateColorCodes('&', "&fUtility to help initiate a fight or move around"));
                skirmisherClassMeta.setLore(skirmisherClasslore);
                skirmisherClass.setItemMeta(skirmisherClassMeta);
                menu.setItem(3 + 9, skirmisherClass);

                ItemStack randomKit = new ItemStack(Material.DIAMOND);
                ItemMeta randomKitMeta = randomKit.getItemMeta();
                randomKitMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lRandom Kit"));
                randomKit.setItemMeta(randomKitMeta);
                menu.setItem(4 + 9, randomKit);

                ItemStack assassinClass = new ItemStack(Material.IRON_SWORD);
                ItemMeta assassinClassMeta = assassinClass.getItemMeta();
                assassinClassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&6&lAssassin Class"));
                List<String> assassinClassLore = new ArrayList<>();
                assassinClassLore.add(ChatColor.translateAlternateColorCodes('&', "&fUtility helps eliminate opponents or destroy areas"));
                assassinClassMeta.setLore(assassinClassLore);
                assassinClass.setItemMeta(assassinClassMeta);
                menu.setItem(5 + 9, assassinClass);

                ItemStack sentinelClass = new ItemStack(Material.PISTON_BASE);
                ItemMeta sentinelClassMeta = sentinelClass.getItemMeta();
                sentinelClassMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&9&lSentinel Class"));
                List<String> sentinelClassLore = new ArrayList<>();
                sentinelClassLore.add(ChatColor.translateAlternateColorCodes('&', "&fUtility to set up traps and defences"));
                sentinelClassMeta.setLore(sentinelClassLore);
                sentinelClass.setItemMeta(sentinelClassMeta);
                menu.setItem(6 + 9, sentinelClass);

                ItemStack backButton = new ItemStack(Material.BARRIER);
                ItemMeta backButtonMeta = backButton.getItemMeta();
                backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
                backButton.setItemMeta(backButtonMeta);
                menu.setItem(4 + 9 * 2, backButton);

                return menu;

            }
            case "guns": {
                Inventory menu = Bukkit.createInventory(player, 9 * 3, "Guns");

                ItemStack assaultRifles = new ItemStack(Material.valueOf("MW_M4A1"));
                ItemMeta assaultRiflesMeta = assaultRifles.getItemMeta();
                assaultRiflesMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lAssault Rifles"));
                assaultRifles.setItemMeta(assaultRiflesMeta);
                menu.setItem(9, assaultRifles);

                ItemStack battleRifles = new ItemStack(Material.valueOf("MW_SCAR_H_CQC"));
                ItemMeta battleRiflesMeta = battleRifles.getItemMeta();
                battleRiflesMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lBattle Rifles"));
                battleRifles.setItemMeta(battleRiflesMeta);
                menu.setItem(1 + 9, battleRifles);

                ItemStack semiautos = new ItemStack(Material.valueOf("MW_M110_SASS"));
                ItemMeta semiautosMeta = semiautos.getItemMeta();
                semiautosMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lDMRs"));
                semiautos.setItemMeta(semiautosMeta);
                menu.setItem(2 + 9, semiautos);

                ItemStack lmgs = new ItemStack(Material.valueOf("MW_MG42"));
                ItemMeta lmgsMeta = lmgs.getItemMeta();
                lmgsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lLMGs"));
                lmgs.setItemMeta(lmgsMeta);
                menu.setItem(3 + 9, lmgs);

                ItemStack smgs = new ItemStack(Material.valueOf("MW_MP7"));
                ItemMeta smgsMeta = smgs.getItemMeta();
                smgsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSMGs"));
                smgs.setItemMeta(smgsMeta);
                menu.setItem(4 + 9, smgs);

                ItemStack shotguns = new ItemStack(Material.valueOf("MW_REMINGTON870"));
                ItemMeta shotgunsMeta = shotguns.getItemMeta();
                shotgunsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lShotguns"));
                shotguns.setItemMeta(shotgunsMeta);
                menu.setItem(5 + 9, shotguns);

                ItemStack sniperRifles = new ItemStack(Material.valueOf("MW_M40A6"));
                ItemMeta sniperRiflesMeta = sniperRifles.getItemMeta();
                sniperRiflesMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSniper Rifles"));
                sniperRifles.setItemMeta(sniperRiflesMeta);
                menu.setItem(6 + 9, sniperRifles);

                ItemStack secondaries = new ItemStack(Material.valueOf("MW_GLOCK_19"));
                ItemMeta secondariesMeta = secondaries.getItemMeta();
                secondariesMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lSecondaries"));
                secondaries.setItemMeta(secondariesMeta);
                menu.setItem(7 + 9, secondaries);

                ItemStack specials = new ItemStack(Material.valueOf("MW_RPG7"));
                ItemMeta specialsMeta = specials.getItemMeta();
                specialsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lSpecials"));
                specials.setItemMeta(specialsMeta);
                menu.setItem(8 + 9, specials);

                ItemStack backButton = new ItemStack(Material.BARRIER);
                ItemMeta backButtonMeta = backButton.getItemMeta();
                backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
                backButton.setItemMeta(backButtonMeta);
                menu.setItem(4 + 9 * 2, backButton);

                return menu;

            }
            case "teleports": {
                Inventory menu = Bukkit.createInventory(player, 9 * 3, "Teleports");

                ItemStack newport = new ItemStack(Material.IRON_BLOCK);
                ItemMeta newportMeta = newport.getItemMeta();
                newportMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lNewport City"));
                List<String> newportLore = new ArrayList<>();
                newportLore.add(ChatColor.WHITE + "The original and classic map");
                newportLore.add(ChatColor.WHITE + "Complexity: [3 / 5]");
                newportLore.add(ChatColor.WHITE + "Interior: [4 / 5]");
                newportLore.add(ChatColor.WHITE + "Exterior: [2 / 5]");
                newportLore.add(ChatColor.BLUE + "Range: Mixed");
                newportMeta.setLore(newportLore);
                newport.setItemMeta(newportMeta);
                menu.setItem(2 + 9, newport);

                ItemStack radiant = new ItemStack(Material.QUARTZ_BLOCK);
                ItemMeta radiantMeta = radiant.getItemMeta();
                radiantMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lRadiant City"));
                List<String> radiantLore = new ArrayList<>();
                radiantLore.add(ChatColor.WHITE + "The best map");
                radiantLore.add(ChatColor.WHITE + "Complexity: [4 / 5]");
                radiantLore.add(ChatColor.WHITE + "Interior: [5 / 5]");
                radiantLore.add(ChatColor.WHITE + "Exterior: [4 / 5]");
                radiantLore.add(ChatColor.BLUE + "Range: Close-Mid");
                radiantLore.add(ChatColor.RED + "Special: Fights in the dark");
                radiantMeta.setLore(radiantLore);
                radiant.setItemMeta(radiantMeta);
                menu.setItem(3 + 9, radiant);

                ItemStack shmar = new ItemStack(Material.STAINED_GLASS, 1, (short)15);
                ItemMeta shmarMeta = shmar.getItemMeta();
                shmarMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lShmar City"));
                List<String> shmarLore = new ArrayList<>();
                shmarLore.add(ChatColor.WHITE + "The most open and the tallest map");
                shmarLore.add(ChatColor.WHITE + "Complexity: [2 / 5]");
                shmarLore.add(ChatColor.WHITE + "Interior: [2 / 5]");
                shmarLore.add(ChatColor.WHITE + "Exterior: [4 / 5]");
                shmarLore.add(ChatColor.BLUE + "Range: Mid-Long");
                shmarMeta.setLore(shmarLore);
                shmar.setItemMeta(shmarMeta);
                menu.setItem(4 + 9, shmar);

                ItemStack audia = new ItemStack(Material.BRICK);
                ItemMeta audiaMeta = audia.getItemMeta();
                audiaMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lAudia City"));
                List<String> audiaLore = new ArrayList<>();
                audiaLore.add(ChatColor.WHITE + "The biggest and most diverse map");
                audiaLore.add(ChatColor.WHITE + "Complexity: [4 / 5]");
                audiaLore.add(ChatColor.WHITE + "Interior: [3 / 5]");
                audiaLore.add(ChatColor.WHITE + "Exterior: [4 / 5]");
                audiaLore.add(ChatColor.BLUE + "Range: Mixed");
                audiaMeta.setLore(audiaLore);
                audia.setItemMeta(audiaMeta);
                menu.setItem(5 + 9, audia);

                ItemStack city17 = new ItemStack(Material.STONE);
                ItemMeta city17Meta = city17.getItemMeta();
                city17Meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&lCity 17"));
                List<String> city17Lore = new ArrayList<>();
                city17Lore.add(ChatColor.WHITE + "The best map for outside fights");
                city17Lore.add(ChatColor.WHITE + "Complexity: [4 / 5]");
                city17Lore.add(ChatColor.WHITE + "Interior: [1 / 5]");
                city17Lore.add(ChatColor.WHITE + "Exterior: [5 / 5]");
                city17Lore.add(ChatColor.BLUE + "Range: Mid-Long");
                city17Meta.setLore(city17Lore);
                city17.setItemMeta(city17Meta);
                menu.setItem(6 + 9, city17);



                ItemStack backButton = new ItemStack(Material.BARRIER);
                ItemMeta backButtonMeta = backButton.getItemMeta();
                backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
                backButton.setItemMeta(backButtonMeta);
                menu.setItem(4 + 9 * 2, backButton);

                return menu;
            }
            case "settings": {
                Inventory menu = Bukkit.createInventory(player, 9 * 3, "Settings");

                ItemStack settings = new ItemStack(Material.COMPASS);
                ItemMeta settingsMeta = settings.getItemMeta();
                settingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lMap Settings"));
                settings.setItemMeta(settingsMeta);
                menu.setItem(2 + 9, settings);

                ItemStack teams = new ItemStack(Material.BANNER, 1, (short)1);
                ItemMeta teamsMeta = teams.getItemMeta();
                teamsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lTeams"));
                teams.setItemMeta(teamsMeta);
                menu.setItem(6 + 9, teams);

                ItemStack backButton = new ItemStack(Material.BARRIER);
                ItemMeta backButtonMeta = backButton.getItemMeta();
                backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
                backButton.setItemMeta(backButtonMeta);
                menu.setItem(4 + 9 * 2, backButton);

                return menu;
            }
            case "map_settings": {
                Inventory menu = Bukkit.createInventory(player, 9 * 5, "Map Settings");

                ItemStack settings = new ItemStack(Material.COMPASS);
                ItemMeta settingsMeta = settings.getItemMeta();
                settingsMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&f&lMap Settings"));
                settings.setItemMeta(settingsMeta);
                menu.setItem(2 + 9, settings);

                ItemStack backButton = new ItemStack(Material.BARRIER);
                ItemMeta backButtonMeta = backButton.getItemMeta();
                backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
                backButton.setItemMeta(backButtonMeta);
                menu.setItem(4 + 9 * 4, backButton);

                return menu;
            }
        }

        return null;
    }

}
