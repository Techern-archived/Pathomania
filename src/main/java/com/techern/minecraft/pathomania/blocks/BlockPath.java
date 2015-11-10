package com.techern.minecraft.pathomania.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

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
    public static BlockPath DIRT_PATH = new BlockPath("blockDirtPath", Material.ground, Block.soundTypeGrass, Blocks.dirt);

    /**
     * The {@link Block} to use as a fallback
     *
     * @since 0.0.1
     */
    private Block fallbackBlock;

    /**
     * Gets this {@link BlockPath}'s fallback {@link Block}
     *
     * @return The fallback {@link Block}
     * @since 0.0.1
     */
    public Block getFallbackBlock() {
        return this.fallbackBlock;
    }

    /**
     * Creates a new {@link BlockPath}
     *
     * @param name The name of this {@link BlockPath}
     * @param material The {@link Material} used for this {@link BlockPath}
     * @paran soundType The {@link net.minecraft.block.Block.SoundType} used by this {@link BlockPath}
     * @param fallbackBlock The {@link Block} used as a fallback
     *
     * @since 0.0.1
     */
    public BlockPath(String name, Material material, SoundType soundType, Block fallbackBlock) {
        super(material);
        this.setUnlocalizedName(name);
        this.setStepSound(soundType);

        this.fallbackBlock = fallbackBlock;

        this.setCreativeTab(CreativeTabs.tabBlock); //TODO: Creative tab for pathways
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.9375F, 1.0F);

    }

    @Override
    public boolean isFullCube() {
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    /**
     * Called when a neighboring block changes.
     *
     * @param worldIn The {@link World} the change happened in
     * @param pos The current {@link BlockPos} of this {@link BlockPath}
     * @param state The current {@link IBlockState} of the (current?) block
     * @param neighborBlock The neighboring {@link Block}
     *
     * @since 0.0.1
     */
    @Override
    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock) {
        super.onNeighborBlockChange(worldIn, pos, state, neighborBlock);

        if (worldIn.getBlockState(pos.up()).getBlock().getMaterial().isSolid())
        {
            worldIn.setBlockState(pos, this.getFallbackBlock().getDefaultState());
        }
    }

}
