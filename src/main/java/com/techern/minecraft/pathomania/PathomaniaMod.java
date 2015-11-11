package com.techern.minecraft.pathomania;

import com.techern.minecraft.pathomania.blocks.BlockPath;
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
    public static final String MOD_VERSION = "0.0.1";

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

        GameRegistry.registerBlock(BlockPath.DIRT_PATH, "dirt_path");
        GameRegistry.registerBlock(BlockPath.GRASS_PATH, "grass_path");

    }


    @Mod.EventHandler
    public static void handlePostInitializationEvent(FMLPostInitializationEvent event) {

        PROXY.registerBlockInventoryModel(BlockPath.DIRT_PATH, "dirt_path");
        PROXY.registerBlockInventoryModel(BlockPath.GRASS_PATH, "grass_path");

        MinecraftForge.EVENT_BUS.register(new PathomaniaPlayerEvents());

    }

}
