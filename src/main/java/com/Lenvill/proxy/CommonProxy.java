package com.Lenvill.proxy;

import com.Lenvill.util.EventHandlerCommon;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class CommonProxy {

    public void registerItemRenderer(Item item, int meta, String id){
        //NOOP for CommonProxy
    }

    public void preInit() {
        //NOOP for commonProxy
    }

    public void init() {
        MinecraftForge.EVENT_BUS.register(new EventHandlerCommon());
    }

    public void postInit() {
        //NOOP for commonProxy
    }
}
