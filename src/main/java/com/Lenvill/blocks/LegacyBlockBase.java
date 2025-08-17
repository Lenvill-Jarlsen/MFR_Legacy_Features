package com.Lenvill.blocks;

import com.Lenvill.MFRLegacyFeatures;
import com.Lenvill.init.LegacyBlocksInit;
import com.Lenvill.init.LegacyItemsInit;
import com.Lenvill.proxy.IClientRegister;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class LegacyBlockBase extends Block implements IClientRegister {
    private final Object drop;

    public LegacyBlockBase (String name, Material material) {
        this(name, material, null);
    }

    public LegacyBlockBase (String name, Material material, Object drop){
        super(material);

        setRegistryName(name);
        setTranslationKey(name);
        setCreativeTab(MFRLegacyFeatures.creativeTab);
        if (material == Material.ROCK) {
            this.setHarvestLevel("pickaxe", 0);
        }

        this.drop = drop;
        LegacyBlocksInit.BLOCKS.add(this);
        LegacyItemsInit.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    public LegacyBlockBase setBlockSoundType(SoundType soundType) {
        setSoundType(soundType);
        return this;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        if (drop != null) {
            if (drop instanceof Item) {
                return (Item) drop;
            }
            if (drop instanceof Block) {
                return Item.getItemFromBlock((Block) drop);
            }
        }
        return Item.getItemFromBlock(this);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerClientModels() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(getRegistryName(), "normal"));
    }
}
