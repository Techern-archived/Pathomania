package com.techern.minecraft.pathomania.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * BlockPath; A class used to create path {@link net.minecraft.block.Block}s
 *
 * @since 0.0.1
 */
public class BlockPath extends Block {

    /**
     * The dirt {@link BlockPath} instance
     *
     * @since 0.0.1
     */
    public static BlockPath DIRT_PATH = new BlockPath(Material.ground, "blockDirtPath", Block.soundTypeGrass);

    /**
     * Creates a new {@link BlockPath}
     *
     * @param material The {@link Material} used for this {@link BlockPath}
     * @param name The name of this {@link BlockPath}
     * @paran soundType The {@link net.minecraft.block.Block.SoundType} used by this {@link BlockPath}
     *
     * @since 0.0.1
     */
    public BlockPath(Material material, String name, SoundType soundType) {
        super(material);
        this.setUnlocalizedName(name);
        this.setStepSound(soundType);

        this.setCreativeTab(CreativeTabs.tabBlock); //TODO: Creative tab for pathways
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);

    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean isFullCube() {
        return false;
    }

}
