package com.Lenvill;

import com.Lenvill.init.LegacyItemsInit;
import com.Lenvill.proxy.CommonProxy;
import com.Lenvill.world.gen.feature.WorldGenGeological;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = MFRLegacyFeatures.MODID, name = MFRLegacyFeatures.NAME, dependencies = MFRLegacyFeatures.DEPENDENCIES, version = MFRLegacyFeatures.VERSION)
public class MFRLegacyFeatures {
    public static final String MODID = "mfr_legacy_features";
    public static final String NAME = "MFR_Legacy_Features";
    public static final String VERSION = "@VERSION@";
    public static final String DEPENDENCIES = "required-after:minefantasyreforged;";

    @SidedProxy(clientSide = "com.Lenvill.proxy.ClientProxy", serverSide = "com.Lenvill.proxy.CommonProxy")
    public static CommonProxy PROXY;

    public static CreativeTabs creativeTab = new CreativeTabs("legacy") {

        @Override
        public String getTabLabel(){
            return "legacy";
        }

        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack createIcon(){
            return new ItemStack(LegacyItemsInit.zyrridium_dust);
        }
    };

    public static final Logger LOG = LogManager.getLogger(MODID);

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        LegacyItemsInit.initLeatherArmor();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        GameRegistry.registerWorldGenerator(new WorldGenGeological(), 5);
        System.out.println();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }
}

    /*
    TO-DO LIST
    MF2:
        Bedroll!
        Dirt-textured roads?
    MF2 Alpha:
        Pestle
        Tea Leaf
        Mild Spice
        Salad
        Scaled Armor
        Research Scrolls
    MF1:
        Herbs!
        Zyrridium
     */