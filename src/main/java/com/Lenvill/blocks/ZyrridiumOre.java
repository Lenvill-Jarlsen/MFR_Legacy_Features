package com.Lenvill.blocks;

import com.Lenvill.init.LegacyItemsInit;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

import java.util.Random;

public class ZyrridiumOre extends LegacyBlockBase {
    private int xp;
    private Random rand = new Random();

    public ZyrridiumOre(String name, Material material){
        super (name, material);
        this.xp = 2;
        setSoundType(SoundType.STONE);
        setHardness(3.0F);
        setResistance(2.0F);
        setHarvestLevel("pickaxe", 2);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune){
        return LegacyItemsInit.zyrridium_dust;
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random rand){
        int max = 2;
        int min = 1;
        return rand.nextInt(max) + min;
    }

    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i'
     * (inclusive).
     */
    @Override
    public int quantityDroppedWithBonus(int fortune, Random rand) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.blockState.getBaseState(), rand, fortune)) {
            int j = rand.nextInt(fortune + 2) - 1;

            if (j < 0) {
                j = 0;
            }

            return this.quantityDropped(rand) * (j + 1);
        } else {
            return this.quantityDropped(rand);
        }
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        if (xp > 0 && this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            return rand.nextInt(xp * 2);
        }
        return 0;
    }
}
