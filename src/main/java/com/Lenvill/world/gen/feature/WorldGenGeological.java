package com.Lenvill.world.gen.feature;

import com.Lenvill.Config;
import com.Lenvill.init.LegacyBlocksInit;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMatcher;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

import java.util.Random;

public class WorldGenGeological implements IWorldGenerator {

    @Override
    public void generate(Random random, int blockXPos, int blockZPos, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider){
        //ZYRRIDIUM ORE
        generateOreInStone(LegacyBlocksInit.zyrridium_ore.getDefaultState(), world, random, blockXPos * 16, blockZPos * 16,
                Config.zyrridiumSize, MathHelper.getInt(random, Config.zyrridiumFrequencyMin, Config.zyrridiumFrequencyMax),
                Config.zyrridiumLayerMin, Config.zyrridiumLayerMax, Config.zyrridiumRarity);
    }

    public void generateOreInStone(IBlockState state, World world, Random random, int blockXPos, int blockZPos, int maxVeinSize, int frequency, int minY, int maxY, float rarity) {
        int deltaY = maxY - minY;

        if (random.nextFloat() < rarity) {
            for (int x = 0; x < frequency; x++) {
                int posX = blockXPos + random.nextInt(16);
                int posY = minY + random.nextInt(deltaY);
                int posZ = blockZPos + random.nextInt(16);
                // N.B. This method applies the anti-cascading-lag offset itself
                (new WorldGenMinable(state, maxVeinSize)).generate(world, random, new BlockPos(posX, posY, posZ));
            }
        }
    }

    public void generateOreInBlock(IBlockState state, Block bed, World world, Random random, int blockXPos, int blockZPos, int maxVeinSize, int frequency, int minY, int maxY, float rarity) {
        int deltaY = maxY - minY;

        if (random.nextFloat() < rarity) {
            for (int x = 0; x < frequency; x++) {
                int posX = blockXPos + random.nextInt(16);
                int posY = minY + random.nextInt(deltaY);
                int posZ = blockZPos + random.nextInt(16);
                // N.B. This method applies the anti-cascading-lag offset itself
                (new WorldGenMinable(state, maxVeinSize, BlockMatcher.forBlock(bed))).generate(world, random, new BlockPos(posX, posY, posZ));
            }
        }
    }
}
