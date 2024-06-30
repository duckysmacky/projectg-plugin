package me.ducky.projectg.catalog.catalogs;

import me.ducky.projectg.catalog.enums.KitClass;
import me.ducky.projectg.catalog.enums.Rarity;
import me.ducky.projectg.catalog.items.KitItem;

import java.util.ArrayList;
import java.util.List;

public class KitCatalog {
    public static final List<KitItem> LIST;

    static {
        LIST = new ArrayList<>();
        LIST.add(new KitItem("IRON_HELMET", "assault", KitClass.ASSAULT, Rarity.COMMON, "&fA swiss knife of a kit - everything you need to fight, survive and win in the same place"));
        LIST.add(new KitItem("SHIELD", "breach", KitClass.ASSAULT, Rarity.UNCOMMON, "&fGood utility to remove obstacles, breach walls and initiate fights"));
        LIST.add(new KitItem("PACKED_ICE", "cryo", KitClass.ASSAULT, Rarity.UNCOMMON, "&fProvides an ability to freeze areas and slowing down the opponents, while having good area control"));
        LIST.add(new KitItem("WEB", "smoke", KitClass.ASSAULT, Rarity.RARE, "&fExcellent utility to block enemies line of sight and deny area with special gas grenades"));
        LIST.add(new KitItem("COMPASS", "recon", KitClass.ASSAULT, Rarity.EPIC, "&fUtility helps locate enemies and initiate a fight with them"));
        LIST.add(new KitItem("STRING", "spy", KitClass.ASSAULT, Rarity.EPIC, "&fProvides utility for flanking and stealth attacks"));
        LIST.add(new KitItem("DIAMOND_CHESTPLATE", "juggernaut", KitClass.ASSAULT, Rarity.LEGENDARY, "&c&lTHIS KIT ALREADY PROVIDES A MAIN WEAPON!\n&fHaha minigun go brrrr"));
        LIST.add(new KitItem("GOLD_BOOTS", "rush", KitClass.SKIRMISHER, Rarity.COMMON, "&fUtility gives a lot of movement-based buffs to help rush into the fight"));
        LIST.add(new KitItem("EYE_OF_ENDER", "stealth", KitClass.SKIRMISHER, Rarity.UNCOMMON, "&fProvides an ability to turn invisible and flank enemy lines"));
        LIST.add(new KitItem("ENDER_PEARL", "nano", KitClass.SKIRMISHER, Rarity.RARE, "&fUtility helps to blind enemies and relocate with ender pearls"));
        LIST.add(new KitItem("STRING", "grapple", KitClass.SKIRMISHER, Rarity.RARE, "&fThe grappling hook gives many opportunities to relocate, flank or get into good angles"));
        LIST.add(new KitItem("IRON_SPADE", "demoman", KitClass.SKIRMISHER, Rarity.EPIC, "&fFor the next three hundred years, people who needed to get to the second\nfloor used the only method available to them: shooting a rocket\nlauncher at their feet. Yes, it was ridiculous, crippling,\nand awful, but what are you going to do? Not go to the\nsecond floor? That's where your bed is."));
        LIST.add(new KitItem("FEATHER", "jetpack", KitClass.SKIRMISHER, Rarity.EPIC, "&fProvides you a jetpack which you can use in many different ways"));
        LIST.add(new KitItem("DIAMOND_SWORD", "blade", KitClass.SKIRMISHER, Rarity.LEGENDARY, "&c&lTHIS KIT ALREADY PROVIDES A MAIN WEAPON!\n&fYou get a powerful blade and increased mobility\nto close down on the range"));
        LIST.add(new KitItem("LAVA_BUCKET", "pyro", KitClass.ASSASIN, Rarity.COMMON, "&fKit provides a fire thrower and other fire-based utility"));
        LIST.add(new KitItem("FIREBALL", "explosive", KitClass.ASSASIN, Rarity.UNCOMMON, "&fKit provides a powerful homing rocket launcher and explosive utility"));
        LIST.add(new KitItem("SLIME_BALL", "toxic", KitClass.ASSASIN, Rarity.UNCOMMON, "&fUtility helps to control and lock down areas with powerful gas grenades"));
        LIST.add(new KitItem("SEEDS", "biohazard", KitClass.ASSASIN, Rarity.RARE, "&fKit provides a biogun and some chemical utility"));
        LIST.add(new KitItem("NETHER_STAR", "chainsaw", KitClass.ASSASIN, Rarity.EPIC, "&fKit provides chainsaw(s)... brrrr"));
        LIST.add(new KitItem("TNT", "nuclear", KitClass.ASSASIN, Rarity.LEGENDARY, "&fThe name speaks for itself"));
        LIST.add(new KitItem("BOW", "sniper", KitClass.ASSASIN, Rarity.LEGENDARY, "&c&lTHIS KIT ALREADY PROVIDES A MAIN WEAPON!\n&fKit provides the infamous NTW-20 as the main weapon,\nwhich can one-shot anyone, but you are easier to kill"));
        LIST.add(new KitItem("GOLDEN_APPLE", "medic", KitClass.SENTINEL, Rarity.COMMON, "&fProvides utility to heal and support your allies"));
        LIST.add(new KitItem("OBSERVER", "tech", KitClass.SENTINEL, Rarity.UNCOMMON, "&fProvides utility to lock down area with traps and view it from cameras"));
        LIST.add(new KitItem("GOLD_PICKAXE", "bulldozer", KitClass.SENTINEL, Rarity.RARE, "&fThis kit provides a hude drill to dig around the map and modify it with extra building blocks"));
        LIST.add(new KitItem("SHULKER_SHELL", "engineer", KitClass.SENTINEL, Rarity.RARE, "&fKit provides a bunch of turrets which can be placed and will shoot any foes"));
        LIST.add(new KitItem("SPECTRAL_ARROW", "artillery", KitClass.SENTINEL, Rarity.EPIC, "&fProvides lots of different airstrikes to use on enemies from the sky"));
        LIST.add(new KitItem("ARROW", "missle", KitClass.SENTINEL, Rarity.LEGENDARY, "&fKit provides powerful missiles which you can point and launch"));
    }
}
