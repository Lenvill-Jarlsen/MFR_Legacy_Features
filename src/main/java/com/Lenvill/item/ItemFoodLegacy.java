package com.Lenvill.item;

import com.Lenvill.MFRLegacyFeatures;
import com.Lenvill.init.LegacyItemsInit;
import com.Lenvill.proxy.IClientRegister;
import minefantasy.mfr.constants.Rarity;
import minefantasy.mfr.item.ItemFoodMFR;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFoodLegacy extends ItemFoodMFR implements IClientRegister {

    public ItemFoodLegacy(String name, int hunger, float saturation, boolean isMeat) {
        this(name, hunger, saturation, isMeat, Rarity.COMMON);
    }

    public ItemFoodLegacy(String name, int hunger, float saturation, boolean isMeat, Rarity rarity) {
        super(name, hunger, saturation, isMeat, rarity);
        setCreativeTab(MFRLegacyFeatures.creativeTab);
        LegacyItemsInit.ITEMS.add(this);
    }

    public ItemFoodLegacy setLegacyStaminaModifier (float buff, float hours) {
        super.setStaminaModifier(buff, hours);
        return this;
    }

    @Override
    public void registerClientModels() {
        MFRLegacyFeatures.PROXY.registerItemRenderer(this, 0, "inventory");
    }

    @Override
    public void registerClient(){
        //NO-OP
    }
}
