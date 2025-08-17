package com.Lenvill.blocks;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

//Aggressively purple
public class ZyrridiumBlock extends LegacyBlockBase {

    public ZyrridiumBlock(String name, Material material){
        super (name, material);
        setSoundType(SoundType.STONE);
        setHardness(3.0F);
        setResistance(2.0F);
        setHarvestLevel("pickaxe", 2);
    }
}
