package me.ducky.projectg.menu;

import me.ducky.projectg.util.GetButtonUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemCatalog {

    private static String[][] kitCatalog = {
        // 0 - Kit Name, 1 - Class Id, 2 - Kit Id, 3 - Rarity Id, 4 - Description, 5 - Icon Id
        // Tiers: Basic, Advanced, Complex, Professional, Elite
        // ASSAULT
        {"Soldier Kit", "assault", "assault", "basic", "&fA swiss knife of a kit - everything you need to fight, survive and win in the same place", "IRON_HELMET"},
        {"Cryo Kit", "assault", "cryo", "advanced", "&fProvides an ability to freeze areas and slowing down the opponents, while having good area control", "PACKED_ICE"},
        {"Smoke Kit", "assault", "smoke", "advanced", "&fExcellent utility to block enemies line of sight and deny area with special gas grenades", "WEB"},
        {"Breach Kit", "assault", "breach", "complex", "&fGood utility to remove obstacles, breach walls and initiate fights", "SHIELD"},
        {"Spy Kit", "assault", "spy", "complex", "&fProvides utility for flanking and stealth attacks", "STRING"},
        {"Recon Kit", "assault", "recon", "professional", "&fUtility helps locate enemies and initiate a fight with them", "COMPASS"},
        {"Juggernaut Kit", "assault", "juggernaut", "elite", "&c&lTHIS KIT ALREADY PROVIDES A MAIN WEAPON!\n&fHaha minigun go brrr", "DIAMOND_CHESTPLATE"},
        // SKIRMISHER
        {"Rush Kit", "skirmisher", "rush", "basic", "&fUtility gives a lot of movement-based buffs to help rush into the fight", "GOLD_BOOTS"},
        {"Stealth Kit", "skirmisher", "stealth", "advanced", "&fProvides an ability to turn invisible and flank enemy lines", "EYE_OF_ENDER"},
        {"Nano Kit", "skirmisher", "nano", "advanced", "&fUtility helps to blind enemies and relocate with ender pearls", "ENDER_PEARL"},
        {"Jetpack Kit", "skirmisher", "jetpack", "complex", "&fProvides you a jetpack which you can use in many different ways", "FEATHER"},
        {"Grapple Kit", "skirmisher", "grapple", "professional", "&fThe grappling hook gives many opportunities to relocate, flank or get into good angles", "STRING"},
        {"Demoman Kit", "skirmisher", "demoman", "professional", "&fFor the next three hundred years, people who needed to get to the second\nfloor used the only method available to them: shooting a rocket\nlauncher at their feet. Yes, it was ridiculous, crippling,\nand awful, but what are you going to do? Not go to the\nsecond floor? That's where your bed is.", "IRON_SPADE"},
        {"Blade Kit (Crucible)", "skirmisher", "blade", "elite", "&fYou get a huge red blade which one-shots anyone, but it has limited uses (5)", "DIAMOND_SWORD"},
        {"Blade Kit (Meteorite)", "skirmisher", "blade", "elite", "&c&lTHIS KIT ALREADY PROVIDES A MAIN WEAPON!\n&fYou are really fast, but lack in protection", "DIAMOND_SWORD"},
        // ASSASSIN
        {"Pyro Kit", "assassin", "pyro", "basic", "&fKit provides a fire thrower and other fire-based utility", "LAVA_BUCKET"},
        {"Explosive Kit", "assassin", "explosive", "advanced", "&fKit provides a powerful homing rocket launcher and explosive utility", "FIREBALL"},
        {"Toxic Kit", "assassin", "toxic", "advanced", "&fUtility helps to control and lock down areas with powerful gas grenades", "SLIME_BALL"},
        {"Biohazard Kit", "assassin", "biohazard", "professional", "&fKit provides a biogun and some chemical utility", "SEEDS"},
        {"Chainsaw Kit", "assassin", "chainsaw", "elite", "&fMakima fanboy kit", "NETHER_STAR"},
        {"Sniper Kit", "assassin", "sniper", "elite", "&c&lTHIS KIT ALREADY PROVIDES A MAIN WEAPON!\n&fKit provides the infamous NTW-20 as the main weapon,\nwhich can one-shot anyone, but you are easier to kill", "BOW"},
        // SENTINEL
        {"Medic Kit", "sentinel", "medic", "basic", "&fProvides utility to heal and support your allies", "GOLDEN_APPLE"},
        {"Bulldozer Kit", "sentinel", "bulldozer", "advanced", "&fKit allows to modify the map and build on with with its utility", "GOLD_PICKAXE"},
        {"Tech Kit", "sentinel", "tech", "advanced", "&fProvides utility to lock down area with traps and view it from cameras", "OBSERVER"},
        {"Engineer Kit", "sentinel", "engineer", "complex", "&fKit provides a bunch of turrets which can be placed and will shoot any foes", "SHULKER_SHELL"},
        {"Missile Kit", "sentinel", "missile", "professional", "&fKit provides powerful missiles which you can point and launch", "ARROW"},
        {"Artillery Kit", "sentinel", "artillery", "elite", "&fProvides a lot of different airstrikes to use on your enemies&fVariants: &aartillery_ray", "SPECTRAL_ARROW"},
        {"Nuclear Kit", "sentinel", "nuclear", "elite", "&fThe name speaks for itself\n&fVariants: &anuclear_small, nuclear_medium, nuclear_big, nuclear_combo, nuclear_ray", "TNT"}
    };

    private static String[][] gunCatalog = {
        // 0 - Display Name, 1 - Gun Type, 2 - Gun Id, 3 - Ammo Id, 4 - Ammo Amount, 5 - Rarity Id
        // ASSAULT RIFLES
        {"SOCOM M4A1", "assault_rifle", "MW_SOCOM_M4A1", "MW_SOCOM_MAG", "12", "common"},
        {"ARX-160", "assault_rifle", "MW_ARX160", "MW_M4A1MAG_2", "12", "common"},
        {"C8 SFW", "assault_rifle", "MW_C8_SFW", "MW_M4A1MAG_2", "12", "common"},
        {"BREN A1", "assault_rifle", "MW_CZ805_BREN_A1", "MW_M4A1MAG_2", "12", "common"},
        {"AK-74", "assault_rifle", "MW_AK74", "MW_AK74MAG", "12", "common"},
        {"AK-15", "assault_rifle", "MW_AK15", "MW_AK15MAG_2", "12", "common"},
        {"M16A4", "assault_rifle", "MW_M16A4", "MW_M4A1MAG_2", "12", "uncommon"},
        {"Remington ACR", "assault_rifle", "MW_ACR", "MW_M4A1MAG_2", "12", "uncommon"},
        {"Mk 16 SCAR-L", "assault_rifle", "MW_SCAR_L", "MW_M4A1MAG_2", "12", "uncommon"},
        {"HK G36K", "assault_rifle", "MW_G36K", "MW_G36CMAG_2", "12", "uncommon"},
        {"AK-12", "assault_rifle", "MW_KALASHNIKOV_AK12", "MW_AK15MAG_2", "12", "uncommon"},
        {"HK G95", "assault_rifle", "MW_HK_G95", "MW_M4A1MAG_2", "12", "uncommon"},
        {"K2C1", "assault_rifle", "MW_K2C1", "MW_M4A1MAG_2", "12", "rare"},
        {"NV4", "assault_rifle", "MW_NV4", "MW_BULLET556X45", "384", "rare"},
        {"MA37 ICWS", "assault_rifle", "MW_MA37_ICWS", "MW_BULLET762X51", "384", "rare"},
        {"M41A", "assault_rifle", "MW_M41A", "MW_BULLET10MM", "384", "rare"},
        {"AUG A1", "assault_rifle", "MW_STEYR_AUG_A1", "MW_M4A1MAG_2", "12", "rare"},
        {"HK G11", "assault_rifle", "MW_G11", "MW_G11MAG", "12", "rare"},
        {"AK-103", "assault_rifle", "MW_AK103_BULLPUP", "MW_AK47MAG", "12", "rare"},
        {"M4A4 Asiimov", "assault_rifle", "MW_ASIIMOV_M4A1", "MW_M4ASIIMOVMAG", "12", "epic"},
        {"AKM Vulcan", "assault_rifle", "MW_AKM_VULCAN", "MW_AKMVULCANMAG", "12", "epic"},
        {"AAC Honey Badger", "assault_rifle", "MW_AAC_HONEY_BADGER", "MW_HONEYBADGERMAG_2", "12", "epic"},
        {"FN F2000", "assault_rifle", "MW_F2000", "MW_M4A1MAG_2", "12", "epic"},
        {"VOLK", "assault_rifle", "MW_VOLK", "MW_ENERGYCASE", "384", "epic"},
        {"TYPE-2", "assault_rifle", "MW_TYPE2", "MW_ENERGYCASE", "384", "legendary"},
        {"OSIPR", "assault_rifle", "MW_OSIPR", "MW_BULLET762X51", "384", "legendary"},
        // BATTLE RIFLES
        {"SCAR-H", "battle_rifle", "MW_SCAR_H_CQC", "MW_SCARHMAG_2", "12", "common"},
        {"KBP 9A_91", "battle_rifle", "MW_KBP_9A91", "MW_KBP9A91MAG_2", "12", "uncommon"},
        {"SR-3", "battle_rifle", "MW_SR3_VIKHR", "MW_VSSVINTOREZMAG_2", "12", "uncommon"},
        {"FN FAL", "battle_rifle", "MW_FNFAL", "MW_AK47MAG", "12", "rare"},
        {"M8A7", "battle_rifle", "MW_M8A7", "MW_BULLET556X45", "12", "rare"},
        {"MA5D ICWS", "battle_rifle", "MW_MA5D", "MW_BULLET762X51", "384", "epic"},
        {"BR-55", "battle_rifle", "MW_BR55", "MW_BULLET762X51", "384", "epic"},
        // DMRs
        {"AR-10 Super SASS", "dmr", "MW_AR10_SUPER_SASS", "MW_M110MAG_2", "6", "common"},
        {"Mk14", "dmr", "MW_MK14_EBR", "MW_MK14EBRMAG_2", "6", "common"},
        {"M1941 Johnson Rifle", "dmr", "MW_M1941_JOHNSON_RIFLE", "MW_BULLET3006SPRINGFIELD", "192", "uncommon"},
        {"M110 SASS", "dmr", "MW_M110_SASS", "MW_M110MAG_2", "6", "uncommon"},
        {"HK SL8", "dmr", "MW_SL8", "MW_G36CMAG_2", "6", "rare"},
        {"M1 Garand", "dmr", "MW_M1_GARAND", "MW_BULLET3006SPRINGFIELD", "192", "rare"},
        {"G43 Gewehr", "dmr", "MW_G43_GEWEHR", "MW_G43_GEWEHR_MAG", "6", "rare"},
        {"Mare's Leg", "dmr", "MW_MARES_LEG", "MW_BULLET44", "192", "rare"},
        {"M392", "dmr", "MW_M392", "MW_BULLET762X51", "192", "epic"},
        {"VSS Vintorez", "dmr", "MW_VSS_VINTOREZ", "MW_VSSVINTOREZMAG_2", "6", "epic"},
        {"TYPE-51", "dmr", "MW_TYPE51", "MW_ENERGYCASE", "192", "legendary"},
        // LMGs
        {"M249", "lmg", "MW_M249", "MW_M249MAG", "6", "common"},
        {"Stoner A1", "lmg", "MW_STONERA1", "MW_STONERMAG", "6", "uncommon"},
        {"MG-42", "lmg", "MW_MG42", "MW_MG42MAG_2", "6", "uncommon"},
        {"M1941 Johnson LMG", "lmg", "MW_M1941_JOHNSON", "MW_JOHNSONMAG", "12", "rare"},
        {"HAR-27", "lmg", "MW_HAR_27", "MW_BULLET556X45", "384", "epic"},
        {"M56 ESG", "lmg", "MW_M56", "MW_BULLET556X45", "384", "legendary"},
//            {"M138 Minigun", "lmg", "MW_M134", "MW_M134MAG", "2", "legendary"},
        // SMGs
        {"HK MP7A1", "smg", "MW_MP7A1", "MW_MP7MAG", "12", "common"},
        {"UMP45", "smg", "MW_UMP_45", "MW_UMP45MAG", "12", "common"},
        {"APC9", "smg", "MW_APC9", "MW_APC9MAG", "12", "uncommon"},
        {"UZI", "smg", "MW_UZI", "MW_UZIMAG_2", "12", "uncommon"},
        {"P90", "smg", "MW_P90", "MW_P90MAG", "12", "rare"},
        {"Kriss Vector", "smg", "MW_KRISS_VECTOR", "MW_VECTORMAG", "12", "rare"},
        {"Scorpion EVO3 A1", "smg", "MW_SCORPION_EVO3_A1", "MW_SCORPIONMAG", "12", "rare"},
        {"MAC-10", "smg", "MW_MAC10", "MW_MAC10MAG", "12", "rare"},
        {"M20 PDW", "smg", "MW_M20", "MW_BULLET9X19MM", "384", "epic"},
        {"Thompson", "smg", "MW_M1928_THOMPSON", "MW_M1928MAG", "12", "epic"},
        // SHOTGUNS
        {"M1014", "shotgun", "MW_M1014", "MW_SHOTGUN12GAUGE", "32", "common"},
        {"KS-23", "shotgun", "MW_KS23", "MW_SHOTGUN4G", "32", "common"},
        {"Remington-870", "shotgun", "MW_REMINGTON870", "MW_SHOTGUN12GAUGE", "32", "uncommon"},
        {"Spas-12", "shotgun", "MW_SPAS_12", "MW_SHOTGUN12GAUGE", "32", "uncommon"},
        {"Origin-12", "shotgun", "MW_ORIGIN12", "MW_ORIGIN12DRUMMAG", "12", "rare"},
        {"CSA-16", "shotgun", "MW_CSA16", "MW_SHOTGUN4G", "32", "rare"},
        {"Saiga 12", "shotgun", "MW_SAIGA12", "MW_SAIGAMAG_2", "12", "epic"},
        {"M45", "shotgun", "MW_M45", "MW_SHOTGUN12GAUGE", "32", "epic"},
        {"SSG-42 MkII-DS", "shotgun", "MW_SSG42", "MW_SHOTGUN12GAUGE", "32", "legendary"},
        // SNIPER RIFLES
        {"AS50", "sniper_rifle", "MW_AS50", "MW_AS50MAG_2", "6", "common"},
        {"L96A1", "sniper_rifle", "MW_L96A1", "MW_L96A1MAG_2", "6", "common"},
        {"Izhmash SV-98", "sniper_rifle", "MW_SV98", "MW_SV98MAG_2", "6", "uncommon"},
        {"M40A6", "sniper_rifle", "MW_M40A6", "MW_M40A6MAG_2", "6", "uncommon"},
        {"M200 Intervention", "sniper_rifle", "MW_M200_INTERVENTION", "MW_INTERVENTIONMAG", "6", "rare"},
        {"Remington-700", "sniper_rifle", "MW_REMINGTON_700", "MW_R700MAG", "6", "rare"},
        {"M1903 Springfield", "sniper_rifle", "MW_SPRINGFIELD", "MW_BULLET3006SPRINGFIELD", "64", "rare"},
        {"M82 Barrett", "sniper_rifle", "MW_M82_BARRETT", "MW_M82MAG_2", "6", "epic"},
        {"AX-50", "sniper_rifle", "MW_AX50", "MW_AX50MAG", "6", "epic"},
        {"Krag Jorgensen", "sniper_rifle", "MW_KRAG_JORGENSEN", "MW_BULLET8X58", "64", "epic"},
        {"SRS-99 AMSR", "sniper_rifle", "MW_SRS99", "MW_BULLET762X51", "64", "legendary"},
//            {"NTW-20", "sniper_rifle", "MW_NTW_20", "MW_NTW20MAG", "3", "legendary"},
        // SECONDARIES
        {"Glock-18C", "secondary", "MW_GLOCK_18C", "MW_GLOCK18CMAG_2", "12", "common"},
        {"CPX-2", "secondary", "MW_SCCY_CPX_2", "MW_M9MAG30", "12", "common"},
        {"M6C SOCOM", "secondary", "MW_M6C_SOCOM", "MW_BULLET9X19MM", "192", "uncommon"},
        {"PP-91 Kedr", "secondary", "MW_PP91_KEDR", "MW_KEDRMAG_2", "12", "rare"},
        {"Frommer Stop", "secondary", "MW_FROMMER_STOP", "MW_FROMMERSTOPMAG", "12", "rare"},
        {"ESA-23", "secondary", "MW_ESA23", "MW_ENERGYCASE", "192", "rare"},
        {"Taurus Hunter", "secondary", "MW_TAURUS_RAGING_HUNTER", "MW_BULLET44", "64", "rare"},
        {"P10", "secondary", "MW_P10", "MW_BULLET10MM", "192", "epic"},
        {"The Dechard", "secondary", "MW_THE_DECHARD", "MW_BULLET556X45", "64", "epic"},
        {"Desert Eagle", "secondary", "MW_DESERT_EAGLE", "MW_DESERTEAGLEMAG", "6", "epic"},
        {"M17", "secondary", "MW_M17", "MW_M17MAG", "12", "legendary"}, //buff
        {"G2 Contender", "secondary", "MW_G2_CONTENDER", "MW_BULLET4570", "64", "legendary"},
//            {"Chainsaw", "secondary", "MW_CHAINSAW", "MW_FUELCELL", "1", "legendary"},
        // SPECIALS
        {"Nether Blaster", "special", "TECHGUNS_NETHERBLASTER", "8748:76", "12", "legendary"},
        {"Laser Pistol", "special", "TECHGUNS_LASERPISTOL", "8748:125", "12", "legendary"},
        {"Grenade Launcher", "special", "TECHGUNS_GRENADELAUNCHER", "8748:5", "32", "legendary"}
    };

    private static String[][] gadgetCatalog = {
            // 0 - Gadget Name, 1 - Gadget Id, 2 - Amount, 3 - Rarity
            {"Water Bucket", "WATER_BUCKET", "1", "common"},
            {"Flint and Steel", "FLINT_AND_STEEL", "1", "common"},
            {"Flashlight", "FLASHLIGHT_FLASHLIGHT", "1", "common"},
            {"Hard Cover", "HBM_HADRON_PLATING_STRIPED", "64", "uncommon"},
            {"Kevlar Insert", "HBM_INSERT_KEVLAR", "1", "rare"},
            {"Slime Pads", "HBM_PADS_SLIME", "1", "rare"},
            {"Trench Mask", "HBM_MASK_PISS", "1", "rare"},
            {"Golden Apple", "GOLDEN_APPLE", "5", "rare"},
            {"Chorus Fruit", "CHORUS_FRUIT", "16", "rare"},
            {"Power Hammer", "TECHGUNS_POWERHAMMER", "1", "epic"},
            {"XSAPI Insert", "HBM_INSERT_XSAPI", "1", "epic"},
            {"Ender Pearl", "ENDER_PEARL", "3", "epic"},
            {"Mining Charge", "TECHGUNS_EXPLOSIVE_CHARGE", "5", "epic"},
            {"Claymore", "SECURITYCRAFT_CLAYMORE", "10", "epic"},
            {"Night Vision Goggles", "TECHGUNS_NIGHTVISIONGOGGLES", "1", "epic"},
            {"Velvet Band-Aid", "HBM_BANDAID", "1", "legendary"},
            //{"8 Inch Blade Autoinjector", "HBM_INJECTOR_KNIFE", "1", "legendary"},
            {"Elytra", "ELYTRA", "1", "legendary"},
            {"Jumppack", "TECHGUNS_JUMPPACK", "1", "legendary"}
    };

    private static String[][] teleportsCatalog = {
            // 0 - City Id, 1 - Location Name, 2 - X, 3 - Y, 4 - Z
            {"Newport","Spawn","-44","249","216"},
            {"Newport","Plaza","-150","160","230"},
            {"Newport","Stone Twin Apartments","-70","120","230"},
            {"Newport","Triple Gray Towers","-130","140","-40"},
            {"Newport","Hospital Complex","-130","120","20"},
            {"Newport","White house","50","100","140"},
            {"Newport","Tall Gray Apartment","90","190","230"},
            {"Newport","RD Hotel","-70","130","-470"},
            {"Newport","MC Skyscraper","0","210","-450"},
            {"Newport","Double Brick Towers","100","120","-280"},
            {"Newport","Large Neighbourhood","80","100","-150"},
            {"Radiant","Spawn","1780","123","198"},
            {"Radiant","Bank Tower Complex","1570","105","60"},
            {"Radiant","Skyscraper","1620","260","200"},
            {"Radiant","Terracotta Tower","1650","200","-20"},
            {"Radiant","Chorus Complex","1740","115","70"},
            {"Radiant","Museum","1830","105","70"},
            {"Radiant","Apartment Towers","1830","110","-30"},
            {"Radiant","Opposing Towers","2030","95","-20"},
            {"Radiant","Embassy","1970","120","-20"},
            {"Radiant","Housing Complex","1900","110","90"},
            {"Radiant","Quartz Heights","1990","140","130"},
            {"Radiant","Police station","1990","100","260"},
            {"Radiant","Court","1900","100","300"},
            {"Shmar","Spawn","42","95","25"},
            {"Shmar","Grocery Store","-360","60","144"},
            {"Shmar","Sandstone Tower","-75","105","115"},
            {"Shmar","Plaza","-90","95","-125"},
            {"Shmar","Brick Complex 1","-115","80","-225"},
            {"Shmar","Brick Complex 2","-110","90","-330"},
            {"Audia","Spawn","85","256","-188"},
            {"Audia","Small Neighbourhood 1","800","100","-1300"},
            {"Audia","Small Neighbourhood 2","1100","100","-1000"},
            {"Audia","Modern House Complex 1","500","100","-200"},
            {"Audia","Modern House Complex 2","500","100","200"},
            {"Audia","White House Complex","-450","100","-100"},
            {"Audia","Brick House Complex","-200","100","-550"},
            {"Audia","Grey House Complex","900","100","-200"},
            {"Audia","Beachside House Complex","1500","100","1500"},
            {"Audia","City Centre Skyscraper","-600","100","-300"},
            {"Audia","Urban Skyscrapers","800","100","-500"},
            {"Audia","Island","-1250","100","940"},
            {"Audia","Cargo Ship","-1350","100","1220"},
            {"Audia","World Trade Centre","70","200","40"},
            {"Audia","Aqua Park","1050","100","1300"},
            {"Audia","Airport","550","100","-1100"},
            {"Audia","Modern City Area","-1000","100","-300"},
            {"Audia","Big Neighbourhood","-800","100","-1000"},
            {"Audia","Medium Neighbourhood","500","100","500"},
            {"Audia","Factory","-1100","100","-1000"},
            {"Audia","Walmart","0","100","-1000"},
            {"Audia","School","1100","100","0"},
            {"Audia","Yachts","-800","100","800"},
            {"Audia","Construction site","-100","100","-400"},
            {"City 17","Spawn","-392","34","-290"},
            {"City 17","Riverside Town","-800","80","-400"},
            {"City 17","Canal Dockage","-650","80","-550"},
            {"City 17","HQ","-760","260","130"},
            {"City 17","Church","-1100","100","425"},
            {"City 17","Construction Cite","-1350","100","575"},
            {"City 17","Power Plant","-1200","100","275"},
            {"City 17","Industrial Zone","-1400","100","400"},
            {"City 17","Panel District","-1050","80","-225"},
            {"City 17","Panel District 2","-1160","80","-90"},
            {"City 17","Ferris Wheel","-970","100","-10"},
            {"City 17","White House","-835","60","-25"},
            {"City 17","Smokey Suburbs","-850","80","250"},
            {"City 17","Central Station","-950","80","125"},
            {"City 17","Brick Town","-900","80","425"}
    };

    public static String[][] getCatalog(String catalogType) {

        if (catalogType.equals("kit")) {

            return kitCatalog;

        } else if (catalogType.equals("gun")) {

            return gunCatalog;

        } else if (catalogType.equals("gadget")) {

            return gadgetCatalog;

        } else if (catalogType.equals("teleports")) {

            return teleportsCatalog;

        } else {

            return null;

        }

    }

    public static String[] getCatalogItem(String catalogType, String itemName) {

        if (catalogType.equals("kit")) {

            for (String[] kit : kitCatalog) {

                if (kit[0].equals(itemName)) {

                    return kit;

                }

            }

        } else if (catalogType.equals("gun")) {

            for (String[] gun : gunCatalog) {

                if (gun[0].equals(itemName)) {

                    return gun;

                }

            }

        } else if (catalogType.equals("gadget")) {

            for (String[] gadget : gadgetCatalog) {

                if (gadget[0].equals(itemName)) {

                    return gadget;

                }

            }

        } else if (catalogType.equals("teleports")) {

            for (String[] location : teleportsCatalog) {

                if (location[0].equals(itemName)) {

                    return location;

                }

            }

        }

        return null;

    }

    public static Inventory selectKitMenu(Player player, String kitClass, String menuTitle) {
        Inventory menu = Bukkit.createInventory(player, 9 * 5, menuTitle);
        String[][] kitCatalog = ItemCatalog.getCatalog("kit");

        int kitSlot = 1;
        int kitRow = 1;
        assert kitCatalog != null;
        for (String[] kitData : kitCatalog) {

            if (kitData[1].equals(kitClass)) {
                ItemStack kit = new ItemStack(Material.valueOf(kitData[5]));
                ItemMeta kitMeta = kit.getItemMeta();
                //player.sendMessage("LOADING KIT " + kitData[0]);

                if (kitData[3].equals("basic")) {
                    kitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + kitData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.translateAlternateColorCodes('&', kitData[4]));
                    lore.add(ChatColor.WHITE + "" + ChatColor.BOLD + "BASIC KIT");
                    kitMeta.setLore(lore);
                    kit.setItemMeta(kitMeta);
                } else if (kitData[3].equals("advanced")) {
                    kitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + kitData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.translateAlternateColorCodes('&', kitData[4]));
                    lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "ADVANCED KIT");
                    kitMeta.setLore(lore);
                    kit.setItemMeta(kitMeta);
                } else if (kitData[3].equals("complex")) {
                    kitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + kitData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.translateAlternateColorCodes('&', kitData[4]));
                    lore.add(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "COMPLEX KIT");
                    kitMeta.setLore(lore);
                    kit.setItemMeta(kitMeta);
                } else if (kitData[3].equals("professional")) {
                    kitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + kitData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.translateAlternateColorCodes('&', kitData[4]));
                    lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "PROFESSIONAL KIT");
                    kitMeta.setLore(lore);
                    kit.setItemMeta(kitMeta);
                } else if (kitData[3].equals("elite")) {
                    kitMeta.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + kitData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.translateAlternateColorCodes('&', kitData[4]));
                    lore.add(ChatColor.DARK_RED + "" + ChatColor.BOLD + "ELITE KIT");
                    kitMeta.setLore(lore);
                    kit.setItemMeta(kitMeta);
                }

                // Slot = Slot Num + 9 * Row
                menu.setItem(kitSlot + 9 * kitRow, kit);

                kitSlot += 1;
                if (kitSlot == 8) {
                    kitSlot = 1;
                    kitRow += 1;
                }
            }

        }

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
        backButton.setItemMeta(backButtonMeta);
        menu.setItem(4 + 9 * 4, backButton);

        return menu;

    }

    public static Inventory selectGunMenu(Player player, String gunType, String menuTitle) {
        Inventory menu = Bukkit.createInventory(player, 9 * 6, menuTitle);
        String[][] gunCatalog = ItemCatalog.getCatalog("gun");

        int gunSlot = 0;
        int gunRow = 0;
        assert gunCatalog != null;
        for (String[] gunData : gunCatalog) {

            if (gunData[1].equals(gunType)) {
                ItemStack gun = new ItemStack(Material.valueOf(gunData[2]));
                ItemMeta gunMeta = gun.getItemMeta();
                //player.sendMessage("LOADING GUN " + gunData[0]);

                if (gunData[5].equals("common")) {
                    gunMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + gunData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "COMMON WEAPON");
                    gunMeta.setLore(lore);
                    gun.setItemMeta(gunMeta);
                } else if (gunData[5].equals("uncommon")) {
                    gunMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + gunData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.AQUA + "" + ChatColor.BOLD + "UNCOMMON WEAPON");
                    gunMeta.setLore(lore);
                    gun.setItemMeta(gunMeta);
                } else if (gunData[5].equals("rare")) {
                    gunMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + gunData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE WEAPON");
                    gunMeta.setLore(lore);
                    gun.setItemMeta(gunMeta);
                } else if (gunData[5].equals("epic")) {
                    gunMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + gunData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "EPIC WEAPON");
                    gunMeta.setLore(lore);
                    gun.setItemMeta(gunMeta);
                } else if (gunData[5].equals("legendary")) {
                    gunMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + gunData[0]);
                    List<String> lore = new ArrayList<>();
                    lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY WEAPON");
                    gunMeta.setLore(lore);
                    gun.setItemMeta(gunMeta);
                }

                // Slot = Slot Num + 9 * Row
                menu.setItem(gunSlot + 9 * gunRow, gun);
                menu.setItem(gunSlot + 9 + 9 * gunRow, GetButtonUtility.getButton("equip"));

                gunSlot += 1;
                if (gunSlot == 9) {
                    gunSlot = 0;
                    gunRow += 2;
                }
                if (gunSlot == 4 && gunRow == 4) {
                    gunSlot += 1;
                }
            }

        }

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
        backButton.setItemMeta(backButtonMeta);
        menu.setItem(4 + 9 * 5, backButton);

        return menu;

    }

    public static Inventory selectGadgetMenu(Player player) {
        Inventory menu = Bukkit.createInventory(player, 9 * 6, "Gadgets");
        String[][] gadgetCatalog = ItemCatalog.getCatalog("gadget");

        int gadgetSlot = 1;
        int gadgetRow = 1;
        assert gadgetCatalog != null;
        for (String[] gadgetData : gadgetCatalog) {

            ItemStack gadget = new ItemStack(Material.valueOf(gadgetData[1]));
            ItemMeta gadgetMeta = gadget.getItemMeta();
            //player.sendMessage("LOADING GADGET " + gadgetData[0]);

            if (gadgetData[3].equals("common")) {
                gadgetMeta.setDisplayName(ChatColor.GRAY + "" + ChatColor.BOLD + gadgetData[0]);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GRAY + "" + ChatColor.BOLD + "COMMON GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
            } else if (gadgetData[3].equals("uncommon")) {
                gadgetMeta.setDisplayName(ChatColor.AQUA + "" + ChatColor.BOLD + gadgetData[0]);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.AQUA + "" + ChatColor.BOLD + "UNCOMMON GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
            } else if (gadgetData[3].equals("rare")) {
                gadgetMeta.setDisplayName(ChatColor.BLUE + "" + ChatColor.BOLD + gadgetData[0]);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.BLUE + "" + ChatColor.BOLD + "RARE GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
            } else if (gadgetData[3].equals("epic")) {
                gadgetMeta.setDisplayName(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + gadgetData[0]);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "EPIC GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
            } else if (gadgetData[3].equals("legendary")) {
                gadgetMeta.setDisplayName(ChatColor.GOLD + "" + ChatColor.BOLD + gadgetData[0]);
                List<String> lore = new ArrayList<>();
                lore.add(ChatColor.GOLD + "" + ChatColor.BOLD + "LEGENDARY GADGET");
                gadgetMeta.setLore(lore);
                gadget.setItemMeta(gadgetMeta);
            }

            // Slot = Slot Num + 9 * Row
            menu.setItem(gadgetSlot + 9 * gadgetRow, gadget);

            gadgetSlot += 1;
            if (gadgetSlot == 8) {
                gadgetSlot = 1;
                gadgetRow += 1;
            }


        }

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
        backButton.setItemMeta(backButtonMeta);
        menu.setItem(4 + 9 * 5, backButton);

        return menu;

    }

    public static Inventory selectLocationsMenu(Player player, String mapName) {
        Inventory menu = null;
        if (mapName.equals("Audia") || mapName.equals("City 17")) {
            menu = Bukkit.createInventory(player, 9 * 6, mapName);
        } else {
            menu = Bukkit.createInventory(player, 9 * 4, mapName);
        }
        String[][] teleportsCatalog = ItemCatalog.getCatalog("teleports");

        int buttonSlot = 1;
        int buttonRow = 1;
        assert teleportsCatalog != null;
        for (String[] teleportsData : teleportsCatalog) {

            if (teleportsData[0].equals(mapName)) {
                ItemStack button = new ItemStack(Material.ENDER_PEARL);
                ItemMeta buttonMeta = button.getItemMeta();
                buttonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a&l" + teleportsData[1]));
                List<String> buttonLore = new ArrayList<>();
                buttonLore.add(ChatColor.WHITE + teleportsData[2] + " " + teleportsData[3] + " " + teleportsData[4]);
                buttonMeta.setLore(buttonLore);
                button.setItemMeta(buttonMeta);

                // Slot = Slot Num + 9 * Row
                menu.setItem(buttonSlot + 9 * buttonRow, button);

                buttonSlot += 1;
                if (buttonSlot == 8) {
                    buttonSlot = 1;
                    buttonRow += 1;
                }
            }

        }

        ItemStack backButton = new ItemStack(Material.BARRIER);
        ItemMeta backButtonMeta = backButton.getItemMeta();
        backButtonMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&c&lBack"));
        backButton.setItemMeta(backButtonMeta);
        if (mapName.equals("Audia") || mapName.equals("City 17")) {
            menu.setItem(4 + 9 * 5, backButton);
        } else {
            menu.setItem(4 + 9 * 3, backButton);
        }

        return menu;

    }
}
