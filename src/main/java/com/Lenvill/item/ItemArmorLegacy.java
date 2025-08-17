package com.Lenvill.item;

import com.Lenvill.MFRLegacyFeatures;
import com.Lenvill.proxy.IClientRegister;
import minefantasy.mfr.MineFantasyReforged;
import minefantasy.mfr.api.armour.ArmourDesign;
import minefantasy.mfr.config.ConfigClient;
import minefantasy.mfr.constants.Rarity;
import minefantasy.mfr.item.ItemArmourMFR;
import minefantasy.mfr.registry.material.BaseMaterial;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemArmorLegacy extends ItemArmourMFR {
    private final Rarity itemRarity;

    public ItemArmorLegacy(String name, BaseMaterial material, ArmourDesign armourDesign, EntityEquipmentSlot slot,
                           String tex, Rarity rarity) {
        super(name, material, armourDesign, slot, tex, rarity);
        baseMaterial = material;

        setCreativeTab(MFRLegacyFeatures.creativeTab);

        itemRarity = rarity;
    }

    public ItemArmorLegacy(String name, BaseMaterial material, ArmourDesign armourDesign, EntityEquipmentSlot slot,
                           String tex, Rarity rarity, float customBulk) {
        this(name, material, armourDesign, slot, tex, rarity);
        this.suitBulk = customBulk;
    }
}
