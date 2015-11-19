package com.techern.minecraft.pathomania.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * An extension of {@link BlockPath} for {@link net.minecraft.block.BlockStone}
 *
 * @since 0.9.0
 */
public class BlockStonePath extends BlockPath {

    /**
     * The variant of {@link BlockStonePath}
     *
     * @since 0.9.0
     */
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", BlockStone.EnumType.class);

    /**
     * The instance of {@link BlockStonePath}
     *
     * @since 0.9.0
     */
    public static final BlockStonePath INSTANCE = new BlockStonePath();

    /**
     * Creates a new {@link BlockStonePath}
     *
     * @since 0.9.0
     */
    public BlockStonePath() {
        super("blockStonePath", Material.ground, Blocks.stone);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, BlockStone.EnumType.STONE));
    }

    /**
     * Creates a {@link BlockState} from this {@link BlockStonePath}
     *
     * @return The {@link BlockState}
     * @since 0.9.0
     */
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] { VARIANT });
    }

    /**
     * Gets a list of {@link ItemStack}s with sub-blocks
     *
     * @since 0.9.0
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(this, 1, BlockStone.EnumType.STONE.getMetadata()));
        list.add(new ItemStack(this, 1, BlockStone.EnumType.GRANITE.getMetadata()));
        list.add(new ItemStack(this, 1, BlockStone.EnumType.GRANITE_SMOOTH.getMetadata()));
        list.add(new ItemStack(this, 1, BlockStone.EnumType.DIORITE.getMetadata()));
        list.add(new ItemStack(this, 1, BlockStone.EnumType.DIORITE_SMOOTH.getMetadata()));
        list.add(new ItemStack(this, 1, BlockStone.EnumType.ANDESITE.getMetadata()));
        list.add(new ItemStack(this, 1, BlockStone.EnumType.ANDESITE_SMOOTH.getMetadata()));
    }

    /**
     * Gets a {@link IBlockState} for this {@link BlockStonePath} representing the supplied metadata
     *
     * @since 0.9.0
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, BlockStone.EnumType.byMetadata(meta));
    }

    /**
     * Gets the metadata value from the supplied {@link IBlockState}
     *
     * @since 0.9.0
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((BlockStone.EnumType) state.getValue(VARIANT)).getMetadata();
    }

    /**
     * Get the damage value that this {@link BlockStonePath} should drop
     *
     * @param state The current {@link IBlockState}
     * @since 0.9.0
     */
    @Override
    public int damageDropped(IBlockState state) {
        return ((BlockStone.EnumType) state.getValue(VARIANT)).getMetadata();
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
            worldIn.setBlockState(pos, this.getFallbackBlock().getDefaultState().withProperty(BlockStone.VARIANT, state.getValue(BlockStonePath.VARIANT)));
        }
    }
}
