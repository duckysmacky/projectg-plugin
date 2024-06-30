package me.ducky.projectg.catalog.catalogs;

import me.ducky.projectg.catalog.enums.Rarity;
import me.ducky.projectg.catalog.items.GadgetItem;

import java.util.ArrayList;
import java.util.List;

public class GadgetCatalog {
    public static final List<GadgetItem> LIST;

    static {
        //        new GadgetItem("8 Inch Blade Autoinjector", "HBM_INJECTOR_KNIFE", 1, Rarity.LEGENDARY),
        LIST = new ArrayList<>();
        LIST.add(new GadgetItem("Water Bucket", "WATER_BUCKET", 1, Rarity.COMMON));
        LIST.add(new GadgetItem("Flint and Steel", "FLINT_AND_STEEL", 1, Rarity.COMMON));
        LIST.add(new GadgetItem("Flashlight", "FLASHLIGHT_FLASHLIGHT", 1, Rarity.COMMON));
        LIST.add(new GadgetItem("Hard Cover", "HBM_HADRON_PLATING_STRIPED", 2, Rarity.UNCOMMON));
        LIST.add(new GadgetItem("Kevlar Insert", "HBM_INSERT_KEVLAR", 1, Rarity.RARE));
        LIST.add(new GadgetItem("Slime Pads", "HBM_PADS_SLIME", 1, Rarity.RARE));
        LIST.add(new GadgetItem("Trench Mask", "HBM_MASK_PISS", 1, Rarity.RARE));
        LIST.add(new GadgetItem("Golden Apple", "GOLDEN_APPLE", 5, Rarity.RARE));
        LIST.add(new GadgetItem("Chorus Fruit", "CHORUS_FRUIT", 16, Rarity.RARE));
        LIST.add(new GadgetItem("Claymore", "SECURITYCRAFT_CLAYMORE", 5, Rarity.RARE));
        LIST.add(new GadgetItem("XSAPI Insert", "HBM_INSERT_XSAPI", 1, Rarity.EPIC));
        LIST.add(new GadgetItem("Ender Pearl", "ENDER_PEARL", 5, Rarity.EPIC));
        LIST.add(new GadgetItem("Mining Charge", "TECHGUNS_EXPLOSIVE_CHARGE", 5, Rarity.EPIC));
        LIST.add(new GadgetItem("Power Hammer", "TECHGUNS_POWERHAMMMER", 1, Rarity.EPIC));
        LIST.add(new GadgetItem("Velvet Band-Aid", "HBM_BANDAID", 1, Rarity.LEGENDARY));
        LIST.add(new GadgetItem("Elytra", "ELYTRA", 1, Rarity.LEGENDARY));
        LIST.add(new GadgetItem("Jumppack", "TECHGUNS_JUMPPACK", 1, Rarity.LEGENDARY));
    }
}
