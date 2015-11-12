package com.techern.minecraft.pathomania.blocks;

import com.techern.minecraft.pathomania.tileentities.TileEntityLivingPath;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

/**
 * An extension of {@link net.minecraft.block.Block} to act like a {@link BlockPath}, but with the ability to change
 *
 * @since 0.9.0
 */
public class BlockLivingPath extends Block implements ITileEntityProvider {

    /**
     * The instance of {@link BlockLivingPath}
     *
     * @since 0.9.0
     */
    public static BlockLivingPath INSTANCE = new BlockLivingPath();

    /**
     * Creates a new {@link BlockLivingPath}
     *
     * @since 0.9.0
     */
    public BlockLivingPath() {
        super(Material.wood);

        this.setUnlocalizedName("blockLivingPath");

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

    @SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.TRANSLUCENT;
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     *
     * @param worldIn The {@link World} that this {@link BlockLivingPath} is in
     * @param meta The metadata of this {@link BlockLivingPath} TODO Verify
     *
     * @since 0.9.0
     */
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityLivingPath();
    }
}
