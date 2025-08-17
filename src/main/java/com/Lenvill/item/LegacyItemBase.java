package com.Lenvill.item;

import com.Lenvill.MFRLegacyFeatures;
import com.Lenvill.init.LegacyItemsInit;
import com.Lenvill.proxy.IClientRegister;
import net.minecraft.item.Item;

public class LegacyItemBase extends Item implements IClientRegister {

    public LegacyItemBase(String name) {
        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(MFRLegacyFeatures.creativeTab);

        LegacyItemsInit.ITEMS.add(this);
    }

    @Override
    public void registerClientModels() {
        MFRLegacyFeatures.PROXY.registerItemRenderer(this, 0, "inventory");
    }
}
