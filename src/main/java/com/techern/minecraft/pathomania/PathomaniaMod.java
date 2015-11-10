package com.techern.minecraft.pathomania;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
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
    public static final String MOD_VERSION = "0.0.1-SNAPSHOT";

    /**
     * The logger used by the {@link PathomaniaMod}
     */
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    @Mod.EventHandler
    public static void handlePostInitializationEvent(FMLPostInitializationEvent event) {

        LOGGER.info("Pathomania version %s has finished loading! :)", MOD_VERSION);

    }



}
