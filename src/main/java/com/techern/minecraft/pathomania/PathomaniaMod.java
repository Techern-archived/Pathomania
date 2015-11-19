package com.techern.minecraft.pathomania;

import com.techern.minecraft.pathomania.blocks.*;
import com.techern.minecraft.pathomania.events.PathomaniaPlayerEvents;
import com.techern.minecraft.pathomania.proxy.CommonProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * The {@link Mod} descriptor for Pathomania
 *
 * @since 0.0.1
 */
@Mod(acceptableRemoteVersions = PathomaniaMod.MOD_VERSION, modid = PathomaniaMod.MOD_ID, version = PathomaniaMod.MOD_VERSION)
public class PathomaniaMod {

    /**
     * The name of the Pathomania {@link Mod}
     *
     * @since 0.0.1
     */
    public static final String MOD_ID = "Pathomania";

    /**
     * The version of the Pathomania {@link Mod}
     *
     * @since 0.0.1
     */
    public static final String MOD_VERSION = "0.9.0";

    /**
     * The logger used by the {@link PathomaniaMod}
     */
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @SidedProxy(clientSide = "com.techern.minecraft.pathomania.proxy.ClientProxy",
                serverSide = "com.techern.minecraft.pathomania.proxy.ServerProxy")
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public static void handlePreInitializationEvent(FMLPreInitializationEvent event) {

        LOGGER.debug("Registering blocks");

        GameRegistry.registerBlock(BlockDirtPath.INSTANCE, "dirt_path");

        GameRegistry.registerBlock(BlockPath.GRASS_PATH, "grass_path");

        GameRegistry.registerBlock(BlockPath.GRAVEL_PATH, "gravel_path");

        GameRegistry.registerBlock(BlockPath.CLAY_PATH, "clay_path");
        GameRegistry.registerBlock(BlockPath.HARDENED_CLAY_PATH, "hardened_clay_path");

        GameRegistry.registerBlock(BlockPlankPath.INSTANCE, "plank_path");

        GameRegistry.registerBlock(BlockPrismarinePath.INSTANCE, "prismarine_path");

        GameRegistry.registerBlock(BlockSandStonePath.INSTANCE, "sandstone_path");
        GameRegistry.registerBlock(BlockRedSandstonePath.INSTANCE, "red_sandstone_path");

        GameRegistry.registerBlock(BlockSandPath.INSTANCE, "sand_path");

        GameRegistry.registerBlock(BlockPath.COBBLESTONE_PATH, "cobblestone_path");
        GameRegistry.registerBlock(BlockPath.MOSSY_COBBLESTONE_PATH, "mossy_cobblestone_path");

        GameRegistry.registerBlock(BlockPath.GLOWSTONE_PATH, "glowstone_path");

        GameRegistry.registerBlock(BlockStonePath.INSTANCE, "stone_path");

        GameRegistry.registerBlock(BlockPath.BRICK_PATH, "brick_path");

        GameRegistry.registerBlock(BlockStoneBrickPath.INSTANCE, "stone_brick_path");

        GameRegistry.registerBlock(BlockStainedClayPath.INSTANCE, "stained_clay_path");

    }


