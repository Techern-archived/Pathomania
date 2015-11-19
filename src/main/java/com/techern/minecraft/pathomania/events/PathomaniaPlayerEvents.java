package com.techern.minecraft.pathomania.events;

import com.techern.minecraft.pathomania.blocks.*;
import net.minecraft.block.*;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

/**
 * A class containing {@link net.minecraftforge.event.entity.player.PlayerEvent}s
 *
 * @since 0.0.1
 */
public class PathomaniaPlayerEvents {

    /**
     * Called when an {@link net.minecraft.entity.player.EntityPlayer} interacts with a {@link Block}
     *
     * @param event The {@link PlayerInteractEvent} being referenced
     * @since 0.0.1
     */
    @SubscribeEvent
    public void playerInteracting(PlayerInteractEvent event) {
        if (event.action.equals(PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK)) {
            if (event.entityPlayer.getHeldItem() != null) {
                if (event.entityPlayer.getHeldItem().getItem() instanceof ItemSpade) {

                    IBlockState state = event.world.getBlockState(event.pos);
                    Block block = state.getBlock();

                    if (block instanceof BlockGrass) {
                        event.world.setBlockState(event.pos, BlockPath.GRASS_PATH.getDefaultState());
                    } else if (block instanceof BlockDirt) {
                        event.world.setBlockState(event.pos, BlockDirtPath.INSTANCE.getDefaultState().withProperty(BlockDirtPath.VARIANT, state.getValue(BlockDirt.VARIANT)));
                    } else if (block instanceof BlockGravel) {
                        event.world.setBlockState(event.pos, BlockPath.GRAVEL_PATH.getDefaultState());
                    } else if (block instanceof BlockClay) {
                        event.world.setBlockState(event.pos, BlockPath.CLAY_PATH.getDefaultState());
                    } else if (block instanceof BlockSand) {
                        event.world.setBlockState(event.pos, BlockSandPath.INSTANCE.getDefaultState().withProperty(BlockSandPath.VARIANT, state.getValue(BlockSand.VARIANT)));
                    }
                } else if (event.entityPlayer.getHeldItem().getItem() instanceof ItemPickaxe) {

                    IBlockState state = event.world.getBlockState(event.pos);
                    Block block = state.getBlock();

                    if (block.getUnlocalizedName().equals(Blocks.cobblestone.getUnlocalizedName())) {
                        event.world.setBlockState(event.pos, BlockPath.COBBLESTONE_PATH.getDefaultState());
                    } else if (block.getUnlocalizedName().equals(Blocks.mossy_cobblestone.getUnlocalizedName())) {
                        event.world.setBlockState(event.pos, BlockPath.MOSSY_COBBLESTONE_PATH.getDefaultState());
                    } else if (block.getUnlocalizedName().equals(Blocks.brick_block.getUnlocalizedName())) {
                        event.world.setBlockState(event.pos, BlockPath.BRICK_PATH.getDefaultState());
                    } else if (block instanceof BlockHardenedClay) {
                        event.world.setBlockState(event.pos, BlockPath.HARDENED_CLAY_PATH.getDefaultState());
                    } else if (block instanceof BlockPrismarine) {
                        event.world.setBlockState(event.pos, BlockPrismarinePath.INSTANCE.getDefaultState().withProperty(BlockPrismarinePath.VARIANT, state.getValue(BlockPrismarine.VARIANT)));
                    } else if (block instanceof BlockSandStone) {
                        event.world.setBlockState(event.pos, BlockSandStonePath.INSTANCE.getDefaultState().withProperty(BlockSandStonePath.VARIANT, state.getValue(BlockSandStone.TYPE)));
                    } else if (block instanceof BlockRedSandstone) {
                        event.world.setBlockState(event.pos, BlockRedSandstonePath.INSTANCE.getDefaultState().withProperty(BlockRedSandstonePath.VARIANT, state.getValue(BlockRedSandstone.TYPE)));
                    } else if (block instanceof BlockGlowstone) {
                        event.world.setBlockState(event.pos, BlockPath.GLOWSTONE_PATH.getDefaultState());
                    } else if (block instanceof BlockStone) {
                        event.world.setBlockState(event.pos, BlockStonePath.INSTANCE.getDefaultState().withProperty(BlockStonePath.VARIANT, state.getValue(BlockStone.VARIANT)));
                    } else if (block instanceof BlockStoneBrick) {
                        event.world.setBlockState(event.pos, BlockStoneBrickPath.INSTANCE.getDefaultState().withProperty(BlockStoneBrickPath.VARIANT, state.getValue(BlockStoneBrick.VARIANT)));
                    }

                } else if (event.entityPlayer.getHeldItem().getItem() instanceof ItemAxe) {

                    IBlockState state = event.world.getBlockState(event.pos);
                    Block block = state.getBlock();

                    if (block instanceof BlockPlanks) {
                        event.world.setBlockState(event.pos, BlockPlankPath.INSTANCE.getDefaultState().withProperty(BlockPlankPath.VARIANT, state.getValue(BlockPlanks.VARIANT)));
                    }

                }
            }
        }
    }
}
