package com.Lenvill.init;

import com.Lenvill.blocks.BlockBedroll;
import com.Lenvill.blocks.LegacyBlockBase;
import com.Lenvill.blocks.ZyrridiumBlock;
import com.Lenvill.blocks.ZyrridiumOre;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class LegacyBlocksInit {
    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block zyrridium_ore = new ZyrridiumOre("zyrridium_ore", Material.ROCK);
    public static final Block zyrridium_block = new ZyrridiumBlock("zyrridium_block", Material.ROCK);
    public static final Block ANCIENT_GRANITE = new LegacyBlockBase("ancient_granite", Material.ROCK).setBlockSoundType(SoundType.STONE).setHardness(2.0F).setResistance(15F);
    public static final Block ANCIENT_GRANITE_BRICK = new LegacyBlockBase("ancient_granite_brick", Material.ROCK).setBlockSoundType(SoundType.STONE).setHardness(2.0F).setResistance(15F);
    public static final Block ANCIENT_GRANITE_BRICK_CRACKED = new LegacyBlockBase("ancient_granite_brick_cracked", Material.ROCK).setBlockSoundType(SoundType.STONE).setHardness(2.0F).setResistance(15F);
    public static final Block ANCIENT_GRANITE_BRICK_MOSSY = new LegacyBlockBase("ancient_granite_brick_mossy", Material.ROCK).setBlockSoundType(SoundType.STONE).setHardness(2.0F).setResistance(15F);
    public static final Block BEDROLL = new BlockBedroll();
}
