package com.techern.minecraft.pathomania;

import com.techern.minecraft.pathomania.blocks.BlockDirtPath;
import com.techern.minecraft.pathomania.blocks.BlockPath;
import com.techern.minecraft.pathomania.blocks.BlockPlankPath;
import com.techern.minecraft.pathomania.blocks.BlockPrismarinePath;
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
    public static final String MOD_VERSION = "0.9.0-SNAPSHOT";

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

        MinecraftForge.EVENT_BUS.register(new PathomaniaPlayerEvents());

    }

}
