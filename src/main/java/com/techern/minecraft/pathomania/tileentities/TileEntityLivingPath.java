package com.techern.minecraft.pathomania.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

/**
 * An extension of {@link net.minecraft.tileentity.TileEntity} for {@link com.techern.minecraft.pathomania.blocks.BlockLivingPath}s
 *
 * @since 0.9.0
 */
public class TileEntityLivingPath extends TileEntity {

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
    }

    @Override
    public void writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
    }
}