    @Mod.EventHandler
    public static void handlePostInitializationEvent(FMLPostInitializationEvent event) {

        PROXY.registerBlockInventoryModel(BlockDirtPath.INSTANCE, 0, "dirt_path");
        PROXY.registerBlockInventoryModel(BlockDirtPath.INSTANCE, 1, "dirt_path");
        PROXY.registerBlockInventoryModel(BlockDirtPath.INSTANCE, 2, "dirt_path");

        PROXY.registerBlockInventoryModel(BlockPath.GRASS_PATH, 0, "grass_path");

        PROXY.registerBlockInventoryModel(BlockPath.GRAVEL_PATH, 0, "gravel_path");

        PROXY.registerBlockInventoryModel(BlockPath.CLAY_PATH, 0, "clay_path");
        PROXY.registerBlockInventoryModel(BlockPath.HARDENED_CLAY_PATH, 0, "hardened_clay_path");

        PROXY.registerBlockInventoryModel(BlockPlankPath.INSTANCE, 0, "plank_path");
        PROXY.registerBlockInventoryModel(BlockPlankPath.INSTANCE, 1, "plank_path");
        PROXY.registerBlockInventoryModel(BlockPlankPath.INSTANCE, 2, "plank_path");
        PROXY.registerBlockInventoryModel(BlockPlankPath.INSTANCE, 3, "plank_path");
        PROXY.registerBlockInventoryModel(BlockPlankPath.INSTANCE, 4, "plank_path");
        PROXY.registerBlockInventoryModel(BlockPlankPath.INSTANCE, 5, "plank_path");
        PROXY.registerBlockInventoryModel(BlockPlankPath.INSTANCE, 5, "plank_path");

        PROXY.registerBlockInventoryModel(BlockPrismarinePath.INSTANCE, 0, "prismarine_path");
        PROXY.registerBlockInventoryModel(BlockPrismarinePath.INSTANCE, 1, "prismarine_path");
        PROXY.registerBlockInventoryModel(BlockPrismarinePath.INSTANCE, 2, "prismarine_path");

        PROXY.registerBlockInventoryModel(BlockSandStonePath.INSTANCE, 0, "sandstone_path");
        PROXY.registerBlockInventoryModel(BlockSandStonePath.INSTANCE, 1, "sandstone_path");
        PROXY.registerBlockInventoryModel(BlockSandStonePath.INSTANCE, 2, "sandstone_path");

        PROXY.registerBlockInventoryModel(BlockRedSandstonePath.INSTANCE, 0, "red_sandstone_path");
        PROXY.registerBlockInventoryModel(BlockRedSandstonePath.INSTANCE, 1, "red_sandstone_path");
        PROXY.registerBlockInventoryModel(BlockRedSandstonePath.INSTANCE, 2, "red_sandstone_path");
        PROXY.registerBlockInventoryModel(BlockRedSandstonePath.INSTANCE, 2, "red_sandstone_path");

        PROXY.registerBlockInventoryModel(BlockSandPath.INSTANCE, 0, "sand_path");
        PROXY.registerBlockInventoryModel(BlockSandPath.INSTANCE, 1, "sand_path");

        PROXY.registerBlockInventoryModel(BlockPath.COBBLESTONE_PATH, 0, "cobblestone_path");
        PROXY.registerBlockInventoryModel(BlockPath.MOSSY_COBBLESTONE_PATH, 0, "mossy_cobblestone_path");

        PROXY.registerBlockInventoryModel(BlockPath.GLOWSTONE_PATH, 0, "glowstone_path");

        PROXY.registerBlockInventoryModel(BlockStonePath.INSTANCE, 0, "stone_path");
        PROXY.registerBlockInventoryModel(BlockStonePath.INSTANCE, 1, "stone_path");
        PROXY.registerBlockInventoryModel(BlockStonePath.INSTANCE, 2, "stone_path");
        PROXY.registerBlockInventoryModel(BlockStonePath.INSTANCE, 3, "stone_path");
        PROXY.registerBlockInventoryModel(BlockStonePath.INSTANCE, 4, "stone_path");
        PROXY.registerBlockInventoryModel(BlockStonePath.INSTANCE, 5, "stone_path");
        PROXY.registerBlockInventoryModel(BlockStonePath.INSTANCE, 6, "stone_path");

        PROXY.registerBlockInventoryModel(BlockPath.BRICK_PATH, 0, "brick_path");

        PROXY.registerBlockInventoryModel(BlockStoneBrickPath.INSTANCE, 0, "stone_brick_path");
        PROXY.registerBlockInventoryModel(BlockStoneBrickPath.INSTANCE, 1, "stone_brick_path");
        PROXY.registerBlockInventoryModel(BlockStoneBrickPath.INSTANCE, 2, "stone_brick_path");
        PROXY.registerBlockInventoryModel(BlockStoneBrickPath.INSTANCE, 3, "stone_brick_path");

        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 0, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 1, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 2, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 3, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 4, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 5, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 6, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 7, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 8, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 9, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 10, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 11, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 12, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 13, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 14, "stained_clay_path");
        PROXY.registerBlockInventoryModel(BlockStainedClayPath.INSTANCE, 15, "stained_clay_path");

        MinecraftForge.EVENT_BUS.register(new PathomaniaPlayerEvents());

    }

}
