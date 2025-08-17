package com.Lenvill.init;

import com.Lenvill.item.ItemArmorLegacy;
import com.Lenvill.item.ItemBedroll;
import com.Lenvill.item.ItemFoodLegacy;
import com.Lenvill.item.LegacyItemBase;
import minefantasy.mfr.api.armour.ArmourDesign;
import minefantasy.mfr.constants.Rarity;
import minefantasy.mfr.registry.material.BaseMaterial;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class LegacyItemsInit {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    public static Item bedroll = new ItemBedroll("bedroll");
    public static Item zyrridium_dust = new LegacyItemBase("zyrridium_dust");

    public static Item TEA_LEAF = new ItemFoodLegacy("tea_leaf", 1, 0.5f, false).setLegacyStaminaModifier(10F, 1.0F).setAlwaysEdible();

    public static Item SCALED_HELMET;
    public static Item SCALED_CHEST;
    public static Item SCALED_LEGS;
    public static Item SCALED_BOOTS;

    public static void initLeatherArmor () {
        BaseMaterial baseMat = BaseMaterial.getMaterial("scale_leather");
        Rarity rarity = baseMat.rarity;
        float bulk = baseMat.weight;
        ArmourDesign design = ArmourDesign.LEATHER;

        SCALED_HELMET = new ItemArmorLegacy("scale_leather_helmet", baseMat, design, EntityEquipmentSlot.HEAD, baseMat.name.toLowerCase() + "_layer_1", rarity, bulk);
        SCALED_CHEST = new ItemArmorLegacy("scale_leather_chest", baseMat, design, EntityEquipmentSlot.CHEST, baseMat.name.toLowerCase() + "_layer_1", rarity, bulk);
        SCALED_LEGS = new ItemArmorLegacy("scale_leather_legs", baseMat, design, EntityEquipmentSlot.LEGS, baseMat.name.toLowerCase() + "_layer_2", rarity, bulk);
        SCALED_BOOTS = new ItemArmorLegacy("scale_leather_boots", baseMat, design, EntityEquipmentSlot.FEET, baseMat.name.toLowerCase() + "_layer_1", rarity, bulk);

        ITEMS.add(SCALED_HELMET);
        ITEMS.add(SCALED_CHEST);
        ITEMS.add(SCALED_LEGS);
        ITEMS.add(SCALED_BOOTS);
    }

    public static void initFood () {
        //TEA_LEAF.setStaminaModifier(10f, 1.0f);
    }

}
