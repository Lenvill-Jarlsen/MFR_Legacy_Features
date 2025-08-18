package com.Lenvill.util;

import com.Lenvill.blocks.BlockBedroll;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerSetSpawnEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandlerCommon {

    @SubscribeEvent
    public void onPlayerSetSpawn(PlayerSetSpawnEvent evt){
        World worldIn = evt.getEntityPlayer().getEntityWorld();

        if (evt.getNewSpawn() != null) {
            Block block = worldIn.getBlockState(evt.getNewSpawn()).getBlock();

            if (!worldIn.isRemote && (block instanceof BlockBedroll)) {
                evt.setCanceled(true);
            }
        }
    }
}
