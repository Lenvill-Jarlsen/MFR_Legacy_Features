package com.Lenvill.util;


import com.Lenvill.init.LegacyBlocksInit;
import com.Lenvill.init.LegacyItemsInit;
import com.Lenvill.proxy.IClientRegister;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {
    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(LegacyItemsInit.ITEMS.toArray(new Item[0]));
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        event.getRegistry().registerAll(LegacyBlocksInit.BLOCKS.toArray(new Block[0]));
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event)
    {
        for(Item item : LegacyItemsInit.ITEMS)
        {
            if(item instanceof IClientRegister)
            {
                ((IClientRegister)item).registerClientModels();
            }
        }

        for(Block block : LegacyBlocksInit.BLOCKS)
        {
            if(block instanceof IClientRegister)
            {
                ((IClientRegister)block).registerClientModels();
            }
        }
    }
}
