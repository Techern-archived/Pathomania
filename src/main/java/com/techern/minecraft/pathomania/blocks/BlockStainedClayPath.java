package com.techern.minecraft.pathomania.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockColored;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;

/**
 * An extension of {@link BlockPath} for stained clay
 *
 * @since 0.9.0
 */
public class BlockStainedClayPath extends BlockPath {

    /**
     * The variant of {@link BlockStainedClayPath}
     *
     * @since 0.9.0
     */
    public static final PropertyEnum VARIANT = PropertyEnum.create("variant", EnumDyeColor.class);

    /**
     * The instance of {@link BlockStainedClayPath}
     *
     * @since 0.9.0
     */
    public static final BlockStainedClayPath INSTANCE = new BlockStainedClayPath();

    /**
     * Creates a new {@link BlockStainedClayPath}
     *
     * @since 0.9.0
     */
    public BlockStainedClayPath() {
        super("blockStainedClayPath", Material.ground, Blocks.stained_hardened_clay);
        this.setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, EnumDyeColor.WHITE));
    }

    /**
     * Creates a {@link BlockState} from this {@link BlockStainedClayPath}
     *
     * @return The {@link BlockState}
     * @since 0.9.0
     */
    @Override
    protected BlockState createBlockState()
    {
        return new BlockState(this, new IProperty[] {VARIANT});
    }

    /**
     * Gets a list of {@link ItemStack}s with sub-blocks
     *
     * @since 0.9.0
     */
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item itemIn, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(this, 1, EnumDyeColor.WHITE.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.ORANGE.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.MAGENTA.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.LIGHT_BLUE.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.YELLOW.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.LIME.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.PINK.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.GRAY.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.SILVER.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.CYAN.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.PURPLE.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.BLUE.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.BROWN.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.GREEN.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.RED.getMetadata()));
        list.add(new ItemStack(this, 1, EnumDyeColor.BLACK.getMetadata()));
    }

    /**
     * Gets a {@link IBlockState} for this {@link BlockStainedClayPath} representing the supplied metadata
     *
     * @since 0.9.0
     */
    public IBlockState getStateFromMeta(int meta)
    {
        return this.getDefaultState().withProperty(VARIANT, EnumDyeColor.byMetadata(meta));
    }

    /**
     * Gets the metadata value from the supplied {@link IBlockState}
     *
     * @since 0.9.0
     */
    public int getMetaFromState(IBlockState state)
    {
        return ((EnumDyeColor) state.getValue(VARIANT)).getMetadata();
    }

    /**
     * Get the damage value that this {@link BlockStainedClayPath} should drop
     *
     * @param state The current {@link IBlockState}
     * @since 0.9.0
     */
    @Override
    public int damageDropped(IBlockState state) {
        return ((EnumDyeColor) state.getValue(VARIANT)).getMetadata();
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
            worldIn.setBlockState(pos, this.getFallbackBlock().getDefaultState().withProperty(BlockColored.COLOR, state.getValue(BlockStainedClayPath.VARIANT)));
        }
    }
}
