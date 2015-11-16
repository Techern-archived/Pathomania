package com.techern.minecraft.pathomania.blocks;

import com.techern.minecraft.pathomania.PathomaniaMod;
import com.techern.minecraft.pathomania.util.ReflectionUtilities;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

import java.lang.reflect.Field;
import java.util.Random;

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
    public static BlockPath DIRT_PATH = new BlockPath("blockDirtPath", Material.ground, Blocks.dirt, 0);

    /**
     * The coarse dirt {@link BlockPath} instance
     *
     * @since 0.9.0
     */
    public static BlockPath COARSE_DIRT_PATH = new BlockPath("blockCoarseDirtPath", Material.ground, Blocks.dirt, 1);

    /**
     * The podzol {@link BlockPath} instance
     *
     * @since 0.9.0
     */
    public static BlockPath PODZOL_PATH = new BlockPath("blockPodzolPath", Material.ground, Blocks.dirt, 2);

    /**
     * The grass {@link BlockPath} instance
     *
     * @since 0.0.1
     */
    public static BlockPath GRASS_PATH = new BlockPath("blockGrassPath", Material.ground, Blocks.grass, 0);

    /**
     * The {@link Block} to use as a fallback
     *
     * @since 0.0.1
     */
    private Block fallbackBlock;

    /**
     * An integer holding the {@code fallbackBlock}'s metadata
     *
     * @since 0.9.0
     */
    private int fallbackMetadata;

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
     * @param fallbackBlock The {@link Block} used as a fallback
     *
     * @since 0.0.1
     */
    public BlockPath(String name, Material material, Block fallbackBlock, int fallbackMetadata) {
        super(material);
        this.setUnlocalizedName(name);

        this.setStepSound(fallbackBlock.stepSound);

        //Time for reflection-only use cases
        try {
            Class<? extends Block> blockClass = fallbackBlock.getClass();

            Field hardnessField = ReflectionUtilities.getFieldInHierarchy(blockClass, "blockHardness", "field_149782_v");
            hardnessField.setAccessible(true);

            this.setHardness(hardnessField.getFloat(fallbackBlock));

            Field resistanceField = ReflectionUtilities.getFieldInHierarchy(blockClass, "blockResistance", "field_149781_w");
            resistanceField.setAccessible(true);

            this.setResistance(resistanceField.getFloat(fallbackBlock));

            Field lightValueField = ReflectionUtilities.getFieldInHierarchy(blockClass, "lightValue", "field_149784_t");
            lightValueField.setAccessible(true);

            this.setLightLevel(lightValueField.getFloat(fallbackBlock));

        } catch (NoSuchFieldException | IllegalAccessException e) {
            PathomaniaMod.LOGGER.error("Exception while automatically setting path data. It should partially work, though. Contact me, please :(");
            PathomaniaMod.LOGGER.error(e);
        }

        this.slipperiness = fallbackBlock.slipperiness;

        this.fallbackBlock = fallbackBlock;
        this.fallbackMetadata = fallbackMetadata;

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
     * Get the damage value that this Block should drop
     *
     * @param state The current {@link IBlockState}
     * @since 0.9.0
     */
    @Override
    public int damageDropped(IBlockState state) {
        return this.fallbackMetadata;
    }

    /**
     * Gets the {@link Item} dropped when harvesting this {@link BlockPath}
     *
     * @param state The current {@link IBlockState}
     * @param rand The {@link Random} number given to this block drop
     * @param fortune The fortune harvested with
     *
     * @return By default, the parent block
     */
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(this.fallbackBlock);
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
            worldIn.setBlockState(pos, this.getFallbackBlock().getStateFromMeta(this.fallbackMetadata));
        }
    }

}
